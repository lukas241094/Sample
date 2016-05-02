package org.gradle;

import static org.gradle.Region.BUFFERZONE;
import static org.gradle.Region.MM;
import static org.gradle.Region.QMZONE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import imperative.ClosestDistanceCalculatorImp;

public class MethodStarter {
	
	public void calculateStreamParallelFunctionalCDC(List<Molecule> molecules,double qmThreshold, double bufferThreshold){
		
		ClosestDistanceCalculator closestDistanceCalculator = new ClosestDistanceCalculator();
		Molecule core = new Molecule(0);
		
		long one = System.currentTimeMillis();
		Map<Region, List<Molecule>> regions =
		molecules.stream()
				 .parallel()
				 .collect(
						 Collectors.groupingBy(molecule -> {
							 double distance = closestDistanceCalculator.calculateClosestDistance(core, molecule);
							// System.out.println(distance);
							 if (distance < qmThreshold) return QMZONE;
							 	else if (distance > bufferThreshold) return MM;
							 		else return BUFFERZONE;
						 }));
		long end = System.currentTimeMillis();

		System.out.println("calculateStreamParallelFunctionalCDC");		
		System.out.println("Time Sorting List in s "+((end-one)/1000.0));
		if(regions.get(Region.QMZONE)!= null)System.out.println("QM size " +  regions.get(Region.QMZONE).size());
		if(regions.get(Region.BUFFERZONE)!= null)System.out.println("Buffer Size  " + regions.get(Region.BUFFERZONE).size());
		if(regions.get(Region.MM)!= null) System.out.println("MM size " + regions.get(Region.MM).size());	
		System.out.println("");
	}
	
	
	
	
	public void calculateStreamPrallelImpCDC(List<Molecule> molecules,double qmThreshold, double bufferThreshold){
		
		ClosestDistanceCalculatorImp closestDistanceCalculatorImp = new ClosestDistanceCalculatorImp();
		Molecule core = new Molecule(0);
		
		long one = System.currentTimeMillis();
		Map<Region, List<Molecule>> regions =
		molecules.stream()
				 .parallel()
				 .collect(
						 Collectors.groupingBy(molecule -> {
							 double distance = closestDistanceCalculatorImp.calculateClosestDistance(core, molecule);
							// System.out.println(distance);
							 if (distance < qmThreshold) return QMZONE;
							 	else if (distance > bufferThreshold) return MM;
							 		else return BUFFERZONE;
						 }));
		long end = System.currentTimeMillis();

		System.out.println("calculateStreamPrallelImpCDC");	
		System.out.println("Time Sorting List in s "+((end-one)/1000.0));
		if(regions.get(Region.QMZONE)!= null)System.out.println("QM size " +  regions.get(Region.QMZONE).size());
		if(regions.get(Region.BUFFERZONE)!= null)System.out.println("Buffer Size  " + regions.get(Region.BUFFERZONE).size());
		if(regions.get(Region.MM)!= null) System.out.println("MM size " + regions.get(Region.MM).size());	
		System.out.println("");
	}
	
	
	public void calculateStreamSerial(List<Molecule> molecules,double qmThreshold, double bufferThreshold){

		ClosestDistanceCalculator closestDistanceCalculator = new ClosestDistanceCalculator();
		Molecule core = new Molecule(0);
		
		long one = System.currentTimeMillis();
		Map<Region, List<Molecule>> regions =
		molecules.stream()
				// .parallel()
				 .collect(
						 Collectors.groupingBy(molecule -> {
							 double distance = closestDistanceCalculator.calculateClosestDistance(core, molecule);
							// System.out.println(distance);
							 if (distance < qmThreshold) return QMZONE;
							 	else if (distance > bufferThreshold) return MM;
							 		else return BUFFERZONE;
						 }));
		long end = System.currentTimeMillis();

		System.out.println("calculateStreamSerial");		
		System.out.println("Time Sorting List in s "+((end-one)/1000.0));	
		if(regions.get(Region.QMZONE)!= null)System.out.println("QM size " +  regions.get(Region.QMZONE).size());
		if(regions.get(Region.BUFFERZONE)!= null)System.out.println("Buffer Size  " + regions.get(Region.BUFFERZONE).size());
		if(regions.get(Region.MM)!= null) System.out.println("MM size " + regions.get(Region.MM).size());	
		System.out.println("");
	}
	
	public void calculateImperative(List<Molecule> molecules,double qmThreshold, double bufferThreshold){
		ClosestDistanceCalculatorImp closestDistanceCalculatorImp = new ClosestDistanceCalculatorImp();
		long start = System.currentTimeMillis();
		Molecule core = new Molecule(0);
		Map<Region, List<Molecule>> regions = new HashMap<>();
		List<Molecule> qmRegion = new ArrayList();
		List<Molecule> bufferRegion = new ArrayList();
		List<Molecule> mmRegion = new ArrayList();
		for (Molecule molecule : molecules){
			
			double distance = closestDistanceCalculatorImp.calculateClosestDistance(core, molecule);
			if(distance < qmThreshold){
				qmRegion.add(molecule);
			}else if(distance < bufferThreshold){
				bufferRegion.add(molecule);
			}else mmRegion.add(molecule);
		}
		
		regions.put(Region.QMZONE, qmRegion);
		regions.put(Region.BUFFERZONE, bufferRegion);
		regions.put(Region.MM, mmRegion);
		
		long end = System.currentTimeMillis();
		double duration = (end - start)/1000.0;
		
		System.out.println("calculateImperative");		
		System.out.println("Time Sorting List in s "+((end-start)/1000.0));	
		if(regions.get(Region.QMZONE)!= null)System.out.println("QM size " +  regions.get(Region.QMZONE).size());
		if(regions.get(Region.BUFFERZONE)!= null)System.out.println("Buffer Size  " + regions.get(Region.BUFFERZONE).size());
		if(regions.get(Region.MM)!= null) System.out.println("MM size " + regions.get(Region.MM).size());	
		System.out.println("");	 
	}
	

}

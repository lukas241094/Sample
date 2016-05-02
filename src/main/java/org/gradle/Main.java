package org.gradle;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.gradle.Region.*;
public class Main {

	public static void main(String[] args) {
		List<Molecule> molecules;
		double qmThreshold = 2.0;
		double bufferThreshold = 5.0;
		
		
		Molecule core = new Molecule(0);
		
		ClosestDistanceCalculator closestDistanceCalculator = new ClosestDistanceCalculator();
		
		long creatingListStart = System.currentTimeMillis();
		molecules = 
		IntStream.range(0,10_000_000)
				 .parallel()
				 .mapToObj(i -> new Molecule(i))
				 .collect(Collectors.toList());
		

		
		long creatingListEnd = System.currentTimeMillis();
		System.out.println("Time creating list in s " + ((creatingListEnd-creatingListStart)/1000.0));
		System.out.println("Number of Molecules " + molecules.size());
		
		
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

				
		System.out.println("Time Sorting List in s "+((end-one)/1000.0));
		
		System.out.println("QM size " +  regions.get(Region.QMZONE).size());
		System.out.println("Buffer Size  " + regions.get(Region.BUFFERZONE).size());
		System.out.println("MM size " + regions.get(Region.MM).size());
		
		System.out.println(regions.get(Region.BUFFERZONE).size()+regions.get(Region.QMZONE).size()+regions.get(Region.MM).size());		 

		
		
		
		
		
		
		
//		long creatingListStartHybrid = System.currentTimeMillis();
//		Map<Region, List<Molecule>> regionsHybrid = 
//		IntStream.range(0,1_000)
//				 .parallel()
//				 .mapToObj(i -> new Molecule(i))
//				 .collect(
//						 Collectors.groupingBy(molecule -> {
//							 double distance = distanceCalculator.calculateDistance(core, molecule);
//							 if (distance < qmThreshold) return QMZONE;
//							 	else if (distance > bufferThreshold) return MM;
//							 		else return BUFFERZONE;
//						 }));
//		
//		long creatingListEndHybrid = System.currentTimeMillis();
//		System.out.println("Time doing both at once in s " + ((creatingListEndHybrid-creatingListStartHybrid)/1000.0));
//		System.out.println("QM size Hybrid " +  regionsHybrid.get(Region.QMZONE).size());
//		System.out.println("Buffer Size  Hybrid " + regionsHybrid.get(Region.BUFFERZONE).size());
//		System.out.println("MM size Hybrid " + regionsHybrid.get(Region.MM).size());
//	
//	
	}
	
}
	


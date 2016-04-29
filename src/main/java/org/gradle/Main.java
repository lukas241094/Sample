package org.gradle;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
public class Main {

	public static void main(String[] args) {
		ArrayList<Molecule> molecules = new ArrayList<>();
		double qmThreshold = 5.0;
		double bufferThreshold = 11.0;
		
		
		Molecule core = new Molecule(0.0,0.0,0.0,0);
		
		DistanceCalculator distanceCalculator = new DistanceCalculator();
		
		for(int i=0;i<1000;i++){
			molecules.add(new Molecule(i));
//			System.out.println(molecules.get(i).getX());
//			System.out.println(molecules.get(i).getY());
//			System.out.println(molecules.get(i).getZ());
//			System.out.println(distanceCalculator.calculateDistance(core, molecules.get(i)));
//			System.out.println("");
		}
		
		long one = System.nanoTime();
		Map<Region, List<Molecule>> regions =
		molecules.stream()
				// .parallel()
				 .collect(
						 Collectors.groupingBy(molecule -> {
							 double distance = distanceCalculator.calculateDistance(core, molecule);
							 if (distance < qmThreshold){
							 return Region.QMZONE;
							 }
							 else if (distance > bufferThreshold){
							 return Region.MM;
							 }
							 else return Region.BUFFERZONE;
						 }));
		long end = System.nanoTime();
				
		System.out.println("calc Time "+((end-one)/1000000000.0));
		
		System.out.println(regions.get(Region.QMZONE).size());
		System.out.println(regions.get(Region.BUFFERZONE).size());
		System.out.println(regions.get(Region.MM).size());
		
		System.out.println(regions.get(Region.BUFFERZONE).size()+regions.get(Region.QMZONE).size()+regions.get(Region.MM).size());		 
	}
	
}
	


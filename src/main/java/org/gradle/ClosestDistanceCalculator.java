package org.gradle;

import java.util.Optional;
import java.util.OptionalDouble;

public class ClosestDistanceCalculator {
	
	private DistanceCalculator calculator = new DistanceCalculator();
	
	public double calculateClosestDistance(Molecule core, Molecule molecule){
		
		
		return             molecule.getAtoms().stream()
						   .flatMapToDouble( atom -> { return core.getAtoms().stream()
								   						             .mapToDouble( coreAtom -> {return calculator.calculateDistance(atom, coreAtom);});
						   })
						   .min()
						   .getAsDouble();
						   

	}
	
}

package org.gradle;

public class ClosestDistanceCalculator {
	
	DistanceCalculator calculator = new DistanceCalculator();
	
	public double calculateClosestDistance(Molecule core, Molecule molecule){
		
		
		return  molecule.getAtoms().stream()
						   .flatMapToDouble( (Atom atom) -> { return core.getAtoms().stream()
								   						             .mapToDouble( coreAtom -> {return (Double) calculator.calculateDistance(atom, coreAtom);});
						   })
						   .min()
						   .getAsDouble();	
	}
	
}

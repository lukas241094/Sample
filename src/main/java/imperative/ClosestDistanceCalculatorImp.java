package imperative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gradle.Atom;
import org.gradle.Molecule;

public class ClosestDistanceCalculatorImp {
	
	private DistanceCalculatorI distanceCalculator = new DistanceCalculatorI();
	
	public double calculateClosestDistance(Molecule core,Molecule molecule){
		List<Double> distances = new ArrayList<Double>();
		for (Atom atom : molecule.getAtoms()) {
			for(Atom coreAtom : core.getAtoms()){
				
			double tempdistance = distanceCalculator.calculateDistance(coreAtom,
					atom);
			distances.add(tempdistance);
			}
		}
		double distance = Collections.min(distances);
		return distance;
		
	}

}

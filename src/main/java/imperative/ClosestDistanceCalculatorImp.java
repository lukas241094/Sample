package imperative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestDistanceCalculatorImp {
	
	private DistanceCalculatorI distanceCalculator = new DistanceCalculatorI();
	
	public double calculateClosestDistance(MoleculeI core,MoleculeI molecule){
		List<Double> distances = new ArrayList<Double>();
		for (AtomI atom : molecule.getAtoms()) {
			for(AtomI coreAtom : core.getAtoms()){
				
			double tempdistance = distanceCalculator.calculateDistance(coreAtom,
					atom);
			distances.add(tempdistance);
			}
		}
		double distance = Collections.min(distances);
		return distance;
		
	}

}

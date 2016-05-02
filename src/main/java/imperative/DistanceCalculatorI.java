package imperative;

public class DistanceCalculatorI {
	
	public double calculateDistance(AtomI coreAtom, AtomI moleculeAtom){
		
		double distance = Math.sqrt((Math.pow(coreAtom.getX()-moleculeAtom.getX(), 2.0))+
				(Math.pow(coreAtom.getY()-moleculeAtom.getY(), 2.0))+
				(Math.pow(coreAtom.getZ()-moleculeAtom.getZ(), 2.0)));

				return distance;
	}

}

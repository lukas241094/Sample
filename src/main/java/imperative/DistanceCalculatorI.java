package imperative;

import org.gradle.Atom;

public class DistanceCalculatorI {
	
	public double calculateDistance(Atom coreAtom, Atom moleculeAtom){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		double distance = Math.sqrt((Math.pow(coreAtom.getX()-moleculeAtom.getX(), 2.0))+
				(Math.pow(coreAtom.getY()-moleculeAtom.getY(), 2.0))+
				(Math.pow(coreAtom.getZ()-moleculeAtom.getZ(), 2.0)));

				return distance;
	}

}

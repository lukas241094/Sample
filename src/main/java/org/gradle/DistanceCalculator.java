package org.gradle;

public class DistanceCalculator {
	
	public double calculateDistance(Molecule core,Molecule molecule){
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		double distance = Math.sqrt((Math.pow(core.getX()-molecule.getX(), 2.0))+
									(Math.pow(core.getY()-molecule.getY(), 2.0))+
									(Math.pow(core.getZ()-molecule.getZ(), 2.0)));
		
		return distance;
	}

}

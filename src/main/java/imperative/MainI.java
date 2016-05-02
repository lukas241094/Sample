package imperative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gradle.Molecule;
import org.gradle.Region;






public class MainI {

	public static void main(String[] args) {
		List<Molecule> molecules = new ArrayList();
		double qmThreshold = 2.0;
		double bufferThreshold = 5.0;
		ClosestDistanceCalculatorImp closestDistanceCalculator = new ClosestDistanceCalculatorImp();

		
		for(int i=0;i<10000;i++){
			molecules.add(new Molecule(i));
		}
		Molecule core = new Molecule(0);
		
		System.out.println("List created");
		System.out.println("Number of molecules "+ molecules.size());
		

		long start = System.currentTimeMillis();
		
		Map<Region, List<Molecule>> regions = new HashMap<>();
		List<Molecule> qmRegion = new ArrayList();
		List<Molecule> bufferRegion = new ArrayList();
		List<Molecule> mmRegion = new ArrayList();
		for (Molecule molecule : molecules){
			
			double distance = closestDistanceCalculator.calculateClosestDistance(core, molecule);
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
		System.out.println("Time sorting list in s " + duration);
		
		System.out.println("QM size " +  regions.get(Region.QMZONE).size());
		System.out.println("Buffer Size  " + regions.get(Region.BUFFERZONE).size());
		System.out.println("MM size " + regions.get(Region.MM).size());
		System.out.println(regions.get(Region.BUFFERZONE).size()+regions.get(Region.QMZONE).size()+regions.get(Region.MM).size());		 

	}
	
	

}

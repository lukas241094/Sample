package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoleculeI implements MoleculeInterface {
	
	private final List<AtomI> atoms = new ArrayList();
	
	private int index;
	
	
	public MoleculeI(int i){
		Random random = new Random();
		for(int j=0; j<= 3; j++) atoms.add(new AtomI());
		this.index = i;
	}


	public List<AtomI> getAtoms() {
		return atoms;
	}
	
	
}

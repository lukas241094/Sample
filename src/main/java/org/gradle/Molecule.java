package org.gradle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Molecule {
	
	private final List<Atom> atoms = new ArrayList();
	
	private int index;
	
	
	public Molecule(int i){
		Random random = new Random();
		for(int j=0; j< random.nextInt(5); j++) atoms.add(new Atom());
		this.index = i;
	}


	public List<Atom> getAtoms() {
		return atoms;
	}
	
	
}

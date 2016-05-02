package org.gradle;

import java.util.Random;

public class Atom implements AtomInterface{
	
	private final double x;
	private final double y;
	private final double z;
	public Atom() {
		Random random = new Random();
		this.x = random.nextDouble()*20;
		this.y = random.nextDouble()*20;
		this.z = random.nextDouble()*20;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}
	
	

}

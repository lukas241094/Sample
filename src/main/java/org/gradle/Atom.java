package org.gradle;

import java.util.Random;

public class Atom {
	
	private final double x;
	private final double y;
	private final double z;
	public Atom() {
		Random random = new Random();
		this.x = random.nextDouble()*10;
		this.y = random.nextDouble()*10;
		this.z = random.nextDouble()*10;
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

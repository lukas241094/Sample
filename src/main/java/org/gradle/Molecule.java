package org.gradle;

import java.util.Random;

public class Molecule {
	
	private double x;
	private double y;
	private double z;
	
	private int index;
	
	public Molecule(double x,double y,double z,int i){
		this.x = x;
		this.y = y;
		this.z = z;
		this.index = i;
	}
	
	public Molecule(int i){
		Random random = new Random();
		this.x = random.nextDouble() * 10;
		this.y = random.nextDouble() * 10;
		this.z = random.nextDouble() * 10;
		this.index = i;
	}



	public double getX() {
		return x;
	}



	public void setX(double x) {
		this.x = x;
	}



	public double getY() {
		return y;
	}



	public void setY(double y) {
		this.y = y;
	}



	public double getZ() {
		return z;
	}



	public void setZ(double z) {
		this.z = z;
	}
	


}

package imperative;

import java.util.Random;

public class AtomI implements AtomInterface{
	
	private final double x;
	private final double y;
	private final double z;
	public AtomI() {
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

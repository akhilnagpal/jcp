package algos.powof10;

public class PowOf10 {

	public static void main(String[] args) {
		checkpowof10(1000);
		checkpowof10(1001);
		checkpowof10(1);
		checkpowof10(0);
		checkpowof10(-10);
	}
	
	public static void checkpowof10(int x) {
		if(x!=0 && x%10==0 ) {
			System.out.println(x + " is a power of 10");
		} else {
			System.out.println(x + " is not a power of 10");
		}
	}

}

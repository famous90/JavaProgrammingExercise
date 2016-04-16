package BasicCal;

public class Power {
	
	static long power(int base, int exp){
		if(exp == 1) return base;
		else if(base == 0) return 1;
		
		if(exp % 2 == 0){
			long newBase = power(base, exp/2);
			return newBase * newBase;
		}else {
			long newBase = power(base, exp/2);
			return newBase * newBase * base;
		}
	}
	
	public static void main(String[] agrs){
		
		int base = 2;
		int exp = 30;
		System.out.println("power " + power(base, exp));
		
	}
}

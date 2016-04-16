package BasicCal;

public class PowerCopy {
	
	static long power(int base, int exp){
		
		if(exp == 1) return base;
		if(base == 0) return 1; 
		
		long result = power(base, exp/2);
		result *= result; 
		if(exp%2 == 1){
			result *= base;
		}
		
		return result;
	}
	
	public static void main(String[] agrs){
		
		int base = 2;
		int exp = 30;
		System.out.println("power " + power(base, exp));
		
	}
}

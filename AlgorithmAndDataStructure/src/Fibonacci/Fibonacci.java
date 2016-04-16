package Fibonacci;

public class Fibonacci {
	
	static long[][] multiply(long[][] a, long[][] b){
		long[][] result = new long[2][2];
		
		result[0][0] = a[0][0]*b[0][0] + a[0][1]*b[1][0];
		result[0][1] = a[0][0]*b[0][1] + a[0][1]*b[1][1];
		result[1][0] = a[1][0]*b[0][0] + a[1][1]*b[1][0];
		result[1][1] = a[1][0]*b[0][1] + a[1][1]*b[1][1];
		
		return result;
	}
	
	static long[][] power(long[][] base, int exp){
		
		if(exp == 1) return base;
		if(exp %2 == 0){
			long[][] result = power(base, exp/2);
			return multiply(result, result);
		}else{
			long[][] result = power(base, exp/2);
			return multiply(multiply(result, result), base);
		}
	}
	
	static long fibonacci(int n){
		long[][] a = new long[2][2];
		a[0][0] = 1;
		a[0][1] = 1;
		a[1][0] = 1;
		a[1][1] = 0;
		
		a = power(a, n);
		
		return a[0][1];
	}
	
	public static void main(String[] args){
		int n=46;
		long result = fibonacci(n);
		
		System.out.println(result);
	}
}

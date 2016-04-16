package Fibonacci;

public class FibonacciCopy {
	
	static long[][] multiply(long[][] a, long[][] b){
		long[][] result = new long[2][2];
		
		result[0][0] = a[0][0]*b[0][0] + a[0][1]*b[1][0];
		result[0][1] = a[0][0]*b[0][1] + a[0][1]*b[1][1];
		result[1][0] = a[1][0]*b[0][0] + a[1][1]*b[1][0];
		result[1][1] = a[1][0]*b[0][1] + a[1][1]*b[1][1];
		
		return result;
	}
	
	static long[][] power(long[][] a, int exp){
		if(exp == 1) return a;
		
		long[][] result = power(a, exp/2);
		result  = multiply(result, result);
		if(exp%2 == 1){
			result = multiply(result, a);
		}
		
		return result;
	}
	
	static long fibonacci(int n){
		
		long[][] a = new long[2][2];
		a[0][0] = 1;
		a[0][1] = 1;
		a[1][0] = 1;
		a[1][1] = 0;
		
		long[][] result = power(a, n);
		
		return result[1][0];
	}
	
	public static void main(String[] args){
		int n=46;
		long result = fibonacci(n);
		
		System.out.println(result);
	}
}

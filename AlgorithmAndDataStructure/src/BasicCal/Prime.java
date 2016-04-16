package BasicCal;

public class Prime {
	
	static boolean isPrime(int n){
		if(n < 2) return false;
		for(int i=2; i*i<=n; i++){
			if(n%i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		
		int n = 103;
		System.out.println(n + " is "+isPrime(n));
	}
}

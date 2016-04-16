package Normal.TopCoder;

public class HandShaking {
	
	static long countPerfect(int n){
		
		if(n <= 0) return 0;
		if(n%2 == 1) return 0;
		if(n == 2) return 1;
		
		return countPerfect(n-2)*3-1;
	}
	
	static long newPerfect(int n){
		long[] dp = new long[n/2+1];
		
		dp[0] = 1;
		for(int i=1; i<=n/2; i++){
//			dp[i] = 0;
			for(int j=0; j<i; j++){
				dp[i] += dp[j] * dp[i-j-1];
			}
		}
		
		return dp[n/2];
	}
	
	public static void main(String[] args){
		int n = 8;
//		long result = countPerfect(n);
		long result = newPerfect(n);
		
		System.out.println(result);
	}	
}

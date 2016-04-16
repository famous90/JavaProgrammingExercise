package binomialCoefficient;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;


public class Solution {
	private static Scanner sc;

	public static void main(String args[]) throws Exception	{
		sc = new Scanner(new FileInputStream("input.txt"));
        
//		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();      
		long mod = 1000000007;
		Combinator com = new Combinator(mod);
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			com.initDp(n, m);
			long result = com.getCombinator(n, m);

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(result%mod);
		}
	}
}


class Combinator {
	
	long[][] dp;
	long[] fact;
	long mod;
	
	public Combinator(long mod){
		this.dp = new long[1][1];
		this.dp[0][0] = 1;
		
		this.mod = mod;
		
		this.fact = new long[2];
		this.fact[0] = 1;
		this.fact[1] = 1;
	}
	
	public void initDp(int n, int m){
		int oldN = dp.length;
		int oldM = dp[0].length;
		int newM = m+1;
		int newN = newM + n+1;
		if(newN>=oldN || newM>=oldM){
			long[][] newDp = new long[newN][newM];
			for(int i=0; i<oldN; i++){
				System.arraycopy(this.dp[i], 0, newDp[i], 0, oldM);
			}
			this.dp = newDp;
		}
		 
		if(newN - 1 > this.fact.length){
			long[] newFact = new long[newN-1];
			System.arraycopy(this.fact, 0, newFact, 0, this.fact.length);
			this.fact = newFact;
		}
	}
	
	public long getCombinator(int n, int m){
		long sum = 0;
		for(int i=0; i<=n; i++){
			for(int j=0; j<=m; j++){
				sum = (sum + this.getDp(i+j, j))%this.mod;
			}
		}
		return sum;
	}
	
	public long getDp(int n, int r){
		if(this.dp[n][r] == 0) {
			if(r == 0 || r == n){
				this.dp[n][r] = 1;
			}else {
				this.dp[n][r] = ((getFactorial(n)/((getFactorial(n-r)*getFactorial(r)%this.mod))))%this.mod;
			}
		}
		return this.dp[n][r];
	}
	
	public long getFactorial(int n){
		if(this.fact.length < n) return 1;
		if(this.fact[n] != 0) return this.fact[n];
		else {
			this.fact[n] = (n * getFactorial(n-1))%this.mod;
			return this.fact[n];
		}
	}
}
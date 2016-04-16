package Normal.TopCoder;

public class Knapsack {
	static int[] ws = {3, 4, 1, 2, 3};
	static int[] ps = {2, 3, 2, 3, 6};
	static int maxw = 10;
	
	static int ret = 0;
	static int count = 0;
	
	static void knapsack(int n, int w, int p){
		count++;
		if(w>maxw) return;
		ret = Math.max(ret, p);
		if(n>=ws.length) return;
		knapsack(n+1, w, p);
		knapsack(n+1, w+ws[n], p+ps[n]);
	}
	
	static int newCount = 0;
	static int newKnapsack(int n, int w){
		newCount++;
		if(w>maxw) return -1;
		if(n>=ws.length) return 0;
		if(dp[n][w]>=0) return dp[n][w];
		return Math.max(newKnapsack(n+1, w), newKnapsack(n+1, w+ws[n])+ps[n]);
	}
	
	static int[][] dp = new int[ws.length+1][maxw+1];
	static int newRet = 0;
	
	static void calc(){
		dp[0][0] = 0;
		for(int i=0; i<ws.length; i++){
			for(int j=0; j<= maxw ; j++){
				if(j!=0 && dp[i][j]==0) continue;
//				System.out.println(i + " i");
				if((j+ws[i])<=maxw){
					dp[i+1][j+ws[i]] = Math.max(dp[i+1][j+ws[i]], dp[i][j]+ps[i]);
					dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
					newRet = Math.max(dp[i+1][j+ws[i]],	newRet);
				}
			}
		}
	}
	
	static void calculate(){
		count = 0;
		for(int i=0; i<ws.length; i++){
			for(int j=0; j<=maxw; j++){
				count++;
				int weight = ws[i];
				int price = ps[i];
				
				if(j!=0 && dp[i][j]==0) continue;
				if(j+weight > maxw) continue;
				
				dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
				dp[i+1][j+weight] = Math.max(dp[i+1][j+weight], dp[i][j] + price); 
			}
		}
	}
	
	public static void main(String[] args){
		for(int i =0; i<ws.length; i++){
			knapsack(i, 0, 0);
		}
		System.out.println(count);
		System.out.println(ret);
		
		for(int i =0; i<ws.length; i++){
			newKnapsack(i, 0);
		}
		System.out.println(newCount);
		
		calculate();
		System.out.println(count);
		
//		calc();
//		calculate();
//		for(int i=0; i<6; i++){
//			for(int j=0; j<11; j++){
//				System.out.print(dp[i][j]+ " ");
//			}
//			System.out.println("");
//		}
//		System.out.println(newRet);
		
	}
}

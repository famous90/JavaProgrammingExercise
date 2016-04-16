package BasicCal;

public class CountPath {
	
	static int h=1005, w=124;;
	
	static long dfs(int nowh, int noww){
		if(nowh > h || noww > w) return 0;
		if(nowh == h || noww == w) return 1;
		return dfs(nowh+1, noww) + dfs(nowh, noww+1);
	}
	
	static long[][] dp = new long[h+1][w+1];
	
	static long dfsMem(int nowh, int noww){
		if(nowh > h || noww > w) return 0;
		if(nowh == h || noww == w) return 1;
		if(dp[nowh][noww] != 0) return dp[nowh][noww];
		return dp[nowh][noww] = dfsMem(nowh+1, noww)+dfsMem(nowh, noww+1);
	}
	
	static long[][] newDP = new long[h+1][w+1];
	
	static void calc(){
		newDP[0][0] = 1;
		for(int i=0;i<=h; i++){
			for(int j=0; j<=w; j++){
				if(i!=0) newDP[i][j] += newDP[i-1][j];
				if(j!=0) newDP[i][j] += newDP[i][j-1];
			}
		}
	}
	
	public static void main(String[] args){
		
		int n = 103;
		System.out.println(n + " is " + dfsMem(0, 0));
		calc();
		System.out.println(n + " is " + newDP[h][w]);
		
	}
}

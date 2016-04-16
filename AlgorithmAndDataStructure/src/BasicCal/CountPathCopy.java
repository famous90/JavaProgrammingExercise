package BasicCal;

public class CountPathCopy {
	
	static int h=1005, w=124;;
	
	static long dfs(int nowh, int noww){
		if(nowh > h || noww > w) return 0;
		if(nowh == h || noww == w) return 1;
		return dfs(nowh+1, noww) + dfs(nowh, noww+1);
	}
	
	static long[][] board = new long[h+1][w+1];
	
	static long path(int hereX, int hereY){
		if(hereX < 0 || hereX>w || hereY<0 || hereY>h) return 0;
		if(hereX == 0 || hereY == 0) {
//			board[hereY][hereX] = 1;
			return 1;
		}
		if(board[hereY][hereX] != 0) return board[hereY][hereX];
		else {
			board[hereY][hereX] = path(hereX-1, hereY) + path(hereX, hereY-1);
			return board[hereY][hereX];
		}
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
	
	static long[][] ddp = new long[h+1][w+1];
	static void calculate(){
		ddp[0][0]	= 1;
		for(int i=0; i<=h; i++){
			for(int j=0; j<=w; j++){
				if(i!=0) ddp[i][j] += ddp[i-1][j];
				if(j!=0) ddp[i][j] += ddp[i][j-1];
			}
		}
	}
	
	public static void main(String[] args){
		
		System.out.println(path(w, h));
		System.out.println(dfsMem(0, 0));
		calc();
		System.out.println(newDP[h][w]);
		calculate();
		System.out.println(ddp[h][w]);
		
	}
}

package Normal.TopCoder;

public class ChessMetric {
	
	static long[][][] dp;
	static int[] moveX = {1, 1, 0, -1, -1, -1, 0, 1, 2, 1, -1, -2, -2, -1, 1, 2};
	static int[] moveY = {0, 1, 1, 1, 0, -1, -1, -1, 1, 2, 2, 1, -1, -2, -2, -1};
	
	static long howMany(int size, int[] start, int[] end, int numMoves){
		return moves(size, start, end, numMoves, start);
	}
	
	static long moves(int size, int[] start, int[] end, int moveCount, int[] here){
		int hereX = here[0], hereY = here[1];
//		System.out.println(hereX + " "+ hereY+ " "+moveCount);
		// 안되는 경우
		if(moveCount < 0) return 0;								// 더 움직일 수 없음 
		if(hereX <0 || hereX>=size || hereY < 0 || hereY>=size) return 0;	// 범위 바깥으로 가면 
		if(moveCount == 0 && !isEqual(here, end)) return 0;		// 더 움직일 수 없지만 도착 못하면 
		if(isEqual(here, start) && dp[start[0]][start[1]][0]!=0) return 0;	// 처음으로 다시 돌아오는 경우 
		
		// 되는 경우  
		if(isEqual(here, end) && moveCount == 0) return 1;		// 목표지점 도착  
		if((dp[hereX][hereY][0] != 0) && (dp[hereX][hereY][1] >= moveCount)) {								
			return dp[hereX][hereY][0];		 // 현재 지점에 이미 값이 있는 경우 -> 카운트가 적은 경우만
		}
		
		int result = 0;
		for(int i=0; i<moveX.length; i++){
			result += moves(size, start, end, moveCount-1, moveTo(here, i));
		}
		
		dp[hereX][hereY][0] = result;
		dp[hereX][hereY][1] = moveCount;
		
		return result;
	}
	
	static int[] moveTo(int[] from, int i){
		int[] there = new int[2];
		there[0] = from[0]+moveX[i];
		there[1] = from[1]+moveY[i];
		return there;
	}
	
	static boolean isEqual(int[] i, int[] j){
		if(i[0] == j[0] && i[1] == j[1]){
			return true;
		}else return false;
	}
	
	public static void main(String[] args){
		
		int size = 100;
		int[] start = {0, 0};
		int[] end = {0, 99};
		int numMoves = 50;
		dp = new long[size][size][numMoves];
//		long result = howMany(size, start, end, numMoves);
		long result = newHowLong(size, start, end, numMoves);
		
		System.out.println(result);
	}
	
	static long[][][] ways = new long[100][100][55];
	
	static long newHowLong(int size, int[] start, int[] end, int numMoves){
		int sx = start[0], sy = start[1], ex = end[0], ey = end[1];
		
		ways[sy][sx][0] = 1;
		
		for(int i=1; i<= numMoves; i++){
			for(int x=0; x<size; x++){
				for(int y=0; y<size; y++){
					if(ways[x][y][i-1] == 0) continue;
					for(int j=0; j<moveX.length; j++){
						int nx = x + moveX[j];
						int ny = y + moveY[j];
						if(nx<0 || nx>=size || ny<0 || ny>=size) continue;
						ways[ny][nx][i] += ways[y][x][i-1];
					}
				}
			}
		}
		
		return ways[ey][ex][numMoves];
	}
}

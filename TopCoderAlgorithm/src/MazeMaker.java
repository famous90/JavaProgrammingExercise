import java.util.LinkedList;
import java.util.Queue;

public class MazeMaker {
	public static void main(String[] args){
		String[] maze = {".......", "X.X.X..", "XXX...X", "....X..", "X....X.", "......."};
		int startRow = 5, startCol = 0;
		int[] moveRow = {1, 0, -1, 0, -2, 1};
		int[] moveCol = {0, -1, 0, 1, 3, 0};
		
		int result = longestPath(maze, startRow, startCol, moveRow, moveCol);
		
		System.out.println(result);
	}
	
	public static int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol){
		int max = 0;
		int width = maze[0].length(), height = maze.length;
		int[][] board = new int[height][width];
		
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				board[i][j] = -1;
			}
		}
		
		board[startRow][startCol] = 0;
		
		Queue<Integer> queueX = new LinkedList<Integer>();
		Queue<Integer> queueY = new LinkedList<Integer>();
		queueX.add(startCol);
		queueY.add(startRow);
		
		while(!queueX.isEmpty()){
			int x = queueX.poll();
			int y = queueY.poll();
			
			for(int i=0; i<moveRow.length; i++){
				int nextX = x+moveCol[i];
				int nextY = y+moveRow[i];
				
				if((0<=nextX) && (nextX < width) && (0<=nextY) && (nextY < height) && (board[nextY][nextX] == -1) && (maze[nextY].charAt(nextX) == '.')){
					board[nextY][nextX] = board[y][x]+1;
					queueX.add(nextX);
					queueY.add(nextY);
				}
			}
		}
		
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				if(maze[i].charAt(j) == '.' && board[i][j] == -1){
					return -1;
				}
				max = Math.max(max, board[i][j]);
			}
		}
		
		return max;
	}
	
//	static String[] maza;
//	static int[] moveRows;
//	static int[] moveCols;
//	
//	
//	public static int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol){
//		
//		maza = maze;
//		moveRows = moveRow;
//		moveCols = moveCol;
//		
//		int depth = move(startRow, startCol, 0);
//		
//		for(int i=0; i<maza.length; i++){
//			for(int j=0; j<maza[i].length(); j++){
//				if(maza[i].charAt(j) == '.'){
//					return -1;
//				}
//			}
//		}
//		
//		
//		return depth;
//	}
//	
//	static int move(int x, int y, int step){
//		
//		char here = maza[y].charAt(x);
//		if(here == 'X' || here == 'V'){
//			return step;
//		}
//		
//		int max = step;
//		String str = maza[x];
//		maza[x] = str.substring(0, y) + 'V' + str.substring(y+1);
//		for(int i=0; i<moveRows.length; i++){
//			int nextX = x+moveCols[i];
//			int nextY = y+moveRows[i];
////			System.out.println("move to "+nextX+" "+nextY);
//			if((nextX<0) || (nextX>=maza[0].length()) || (nextY<0) || (nextY>=maza.length)){
////				System.out.println("dont go");
//				continue;
//			}else {
////				System.out.println("go");
//				max = Math.max(max, move(nextX, nextY, step+1));
//			}
//		}
//		
//		// return depth;
//		return max;
//	}
}

//import java.awt.Point;
//import java.util.ArrayList;

public class CrazyBot {
	
//	public static double e, w, s, n;
//	public static int totalStep;
//	public static double totalPro;
	
	public static void main(String[] args){
		int n=2, east = 25, west = 25, south = 25, north= 25;
		double result = getProbability(n, east, west, south, north);
		
		System.out.println(result);
	}
	
	static boolean[][] grid = new boolean[100][100];
	static int vx[] = {1, -1, 0, 0};
	static int vy[] = {0, 0, 1, -1};
	
	static double[] prob = new double[4];
	
	public static double getProbability(int n, int east, int west, int south, int north){
		prob[0] = east/100.0;
		prob[1] = west/100.0;
		prob[2] = south/100.0;
		prob[3] = north/100.0;
		
		return dfs(50, 50, n);
	}
	
	static double dfs(int x, int y, int n){
		
		if(grid[x][y]) return 0;
		if(n == 0) return 1;
		
		grid[x][y] = true;
		double ret = 0;
		for(int i=0; i<4; i++){
			ret += (dfs(x+vx[i], y+vy[i], n-1)*prob[i]);
		}
		grid[x][y] = false;
		
		return ret;
	}
	
//	public static double getProbability(int length, int east, int west, int south, int north){
//		
//		e = east/100;
//		w = west/100;
//		s = south/100;
//		n = north/100;
//		totalPro = 0;
//		totalStep = length;
//		double pro = 1;
//		
//		Point start = new Point(0, 0);
//		ArrayList<Point> history = new ArrayList<Point>();
//		history.add(start);
//		moveTo(length, pro, history);
//		
//		return totalPro;
//	}
//	
//	static void moveTo(int leftStep, double pro, ArrayList<Point> history){
//		
//		Point lastPoint = history.get(history.size()-1);
//		
//		for(int i=history.size()-2; i>=0; i++){
//			if(history.get(i).x == lastPoint.x && history.get(i).y == lastPoint.y){
//				return;
//			}
//		}
//		
//		if(leftStep == 0){
//			totalPro += pro;
//			return;
//		}else {
//			leftStep--;
//			
//			for(int i=0; i<4; i++){
//				Point point = null;
//				double nextPro = pro;
//				switch(i){
//				case 1:
//					point = new Point(lastPoint.x+1, lastPoint.y);
//					nextPro *= e;
//					break;
//				case 2:
//					point = new Point(lastPoint.x-1, lastPoint.y);
//					nextPro *= w;
//					break;
//				case 3:
//					point = new Point(lastPoint.x, lastPoint.y+1);
//					nextPro *= s;
//					break;
//				case 4:
//					point = new Point(lastPoint.x, lastPoint.y-1);
//					nextPro *= n;
//					break;
//				}
//				history.add(point);
//				moveTo(leftStep, nextPro, history);
//			}
//		}
//	}
}

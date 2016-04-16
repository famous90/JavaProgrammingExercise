package dartGame;

import java.lang.Math;
import java.util.Scanner;
import java.io.FileInputStream;


public class Solution {
	private static Scanner sc;
	private static DartBull dart;

	public static void main(String args[]) throws Exception	{
		sc = new Scanner(new FileInputStream("input.txt"));
        
//		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int e = sc.nextInt();
			dart = new DartBull(a, b, c, d, e);
			
			int countOfThrows = sc.nextInt();
			int totalScore = 0;
			for(int i=0; i<countOfThrows; i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				int score = dart.getScore(x, y);
				totalScore += score;
			}
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(totalScore);
		}
	}
}

class DartBull {
	
	int radiusOfBull, radiusOfTripleStart, radiusOfTripleEnd, radiusOfDoubleStart, radiusOfDoubleEnd;
	int[] basePoint = {6, 13, 4, 18, 1, 20, 5, 12, 9, 14, 11, 8, 16, 7, 19, 3, 17, 2, 15, 10};
	
	public DartBull(int bull, int tripleStart, int tripleEnd, int doubleStart, int doubleEnd) {
		this.radiusOfBull = bull;
		this.radiusOfTripleStart = tripleStart;
		this.radiusOfTripleEnd = tripleEnd;
		this.radiusOfDoubleStart = doubleStart;
		this.radiusOfDoubleEnd = doubleEnd;
	}
	
	public int getScore(int x, int y){
		System.out.println("x : "+x + " y : "+y);
		double radius = Math.sqrt(x*x+y*y);
		double radian = Math.atan2(y, x);
		
		System.out.println("radius : "+radius + " radian : "+radian);
		
		int multiplePoint = 1;
		if(radius < this.radiusOfBull){
			System.out.println("BULL");
			return 50;
		}else if(this.radiusOfTripleStart < radius && radius < this.radiusOfTripleEnd){
			multiplePoint = 3;
		}else if(this.radiusOfDoubleStart < radius && radius < this.radiusOfDoubleEnd){
			multiplePoint = 2;
		}else if(this.radiusOfDoubleEnd < radius){
			System.out.println("no point");
			return 0;
		}
		
		int basePoint = this.getBasePoint(radius, radian);
		
		System.out.println("base : "+basePoint + " multi : "+multiplePoint);
		
		return basePoint * multiplePoint;
	}
	
	public int getBasePoint(double r, double theta){
		
		if(theta<0){
			theta += (Math.PI*2);
		}
		theta += Math.PI/20;
		int section = (int) (theta/(Math.PI/10));
		
		if(section == 20){
			section = 0;
		}
		
		System.out.println("section: "+section);
		
		return this.basePoint[section];
	}
}





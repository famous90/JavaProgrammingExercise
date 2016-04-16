package FlatNumber;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
        
//		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
        
			int countOfLines = sc.nextInt();
			int[][] lines = new int[countOfLines][5];
			for(int i=0; i<countOfLines; i++){
				for(int j=0; j<4; j++){
					// x1, y1, x2, y2
					lines[i][j] = sc.nextInt();
				}
			}
			
			double[] center = new double[2];
			double radius = 0;
			
			int tempX1, tempY1;
			double tempMin = -1;
			for(int i=0; i<2; i++){
				tempX1 = lines[0][0+i*2];
				tempY1 = lines[0][1+i*2];
				for(int j=0; j<2; j++){
					int tempX2 = lines[1][0+j*2];
					int tempY2 = lines[1][1+j*2];
					double tempD = Math.sqrt((tempX1-tempX2)*(tempX1-tempX2)+(tempY1-tempY2)*(tempY1-tempY2));
					if(tempMin == -1 || tempMin > tempD){
						center[0] = (tempX1+tempX2)/2.0;
						center[1] = (tempY1+tempY2)/2.0;
						lines[1][4] = j+1;
						lines[0][4] = i+1;
						System.out.println(lines[0][4]+" "+lines[1][4]);
						radius = tempD/2.0;
						tempMin = radius;
					}
				}
			}
			System.out.println(center[0] + " "+center[1]+ " "+radius);
			
			if(countOfLines>2){
				for(int i=2; i<countOfLines; i++){
					
					double cx = center[0];
					double cy = center[1];
					int x1 = lines[i][0];
					int y1 = lines[i][1];
					int x2 = lines[i][2];
					int y2 = lines[i][3];
					
					double distance1 = Math.sqrt((cx-x1)*(cx-x1) + (cy-y1)*(cy-y1));
					double distance2 = Math.sqrt((cx-x2)*(cx-x2) + (cy-y2)*(cy-y2));
					
					double distance = 0;
					int thisX, thisY;
					if(distance1 < distance2){
						distance = distance1;
						lines[i][4] = 1;
						thisX = lines[i][0];
						thisY = lines[i][1];
					}else {
						distance = distance2;
						lines[i][4] = 2;
						thisX = lines[i][2];
						thisY = lines[i][3];
					}
					
					if(distance > radius){
						//find
						double max = 0;
						double newcx = 0, newcy = 0;
						for(int j=0; j<i; j++){
							int x, y;
							if(lines[j][4] == 1){
								x = lines[j][0];
								y = lines[j][1];
							}else{
								x = lines[j][2];
								y = lines[j][3];
							}
							
							if(max < Math.sqrt((thisX-x)*(thisX-x)+(thisY-y)*(thisY-y))){
								max = Math.sqrt((thisX-x)*(thisX-x)+(thisY-y)*(thisY-y));
								newcx = (thisX + x)/2.0;
								newcy = (thisY + y)/2.0;
							}
						}
						center[0] = newcx;
						center[1] = newcy;
						radius = max/2;
					}
				}
			}
			
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(radius);
			
		}
	}
}
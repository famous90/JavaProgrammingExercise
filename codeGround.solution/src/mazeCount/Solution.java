package mazeCount;

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
        
			int mazeSize = sc.nextInt();
			int round = sc.nextInt();
			String directions = sc.next();
			int x = 0;
			int y = 0;
			int sum = 1;
			
			for(int i=0; i<round; i++){
				char direction = directions.charAt(i);
				switch(direction){
				case 'U':
					y--;
					break;
				case 'D':
					y++;
					break;
				case 'L':
					x--;
					break;
				case 'R':
					x++;
					break;
				}
				sum += getPoint(mazeSize, x, y);
			}
        
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(sum);
			
		}
	}
	
	static int getPoint(int size, int x, int y){
		
		int sum = x+y;
		int round = 0;
		int lastPoint = size * size;
		int point = 0;
		boolean isFront = true;
		int first = 0;
		
		// sum 이 뒷편인경우 생각
		if(sum<size){
			isFront = true;
		}else {
			isFront = false;
//			sum = 2*(size-1) - sum;
//			int temp = x;
			x = (size-1) - x;
			y = (size-1) - y;
			sum = x+y;
		}
		
		if(sum%2 == 0){
			// even
			round = sum/2 + 1;
			if(round == 1){
				first = 1;
			}else {
				first = round*round*2 - 3*round + 2;
			}
			point = first + x;
		}else {
			// odd
			round = sum/2 +1;
			if(sum == 1){
				first = 2;
			}else {
				first = round*round*2 - round + 1;
			}
			point = first + y;
		}
		
		if(!isFront){
			point = lastPoint + 1 - point;
		}
//		System.out.println(x +" " + y +" " +point + " "+ first + " "+ round + " " + isFront);
		return point;
	}
}
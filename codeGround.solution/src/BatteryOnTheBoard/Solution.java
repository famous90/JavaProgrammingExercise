package BatteryOnTheBoard;

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
        
			int number = sc.nextInt();
			int result = -1;
			
			for(int i=2; i<number; i++){
				int temp = number;
				boolean isFlat = false;
				while(temp>1){
					int rest = 0;
					 if(((temp/i)%i) == (temp%i)){
						 rest = temp % i;
						 temp = temp/i;
					 }else {
						 break;
					 }
					 if(temp == rest){
						 isFlat = true;
					 }
				}
				if(isFlat){
					result = i;
					break;
				}
			}
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(result);
			
		}
	}
}
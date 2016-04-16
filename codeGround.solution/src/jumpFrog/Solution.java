package jumpFrog;

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
        
			int rocks = sc.nextInt();
			int[] steppingStone = new int[rocks];
			for(int i=0; i<rocks; i++){
				int positionOfRock = sc.nextInt();
				steppingStone[i] = positionOfRock;
			}
			
			int maxJumpping = sc.nextInt();
			
			int position = 0;
			int positionIndex = 0;
			int nextIndex = 1;
			int steps = 0;
			int destination = steppingStone[rocks-1];
			boolean canGo = true;
			while(position < destination && canGo){
				
				int i=1;
				while(i>=0 && rocks > positionIndex+i){
					if(steppingStone[positionIndex+i] - position == maxJumpping){
						nextIndex = positionIndex + i;
						break;
					}else if(steppingStone[positionIndex+i] - position < maxJumpping){
						nextIndex = positionIndex + i;
						i++;
					}else {
						if(i==1){
							canGo = false;
							steps = -1;
						}
						break;
					}	
				}
				
				if(canGo){
					position = steppingStone[nextIndex];
					positionIndex = nextIndex;
					steps++;
				}
			}
			
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(steps);
			
		}
	}
}

//int nextPosition = position + maxJumpping;
//while(nextPosition>position){
//	int search = Arrays.binarySearch(steppingStone, nextPosition);
//	if(search>0){
//		position = steppingStone[search];
//		steps++;
//		break;
//	}
//	nextPosition--;
//	
//	if(nextPosition == position){
//		steps = -1;
//		canGo = false;
//		break;
//	}
//}

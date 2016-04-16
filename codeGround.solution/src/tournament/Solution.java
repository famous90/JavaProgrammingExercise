package tournament;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


public class Solution {
	private static Scanner sc;

	public static void main(String args[]) throws Exception	{
		sc = new Scanner(new FileInputStream("input.txt"));

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			
			int countOfSubjects = sc.nextInt();
			int countOfSelect = sc.nextInt();
			
			int[] scores = new int[countOfSubjects];
			for(int i=0; i<countOfSubjects; i++){
				scores[i] = sc.nextInt();
			}
			
			Arrays.sort(scores);
			int maxTotalScore = 0;
			int countOfLeftSubjects = countOfSubjects - countOfSelect;
			for(int i=countOfSubjects-1; i>(countOfLeftSubjects-1); i--) {
				maxTotalScore += scores[i];
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(maxTotalScore);
		}
	}
}

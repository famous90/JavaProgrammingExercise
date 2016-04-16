package studyForExam;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


public class Solution {
	private static Scanner sc;

	public static void main(String args[]) throws Exception	{
		sc = new Scanner(new FileInputStream("input.txt"));
        
//		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			
			int countOfTestees = sc.nextInt();
			int maxScoreInRound = 0;
			int maxScoreCanGet = countOfTestees;
			
			int[] scores = new int[countOfTestees]; 
			
			// insert data
			for(int i=0; i<countOfTestees; i++) {
				int totalScore = sc.nextInt();
				if(maxScoreInRound < totalScore){
					maxScoreInRound = totalScore;
				}
				if(totalScore + maxScoreCanGet > maxScoreInRound){
					scores[i] = totalScore;
				}
			}
			
			// find max score
			Arrays.sort(scores);
			for(int i=0; i<scores.length; i++){
				int score = scores[i];
				int nextScore = score + maxScoreCanGet - i;
				if(maxScoreInRound < nextScore){
					maxScoreInRound = nextScore;
				}
			}
			
			// get result
			int countOfWinner = 0;
			for(int i=0; i<scores.length; i++){
				if(scores[i] + maxScoreCanGet >= maxScoreInRound){
					countOfWinner++;
				}
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(countOfWinner);
		}
	}
}

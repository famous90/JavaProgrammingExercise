package BinarySearch;

public class BinarySearch {
	
	static int binarysearch(int[] scoreList, int target){
		
		int length = scoreList.length;
		int left = 0;
		int right = length-1;
		int middle = 0;
		
		while(left<=right){
			middle = (right+left)/2;
			if(target == scoreList[middle]){
				return middle;
			}else if(target < scoreList[middle]){
				right = middle - 1;
			}else {
				left = middle + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		int[] scoreList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 1000, 10000, 100000, 121313, 1232342};
		
		System.out.println("search index "+binarysearch(scoreList, 3));
	}

}

package BinarySearch;

public class BinarySearchCopy {
	
	static int binarysearch(int[] dataset, int target){
		int left=0, right = dataset.length, middle = (left + right)/2;
		while(left<=right){
			if(dataset[middle] == target){
				return middle;
			}else if(target < dataset[middle]){
				right = middle-1;
			}else {
				left = middle+1;
			}
			middle = (left+right)/2;
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		int[] scoreList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 1000, 10000, 100000, 121313, 1232342};
		
		System.out.println("index "+binarysearch(scoreList, 3)+" search for 3");
		System.out.println("index "+binarysearch(scoreList, 11)+" search for 11");
	}

}

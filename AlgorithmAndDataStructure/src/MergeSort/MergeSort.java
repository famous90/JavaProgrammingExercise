package MergeSort;

public class MergeSort {
	
	static void mergesort(int[] dataset, int left, int right){
		if(right - left < 1) return;
		
//		if(left<right){
			int middle = (left + right)/2;
			mergesort(dataset, left, middle);
			mergesort(dataset, middle+1, right);
			
			merge(dataset, left, middle, right);
//		}
	}
	
	static void merge(int[] dataset, int start, int middle, int end){
		
		int leftIndex = start;
		int rightIndex = middle+1;
		int destIndex = 0;
		int length = end-start+1;
		int[] sorted = new int[length];
		
		while(leftIndex <= middle && rightIndex<= end){
			if(dataset[leftIndex]<dataset[rightIndex]){
				sorted[destIndex++] = dataset[leftIndex++];
			}else{
				sorted[destIndex++] = dataset[rightIndex++];
			}
		}
		
		while(leftIndex <= middle){
			sorted[destIndex++] = dataset[leftIndex++];
		}
		
		while(rightIndex <= end){
			sorted[destIndex++] = dataset[rightIndex++];
		}
		
		destIndex = 0;
		for(int i=start; i<=end; i++){
			dataset[i] = sorted[destIndex++];
		}
	}
	
	public static void main(String[] args){
		int dataset[] = {6, 4, 2, 3, 3, 6, 2, 6 ,8 ,3, 9, 0, 1, 2, 5, 7, 8, 0, 10, 1, 5};
		int length = dataset.length;
		
		mergesort(dataset, 0, length-1);
		
		printData(dataset);
	}
	
	static void printData(int[] dataset){
		for(int i=0; i<dataset.length; i++){
			System.out.print(dataset[i] + " ");
		}
		System.out.println("");
	}
}

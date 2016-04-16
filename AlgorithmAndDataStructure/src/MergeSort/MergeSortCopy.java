package MergeSort;

public class MergeSortCopy {
	
	static void mergesort(int[] dataset, int left, int right){
		if(left < right){
			int middle = (left+right)/2;
			
			mergesort(dataset, left, middle);
			mergesort(dataset, middle+1, right);
			
			merge(dataset, left, middle, right);
		}
	}
	
	static void merge(int[] dataset, int start, int middle, int end){
		int left = start, right = middle+1, dest = 0, length = end-start+1;
		int[] sorted = new int[length];
		
		while(left <= middle && right<=end){
			if(dataset[left]<=dataset[right]){
				sorted[dest++] = dataset[left++];
			}else sorted[dest++] = dataset[right++];
		}
		
		while(left<=middle){
			sorted[dest++] = dataset[left++];
		}
		
		while(right<=end){
			sorted[dest++] = dataset[right++];
		}
		
		dest = 0;
		for(int i=start; i<=end; i++){
			dataset[i] = sorted[dest++];
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

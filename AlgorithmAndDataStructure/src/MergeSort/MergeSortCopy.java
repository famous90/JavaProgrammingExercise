package MergeSort;

public class MergeSortCopy {
	
	static void mergesort(int[] dataset, int start, int end){
		int middle = (start+end)/2;
		if(start < end){
			mergesort(dataset, start, middle);
			mergesort(dataset, middle+1, end);
			
			merge(dataset, start, middle, end);
		}
	}
	
	static void merge(int[] dataset, int start, int middle, int end){
		int length = end - start + 1;
		int left = start;
		int right = middle+1;
		int dest = 0;
		int[] sorted = new int[length];
		
		while((left<=middle) && (right<= end)){
			if(dataset[left]<dataset[right]){
				sorted[dest++] = dataset[left++];
			}else {
				sorted[dest++] = dataset[right++];
			}
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

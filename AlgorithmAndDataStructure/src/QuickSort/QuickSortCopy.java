package QuickSort;

public class QuickSortCopy {
	
	static void swap(int[] array , int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	static int partition(int[] dataset, int left, int right){
		
		int first = left;
		int pivot = dataset[left++];
		
		while(left <= right){
			while(dataset[left] <= pivot && left < right){
				left++;
			}
			while(pivot < dataset[right] && left <= right){
				right--;
			}
			
			if(left < right){
				swap(dataset, left, right);
			}else break;
		}
		
		swap(dataset, first, right);
		
		return right;
	}
	
	static void quicksort(int[] dataset, int left, int right){
		if(left<right){
			int middle = partition(dataset, left, right);
			
			quicksort(dataset, left, middle-1);
			quicksort(dataset, middle+1, right);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		int dataset[] = {6, 4, 2, 3, 3, 6, 2, 6 ,8 ,3, 9, 0, 1, 2, 5, 7, 8, 0, 10, 1, 5};
		int length = dataset.length;
		
		quicksort(dataset, 0, length-1);
		
		printData(dataset);
	}
	
	static void printData(int[] dataset){
		for(int i=0; i<dataset.length; i++){
			System.out.print(dataset[i] + " ");
		}
		System.out.println("");
	}
}

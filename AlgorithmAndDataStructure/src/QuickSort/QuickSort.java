package QuickSort;

public class QuickSort {
	
	static void swap(int[] array, int first, int second){
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	
	static int partition(int dataset[], int left, int right){
		
		int first = left;
		int pivot = dataset[left];
		
		left++;
		
		while(left<=right){
			while(dataset[left] <= pivot && left<right){
				left++;
			}
			while(dataset[right] > pivot && left <= right){
				right--;
			}
			
			if(left<right){
				swap(dataset, left, right);
			}else {
				break;
			}
		}
		
		swap(dataset, first, right);
		
		return right;
	}
	
	static void qsort(int dataset[], int left, int right){
		
		
//		if(left < middle){
//			qsort(dataset, left, middle-1);
//		}else if(middle < right){
//			qsort(dataset, middle+1, right);
//		}
		if(left<right){
			int middle = partition(dataset, left, right);
			qsort(dataset, left, middle-1);
			qsort(dataset, middle+1, right);
		}
	}
	
	public static void main(String[] args){
		int dataset[] = {6, 4, 2, 3, 1, 5};
		int length = dataset.length;
		
		qsort(dataset, 0, length-1);
		
		for(int i=0; i<length; i++){
			System.out.print(dataset[i] + " ");
		}
		System.out.println("");
	}
}

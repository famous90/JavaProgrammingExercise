package PriorityQueue;

public class PriorityQueue {
	
	static int[] heap = new int[3];
	static int last = -1;
	
	static void insert(int data){
		
		if(heap.length-1 == last){
			int capa = heap.length*2;
			int[] newHeap = new int[capa];
			for(int i=0; i<heap.length; i++){
				newHeap[i] = heap[i];
			}
			heap = newHeap;
		}
		
		last++;
		heap[last] = data;
		int dataIndex = last;
		while(dataIndex >= 0){
			int parentIndex = getParent(dataIndex);
			if(parentIndex>=0 && data < heap[parentIndex]){
				swap(dataIndex, parentIndex);
				dataIndex = parentIndex;
			}else{
				break;
			}
			
			if(dataIndex == 0) break;
		}
	}
	
	static void delete(){
		swap(0, last);
		heap[last--] = 0;
		
		int data = heap[0];
		int dataIndex = 0;
		
		while(dataIndex <= last){
			int leftChildIndex = getLeftChild(dataIndex);
			if(leftChildIndex > last) break;
			if(heap[leftChildIndex] < data && (heap[leftChildIndex] < heap[leftChildIndex+1] || leftChildIndex==last)){
				swap(leftChildIndex, dataIndex);
				data = heap[leftChildIndex];
				dataIndex = leftChildIndex;
			}else if((leftChildIndex+1 <= last) && (heap[leftChildIndex+1] < data && heap[leftChildIndex+1] < heap[leftChildIndex])){
				swap(leftChildIndex+1, dataIndex);
				data = heap[leftChildIndex+1];
				dataIndex = leftChildIndex+1;
			}else break;
		}
	}
	
	static void swap(int i, int j){
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	static int getParent(int index){
		if(index == 0) return -1;
		return (index-1)/2;
	}
	
	static int getLeftChild(int index){
		int childIndex = index*2+1;
		return childIndex;
	}
	
	static void printNode(){
		for(int i=0; i<=last; i++){
			System.out.print(heap[i]+ " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args){
		
		insert(12);
		insert(87);
		insert(111);
		insert(34);
		insert(16);
		insert(75);
		
		printNode();
		
		delete();
		printNode();
		delete();
		printNode();
		delete();
		
		printNode();
	}
}

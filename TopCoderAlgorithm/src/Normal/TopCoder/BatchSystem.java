package Normal.TopCoder;

import java.util.HashMap;

public class BatchSystem {
	
	static void schedule(int[] duration, String[] user){
		
		quicksort(duration, user, 0, duration.length-1);
	}
	
	public static void main(String[] args){
		int[] duration = {400, 100, 100, 100};
		String[] user = {"Danny Messer", "Stella", "Bonasera", "Mac"};
		
		schedule(duration, user);
		print(duration, user);
	}
	
	static void quicksort(int[] duration, String[] user, int left, int right){
		if(left<right){
			int middle = partition(duration, user, left, right);
			
			quicksort(duration, user, left, middle-1);
			quicksort(duration, user, middle+1, right);
		}
	}
	
	static void print(int[] duration, String[] user){
		for(int i=0; i<duration.length; i++){
			System.out.print(duration[i] + " ");
		}
		System.out.println("");
		for(int i=0; i<duration.length; i++){
			System.out.print(user[i] + " ");
		}
		System.out.println("");
	}
	
	static int partition(int[] duration, String[] user, int left, int right){
		int first = left;
		int pivotInt = duration[first];
		String pivotStr = user[first];
		left++;
		
		while(left<=right){
			while(duration[left]<=pivotInt && left<right){
				if(duration[left] == pivotInt && user[left].compareTo(pivotStr)>0) break;
				left++;
			}
						
			while(pivotInt<=duration[right] && left<= right){
				if(duration[right] == pivotInt && user[right].compareTo(pivotStr)<0) break;
				right--;
			}
			
			if(left<right){
				swap(duration, user, left, right);
			}else break;
		}
		
		swap(duration, user, first, right);
		
		return right;
	}
	
	static void swap(int[] duration, String[] user, int left, int right){
		int tempInt = duration[left];
		String tempStr = user[left];
		
		duration[left] = duration[right];
		user[left] = user[right];
		
		duration[right] = tempInt;
		user[right] = tempStr;
	}
	
	static int[] newSchedule(int[] duration, String[] user){
		int n = duration.length;
		
		HashMap<String, Long> jobTime = new HashMap<String, Long>();
		for(int i=0; i<n; i++) {
			jobTime.put(user[i], 0L);
		}
		for(int i=0; i<n; i++) {
			jobTime.put(user[i], duration[i]+jobTime.get(user[i]));
		}
		
		boolean[] done = new boolean[n];
		int[] ans = new int[n];
		int ansCount = 0;
		while(ansCount < n){
			String next = "";
			for(int i=0; i<n; i++){
				if(!done[i] && (next.equals("") || jobTime.get(user[i]) < jobTime.get(next))){
					next = user[n];
				}
			}
			
			for(int i=0; i<n; i++){
				if(user[i].equals(next)){
					done[n] = true;
					ans[ansCount++] = n;
				}
			}
		}
		
		return ans;
	}
}

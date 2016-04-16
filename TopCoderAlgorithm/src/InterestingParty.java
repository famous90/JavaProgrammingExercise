import java.util.HashMap;

class InterestingParty {
	public static void main(String[] args) {
		String[] first = {"t", "o", "p", "c", "o", "d", "e", "r", "s", "i", "n", "g", "l", "e", "r", "o", "u", "n", "d", "m", "a", "t", "c", "h", "f", "o", "u", "r", "n", "i"};
		String[] second = {"n", "e", "f", "o", "u", "r", "j", "a", "n", "u", "a", "r", "y", "t", "w", "e", "n", "t", "y", "t", "w", "o", "s", "a", "t", "u", "r", "d", "a", "y"};
//		String[] first = {"fishing", "gardening", "swimming", "fishing"};
//		String[] second = {"hunting", "fishing", "fishing", "biting"};
		
		int result = bestInvitation(first, second);
		
		System.out.println(result);
		System.out.println(bestInt(first, second));
//		System.out.print("{ ");
//		for(int i=0; i<result.length; i++){
//			System.out.print(result[i]+" ");
//		}
//		System.out.print("}");
	}
	
	static int bestInt(String[] first, String[] second){
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		
		for(int i=0; i<first.length; i++){
			if(hash.containsKey(first[i])){
				hash.put(first[i], hash.get(first[i])+1);
			}else {
				hash.put(first[i], 1);
			}			
			if(hash.containsKey(second[i])){
				hash.put(second[i], hash.get(second[i])+1);
			}else {
				hash.put(second[i], 1);
			}			
		}
		
		int max = 0;
		for(String key: hash.keySet()){
			max = Math.max(max, hash.get(key));
		}
		
		return max;
	}
	
	public static int bestInvitation(String[] first, String[] second){
		
		HashMap<String, Integer> interesting = new HashMap<String, Integer>();
		
		for(int i=0; i<first.length; i++){
			String temp1 = first[i];
			String temp2 = second[i];
			
			if(interesting.get(temp1) == null){
				interesting.put(temp1, 0);
			}
			if(interesting.get(temp2) == null){
				interesting.put(temp2, 0);
			}
			
			interesting.put(temp1, (interesting.get(temp1)+1));
			interesting.put(temp2, (interesting.get(temp2)+1));
		}
		
		int result = 0;
		for(String key : interesting.keySet()){
			result = Math.max(result, interesting.get(key));
		}
		
		return result;
	}
}

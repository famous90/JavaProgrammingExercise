import java.util.ArrayList;

public class InterestingDigit {
	
	public static void main(String[] args) {
		int base = 9;
		
		int[] result = digits(base);
		
		System.out.print("{ ");
		for(int i=0; i<result.length; i++){
			System.out.print(result[i]+" ");
		}
		System.out.print("}");
	}
	
	public static int[] digits(int base){
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=2; i<=base; i++){
			// correct
			if(((base-1) % i)==0){
				result.add(i);
			}
		}
		
		int[] digits = new int[result.size()];
		for(int i=0; i<result.size(); i++){
			digits[i] = result.get(i);
		}
		
		return digits;
	}
}

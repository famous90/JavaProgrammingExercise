
public class Cryptography {
	static long encrypt(int[] number){
		
		int min = Integer.MAX_VALUE;
		int total = 1;
		
		for(int i=0; i<number.length; i++){
			min = Math.min(min, number[i]);
			total *= number[i];
		}
		
		if(min != 0){
			total /= min;
			total *= (min+1);
		}
		
		
		return total;
	}
	
	public static void main(String[] args){
		int[] numbers = {1000, 999, 998, 997, 996, 995};
		System.out.println(encrypt(numbers));
	}
}


public class Cryptography {
	public long encrypt(int[] number){
		
		int min = 0;
		int total = 1;
		
		for(int i=0; i<number.length; i++){
			min = Math.min(min, number[i]);
			total *= number[i];
		}
		
		total /= min;
		total *= (min+1);
		
		return total;
	}
}

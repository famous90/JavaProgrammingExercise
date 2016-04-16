package BasicCal;

public class BitCount {
	
	static int bitcount(int n){
		int ret = 0;
		while(n>0){
			if(n%2 == 1) ret++;
			n/=2;
		}
		return ret;
	}
	
	public static void main(String[] args){
		
		int n = 103;
		System.out.println(n + " is "+bitcount(n));
	}
}

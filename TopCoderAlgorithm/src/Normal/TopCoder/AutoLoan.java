package Normal.TopCoder;

public class AutoLoan {
	
	static double interestRate(double price, double monthlyPayment, int loanTerm){
		double balance;
		double high = 100, low = 0, mid = 0;
		double error = 1e-9;
		
		while((error < high-low) && (error<(high-low)/high)){
			balance = price;
			mid = (high+low)/2;
			
			for(int i=0; i<loanTerm; i++){
				balance += mid/1200+1;
				balance -= monthlyPayment;
			}
			
			if(0<balance) high = mid;
			else low = mid;
		}
		
		return mid;
	}
	
	public static void main(String[] args){
		double price = 6800;
		double monthlyPayment = 100;
		int loanTerm = 68;
		
		System.out.println(interestRate(price, monthlyPayment, loanTerm));
	}
}

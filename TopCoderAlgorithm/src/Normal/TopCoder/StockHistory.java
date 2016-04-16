package Normal.TopCoder;

public class StockHistory {
	
	static long maxEarnings(int init, int monthly, String[] stockPrices){
		
		int[][] prices = convertPrices(stockPrices);
		int months = prices[0].length;
		double maxEarn = 0;
		
		for(int month=0; month<months-1; month++){
			double maxEarnRate = 0;
			for(int stock=0; stock<prices.length; stock++){
				int lastPrice = prices[stock][months-1];
				int thisPrice = prices[stock][month];
				System.out.print(lastPrice+ " "+thisPrice + " " + ((double)(lastPrice-thisPrice))/((double)thisPrice)+ " ");
				maxEarnRate = Math.max(maxEarnRate, ((double)(lastPrice-thisPrice))/((double)thisPrice));
				
			}
			System.out.println(maxEarnRate);
			
			int money = init;
			if(month>0) money = monthly;
			if(maxEarnRate>0){
				maxEarn += money * maxEarnRate;
			}
		}
		
		return Math.round(maxEarn);
	}
	
	static int[][] convertPrices(String[] prices){
		int[][] convert = null;
		for(int i=0; i<prices.length; i++){
			String[] array = prices[i].split(" ");
			if(i == 0){
				convert = new int[array.length][prices.length];
			}
			for(int j=0; j<array.length; j++){
				convert[j][i] = Integer.parseInt(array[j]);
			}
		}
		return convert;
	}
	
	public static void main(String[] args){
		
		int inialInvestment = 100;
		int monthlyContribution = 20;
		String[] stockPrices = {"40 50 60", "37 48 55", "100 48 50", "105 48 47", "110 50 52", "110 50 52", "110 51 54", "109 49 53"};
		
		long result = maxEarnings(inialInvestment, monthlyContribution, stockPrices);
		
		System.out.println(result);
	}	
}

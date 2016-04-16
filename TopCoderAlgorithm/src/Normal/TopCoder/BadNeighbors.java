package Normal.TopCoder;

public class BadNeighbors {
	
	static int[] donations = {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 71};
	static int[] total = new int[donations.length];
	
	static int getTotalDonations(int here, int startAt){
		
		if(here>=donations.length) return 0;
		if(here == donations.length-1 && startAt == 0) return 0;
		if(total[here]!=0) return total[here];
		total[here] = Math.max(getTotalDonations(here+2, startAt), getTotalDonations(here+3, startAt)) + donations[here];
		return total[here];
	}
	
	static int maxDonations(int[] donations){
		
		int ans = 0;
		int length = donations.length;
		int[] dp = new int[length];
		
		for(int i=0; i<length-1; i++){
			dp[i] = donations[i];
			if(i>0) dp[i] = Math.max(dp[i], dp[i-1]);
			if(i>1) dp[i] = Math.max(dp[i], dp[i-2]+donations[i]);
			ans = Math.max(ans, dp[i]);
		}
		
		for(int i=0; i<length-1; i++){
			dp[i] = donations[i+1];
			if(i>0) dp[i] = Math.max(dp[i], dp[i-1]);
			if(i>1) dp[i] = Math.max(dp[i], dp[i-2]+donations[i+1]);
			ans = Math.max(ans, dp[i]);
		}
		
		return ans;
	}
		
	public static void main(String[] args){
		
		int result = Math.max(getTotalDonations(0, 0), getTotalDonations(1, 1));
		int res = maxDonations(donations);
//		result = Math.max(result, getTotalDonations(2, 2));
		
		System.out.println(result);
		System.out.println(res);
	}
}

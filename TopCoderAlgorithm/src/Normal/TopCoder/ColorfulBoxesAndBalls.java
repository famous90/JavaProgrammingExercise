package Normal.TopCoder;

public class ColorfulBoxesAndBalls {
	
	static int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors){
		int min = Math.min(numRed, numBlue);
		int maxPoint = 0;
		for(int i=0; i<=min; i++){
			int point = (numRed-i)*onlyRed + (numBlue-i)*onlyBlue + i*2*bothColors;
			maxPoint = Math.max(maxPoint, point);
		}
		
		return maxPoint;
	}
	
	public static void main(String[] args){
		int numRed = 9;
		int numBlue = 1;
		int onlyRed = -1;
		int onlyBlue = -10;
		int bothColors = 4;
		
		int result = getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);
		
		System.out.println(result);
	}	
}

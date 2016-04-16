
public class ThePalindrome {
	
	public static void main(String[] args){
		String s = "abdfhdyrbdbsdfghjkllkjhgfds";
		int result = find(s);
		System.out.println(result); 
	}
	
	public static int find(String s){
		
		int equalIndex = 0;
		boolean isPalindrome = false;
		int length = s.length();
		
		char lastChar = s.charAt(length-1);
		for(int i=0; i<length; i++){
			if(s.charAt(i) == lastChar){
				isPalindrome = false;
				int palLast = (length-i)/2;
				for(int j=0; j<palLast; j++){
					int frontIndex = j + i;
					int rearIndex = length - 1 - j;
					System.out.println(s.charAt(frontIndex) + " " +s.charAt(rearIndex));
					if(s.charAt(frontIndex) == s.charAt(rearIndex)){
						if(j == ((length-i)/2-1)){
							isPalindrome = true;
						}
					}else {
						break;
					}
				}
				
				if(isPalindrome){
					equalIndex = i;
					break;
				}
			}
		}
		
		if(!isPalindrome){
			System.out.println("not pal");
			equalIndex = length-1;
		}
		
		System.out.println(equalIndex);
		
		return length + equalIndex;
	}
}

	
public class FriendScore {
	
	public static void main(String[] args){
		String[] friends = {"NYNNNNNNN", "YNYNNNNNN", "NYNYNNNNN", "NNYNYNNNN", "NNNYNYNNN", "NNNNYNYNN", "NNNNNYNYN", "NNNNNNYNY", "NNNNNNNYN"};
		
		int result = highestScore(friends);
		
		System.out.println(result);
	}
	
	// convert matrix to links
	// make friends count array
	// change count while has friend not me
	// if all links checked, end
	
	public static int highestScore(String[] friends){
		
		int max = 0;
		
		for(int i=0; i<friends.length; i++){
			String friend = friends[i];
			int count = 0;
			for(int j=0; j<friends.length-i; j++){
				char isFriend = friend.charAt(j);
				if(isFriend == 'Y'){
					count++;
				}else {
					for(int k=0; k<friends.length; k++){
						if(friends[j].charAt(k)== 'Y' && friends[k].charAt(i)== 'Y'){
							count++;
							break;
						}
					}
				}
			}
			
			max = Math.max(max, count);
		}
		
		return max;
	}
}
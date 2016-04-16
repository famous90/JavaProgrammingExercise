
public class KiwiJuiceEasy {
	
	public static void main(String[] args) {
		int[] capacities = {700000, 800000, 900000, 1000000};
		int[] bottles = {478478, 478478, 478478, 478478};
		int[] fromId = {2, 3, 2, 0, 1};
		int[] toId = {0, 1, 1, 3, 2};
		
		int[] result = thePouring(capacities, bottles, fromId, toId);
		
		System.out.print("{ ");
		for(int i=0; i<result.length; i++){
			System.out.print(result[i]+" ");
		}
		System.out.print("}");
	}
	
	public static int[] thePouring(int[] capacities, int[] bottles, int[] fromIds, int[] toIds){
		
		for(int i=0; i<fromIds.length; i++ ){
			//pour the juice to toid
			int fromId = fromIds[i];
			int toId = toIds[i];
			int bottleFromId = bottles[fromId];
			int bottleToId = bottles[toId];
			int capacityToId = capacities[toId];
			
			// my code
			if((bottleFromId + bottleToId) >= capacityToId ){
				int rest = bottleFromId + bottleToId - capacityToId;
				bottles[toId] = capacityToId;
				bottles[fromId] = rest;
			}else {
				bottles[toId] = bottleToId + bottleFromId;
				bottles[fromId] = 0;
			}
			
			
			// practice1
//			int vol = Math.min(bottleFromId, capacityToId-bottleToId);
//			
//			bottles[fromId] -= vol;
//			bottles[toId] += vol;
			
			// practice2
//			int sum = bottleFromId + bottleToId ;
//			bottles[toId] = Math.min(sum, capacityToId);
//			bottles[fromId] = sum - bottles[toId];
//			
			
			System.out.print("{ ");
			for(int j=0; j<bottles.length; j++){
				System.out.print(bottles[j]+" ");
			}
			System.out.println("}");
		}
		
		return bottles;
	}
}

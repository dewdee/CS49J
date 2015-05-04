import java.util.*;

public class Problem4 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		//create HashMap of string keys and ArrayList of positions
		Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		String line = in.nextLine();
		//change all into lowercase so that same words get mapped to same key
		line = line.toLowerCase();
		//take out punctuations and white space
		String[] words = line.split("[.,;!?\\s]+");
		for(int i = 0; i < words.length; i++){
			//we use arraylist to check for same word, then we add another position
			if(map.containsKey(words[i]))
				map.get(words[i]).add(i + 1); //adding 1 just to make hashmap positions make sense
			else{//word doesn't exist in our hashmap
				ArrayList<Integer> positions = new ArrayList<Integer>();
				positions.add(i + 1);
				map.put(words[i], positions);
			}
		}
		//iterate through hashmap
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			ArrayList<Integer> value = map.get(key);
			System.out.println(key + " -> " + value);
		}
		in.close();
	}
}

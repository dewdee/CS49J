import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Problem5 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		//take out punctuations and white space
		String[] sentences = line.split("[.,;!?]+");
		
		for(int i = 0; i < sentences.length; i++){
			if(checkSentence(sentences[i]))
				System.out.println("Sentence " + (i + 1) + ": all words are unique.");
			else
				System.out.println("Sentence " + (i + 1) + ": words are repeated.");
		}

		in.close();
	}
	public static boolean checkSentence(String line){
		String[] words = line.split("[.,;!?\\s]+");
		//create HashMap of string keys and ArrayList of positions
		Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		
		for(int i = 0; i < words.length; i++){
			//we use arraylist to check for same word, then we add another position
			if(map.containsKey(words[i]))
				return false;
			else{//word doesn't exist in our hashmap
				ArrayList<Integer> positions = new ArrayList<Integer>();
				positions.add(i + 1);
				map.put(words[i], positions);
			}
		}
		return true;
	}
}

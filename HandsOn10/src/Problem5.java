import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem5 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		//take out punctuations and white space
		String[] sentences = line.split("[.;!?]+");
		
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
		//create HashMap of string keys and integers of positions
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0; i < words.length; i++){
			if(map.containsKey(words[i])) //don't need to do any operation if we find the word in our map, just return false
				return false;
			else{//word doesn't exist in our hashmap
				map.put(words[i], i + 1);
			}
		}
		return true;
	}
}

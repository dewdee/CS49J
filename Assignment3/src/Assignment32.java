import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Assignment32 {
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Given the location of the file: ");
			String fileName = in.nextLine();
			
			String digitsOfPi = readFile(fileName);
			System.out.println("Number of digits of pi to parse:");
			int numDigits = in.nextInt();
			in.nextLine();//flush nextline
			
			//key will be digit, value will be position
			//create new arraylist for storing positions
			Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
			for(int i = 0; i < numDigits; i++){
				ArrayList<Integer> position = new ArrayList<Integer>(); 
				int curr = Integer.parseInt(Character.toString(digitsOfPi.charAt(i)));
				//nothing in the map for the current digit
				if(map.containsKey(curr)){
					position = map.get(curr);
					position.add(i);
				}
				else{
					position.add(i);
					map.put(curr, position);
				}
			}
			System.out.println("Give any number between 0-9");
			int num = in.nextInt();
			ArrayList<Integer> position = new ArrayList<Integer>(); 
			if(map.containsKey(num)){
				position = map.get(num);
				System.out.println(num + " appears " + position.size() + " times");
				System.out.println("First position in which " + num + " appears: " + (position.get(0) + 1));
				System.out.println("Last position in which " + num + " appears: " + (position.get(position.size() - 1) + 1));
			}
			else{
				System.out.println(num + " appears " + position.size() + " times");
			}
		}
		catch(IOException e){
			System.out.println(e);
		}
		in.close();
	}
	public static String readFile(String fileName) throws IOException{
		String line = "";
		
		try{
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
			line = in.readLine();
			line = line.substring(2); //remove 3., only read decimal places
			
			//System.out.println(digitsOfPi);
			in.close(); //close connection
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		return line;
	}
}
/*
 * Given the location of the file: 
C:\Users\Mike\Downloads\Desktop\digits_of_pi.txt
Number of digits of pi to parse:
100
Give any number between 0-9
3
3 appears 11 times
First position in which 3 appears: 9
Last position in which 3 appears: 91

Given the location of the file: 
C:\Users\Mike\Downloads\Desktop\digits_of_pi.txt
Number of digits of pi to parse:
49
Give any number between 0-9
2
2 appears 5 times
First position in which 2 appears: 6
Last position in which 2 appears: 33

Given the location of the file: 
C:\Users\Mike\Downloads\Desktop\digits_of_pi.txt
Number of digits of pi to parse:
345
Give any number between 0-9
7
7 appears 23 times
First position in which 7 appears: 13
Last position in which 7 appears: 343

Given the location of the file: 
digits_of_pi.txt
Number of digits of pi to parse:
10000
Give any number between 0-9
8'
Exception in thread "main" java.util.InputMismatchException
	at java.util.Scanner.throwFor(Unknown Source)
	at java.util.Scanner.next(Unknown Source)
	at java.util.Scanner.nextInt(Unknown Source)
	at java.util.Scanner.nextInt(Unknown Source)
	at Assignment32.main(Assignment32.java:41)

Given the location of the file: 
digits_of_pi.txt
Number of digits of pi to parse:
99999
Give any number between 0-9
8
8 appears 9978 times
First position in which 8 appears: 11
Last position in which 8 appears: 99986
*/

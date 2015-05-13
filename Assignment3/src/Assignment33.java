import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashSet;

public class Assignment33 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Specify path: ");
		String fileName = in.nextLine();
		int phoneDigit = 5; //how long the number is can be changed here
		boolean repeat = false;
		
		try{
			String digitsOfPi = readFile(fileName);
			System.out.println("Number of digits of pi to parse:");
			int numDigits = in.nextInt();
			in.nextLine();//flush nextline
			
			HashSet<Integer> phoneSet = new HashSet<Integer>();
			int newNum = 0;
			for(int i = 0; i < numDigits; i++){
				int end = i + phoneDigit;
				if(end <= numDigits){
					newNum = Integer.parseInt(digitsOfPi.substring(i, end));
					//check if number is in set
					if(!phoneSet.contains(newNum))
						phoneSet.add(newNum);
					else
						repeat = true;
				}
				else
					break;
			}
			
			System.out.println("Total phone numbers generated: " + phoneSet.size());
			if(repeat)
				System.out.println("Phone numbers are repeated.");
			else
				System.out.println("Task success, all phone numbers are unique.");
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
Specify path: 
C:\Users\Mike\Downloads\Desktop\digits_of_pi.txt
Number of digits of pi to parse:
10
Total phone numbers generated: 6
Task success, all phone numbers are unique.

Specify path: 
C:\Users\Mike\Downloads\Desktop\digits_of_pi.txt
Number of digits of pi to parse:
72
Total phone numbers generated: 68
Task success, all phone numbers are unique.

Specify path: 
C:\Users\Mike\Downloads\Desktop\digits_of_pi.txt
Number of digits of pi to parse:
934
Total phone numbers generated: 925
Phone numbers are repeated.

Specify path: 
C:\Users\Mike\Downloads\Desktop\digits_of_pi.txt
Number of digits of pi to parse:
6747
Total phone numbers generated: 6542
Phone numbers are repeated.

Specify path: 
C:\Users\Mike\Downloads\Desktop\digits_of_pi.txt
Number of digits of pi to parse:
167
Total phone numbers generated: 163
Task success, all phone numbers are unique.
*/
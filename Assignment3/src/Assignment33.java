import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment33 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Specify path: ");
		String s = in.nextLine();
		try{
			readFile(s);
		}
		catch(IOException e){
			System.out.println(e);
		}
		in.close();
	}
	public static void readFile(String fileName) throws IOException{

		File f = new File(fileName);

		try{
			FileReader reader = new FileReader(f);
			BufferedReader in = new BufferedReader(reader);
			//String str;
			int i = 0;
			int pi = 0;
			while(i <= 10){
				pi = in.read();
				if(Character.isDigit((char)pi))
						System.out.println((char)pi);
				i++;
			}
			//System.out.println(i);
			in.close(); //close connection
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
	}
}

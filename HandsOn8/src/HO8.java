import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
class NotNucleotideException extends Exception{
	NotNucleotideException(String message){
		super(message);
	}
}
public class HO8 {
	public static void main(String[] args){
		problemOne(args);
		//problem two
		int[] arr = {1, 4, 6, 2};
		try{
			problemTwo(arr, 3);
		}
		catch(Exception e){
			System.out.println(e);
		}
		//problem three
		try{
			problemThree("input.txt");
		}
		catch(IOException e){
			System.out.println(e);
		}
		//problem four
		/*try{
			problemFour();
		}
		catch(Exception e){
			System.out.println(e);
		}*/
		try{
			problemFive("ACGTACA");
		}
		catch(NotNucleotideException e){
			System.out.println(e);
		}
		try{
			problemSix("PWM.txt");
		}
		catch(IOException e){
			System.out.println(e);
		}
		try{
			problemSeven("number.txt");
		}
		catch(IOException e){
			System.out.println(e);
		}

	}
	public static void problemOne(String[] args){
		try{
			int size = args.length;
			int[] arr = new int[size];
			for(int i = 0; i < size; i++)
				arr[i] = Integer.parseInt(args[i]);
			int[] sorted = sort(arr, size);
			System.out.println(Arrays.toString(sorted));
		}
		catch(NumberFormatException e){
			System.out.println("Invalid input, integers only.");
		}
	}
	public static void problemTwo(int[] arr, int N) throws Exception{
		if(N == 0)
			throw new Exception("N cannot be 0.");
		else{
			int sum = 0;
			for(int i = 0; i < N; i++)
				sum += arr[i];

			double result = sum / N;
			System.out.println("Average: " + result);
		}
	}
	public static void problemThree(String fileName) throws IOException{
		File f = new File(fileName);

		try{
			FileReader reader = new FileReader(f);
			BufferedReader in = new BufferedReader(reader);

			String str;
			while((str = in.readLine()) != null)
				System.out.println(str);

			in.close(); //close connection
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
	}
	public static void problemFour()throws Exception{
		Scanner input = new Scanner(System.in);
		int size = 5;
		int[] arr = {0, 0, 0, 0, 0};
		System.out.println("Enter in array of integers: ");
		try{
			for(int i = 0; i < size; i++)
				arr[i] = input.nextInt();
			int a = 0;
			if(a != 0){ //read in an int afterwards means it read in something, so exceeds array size
				throw new Exception("Number of elements accepted exceeds fixed array size.");

			}
			else{
				System.out.println("Integers are: ");
				for(int i = 0; i < size; i++)
					if(i == arr[i])
						System.out.print(arr[i] + " ");
				System.out.println("");
			}
		}
		catch(NumberFormatException e){
			System.out.println("Invalid input.");
		}

		finally{

			input.close();
		}

	}
	public static void problemFive(String sequence) throws NotNucleotideException{
		int size = sequence.length();

		for(int i = 0; i < size; i++)
			if(sequence.charAt(i) != 'A' && sequence.charAt(i) != 'C' && sequence.charAt(i) != 'G' && sequence.charAt(i) != 'T'){
				throw new NotNucleotideException("Non-nucleotide found");
			}
	}
	public static void problemSix(String fileName) throws IOException{
		File f = new File(fileName);

		try{
			FileReader reader = new FileReader(f);
			BufferedReader in = new BufferedReader(reader);

			String[] sequences = new String[10];
			String str;
			int i = 0;
			while((str = in.readLine()) != null){
				sequences[i] = str;
				i++;
			}
			try{
				for(int j = 0; j < i; i++)
					problemFive(sequences[j]);
			}
			catch(NotNucleotideException e){
				System.out.println(e);
			}
			PWM(sequences);
			in.close(); //close connection
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
	}
	public static void problemSeven(String fileName) throws IOException{
		File f = new File(fileName);

		try{
			FileReader reader = new FileReader(f);
			BufferedReader in = new BufferedReader(reader);

			String line = "";
			int minimum = 100;
			int num = 0;
			while((line = in.readLine()) != null){
				num = Integer.parseInt(line.trim());
				if(minimum > num)
					minimum = num;
			}
			System.out.println(minimum);
			in.close(); //close connection
		}

		catch(FileNotFoundException e){
			System.out.println(e);
		}
	}
	public static void PWM(String[] sequences){
		int aCount = 0, gCount = 0, tCount = 0, cCount = 0;
		int COL = 9, ROW = 10, AMINO = 4;

		double[][] matrix = new double[AMINO][COL];

		for(int i = 0; i < COL; i++)
		{
			for(int j = 0; j < ROW; j++)
			{
				if(sequences[j].charAt(i) == 'A')
					aCount++;
				else if(sequences[j].charAt(i) == 'G')
					gCount++;
				else if(sequences[j].charAt(i) == 'C')
					cCount++;
				else if(sequences[j].charAt(i) == 'T')
					tCount++;
			}

			matrix[0][i] = (aCount + .1) / 10.4;
			matrix[1][i] = (cCount + .1) / 10.4;
			matrix[2][i] = (gCount + .1) / 10.4;
			matrix[3][i] = (tCount + .1) / 10.4;
			//reset the count for next iteration
			aCount = 0;
			gCount = 0;
			cCount = 0;
			tCount = 0;
		}

		for(int i = 0; i < AMINO; i++) //A, G, C, T
		{
			for(int j = 0; j < COL; j++)
			{
				//divide by log2 to get log base 2
				matrix[i][j] = (Math.log(matrix[i][j] / .25) / Math.log(2));
				System.out.printf("%.3f ", matrix[i][j]);
			}
			System.out.println("\n");
		}

	}
	public static int[] sort(int[] unsorted, int size){
		int[] sorted = new int[size];
		int temp;

		//copy array over
		for(int i = 0; i < size; i++)
			sorted[i] = unsorted[i];

		//simple bubble sort, swaps numbers around to be ascending order
		for(int i = 0; i < size; i++){
			for(int j = 1; j < size - i; j++){
				if(sorted[j - 1] > sorted[j]){
					temp = sorted[j - 1];
					sorted[j - 1] = sorted[j];
					sorted[j] = temp;
				}
			}
		}
		return sorted;
	}
}

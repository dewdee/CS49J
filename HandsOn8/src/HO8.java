import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class HO8 {
	public static void main(String[] args){
		problemOne(args);
		//problem two
		int[] arr = {1, 4, 6, 2};
		try{
			problemTwo(arr, 3);
		}
		catch(Exception e){
			System.out.println("N cannot be 0.");
		}
		//problem three
		try{
			problemThree("input.txt");
		}
		catch(IOException e){
			System.out.println(e);
		}
		//problem four
		problemFour();

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
	public static void problemFour(){
		Scanner input = new Scanner(System.in);
		int size = 5;
		int[] arr = new int[size];
		System.out.println("Enter in array of integers: ");
		try{
			for(int i = 0; i < size; i++)
				arr[i] = input.nextInt();
		}
		catch(NumberFormatException e){
			System.out.println("Invalid input.");
		}
		System.out.println("Integers are: ");
		for(int i = 0; i < size; i++)
			if(i == arr[i])
				System.out.print(arr[i] + " ");
		input.close();
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

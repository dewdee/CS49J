/*
 * Write a program to compute the Fibonacci sequence. 
 * Method that computes the Fibonacci sequence should be recursive. 
 * Given k, it should print the first k numbers in the Fibonacci sequence. 
 * Also, write another method that returns the nth number in the Fibonacci sequence given n.
 */
public class Problem1 {
	public static void main(String[] args){
		int k = 5;
		for(int i = 0; i < k; i++){
			System.out.print(specificFib(i) + " ");
		}
		System.out.println(specificFib(5));
	}
	public static int specificFib(int n){
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return specificFib(n - 1) + specificFib(n - 2);
	}
}

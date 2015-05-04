
public class Problem2 {
	public static void main(String[] args){
		int[] arrInt = {3, 1, 6, 2, 7, 8, 4};
		int result = calcArray(arrInt, arrInt.length - 1);
		System.out.println(result);
	}
	public static int calcArray(int[] array, int n){
		if(n == 0){
			if(array[n] % 2 == 0){ //even
				return (array[n] / 5);
			}
			else{ //odd
				return (array[n] * 3 + 1);
			}
		}
		else{
			if(array[n] % 2 == 0){ //even
				return (array[n] / 5) + calcArray(array, n - 1);
			}
			else{ //odd
				return (array[n] * 3 + 1) - calcArray(array, n - 1);
			}
		}
	}
}

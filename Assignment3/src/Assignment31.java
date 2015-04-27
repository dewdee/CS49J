import java.io.*;


public class Assignment31 {
	public static void main(String[] args){
		
	}
	public static void readFile(String fileName) throws IOException{
		
		File f = new File(fileName);

		try{
			FileReader reader = new FileReader(f);
			BufferedReader in = new BufferedReader(reader);

			String str;
			int i = 0;
			while((str = in.readLine()) != null){
				i++;
			}
			in.close(); //close connection
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
	}
	public static int precedence(char operator){
	    switch (operator) {
	        case '&':
	        	return 1;
	        case '^':
	            return 2;
	        case '|':
	            return 3;
	        default:
	            throw new IllegalArgumentException("Operator unknown: " + operator);
	    }
	}
}

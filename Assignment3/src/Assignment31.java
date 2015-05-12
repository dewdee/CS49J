import java.util.Scanner;
import java.util.Stack;


public class Assignment31 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		String line = input.nextLine();
		Stack<String> operator = new Stack<String>();
		Stack<Integer> operand = new Stack<Integer>();

		try{
			parseInput(line,operator,operand);
			System.out.println(calculate(operator, operand));
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		input.close();
	}
	public static void parseInput(String input, Stack<String> operator, Stack<Integer> operand) throws Exception{
		String[] tokens = input.split("\\s+");
		int size = tokens.length;
		//going backwards because of stack LIFO rule
		for(int i = 0; i < size; i++){
			//checking for less than size - 1 and at size - 1 to avoid array out of bounds exception
			if(i > size - 1){
				//checks for two operators/operands in a row
				if(!Character.isLetter(tokens[i].charAt(0)) && !Character.isLetter(tokens[i + 1].charAt(0)))
					throw new Exception("Two numbers in a row is not a valid input.");
				else if(Character.isLetter(tokens[i].charAt(0)) && Character.isLetter(tokens[i + 1].charAt(0))){
					throw new Exception("Two operators in a row is not a valid input.");
				}
			}
			if(tokens[i].equals("&") || tokens[i].equals("^") || tokens[i].equals("|"))
				operator.add(tokens[i]);
			else if(Character.isDigit(tokens[i].charAt(0)))
				operand.add(Integer.parseInt(tokens[i]));
			else{
				throw new Exception("Not a valid operator.");
			}
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
	public static int operations(String operator, int operand1, int operand2){
		int result = 0;

		if (operator.equals("&"))
			result = operand1 & operand2;
		else if (operator.equals("^"))
			result = operand1 ^ operand2;
		else if (operator.equals("|"))
			result = operand1 | operand2;

		return result; 
	}
	public static double calculate(Stack<String> operator, Stack<Integer> operand){
		int result = 0;
		
		//there are more operands than operators, so we check until operator is empty
		while(!operator.isEmpty()){
			int first = operand.pop();
			int second = operand.pop();
			String op = operator.pop();
			result = operations(op, first, second);
			//readd result to the bottom, so continues evaluating "left to right"
			operand.push(result);
		}
		result = operand.pop();
		return result;
	}
}

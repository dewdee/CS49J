import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class Assignment31 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		String line = input.nextLine();
		Stack<String> operator = new Stack<String>();
		Stack<Integer> operand = new Stack<Integer>();

		try{
			System.out.println(parseInput(line,operator,operand));
		}
		catch(Exception e){
			System.out.println(e);
		}

		input.close();
	}
	public static int parseInput(String input, Stack<String> operator, Stack<Integer> operand) throws Exception{
		String token;
		int result = 0;

		input = input.replace(" ", ""); // replacing all spaces in the expression
		StringTokenizer tokens = new StringTokenizer(input, "&^|", true); //converting expression into tokens

		while(tokens.hasMoreTokens()){
			token = tokens.nextToken();
			//add integers to proper stack
			if(Character.isDigit(token.charAt(0)))
				operand.push(Integer.parseInt(token));
			//if there aren't at least two operators in stack, theres nothing to do
			while(operator.size() > 1){
				String op = operator.pop();
				int first = operand.pop();
				int second = operand.pop();
				result = operations(op, first, second);
				operand.push(result);	
			}
			if(isOperator(token.charAt(0))){
				while (!operator.isEmpty() && precedence(operator.peek().charAt(0)) <= precedence(token.charAt(0))){
					String op = operator.pop();
					int first = operand.pop();
					int second =  operand.pop();
					result = operations(op, first, second);
					operand.push(result);
				}
				operator.push(token); //add operator to stack
			}
		}
		//get remains from the stacks and calculate for final result
		String op = operator.pop();
		int first = operand.pop();
		int second = operand.pop();
		result = operations(op, first, second);

		return result;
	}
	public static boolean isOperator(char op){
		if(op == '&' || op == '^' || op == '|')
			return true;

		return false;
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
}

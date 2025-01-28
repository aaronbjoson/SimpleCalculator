package myCalculator;
import java.util.Scanner;
import java.util.Stack;


public class InputHandler {
	
	/*
	public static String get_Input() {
		Scanner readIn = new Scanner(System.in);
		
		
	}
	*/
	
	public static String Shunting_Yard_Alg(String input) {
		
		Stack<Character> operator_Stack = new Stack<>();
		char[] tokens = input.replaceAll("\\s","").toCharArray();
		String postfixed_Output = "";
		
		//Separate operands from operators for Reverse Polish Notation.
		for(int i = 0; i < tokens.length; i++) {
			
			if(Character.isDigit(tokens[i])) {
				postfixed_Output+=tokens[i];
			} //end if char at i is an operand.
			
			else if(Operations.isOperator(tokens[i])) {
				while(!operator_Stack.isEmpty() && 
						Operations.get_Precedence(operator_Stack.peek()) >= Operations.get_Precedence(tokens[i]) &&
						Operations.is_Left_Associativity(tokens[i])) {
					postfixed_Output += operator_Stack.pop();
				}
				
				operator_Stack.push(tokens[i]);
			}
			
			else if(tokens[i] == '(') {
				operator_Stack.push(tokens[i]);
			}
			
			else if(tokens[i] == ')') {
				while (operator_Stack.peek() != '(') {
					postfixed_Output += operator_Stack.pop();
				}
				operator_Stack.pop();
			} //End if char is a right Parenthesis
			
			
		} //End of For loop
		
		
		while(!operator_Stack.isEmpty()) {
			postfixed_Output += operator_Stack.pop();
		}
		
		return postfixed_Output;
		
	} //End of Shunting Yard Process
	
	
	
	public static double eval_RPN(String input_To_Eval) {
		double operand1, operand2;
		Stack<Double> operand_Stack = new Stack<>();
		char[] char_At = input_To_Eval.toCharArray();
		
		for(int i = 0; i< char_At.length; i++) {
			
			if(Operations.isOperator(char_At[i])) {
				operand2 = operand_Stack.pop();
				operand1 = operand_Stack.pop();
				
				double result = Operations.performOp(operand1, operand2, char_At[i]);
				
				System.out.printf("Result of %f %s %f is %f \n", operand1, char_At[i], operand2, result);
				
				operand_Stack.push(result);
			} //End of if
			
			else {				
				operand_Stack.push((double)Character.getNumericValue(char_At[i]));
				
			} //End of else 
			
		} //End of For loop
		
		return operand_Stack.pop();
	}
	
	public static double perform_Calculations(String input) {
		String processed_Input = Shunting_Yard_Alg(input);
		
		return eval_RPN(processed_Input);
	}
} //End of InputHandler Class

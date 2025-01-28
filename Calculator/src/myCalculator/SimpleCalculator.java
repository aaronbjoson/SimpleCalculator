package myCalculator;


public class SimpleCalculator {
	
	public static void main (String[] args) {
		String input = "3 + 4 * 5 / ( 1 - 5 ) ^ 2 ^ 3";
		
		System.out.println("Infix input: "+input.replaceAll("\\s", ""));
		
		String postfixed_Input = InputHandler.Shunting_Yard_Alg(input);
		
		System.out.println("Postfix Input: "+ postfixed_Input);

		double result = InputHandler.eval_RPN(postfixed_Input);
		
		System.out.println("Result: "+ result);
		
		
	}
} // 3 8 (-4) 8 

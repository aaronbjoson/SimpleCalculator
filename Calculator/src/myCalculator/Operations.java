package myCalculator;

public class Operations {
	
	public static double add(double operand1, double operand2) {
		double result = operand1 + operand2;
		
		return result;
	}
	
	public static double subtract(double operand1, double operand2) {
		double result = operand1 - operand2;
		
		return result;
	}
	
	public static double multiply(double operand1, double operand2) {
		double result = operand1 * operand2;
		
		return result;
	}
	
	public static double divide(double operand1, double operand2) {
		double result = operand1 / operand2;
		
		return result;
	}
	
	public static double modulo(double operand1, double operand2) {
		double result = operand1 % operand2;
		
		return result;
	}
	
	public static double powerOf(double base, double exponent) {
		double result = base;
		
		for(int i =1; i < exponent; i++) {
			result *= base;
		}
		
		return result;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Version to accept characters
	public static boolean isOperator(char token) {
		if(token == '+' || token == '-' || token == '*' || token == '/' || token == '%' || token == '^') {
			return true;
		}
		
		else {
			return false;
		}
	}
	

	public static boolean is_Left_Associativity(char operator) {
		if(operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%') {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public static int get_Precedence(char operator){
		
		int precedence_Value = -1;
		
		if(operator == '^') {
			precedence_Value = 4;
		}
		
		else if(operator == '*' || operator == '/') {
			precedence_Value = 3;
		}
		else if(operator == '+' || operator == '-') {
			precedence_Value = 2;
		}
		
		return precedence_Value;
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Version to Accept Strings	
	public static boolean check_For_Numbers(String input) {
		boolean isNumeric = true;
		
		try {
			Double number = Double.parseDouble(input);
		}
		catch (NumberFormatException e) {
			isNumeric = false;
		}
		
		return isNumeric;
	}
	
	public static boolean isOperator(String token) {
		if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%") || token.equals("^")) {
			return true;
		}
		
		else {
			return false;
		}
	}	

	public static boolean is_Left_Associativity(String operator) {
		if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("%") ) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public static int get_Precedence(String operator){
		
		int precedence_Value = -1;
		
		if(operator == "^") {
			precedence_Value = 4;
		}
		
		else if(operator == "*" || operator == "/") {
			precedence_Value = 3;
		}
		else if(operator == "+" || operator == "-") {
			precedence_Value = 2;
		}
		
		return precedence_Value;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static double performOp(double operand1, double operand2, char op_Token) {
		double result = 0;

		switch (op_Token) {
		
			case '+':
				result = add(operand1, operand2);
				break;	
				
			case '-':
				result = subtract(operand1, operand2);
				break;
				
			case '*':
				result = multiply(operand1, operand2);
				break;
				
			case '/':
				result = divide(operand1, operand2);
				break;
				
			case '%':
				result = modulo(operand1, operand2);
				break;
				
			case '^':
				result = powerOf(operand1, operand2);
				break;	
		} //end of Switch case
		
		return result; //returns 0 if operation doesn't work
	} //end of performOp
}

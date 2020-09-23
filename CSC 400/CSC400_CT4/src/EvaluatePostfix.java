/*
 * Gregory Norris
 * Critical Thinking 4 Option 1 - PostFix Calculator
 * CSC400
 * Colorado State University Global Campus
 * 
 * 
*/
import java.util.Stack;
//Followed logic structure from textbook.

public class EvaluatePostfix 
{
	private static Stack <Double> valueStack = new Stack<Double>(); //Primary Stack
	
	public static double calculate(String input)//Calculator method
	{
		int characterCount = input.length();	//Determine string length
		int charIndex = 0;
		boolean bal = true;						//Checks for balanced equation...
												//Class/method exists. Hard coded as true for troubleshooting.
		
		while (bal &&(charIndex<characterCount))//Loop through each character in string. 
		{
			char nextCharacter = input.charAt(charIndex);
			subSort(nextCharacter);				//subSort pushes postfix expression to stack
			charIndex++;
		} 
		return valueStack.pop();				//***RETURN CALCULATED POSTFIX RESULT***
	}
	// *** SUBCALCULATE() ***
	static double subCalculate (double operand1, double operand2, char iTopOperator) 
	{
		double result = 0;
		//Calculates the postfix expression after subSort pushes data to stack.
		switch (iTopOperator) 
		{
			case'+':
				result = operand1 + operand2;
				break;
			case'-':
				result = operand1 - operand2;
				
				break;
			case '*':
				result = operand1 * operand2;
				
				break;
			case '/':
				result = operand1 / operand2;
				break;
			default: break;
		}//end switch
		return result;
	}//end subCalculate
	
	static void subSort(char in_char) //Pushes postfix expression into stack.
	{
		char nextChar = in_char;
		double result = 0;
		switch (nextChar) 
		{							//Push numberic characters to stack, convert from char to double.
		case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
			 double fuckingNumberBetterBeRight = Double.parseDouble(Character.toString(nextChar));
			//System.out.println("StackNum"+fuckingNumberBetterBeRight);
			valueStack.push(fuckingNumberBetterBeRight);
			break;
		//Take operand and two values from stack to calculate.	
		case'+': case'-':case '*':case '/': case'^':
			double operandTwo = valueStack.pop();
			double operandOne = valueStack.pop();
			result = subCalculate(operandOne,operandTwo,nextChar);
			valueStack.push(result);
			break;
		}
		
	}//end subSort
}//end class
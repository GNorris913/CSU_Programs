/* import java.util.Stack;

public class InFixCalc 
{	
	
	public static double calculate(String input)
	{
		Stack<Character> opsStack = new Stack<Character>();
		Stack<Double> valStack = new Stack<Double>();
		int characterCount = input.length();
		int charIndex = 0;
		char nextChar = ' ';
		boolean bal = true;
		
		while (bal &&(charIndex<characterCount)) 
		{
			nextChar = input.charAt(charIndex);
			switch (nextChar) 
			{
			case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
				valStack.push((double)nextChar);
				break;
			
			case'^': 
				opsStack.push(nextChar);
				break;
			
			case'+': case'-':case '*':case '/':
				while(!valStack.isEmpty() && (OpsOrder(nextChar)<= OpsOrder(opsStack.peek())) )
				{
					double result = 0;
					char topOps = opsStack.pop();
					double operandTwo = valStack.pop();
					double operandOne = valStack.pop();
					double result2 = subCalculate(operandOne,operandTwo,topOps);
					valStack.push(result2);
					opsStack.push(nextChar);
					break;
				}//end while
			case '(':
				opsStack.push(nextChar);
					break;
			case ')':
				char topOperator = opsStack.pop();
					while (topOperator !='(') 
					{
						double operandTwo = valStack.pop();
						double operandOne = valStack.pop();
						double result = subCalculate(operandOne,operandTwo,topOperator);
						valStack.push(result);
			}// end switch1
			charIndex++;			
		}//end while
		while (!opsStack.isEmpty())
			{
				char topOperator = opsStack.pop();
				double operandTwo = valStack.pop();
				double operandOne = valStack.pop();
				double result = 
			}
			}
	}//end calculate()
	
	static int OpsOrder(char in_operand)
	{
		switch(in_operand) 
		{
		case'+' : return 1;
		case'-' : return 1;
		case'*' : return 2;
		case'/' : return 2;
		case'^' : return 3;
		default: return 0;
		}
			
	}
	
	static double subCalculate(double operand1, double operand2, char iTopOperator) 
	{
		double result = 0;
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
	}//end switch 3
		return result;
	}//end calculate1

	
}
	
	*/
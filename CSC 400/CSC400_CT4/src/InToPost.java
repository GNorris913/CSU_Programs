/*
 * Gregory Norris
 * Critical Thinking 4 Option 1 - PostFix Calculator
 * CSC400
 * Colorado State University Global Campus
 * 
 * 
*/
import java.util.Stack;

public class InToPost {
	
	public static String convert (String input) 
	{
		Stack <Character> operatorStack = new Stack<Character>();
		String postfix = "";
		int characterCount = input.length();
		int charIndex = 0;
		boolean bal = true;
		
		while (bal &&(charIndex<characterCount)) 
		{
			char nextChar = input.charAt(charIndex);
			switch (nextChar) 
			{
			case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
				postfix = postfix+nextChar;
				break;
			case '^':
				operatorStack.push(nextChar);
				break;
			case'+':case'-':case'*':case'/':		
				while(!operatorStack.isEmpty() && (OpsOrder(nextChar)<=OpsOrder(operatorStack.peek()))) 
				{
					postfix = postfix+operatorStack.peek();
					operatorStack.pop();
				}
				operatorStack.push(nextChar);
				break;
			case '(':
					operatorStack.push(nextChar);
					break;
			case ')':
					char topOperator = operatorStack.pop();
					while(topOperator!='(') 
					{
						postfix = postfix+topOperator;
						topOperator = operatorStack.pop();
					}
					break;
			default: break;
			}
			charIndex++;
		} 
		while(!operatorStack.isEmpty()) 
		{
			char topOperator = operatorStack.peek();
			postfix = postfix+topOperator;
			operatorStack.pop();
		}
		//System.out.println(postfix);
		return postfix;
	}
	
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
}

import java.util.Stack;

public class BalanceChecker {
	public static boolean checkBalance(String input)
	{
		Stack<Character> cStack = new Stack<Character>();
		int characterCount = input.length();
		int charIndex = 0;
		char nextChar = ' ';
		boolean bal = true;
		while (bal &&(charIndex<characterCount)) 
		{
			nextChar = input.charAt(charIndex);
			switch (nextChar) 
			{
			case'(': case'[': case'{':
				cStack.push(nextChar);
				break;
			case')': case']':case'}':
				if(cStack.isEmpty()) bal = false;
				else
				{
					char cDelimiter = cStack.pop();
					bal = isPaired(cDelimiter, nextChar);
				}//end else
				break;
				default : break;
				}// end switch
			charIndex++;			
		}//end while
		if (!cStack.isEmpty())
			{bal = false;}
		return bal;
	}//end parsePostFix()

	private static boolean isPaired(char open, char close) 
	{
		return 	(open == '(' && close == ')') ||
				(open == '[' && close == ']') ||
				(open == '{' && close == '}');
	}
}

/*
 * Gregory Norris
 * Critical Thinking 4 Option 1 - PostFix Calculator
 * CSC400
 * Colorado State University Global Campus
 * 
 * 
*/
public class Test {
//TEST CLASS FOR POSTFIX CALCULATOR
	public static void main(String[] args) {
			
			int data1 = 1;
			int data2 = 2;
			int data3 = 4;
			int data4  = 5;
			int data5 = 3;
			
			String test1 = "("+data1+"*"+data2+"*"+data3+"-"+data1+")"+"/"+"("+data4+"*"+data5+")";
			String test2 = "(1*2*4-1)/(5*3)";
			String test3 = "2*(3+4)*5";
			String test4 = "(1+2+3)*4*5/6";
			System.out.println("Prefix1: "+test1);
			System.out.println("Prefix2: "+test2);
			System.out.println("Prefix3: "+test3);
			System.out.println("Prefix4: "+test4);
			String postfix = InToPost.convert(test1);
			String postfix2 = InToPost.convert(test2);
			String postfix3 = InToPost.convert(test3);
			String postfix4 = InToPost.convert(test4);
			
			System.out.println("Postfix1: "+postfix);
			System.out.println("Postfix2: "+postfix2);
			System.out.println("Postfix3: "+postfix3);
			System.out.println("Postfix3: "+postfix4);
			EvaluatePostfix calculate = new EvaluatePostfix();
			
			double result1 = calculate.calculate(postfix);
			double result2= calculate.calculate(postfix2);
			double result3= calculate.calculate(postfix3);
			System.out.println("Result1: "+result1);
			System.out.println("Result2: "+result2);
			System.out.println("Result2: "+result3);
	}

}

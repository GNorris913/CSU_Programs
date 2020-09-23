/*		CSC 372-1
 * 		Module 5 Critical Thinking, Option 2
 * 		Gregory Norris
 * 		Colorado State University Global Campus
 * This program accepts five different numbers from a user and return the sum using two recursive methods.
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Recursion {
											//Variables
	int iterator = 0;
	double userNum = 0;
											//Scanner
	Scanner scnr = new Scanner(System.in);
	//****************************** sumUserNum()*************************************
	private void sumUserNum(int in_Iterator, int in_userNum)
	{
		 int s_iterator = in_Iterator; 		//Control value
		 int s_userNum = in_userNum;  		//Return value (INT)
		 									//Control statement
		 if (s_iterator > 0)
		 {
		 
			 int i_userNum = getUserNum(s_iterator);
			 s_userNum = s_userNum + i_userNum;
			 s_iterator = s_iterator -1;	//Increment Control Value
		 
		 sumUserNum(s_iterator, s_userNum);
		 }
		 else 								//Control condition is met 
		 {
			 scnr.close();					//Close scanner
			 								//Print total values.
			 System.out.println("Total: "+s_userNum);  
		 }
	}
											//Get user input, return INT, check for valid input.
	//***************************** getUserNum() *******************8*****************
	private int getUserNum(int in_iterator){
		int gotUserIn = 0;
		int g_iterator = in_iterator;
											//gather integer from user
		try 
		{
			System.out.println("Enter an integer to add ("+g_iterator+" remaining): ");
			gotUserIn = scnr.nextInt();
			
		}
											//catch non-integer user entry
		catch (InputMismatchException ex) 
		{
			System.out.println("Please enter an integer value.");
			
			scnr.next();					//Clear scanner token
											//Recursively call scnr function
			gotUserIn = getUserNum(g_iterator);
			
		}
		return gotUserIn;
	}
	//##########################   MAIN   #############################
	public static void main(String[] args) {
		Recursion rec = new Recursion();
		rec.sumUserNum(5,0);
		System.exit(0);
		
	}

}

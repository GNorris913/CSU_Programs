// Source.cpp
/*
		Critical Thinking 2
		Gregory Norris
		Colorado State University Global Campus
		CSC 450 - Haseltine
		String Reverse'o'Matic.
		This program will translate three short phrases of less than a characters into a reversed order string.
		Example: Taco Cat = taC ocaT

*/
#include <iostream>;
#include<string>;
#include<stdio.h>;
using namespace std;

int main()
{
	int unsigned a = 255;
	cout << "Critical Thinking 2 Option 1\nGregory Norris\nCSC450 Haseltine\nColorado State University Global Campus\n--------------------------------\n";
	cout << "String Reverse'o'matic.\nThis program will translate three short phrases of less than " << a <<" characters into a reversed order string.\nExample: Taco Cat = taC ocaT";
	for (int i = 0; i < 3; i++)
	{
		std::string usr_str = "";				//Initialize variable.
		cout << "\nEnter a short phrase of less than " << a << " characters: ";
		try										//Try
		{
			cin >> usr_str;						//Get string from user.
			cin.clear();
			cin.ignore();						//Clear cin buffer in between loops.
			if (usr_str.length() > a)			//Check if length is within 256 characters.
			{
				usr_str = "";					//Clear string.
				cout << "\nInput too long.";	//Warn user.
				i--;							//Deincrement loop.
			}
			else								//Else, perform string reversal
			{
					
				reverse(usr_str.begin(), usr_str.end());	//Reverse string.
				cout << usr_str;				//Output reversed string.
			}
		}//end try{}
		catch (std::out_of_range)				//Catch out of range errors. I attempted to do this with a c-style string initially using fgets().
		{										//std::string throws out_of_range errors. Wrapping in a try clause should catch most std::string related errors (I hope).
			usr_str = "";
			cout << "\nIncorrect Input Detected.";	// Warn user.
			i--;
		}
		

		// using c style character arrays seems like more trouble than it's worth to harden. Going with a string based approach instead.
		//char usr_in[48];
		//cin.width((a[i]-1));
		//char * fgets(char * usr_str, int * (a[i]) ,FILE * stream);

	}//end for (i)
	
	cout << "\nPress ENTER to continue.\n";
	cin.ignore();//Wait for input / clear buffer.
	//cin >> a;
	return 0;
}//end Main()
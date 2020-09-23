// Source.cpp
/*
Critical Thinking 4
Gregory Norris
Colorado State University Global Campus
CSC 450 - Haseltine
Salary Calculator.
This program will take information from a user an calculate their salary using formatted output.
*/

#include <iostream>
#include<string>
#include<stdio.h>
#include<iomanip>
#include<sstream>
#include<exception>
#include<limits>
using namespace std;


int main()
{
	int unsigned a = 10;
	double user_data[4] = { 0, 0, 0, 0 };									//Standard Hours Worked [0], Rate of Pay[1], Overtime Hours Worked[2]
	double *pointers[4];
	ios init(NULL);															//Initialize init object for storing cout format flags
	init.copyfmt(cout);														//Copy default format for cout to restore later
	std::cout << "Critical Thinking 4 Option 1\nGregory Norris\nCSC450 Haseltine\nColorado State University Global Campus\n--------------------------------\n\nThis program calculates a salary based upon hours worked and the pay rate.\n";
	
	string enterType[4] = { "Standard Hours Worked: \t\t", "Rate of Pay: \t\t\t$", "Overtime Hours (0 if none): \t","Total Salary: \t\t\t$" };
	for (int i = 0; i < 3; i++)
	{
		std::string usr_str = "";									//Initialize variable.
		cout << setw(a) << "\nPlease enter "<<enterType[i]<<endl;
		try															//Try
		{
			std::cin >> setw(10) >> usr_str;						//Get string from user.									
			std::cin.clear();
			std::cin.ignore(10000, '\n');						//Clear cin buffer in between loops.	
		}//end try{}
		catch (std::out_of_range)								//Catch out of range errors. I attempted to do this with a c-style string initially using fgets().
		{														//std::string throws out_of_range errors. Wrapping in a try clause should catch most std::string related errors (I hope).
			usr_str = "";
			std::cin.clear();
			std::cin.ignore();
			cout << "\nIncorrect input.";						// Warn user.
			i--;
			break;
		}
		try
		{
			double *pointer;
			pointer = new double;
			*pointer = stod(usr_str);								//Convert string into double ptr (could have used double)
			if ((0 <= *pointer) && (*pointer < 99999999))			//Validate 
			{
				user_data[i] = *pointer;							//Store value to array.
				delete pointer;										//delete pointer.
			}		//Qualify input
			else{ i--; cout << "Value out of bounds";}
		}
		catch (...)
		{
			usr_str = "";
			cout << "\nInput error";			//General catch-all.
			i--;
		}

	}//end for (i)
	
	user_data[3] = (user_data[0] * user_data[1]) + (user_data[2] * user_data[1] * 1.5);
	
	for (int i = 0; i < 4; i++)
	{
		pointers[i] = &user_data[i];
		
		cout << enterType[i] << setprecision(2) << fixed << user_data[i] << endl;			//Set new format and output user data.
		cout.copyfmt(init);																	//Restore cout format defaults
		cout << "Pointers Value: " << *pointers[i] << "\tDereference: " << pointers[i] << "\tPointer Address: " << &pointers[i] << endl;
	}

	cout << "\nPress ENTER to continue.\n";
	std::cin.ignore();						//Wait for input / clear buffer.
	
	return 0;
}//end Main()

/*
		Critical Thinking 3
		Gregory Norris
		CSC 450
		Colorado State University Global Campus
		
		This program receives user input, stores a number as a variable, creates three pointers to each variable 
		and displays the pointer value, pointer destination address and the pointer's address value.
		runThisManyTimes determines the number of times to run the program. Currently set to 3.


*/


#include <iostream>
#include <string>
#include <iomanip>
#include<stdio.h>
#include<exception>

using namespace std;
int main()
{
	cout << "Critical Thinking 3\nGregory Norris\nCSC 450\nThis program asks the user for 3 integers, \nassigns 3 pointer values to each stored integer and returns \ninformation about the assigned pointers.\n\n";
	const int runThisManyTimes = 3;
	int numbers[runThisManyTimes];
	int *pointers[runThisManyTimes*3];
	

	for (int i = 0; i < runThisManyTimes; i++)
	{
		
		string user_Input = "";
		cout << "\nEnter an integer number("<<i+1<<"\\"<< runThisManyTimes<<")"<< endl;
		//int userNumber;
		try {
			
																//C++ style string input. Set width to decimal width of max INT (signed).
			cin >> setw(10) >> user_Input;
			//getline(cin, user_Input);
			cin.clear();
			cin.ignore();
		}
		catch (std::out_of_range)								//Catch out_of_range error when collecting user input. Alert user. Deincrement i. Break.
		{
			string user_Input = "";
			cin.clear();
			cin.ignore();
			cout << "Incorrect Entry.\n";
			i--;
			break;
		}
		try{		
			int *pointer;										//Initialize new pointer, assign memory dynamically.
			pointer = new int;
			*pointer = stoi(user_Input);						//Use std::stoi to parse string into int.
			user_Input = "";									//Immediately reset string value

			//*pointer = userNumber;							//Did not have the error handling I was expecting...
			numbers[i] = *pointer;
				for (int j = 1; j < 4; j++)
				{
					int k = (j*i) + (j - 1);					//For every number entered, store 3 pointer values in the array.
					pointers[k] = pointer;
					if ((j % 3) == 1)
					{
						cout <<"\nNumber: " << numbers[i] << endl;//Print number, enter/tap pointer stored value, destination address, pointer address.
					}
					int **doublePointer = &pointers[k];
					cout << "\tPointer Value: " << *pointers[k] << "\tDereference: " << pointers[k] << "\tAddress-of: " << &pointers[k] << endl;
					//cout << "\t\tPointer to the pointer "<<&doublePointer<<endl;
				}
				delete pointer;									//Delete pointer, release memory.
		}
		catch (std::exception e){ 
			cout <<  "\nInput error: "<<e.what();			//General catch-all.
			i--;
			//break;
		}
	}
																//Wait for user input before closing program.
	cout << "\nPress Enter to continue...\n";
	cin.ignore();
	return 0;
}
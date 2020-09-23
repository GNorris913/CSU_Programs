#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include <fstream>
#include <exception>
#include <stack>

using namespace std;
 
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^   METHODS   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

void rev_file(const std::string &in_fileName, const std::string &out_fileName);
void get_input(const std::string &filename);
void copy_file(const std::string &in_fileName, const std::string &out_fileName);

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    MAIN    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
int main()
{	
	const std::string firstFileName = "CSC450_CT5_mod5.txt";
	const std::string copyFileName = "CSC450_CT5_mod5_2.txt";
	const std::string reverseFileName = "CSC450_CT5_mod5_reverse.txt";
	
	get_input(firstFileName);
	copy_file(firstFileName, copyFileName);
	rev_file(copyFileName,reverseFileName);
	
	cout << "\n\nPress ENTER to end program.\n";
	cin.get();
	return 0;
}
//************************** GET INPUT - APPEND TO FILE ***************************************
void get_input(const std::string &in_fileName)
{

	string user_input = "";										//Initialize string for user input
	cout << "\nEnter a string to be inserted into the " << in_fileName << " file\n"; //Prompt user
	try{														//Try | catch out_of_range | catch ...
		getline(cin, user_input);								//Get user input
		std::cin.clear();										//Clear input flags
	}

	catch (std::out_of_range)									//Catch out of range exception
	{
		cout << "Error: out of range";
		std::cin.clear();
		std::cin.ignore();
		return;
	}
	catch (...)													//Catch all other exceptions
	{
		cout << "Invalid input";
		std::cin.clear();
		std::cin.ignore();
		return;
	}
	//Open the output file in append mode
	std::ofstream oFile(in_fileName, std::ios::out | std::ios::app);
	if (!oFile.is_open())										//Check if file is open
	{
		cout << "Input file check failed.\n";
		return;
	}//end if()
	else
	{
		oFile << "\n";
		oFile << user_input;									//Append the user input to the file after newline character
		cout << "\nInput written to file.\n";
	}

	oFile.close();												//Close file output file.
	return;
}
//************************** COPY TO NEW FILE ***************************************
void copy_file(const std::string &in_fileName, const std::string &out_fileName)

{																//Open input file in read-only mode, begin stream at start of file
	std::ifstream iFile(in_fileName, std::ios::in | std::ios::beg);
	if (!iFile.is_open())										//Check if input file is open
	{
		cout << "Input file check failed.\n";
		return;													//return to Main() if check failed
	}//end if()
	else{

		std::ofstream oFile(out_fileName, std::ios::out);		//Open the output file
		if (!oFile.is_open())									//Check if file is open.
		{
			cout << "Output file check failed.\n";
			return;												//return if failed

		}
		else
		{
			oFile << iFile.rdbuf();								//Copy source file to buffer, write to destination file. This essentially makes a copy of the initial file.
		}//end else
	
		oFile.close();											//Close oFile
	}//end else
	

}//end copy_file(){}

//************************** REVERSE INPUT COPY TO NEW FILE ***************************************
void rev_file(const std::string &in_fileName, const std::string &out_fileName) 
{
	std::ifstream iFile(in_fileName, std::ios::in | std::ios::beg);
	if (!iFile.is_open())										//Check if input file is open
	{
		cout << "Input file check failed.\n";
		return;													//Return to Main() if check failed
	}//end if()
	else{
		char c;
		stack <char> charStack;									//Initialize character stack, used to reverse file contents
		cout << "\nNew file contents:\n\n";
		
		while (iFile.get(c))									//Copy each character of file into a variable
		{
			cout << c;											//Print character to console
			charStack.push(c);									//Push character to top of stack
		}
		
		std::ofstream oFile(out_fileName, std::ios::out);
		if (!oFile.is_open())									//Check if output file is open
		{
			cout << "Output file check failed.\n";
			return;												//return to Main() if failed
		
		}
		else
		{
			while (!charStack.empty())							//While stack is not empty
			{
				c = charStack.top();							//Take top character off <char> stack
				oFile << c;										//Write char to file -- This method does require a lot of writes to disk, probably better to write to buffer then write to disk to avoid disk thrashing.
				charStack.pop();								//Pop the top character off the <char> stack
			}
		}//end else()
		
		
		oFile.close();											//Close oFile
		iFile.close();											//Close iFile
	}//end else()
}

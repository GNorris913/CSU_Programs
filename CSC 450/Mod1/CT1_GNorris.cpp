// CT1_GNorris.cpp : Defines the entry point for the console application.
//
/*
	Critical Thinking 1
	Gregory Norris
	CSC450 - Colorado State University Global Campus

*/

#include "stdafx.h";
#include <iostream>;
#include <string>;
using namespace std;

int main()
{
	char firstName[15] = "SpongeBob";
	char lastName[15] = "Squarepants";
	char address[30] = "In a pineapple under the sea.";
	char city[30] = "Bikini Bottom";
	char zipCode[8] = "80122";

	cout<<"Name: "<< firstName<<" "<<lastName<<"\nAddress:  "<<address<<", "<<" "<<city<<", "<<zipCode<<"\n";
	cin.get();



	return 0;
}


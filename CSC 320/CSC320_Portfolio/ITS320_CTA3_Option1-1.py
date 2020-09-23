#!/usr/bin/env python3
#Gregory Norris - Module 3 Option 1.
#CSU Global Campus
#ITS 320 - 1/8/2019

#----------------Defined main program-------------------
def main():
	carYear = 1
	print ("\nThis program calculates the approximate value of a Ferrari 250 GTO between 1962 and 2014")
	while carYear !=0:
		carYear = getInput()
		if carYear == 0:
			break
		carValue = calculateValue(carYear)
		printOutput(carYear,carValue)
#--------------------Obtain the user input as an integer between 1962 and 2014-------------
def getInput():
	correctInput = False
	correctRange = False
	while (correctRange == False):
		while (correctInput == False):
			try:
				userinput = int(input('Please enter the year or enter 0 to quit: '))
				correctInput = True
			except ValueError:
				print ('Incorrect Input\nPlease enter an integer between 1962 and 2014')
				break
			if (userinput >= 1962) and (userinput <= 2014):
				correctRange = True
				return userinput
			elif (userinput == 0):
				return userinput
			else:
				print ('Incorrect Input\nPlease enter an integer between 1962 and 2014')
				correctInput=False
#--------------Take the car year and return the car's value-------------------------	
def calculateValue(cYear):
	retValue = 0
	if cYear <= 1964:
		retValue = 18500
	elif cYear <= 1968:
		retValue = 6000
	elif cYear <= 1971:
		retValue = 12000
	elif cYear <= 1975:
		retValue = 48000
	elif cYear <= 1980:
		retValue = 200000
	elif cYear <= 1985:
		retValue = 650000
	elif cYear <= 2012:
		retValue = 35000000
	elif cYear <= 2014:
		retValue = 52000000
	return retValue
#-------------------------------Print the car's value------------------------------
def printOutput(iYear,iValue):
	print ('The estimated value of a Ferrari 250 GTO in the year {} is ${:,}' .format(iYear, iValue))

#============Run Main Program=========================
main()
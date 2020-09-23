#!/usr/bin/env python3
#Gregory Norris - Module 4 Option 1.
#CSU Global Campus
#ITS 320 - 1/8/2019
#------------Defines main program. Obtains user input, calls upon functions to calculate, calls upon function to print---------------
def main():
	print('This program calculates the Sum, Largest, Smallest, Average, and 20% of five numbers entered.')
	numberList=[]
	for i in range(5):
		correctInput = False
		user_in = 0.0
		while correctInput != True:
			try:
				user_in = float(input('Please enter a number: '))
				correctInput = True
			except ValueError:
				print ('Must be a number')
		numberList.append(user_in)
	numTotal = calculateTotal(numberList)
	numAv = calculateAverage(numberList)
	numMax = calculateMaximum(numberList)
	numMin = calculateMinimum(numberList)
	numInt = calculateInterest(numberList)
	printEverything(numTotal,numAv,numMax,numMin,numInt)
def printEverything(total,average,numMax,numMin,interest = []):
		print ('Total: {}\nAverage: {}\nLargest Number: {}\nSmallest Number: {}'.format(total,average,numMax,numMin))
		print ('20% Interest: ',end = '')
		print (*interest, sep = ', ')
def calculateTotal(numList = []):
	numTotal = 0.0
	for usrNum in numList:    
	    numTotal = numTotal + usrNum
	return numTotal
def calculateAverage(numList = []):
	numAvg = 0.0
	for usrNum in numList:
		divisor = len(numList)
		numAvg = float(numAvg) + usrNum
	numAvg = numAvg/divisor
	return numAvg	
def calculateMaximum(numList = []):
	numMax = max(numList)
	return numMax
def calculateMinimum(numList = []):
	numMin = min(numList)
	return numMin
def calculateInterest(numList = []):
	numInterest=[]
	numInt = 0
	for userNum in numList:
		numInt = float(userNum+userNum*0.02)
		numInterest.append(numInt)
	return numInterest
#==================MAIN====================
main()	
	
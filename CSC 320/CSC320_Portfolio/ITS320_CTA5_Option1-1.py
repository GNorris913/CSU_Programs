#!/usr/bin/env python3
#Gregory Norris - Module 5 Option 1.
#CSU Global Campus
#ITS 320 - 1/28/2019
#------------Defines main program. Obtains user input, calls upon functions to calculate, calls upon function to print---------------
def main():
    # Get user input and store as three seperate variables. Would probably scale better with a list.
    uno = getInput()
    dos = getInput()
    tres = getInput()
    programOutput(uno,dos,tres)
    uno = reverseString(uno)
    dos = reverseString(dos)
    tres = reverseString(tres)
    programOutput(uno,dos,tres)

#This method asks the user for a string and returns the user input.
def getInput():
    userIn = input('Please enter a string: ')
    return userIn

#This particular takes the three string variables and outputs them in the reverse order that they were entered in.	
def programOutput(in1,in2,in3):
    #Removed unused variables.
    print (in3+in2+in1)

####Takes an individual string and returns the string in reverse. For example: .noitcerid lareneg ruoy ni traf I !seirrebredle fo tlems rehtaF ruoy dnA retspmah a saw rehtoM ruoY 
## in_str = in_str[::-1], Since there are no values in the slice, it takes the whole string. 
## The -1 modifier indicates start from the end and work backwards. Variations on the [-1] slice can be useful for tailing a log, similar to the tail command in Bash.
def reverseString(in_str):
    in_str = in_str[::-1] 
    return in_str
####Main Program Call####
main()
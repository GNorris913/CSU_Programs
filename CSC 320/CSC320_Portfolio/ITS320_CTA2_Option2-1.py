#Gregory Norris ITS320 - CSU Global - Module 2, Option 2
import sys

def main():
#Cycle through attributes in list. Collect user input into additional list. Zip two lists together into dictionary.
    cAttributes = ["Make", "Model", "Year", "Starting Odometer", "Ending Odometer","Gallons of Gas","Estimated MPG"]
    n = 0
    cList = []
    cDict = {}
    for field in cAttributes:
        n +=1
        if n == 7:
            break
        print('Enter the '+field+': ')
        #Check input as integer. Otherwise, close program to prevent crash.
        if n <3:
            cList.append(input())
        else:
            try:
                u_in = int(input())
                cList.append(u_in)
            except ValueError:
                print("Must be integer value. Program will now close.")
                sys.exit()
       #Calculate Miles per Gallon         
        if n == 6:
            startOdo = int(cList[3])
            endOdo =int((cList[4]))
            gas = int((cList[5]))
            gas = ((endOdo - startOdo)/gas)
            mpg = round(gas,2)
            cList.append(mpg)
            n = 0
            break
    zipCList = zip(cAttributes,cList)
    cDict = dict(zipCList)    
    print(cDict)

#-------------Main-----------------
main()

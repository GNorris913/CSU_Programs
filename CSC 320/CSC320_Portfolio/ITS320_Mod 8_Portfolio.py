#Gregory Norris
#ITS320-4 Module 8 Portfolio Project
#This program is designed to keep a running record of cars in stock at a dealership.
import os
import csv
                             # This could have been much cleaner using more iterators and dict/arrays.
                             # Currently incapable of correctly handling comma char in input.
                             # Due to no quotations in data fields on CSV output. Whatever.
filename = 'inventory.csv'
verbose = False              # Enable printing troubleshooting prompts to console.
inventory = []               # Primary inventory array stores class Vehicle(). This is a global variable. Whatever.
runprogram = True            # Control statement to end program.


def main():                  # Main program loop. Control statement, runs menu until close.
    try:
        make_csv()           # Initialize CSV file if one does not exist.
        load_from_csv()      # Load existing inventory from inventory.csv if file exists.
        while runprogram:
            menu()           # Main user menu.

        if verbose:
            print('Post Menu')
    except:
        print('Main() Exception')
    print('Program Complete')


def menu():                       # COMPLETE Primary user menu.
    if verbose:
        print('menu()')
    print('\n********MAIN MENU********')
    print("1. New\n2. List\n3. Modify\n4. Delete\n5. Write and quit")
    selection = get_int(1, 5)
    if selection == 1:            # COMPLETE - Add vehicle to list
        if verbose:
            print('menu(): 1')
        add_car()
        if verbose:
            print('menu() > addCar() done')
    elif selection == 2:          # COMPLETE - Print vehicles list
        if verbose:
            print('menu(): 2')
        display_inventory()
        if verbose:
            print('menu() > display_inventory() done')
    elif selection == 3:          # COMPLETE - Edit list
        if verbose:
            print('edit inventory')
        edit_inventory()
        if verbose:
            print ('menu() > edit inventory done')
    elif selection ==4:           # COMPLETE - Delete Inventory
        if verbose:
            print('menu () delete inventory()')
            delete_inventory()
            print('menu () delete_inventory() done')
    elif selection == 5:          # COMPLETE - Print and close
        save_export()
        if verbose:
            print('Exported to CSV inventory.csv')
        global runprogram
        runprogram = False


def display_inventory():      # COMPLETE - Used to display vehicle information stored in memory.
    if verbose:
        print('Display Array')
    for row in range(len(inventory)):
        print(inventory[row])


def make_pin():               # COMPLETE  - Vehicle PIN number automatically assigned by make_pin()
    out_pin = 0
    for row in range(len(inventory)):
        in_pin = inventory[row]
        if in_pin.pin >= out_pin:
            out_pin = in_pin.pin+1
    return out_pin


def add_car():                # COMPLETE - Add car to memory using Vehicle class
    if verbose:
        print('def add_car()')
    print('********ADD VEHICLE********')
    pin = make_pin()
    print('Enter Make: ')
    make = get_str()
    print('Enter Model:')
    model = get_str()
    print('Enter Year:')
    year = get_int(1885, 2200)  # Check for valid date range
    print('Enter Color:')
    color = get_str()
    print('In Stock? Y/N')
    stock = get_bool()
    car1 = Vehicle(pin, make, model, year, color, stock)
    #car = Vehicle(10, 'Honda', 'Accord', 2003, 'Gold', 'Y') #Preload class for testing.
    if verbose:
        print('inventory.append[car]')
    # inventory.append(car) - Demo constructor
    inventory.append(car1)
    if verbose:
        print('inventory.append[car] done')


def make_csv():                 # COMPLETE - Make new CSV file & Header if not exist

    if verbose:
        print('InitializeFile()')
        print(os.getcwd())
    headers = ['ID', 'Make', 'Model', 'Year', 'Color', 'Inventory']
    if verbose:
        print('makeCSV() file Empty')

    if verbose:
        print('makeCSV() with open(inventory.csv) as csvfile')
    with open('inventory.csv', 'a+') as csvFile:
        if verbose:
            print('csvWriter = csv.writer')
        csvWriter = csv.writer(csvFile, delimiter=',')
        fileEmpty = os.stat('inventory.csv').st_size == 0 # Check file size
        if verbose:
            print('if fileEmpty')
        if fileEmpty:
            if verbose:
                print('makeCSV() csvWriter.writeheader()')
            csvWriter.writerow(headers)                  # Print file header


def load_from_csv():               # COMPLETE - load car class from csv file
    print('Loading existing inventory from inventory.csv')
    with open('inventory.csv', 'r') as csvfile:
        csvreader = csv.reader(csvfile, delimiter=',')
        csvlist = list(csvreader)
        for row1 in csvlist:
            print(row1)
            id = ','.join(map(str, row1[0:1]))
            print('id'+id)
            isnumber = str.isdigit(id)
            print(isnumber)
            if isnumber:                              # Checks for PIN number to identify vehicle to load into memory.
                pin = ','.join(map(str, row1[0:1]))   # Loads data from CSV into vehicle class, adds to inventory array.
                pin = int(pin)                        # Format input for class constructor
                make = ','.join(map(str, row1[1:2]))  # Proof I'd rather map input than troubleshoot class output
                model = ','.join(map(str, row1[2:3]))
                year = ','.join(map(str, row1[3:4]))
                year = int(year)
                color = ','.join(map(str, row1[4:5]))
                stock = ','.join(map(str, row1[5:6]))
                car1 = Vehicle(pin, make, model, year, color, stock) # Make new Vehicle class item.
                if verbose:
                    print('CSV: inventory.append[car1]')
                # inventory.append(car)
                inventory.append(car1)
                if verbose:
                    print('inventory.append[car1] done')


def save_export():               # - COMPLETE Overwrite existing CSV file from memory and close program.
    if verbose:
        print('makeCSV() with open(inventory.csv) as csvfile')
    with open('inventory.csv', 'w', newline='') as csvFile:
        if verbose:
            print('csvWriter = csv.writer()')
        csvWriter = csv.writer(csvFile, delimiter=',')

        for row in range(len(inventory)):
            newItem = inventory[row]
            memonly = newItem.memonly
            if memonly:
                outID = newItem.pin
                outMake = newItem.make
                outModel = newItem.model
                outYear = newItem.year
                outColor = newItem.color
                outStock = newItem.stock

                formatOut = [outID, outMake, outModel, outYear, outColor, outStock]
                csvWriter.writerow(formatOut)


class Vehicle(object):            # Vehicle class. Has display format.
    def __init__(self, pin, make, model, year, color, stock):
        self.pin = pin
        self.make = make
        self.model = model
        self.year = year
        self.color = color
        self.stock = stock
        self.memonly = True

    def __str__(self):
                                # Formats output for display when called as str().
        return (f'Pin #: %i\n\tMake:   %s\n\tModel:  %s\n\tYear:   %i\n\tColor:  %s\n\tIn Stock? %s\n\n' % (self.pin, self.make, self.model, self.year, self.color, self.stock))


def get_int(min, max):          # Get user integer input, set min and max acceptable input values
    print()
    incorrect = True
    while incorrect:
        try:
            usrin = int(input())
            if ((usrin>=min) & (usrin<=max)):
                incorrect = False
            else:
                print(f'Must be between %i and %i' % (min, max))
        except ValueError:
            print('Must be integer')
    return usrin


def get_str():                   # IDK if I even use this one.
    out_str = input()
    return out_str


def get_bool():                  # Get user input, return boolean statement
    incorrect = True
    while incorrect:
        userIn = input()
        if userIn == 'Yes'or'yes'or'y'or'Y':
            userIn = 'Yes'
            incorrect = False
        elif userIn == 'No'or'no'or'N'or'n':
            userin = 'No'
            incorrect = False
        else:
            print('Must be yes or no')
    return userIn


def edit_inventory():  # COMPLETE - EDIT CURRENT INVENTORY ITEM
    print('Enter the PIN # of the vehicle to be edited')
    match_found = False
    in_pin = get_int(0, 9999999)
    for item in inventory:
        print()
        if in_pin == item.pin:
            print('Match Found')
            match_found = True
            keep_editing = True
            while keep_editing:
                print(str(item))
                print('Select field to edit:\n1. Make\n2. Model\n3. Year\n4. Color\n 5. In Stock\n 6. Exit Menu')
                user_in = get_int(1, 6)  # Sets minimum and max int user responses.
                if  user_in == 1:
                    print('Enter New Make:')
                    item.make = input()
                elif user_in == 2:
                    print('Enter New Model:')
                    item.model = input()
                elif user_in == 3:
                    print('Enter New Year:')
                    item.year = get_int(1845, 2200)
                elif user_in == 4:
                    print('Enter New Color: ')
                    item.color = input()
                elif user_in == 5:
                    print('Vehicle in inventory? Y/N')
                    item.stock = get_bool()
                elif user_in == 6:
                    keep_editing = False
    if match_found != True:
            print('No Match Found')


def delete_inventory():
    print('This function will delete the vehicle')
    print('Enter the PIN # of the vehicle to be edited')
    pin_match = False
    in_pin = get_int(0, (len(inventory)-1))
    counter = 0
    for item in inventory:
        if in_pin == item.pin:
            print('Match Found')
            pin_match = True
            print(str(item))
            print('Confirm deletion? Y/N')
            verify_delete = get_bool()
            if verify_delete == 'Yes':
                inventory.pop(counter)
            else:
                break
        counter = counter + 1
    if pin_match != True:
        print('No matching vehicle PIN.')


main()

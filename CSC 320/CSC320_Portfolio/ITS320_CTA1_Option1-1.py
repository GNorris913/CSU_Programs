#!/usr/bin/env python3
#Gregory Norris - CSU Global: ITS320 - Module 1: Option 1
import sys
import turtle
from turtle import *
#Global variable for program termination
end = False

#main program, contains sys.exit() for program termination. Setting global variable end to True, or animal == 0 will terminate program.
def main():
    while end == False:  
        animal = select_animal()
        if ((animal == '0') or (end==True)):
            sys.exit()
        else:
            draw_animal(animal)
            
#select which animal to draw. Triggers the draw script for each animal from Print_Animals class.
def draw_animal(in_animal):
    selector = in_animal
    if(selector=='1'):
        Print_Animals.make_mouse()
    elif(selector=='2'):
        Print_Animals.make_dolphin()
    elif(selector=='3'):
        Print_Animals.make_duck()
    

#get user input
def select_animal():
    run_sel_anm = True
    while (run_sel_anm==True):
        #Check for correct user input 0 to 3. Catch ValueError exception.
        try:
            user_in = '100'
            user_in = input('Enter 1 for Mouse, 2 for Dolphin, 3 for Duck\n Type 0 to quit\nAnimal: ')
            check = int(user_in)
        except ValueError:
                print('Must be integer between 0 and 3\n')
        if ('0'<=user_in<'4'):
            return user_in
            run_sel_anm==False
            break
        else:
            print('Incorrect entry')


#---------Defines what to print for each animal----------------#    
class Print_Animals():
    #Prints a Mouse
    def make_mouse():
        print('A Mouse')
        print('             (\-.\n             / _`>\n     _)     / _)=\n    (      / _/    \n     `-.__(___)_\n       ')
    #Prints a dolphin
    def make_dolphin():
        print('A Dolphin')
        print('                ;\'-.\n    `;-._        )  \'---.._\n      >  `-.__.-\'          `\'.__\n     /_.-\'-._         _,   ^ ---\'\n      `       `\'------/_.\'----\\   ')
    #Prints ASCII Duck word + terrible turtle drawing of duck.
    def make_duck():
        #Commented print line prints the words "A Duck" in large obnoxious ASCII art. Removed due to obnoxiousness, also does not format well on smaller CLI windows.
        #print('          _____                                    _____                    _____                    _____                    _____          \n         /\    \                                  /\    \                  /\    \                  /\    \                  /\    \         \n        /::\    \                                /::\    \                /::\____\                /::\    \                /::\____\        \n       /::::\    \                              /::::\    \              /:::/    /               /::::\    \              /:::/    /        \n      /::::::\    \                            /::::::\    \            /:::/    /               /::::::\    \            /:::/    /         \n     /:::/\:::\    \                          /:::/\:::\    \          /:::/    /               /:::/\:::\    \          /:::/    /          \n    /:::/__\:::\    \                        /:::/  \:::\    \        /:::/    /               /:::/  \:::\    \        /:::/____/           \n   /::::\   \:::\    \                      /:::/    \:::\    \      /:::/    /               /:::/    \:::\    \      /::::\    \           \n  /::::::\   \:::\    \                    /:::/    / \:::\    \    /:::/    /      _____    /:::/    / \:::\    \    /::::::\____\________  \n /:::/\:::\   \:::\    \                  /:::/    /   \:::\ ___\  /:::/____/      /\    \  /:::/    /   \:::\    \  /:::/\:::::::::::\    \ \n/:::/  \:::\   \:::\____\                /:::/____/     \:::|    ||:::|    /      /::\____\/:::/____/     \:::\____\/:::/  |:::::::::::\____\ \n\::/    \:::\  /:::/    /                \:::\    \     /:::|____||:::|____\     /:::/    /\:::\    \      \::/    /\::/   |::|~~~|~~~~~     \n \/____/ \:::\/:::/    /                  \:::\    \   /:::/    /  \:::\    \   /:::/    /  \:::\    \      \/____/  \/____|::|   |          \n          \::::::/    /                    \:::\    \ /:::/    /    \:::\    \ /:::/    /    \:::\    \                    |::|   |          \n           \::::/    /                      \:::\    /:::/    /      \:::\    /:::/    /      \:::\    \                   |::|   |          \n           /:::/    /                        \:::\  /:::/    /        \:::\__/:::/    /        \:::\    \                  |::|   |          \n          /:::/    /                          \:::\/:::/    /          \::::::::/    /          \:::\    \                 |::|   |          \n         /:::/    /                            \::::::/    /            \::::::/    /            \:::\    \                |::|   |          \n        /:::/    /                              \::::/    /              \::::/    /              \:::\____\               \::|   |          \n        \::/    /                                \::/____/                \::/____/                \::/    /                \:|   |          \n         \/____/                                  ~~                       ~~                       \/____/                  \|___|          \n                                                                                                                                             \n')
        print('A duck shall appear in a new window')
#--------Opens a new Graphics window using Turtle----------
        maturin = turtle.Turtle()
        maturin.speed(0)
        maturin.setposition(0,0)
        maturin.pendown()
        maturin.circle(90)
        maturin.circle(90,60)
        maturin.right(60)
        maturin.forward(80)
        maturin.right(90)
        maturin.forward(10)
        maturin.right(90)
        maturin.forward(89)
        maturin.penup()
        maturin.setposition(35,110)
        maturin.pendown()
        maturin.circle(15)
        maturin.penup()
        maturin.setposition(0,0)
        maturin.pendown()
        maturin.circle(-700,20)
        maturin.circle(-700,-20)
        maturin.circle(90,-230)
        maturin.goto(-234,35)
        turtle.done()

#----------------------RUN MAIN----------------------------------------------
main()   

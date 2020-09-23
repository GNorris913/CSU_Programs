/*
*	GREGORY NORRIS
*	PORTFOLIO ASSIGNMENT OPTION 1
*	CSC372-1, BASS
*	AUGUST 2 2019
*	COLORADO STATE UNIVERSITY GLOBAL CAMPUS
*
*
*	This program stores student data in an a linked list, sorts by proper name (last, first, middle, title)
*	and allows the user to save student data to a text document. Deletion by student number is allowed,
*	there was an option to modify existing student data, but it's not a requirement and I'm happy enough with
*	how this program operates.
*
*
*	STRUCTURE:
*	Main():		just calls JFX class, provides args.
*	JFX:		JavaFX program, contains most of the working methods and linked list array.
*	Student:	Student class object
*	SortName:	Takes LinkedList<Student>, splits name, formats proper name, sorts by name, returns LinkedList<Student>.
*
*	OPERATION:	Add Student and Delete student available from main window. 
*				Options to populate array w/ sample data, save, quit, 
*				and sort students list are top menu bar options which are 
*				only available from the main scene. Add Students and Delete
*				Students operate from their own JFX scenes. Program *should*
*				catch all logical user input errors including blank fields &
*				type mismatch.
*
*	PROGRAM REFLECTION:	
*				During my research for this program, I learned there are vastly more efficient ways of structuring scene in JavaFX.
*				I also would have contained each scene into it's own object instead of initializing and basically having them all run simultaneously.
*				A lot of times, after writing something, I would find a more logical way to do it. This code is pretty much a first-draft, and I have a
*				feeling everything could have been implemented with 1/3 the effort and code provided if I had spent more time researching before just throwing code into the IDE to see what works.
*				I also ask myself: is this maintainable? The answer is no, but I have a lot to learn still to become proficient at programming.
*/
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        Application.launch(JFX.class, args);
    }
}
import javafx.application.Application;

/* Gregory Norris
 * CSC 400 - Bass
 * Module 8 Portfolio Project Option 1
 * Colorado State University Global Campus
 * 
 * 			*** PROGRAM INFORMATION ***

 * Program uses JavaFX (JFX) for GUI. Person class is stored in a
 * custom-instantiated queue class called PQueue. PQueue is a linked-list queue class.
 * Quicksorts are completed by passing alias to QSortAge, QSortFName QSortLName.
 * Quicksorts parse the Queue into a linked list array for sorting, the back into a queue.
 * Printing the Queue in the GUI empties the Queue.
 * Quicksort comments on QSortFName.
 * Almost all of the JFX class is copied/modified from my CSC-372 portfolio project.
 *
 */

public class Main {

	public static void main(String[] args) 
	{
		Application.launch(JFX.class, args);
		
		//Test cases
		
		PQueue <Person> people = new PQueue<Person>();
		Person person = new Person("Greg","Norris",29);
		
		people.enqueue(person);
		people.enqueue(new Person("Rachel","Green",24));
		people.enqueue(new Person("Phoebe","Buffay",28));
		people.enqueue(new Person("Joey","Tribbiani",26));
		people.enqueue(new Person("Chandler","Bing",27));
		people.enqueue(new Person("Ross","Geller",27));
		people.enqueue(new Person("Monica","Geller",30));
		people.enqueue(new Person("Princess Conseula","Banana-Hammock",28));
		
		QSortAge ageSort = new QSortAge();
		QSortLName lastNameSort = new QSortLName();
		QSortFName firstNameSort = new QSortFName();
		
		firstNameSort.qSortByFirst(people);
		lastNameSort.qSortByLast(people);
		ageSort.qSortByAge(people);
		
		while (people.notEmpty()) 
		{
			person = people.dequeue();
			System.out.println(person.toString());
		}
		
		
	}

}

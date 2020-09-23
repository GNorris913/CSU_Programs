import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/*Gregory Norris
 * CSC 400 - Bass
 * Critical Thinking 6 Option 1
 * 
 * -Due to the wrong ISBN being posted on the CSU Global front-end, I do not have access to the correct chapter/exercises.
 * After emailing Professor Bass, I am submitting exercise 1 on page 463 of the 4th edition of the textbook.
 *  Exercise 1:
 *  Suppose that nameList is a list that contains the following strings: Kyle, Cathy, Sam, Austin, Sara.
 *  What output is produced by the following sequence of statements?
 *  Iterator<String> nameIterator = nameList.getIterator();
 *  System.out.println(nameIterator.next());
 *  nameIterator.next();
 *  System.out.println(nameIterator.next());
 *  nameIterator.remove();
 *  System.out.println(nameIterator.next());
 *  displayList(nameList);
 * 
 * 
 * 
 * 
 */
public class Main {
	public static void main(String[] args) 
	{
		List<String> nameList = new ArrayList<String>();
		nameList.add("Kyle");
		nameList.add("Cathy");
		nameList.add("Sam");
		nameList.add("Austin");
		nameList.add("Sara");
		 
		Iterator<String> nameIterator = nameList.listIterator();//getIterator() changed to listIterator() to avoid having to rework three prerequisite chapters. Same thing right? I understand an internal private method would be faster than external methods in some cases where iterator is used.
		System.out.println(nameIterator.next());	//Will print the first name in the list. Pointer moves from 0 to between 0 and 1.
		nameIterator.next();						// Advances pointer to next iterator in list (2). Pointer moves to between 1 and 2.
		System.out.println(nameIterator.next());	//Advances pointer between 2 and 3. Will print third name in list. 
		nameIterator.remove();						//Removes #3 "Sam".
		System.out.println(nameIterator.next());	//Advances pointer between 4 and 5 (3 is deleted). Prints "Austin"
		displayList(nameList);						//Prints remaining list.
	
	}

	
	public static void displayList(List<String> nameList) 
	{
		System.out.println("displayList()");
		for (String i : nameList) 
		{
			System.out.println(i);
		}
	}
}

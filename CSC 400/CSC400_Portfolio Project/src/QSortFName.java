import java.util.LinkedList;

public class QSortFName
{
	//Initiated variables within class method to avoid having duplicate lists in memory.
	//Seems more efficient that way.
	public  void qSortByFirst (PQueue<Person> inQ)
	{//PQueue<Person>
		
		PQueue<Person> q1 = new PQueue<Person>();
		LinkedList <Person> q2 = new LinkedList<Person>();
		
										//Make new variable from: Queue<Person> parameter
		q1 = inQ;
										//Convert Queue into linked list
		while(q1.notEmpty()) 
		{
			Person p1 = q1.dequeue();
			q2.add(p1);
		}
										//Initiate quickSort() on linked list. Pass q2, pointer value 0, pointer value max array size.
		quickSort(q2,0,q2.size()-1);
		
										//Convert list back into queue for return.
		for (Person p : q2) 
		{
			q1.enqueue(p);
		}
										//Return q1 as Queue<Person> Somehow this overwrites the method's parameter when called.
										//It works, but was not the expected means of returning sorted values. Probably more efficient not to copy the queue, but it feels less self-contained since technically the linked list in the people object should be private.
		//return q1;					I think that q1 becomes an alias of the Queue stored in Main() rather than a copy of it.
	}
										//This is slightly concerning since the linked-list is declared private by the Queue class and has mutator methods. Any insight on this is appreciated.
	private int partition(LinkedList <Person> q2, int low, int high) 
	{
													//Pull first name as String from Person class
		Person pPerson = q2.get(high);
		String pivot = pPerson.getFirst();			//Use first value in LL as pivot.
		int i = (low-1);							//Set low side pointer
		for (int j = low; j<high;j++)				 
		{
			Person lPerson = q2.get(j);
			String name1 = lPerson.getFirst();
			if(pivot.compareToIgnoreCase(name1)>0) //compareToIgnoreCase compares two strings by unicode value. Returns a +/- number. 
			{
				i++;								//Increment low pointer
				Person temp = q2.get(i);			//Swap values between pivot and low pointer
				q2.set(i, q2.get(j));
				q2.set(j, temp);
			}//end if()	
		}//end for(j)
		Person temp = q2.get((i+1));				//Swap low pointer for highest pointer.
		q2.set((i+1), q2.get(high));				//
		q2.set(high, temp);							//
		return i+1;
	}
	private void quickSort(LinkedList <Person> q2, int low, int high) 
	{
		if (low < high) 							//Check that there are cells between pointers.							
		{
			int par = partition(q2, low, high);		//
			quickSort(q2, low, par-1);				//Perform QS on low half of LL 
			quickSort(q2, par+1,high);				//Perform QS on high half of LL
		}
		
	}
}
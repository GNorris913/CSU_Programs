import java.util.LinkedList;

public class QSortLName
{
	
	public PQueue<Person> qSortByLast (PQueue<Person> inQ)
	{
		PQueue<Person> q1 = new PQueue<Person>();
		LinkedList <Person> q2 = new LinkedList<Person>();

		q1 = inQ;
		while(q1.notEmpty()) 
		{
			Person p1 = q1.dequeue();
			q2.add(p1);
		}
		
		quickSort(q2,0,q2.size()-1);
		
		//Convert list back into queue for return.
		for (Person p : q2) 
		{
			q1.enqueue(p);
		}
		return q1;
	}
	
	private int partition(LinkedList <Person> q2, int low, int high) 
	{
		Person pPerson = q2.get(high);
		String pivot = pPerson.getLast();
		int i = (low-1);
		for (int j = low; j<high;j++) 
		{
			Person lPerson = q2.get(j);
			String name1 = lPerson.getLast();
			if(pivot.compareToIgnoreCase(name1)>0) //compareToIgnoreCase compares two strings by unicode value then returns a positive or negative number. 
			{
				i++;
				Person temp = q2.get(i);
				q2.set(i, q2.get(j));
				q2.set(j, temp);
			}	
		}
		Person temp = q2.get((i+1));
		q2.set((i+1), q2.get(high));
		q2.set(high, temp);
		return i+1;
	}
	private void quickSort(LinkedList <Person> q2, int low, int high) 
	{
		if (low < high) 
		{
			int par = partition(q2, low, high);
			quickSort(q2, low, par-1);
			quickSort(q2, par+1,high);
		}
		
	}
}

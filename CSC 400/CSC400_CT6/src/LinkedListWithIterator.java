import java.util.Iterator;
import java.util.NoSuchElementException;
import org.w3c.dom.Node;

public class LinkedListWithIterator <T> implements ListWIthIteratorInterface<String> {

	private Node firstNode;
	private int numberOfEntries;
	
	public LinkedListWithIterator() 
	{
		//initializeDataFields();
		//IteratorForLinkedList IFLL = new IteratorForLinkedList();
		//return IFLL;
		
	}//end default constructor
	
	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<String> getIterator() 
	{
		return iterator();
	}

	//PC *** IteratorForLinkedList ***
	private class IteratorForLinkedList implements Iterator<String>
	{

		private Node nextNode;
		private IteratorForLinkedList() 
		{
			nextNode = firstNode;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String next() 
		{
			if (hasNext()) 
			{
				//Node returnNode = nextNode;
				//nextNode = nextNode.getNextNode();
				//return returnNode.getData();
				return "0";
			}
			else
					throw new NoSuchElementException("Illegal call for next(); "+"iterator is after end of list.");
		}
		
	}//end IteratorForLinkedList
}//end LinkedListWithIterator

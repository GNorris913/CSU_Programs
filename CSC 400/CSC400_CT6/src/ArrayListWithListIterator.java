import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArrayListWithListIterator <T> implements ListWIthListIteratorInterface<T> 
{
	private T[] list;
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayListWithListIterator() 
	{
		this(DEFAULT_CAPACITY);
	}//end constructor
	
	public ArrayListWithListIterator(int initialCapacity) 
	{
		if (initialCapacity < DEFAULT_CAPACITY) { initialCapacity = DEFAULT_CAPACITY; }
		else{checkCapacity(initialCapacity);}
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[initialCapacity+1];
		list = tempList;
		numberOfEntries = 0;
		initialized = true;
	}// end constructor
	
	private void checkCapacity(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}

	public ListIterator<T> getIterator()
	{
		return new ListIteratorForArrayList();
	}//end getIterator
	
	public Iterator<T> iterator()
	{
		return getIterator();
	}
	private class ListIteratorForArrayList implements ListIterator<T>
	{

		@Override
		public void add(T arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void set(T arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

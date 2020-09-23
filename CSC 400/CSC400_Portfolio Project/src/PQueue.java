/*Gregory Norris
 * Portfolio Project Option 1
 * CSC 400 - Bass
 * Colorado State University Global Campus
 * 9/30/2019
 * 
 * 
 * Queue class adapted from java2s.com/Code/Java/Collections-Data-Structure/TheGenericQueueClass.htm
 * and from algs4.cs.princeton.edu/43mst/Queue.java.html
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class PQueue<T> implements Cloneable
{
	private LinkedList<T> queue = new LinkedList<T>();
	//private int frontIndex;
	//private int backIndex;
	//private final int MAXSIZE = 100;
	//private int nItems;
	//private boolean initialized = false;
	
	//Add new object to queue
	public T enqueue (T newEntry) 
	{
		queue.addLast(newEntry);
		return newEntry;	
	}
	//Remove from queue, return object.
	public T dequeue() 
	{
		return queue.poll();
	}
	public boolean notEmpty() 
	{
		return !queue.isEmpty();
	}
	public int size() 
	{
		return queue.size();
	}
	public void addItems(PQueue<? extends T> q) 
	{
		while(q.notEmpty()) {queue.addLast(q.dequeue());}
	}
	public T peek() 
	{
		if(!notEmpty()) {throw new NoSuchElementException("Queue Underflow");}
		return queue.peek();
	}

}

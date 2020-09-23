import java.util.Iterator;

public interface ListWIthIteratorInterface<T> extends ListInterface<T>, Iterable<T> 
{
	public Iterator<T> getIterator();
	
}

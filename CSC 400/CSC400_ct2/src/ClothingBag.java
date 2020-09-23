

public class ClothingBag implements BagInterface {
	private int numberofProducts;
	private static final int Default_Capacity = 25;
	private final Item[] bag;
		
	public ClothingBag(int capacity) 
	{
		numberofProducts = 0;
		//@SuppressWarnings("unchecked")
		Item[] tempBag = (Item[]) new Item[capacity];//Object[capacity]
		bag = tempBag;
	}//end constructor
	
	public ClothingBag() {this(Default_Capacity);}//end default constructor
	
	public boolean isFull(){return numberofProducts == bag.length;}//end isFull()

	public int maxSize() {int maxSize = Default_Capacity; return maxSize;}
	public Item[] toArray()
	{
		//@SuppressWarnings("unchecked")
		Item[] result = (Item[]) new Item[Default_Capacity];//unchecked
		for (int i = 0; i < numberofProducts;i++) 
		{
			result[i] = bag[i];
		}
		return result;
	}
	
	public boolean add(Item inItem)	{
		boolean success = false;
		if (isFull()) {success = false;}
		else {	
			bag[numberofProducts] =	(Item) inItem;
			numberofProducts++;
		}
		return success;
		
	}//end add()
	public int getCurrentSize() {return numberofProducts;}
	public int getFrequencyOf(Item inItem) 
	{
		int counter = 0;
		for (int i = 0; i<numberofProducts;i++) 
		{
			if(inItem.equals(bag[i])) 
			{
				counter++;
			}
		}
		return counter;
	}
	public boolean contains(Item inItem) 
	{
		boolean match = false;
		int index = 0;
		while(!match && (index < numberofProducts)) 
		{
			if(inItem.equals(bag[index])) 
			{
				match = true;
			}
			else {index++;}
		}
		
		return match;
	}
	public boolean isEmpty() 
	{
		boolean result = false;
		if (numberofProducts>0) {result = true;}
		return result;
	}
	public Item remove() 
	{
		Item result = null;
		if (!isEmpty()) 
		{
			result = bag[numberofProducts-1];
			bag[numberofProducts-1] = null;
			numberofProducts--;
		}//end if
		return result;
	}//end remove()
	public void clear() 
	{
		while(!isEmpty()) {remove();}
	}//end clear()
	public boolean remove (Item inItem) {
	boolean match = false;	
	int index = 0;
	while (!match && (index< numberofProducts)) 
	{
		if (inItem.equals(bag[index])) 
		{
			match = true;
			bag[index] = bag[numberofProducts-1];
			bag[numberofProducts-1]=null;
			numberofProducts--;
		}
		else {index++;}
	}
	return match;
	}
}//end MyBag class

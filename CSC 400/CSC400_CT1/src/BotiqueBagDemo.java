
public class BotiqueBagDemo {


	ClothingBag inventory = new ClothingBag();
	
	public void testAdd1() 
	{
		Item item0 = new Item("NASA T-Shirt",15.00);
		Item item2 = new Item("NWA Hat",10.00);
		Item item3 = new Item ("I <3 Bacon T-Shirt",15.00);
		Item item4 = new Item("Bernie 2020 Poncho",20.00);
	
		inventory.add(item0);
		inventory.add(item2);
		inventory.add(item3);
		inventory.add(item4);
		
	}
	public void displayBag() 
	{
		int maxSize = inventory.maxSize();
		int invSize = inventory.getCurrentSize();
		Item[] result = (Item[]) new Item[maxSize];
		result = inventory.toArray(); 
		for(int i=0;i<invSize;i++) 
		{
			Item tempItem = result[i];
			
			String outName = tempItem.getItemName();
			double outPrice = tempItem.getItemPrice();
			System.out.println("Item Name: "+outName+"  $"+outPrice);
		}
	}
	
	public static void main(String[] args) 
	{
		BotiqueBagDemo bdb = new BotiqueBagDemo();
		bdb.testAdd1();
		bdb.displayBag();
	}

}

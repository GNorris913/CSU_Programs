import java.text.DecimalFormat;

public class Item{
	
	private String 		itemName = null;
	private double 		itemPrice = 0;
	DecimalFormat df = new DecimalFormat("###.##");
	
	public boolean setItemName(String iName) 	
	{
		this.itemName = iName;
		return true;
	}
	public String getItemName() {return itemName;}
	
	public boolean setItemPrice(double iPrice) 	
	{
		if(iPrice >0) 
		{this.itemPrice = iPrice; return true;}
		else {return false;}
	}
	
	//Convert/round to 00.00 for currency.
	public static double roundPrice (double inPrice) 
	{
		double scale = Math.pow(10, 2);
		return Math.round(inPrice*scale)/scale;
	}
	public double getItemPrice() {return itemPrice;}
	
	//Class Constructor
	Item(String inName, double inPrice) 
	{
		inPrice = roundPrice(inPrice);
		this.itemName = inName;
		this.itemPrice = inPrice;
	}
}

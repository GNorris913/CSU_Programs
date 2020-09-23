import java.util.ArrayList;

/* Gregory Norris
 * CSC 400 - Bass
*  Colorado State University Global Campus
*  9/28/2019
* 
* P. 288 Data Structures and Abstractions with Java 4e. F Carrino, T. Henry.
* Exercise #5:
*	"Show the steps that a radix sort takes when sorting the following array of Integer objects:
*	 783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94
*
*/
public class RadixSort 
{
	public static int[] radixSort(int[] inInt) 
	{
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] bucket = new ArrayList[10];
		ArrayList<Integer> sortList = new ArrayList<Integer>();
		int bigO = 0;
													//convert list to arrayList.
		for (int e = 0; e < inInt.length; e++) 
		{ 
			sortList.add(inInt[e]);
			//System.out.print("\nSL"+sortList.get(e));
		}
		
		/* ****Troubleshooting****
		for (int i = 0; i < sortList.size(); i++) 
		{
			int j = sortList.get(i);
			System.out.println(j);
		}
		*/
		
													
		int power = 1;								// Starting decimal place (1)
		int maxPower = 3; 							// Max decimal powers (1,10,100,1000) 3 = 1000
													//RADIX SORT
		for (int i = 0; i < maxPower; i++) 
		{
			for (int b = 0; b<10; b++) 
			{
													//Create array of int Arraylist to store multiple int in each bucket
				bucket[b] = new ArrayList<Integer>();
			}//for (b) end
			
													// Divide by power then by 10, modulus remainder determines which bucket to add result into.
			for(int j = 0; j < sortList.size(); j++) 
			{
				bucket[(sortList.get(j)/power)%10].add(sortList.get(j)); // This is where the magic happens.
				bigO++;
			}//for (j) end
													// Clear the sortList between rounds since data is stored in the buckets. Prevents index out of bounds error.
			sortList.clear();
													//Add each bucket in order to the sortList. addAll() preserves the order allows for sorting.
			for (int k = 0; k<10; k++) 
			{
				sortList.addAll(bucket[k]);
			}//for (k) end
													//Increase the power by 10 for the next Radix sort round. ones, tens, hundreds, thousands, etc...
			power = power*10;
		}//for (i) end
		
		
													//Convert sortList back into inInt[] as return value.
		for (int m = 0; m < sortList.size(); m++) 
		{
			inInt[m] = sortList.get(m);
			//System.out.println("i:"+inInt[m]);
		}
													//RETURN int[] RESULTS
		System.out.print("\nBigO Count:"+bigO);
		return inInt;
		
	}
	
	private int largest(int[] a) 
	{
		int largest = a[0];
		for (int i : a) 
		{
			if (a[i] > largest)
			{
				largest = a[i];
			}
		}
		return largest;
	}
}

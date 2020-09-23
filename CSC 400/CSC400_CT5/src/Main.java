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
public class Main {

	public static void main(String[] args) {
		int needsSort[] = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
		RadixSort rSort = new RadixSort();
		
		
		System.out.println("Pre-Sort: ");
		printArray(needsSort);
		needsSort = rSort.radixSort(needsSort);
		System.out.println("\nPost-Sort: ");
		printArray(needsSort);
	}

	public static void printArray (int[] inArr) 
	{
		System.out.print("| ");
		for (int i : inArr) 
		{
			System.out.print(i+" | ");
		}
	}

}

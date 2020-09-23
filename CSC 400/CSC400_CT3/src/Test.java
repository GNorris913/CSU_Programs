import java.math.BigInteger;

public class Test {
	static Float counter = (float) 0.0;
	public  static void method1(int[] array, int n)
	{
		
		for (int index = 0; index < n-1; index++) 
		{
			int mark = privateMethod1 (array, index, n-1);
			int temp = array[index];
			array[index] = array[mark];
			array[mark] = temp;
			//counter = counter + 1;
		}
		System.out.println("COUNTER: "+counter);
		counter = (float) 0;
	}
	
	public static int privateMethod1(int[] array, int first, int last) 
	{
		int min = array[first];
		int indexOfMin = first;
		for (int index = first +1; index <= last; index++)
		{
			if (array[index] < min) 
			{
				min = array[index];
				indexOfMin = index;
			}//end if
			counter = counter + 1;
		}// end for
		//System.out.println("iOM"+indexOfMin);
		//System.out.println("vOM"+array[indexOfMin]);
		
		return indexOfMin;
	}
}

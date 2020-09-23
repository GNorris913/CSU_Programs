
public class DIS6 {

	public static void main(String[] args) 
	{
		int[] array1 = {9,8,7,6,5,4,3,2,1,0};
		int aMax = array1.length;
		for (int i = 0; i< aMax; i++) 
		{
			for (int j = i; j<aMax;j++) 
			{
				if (array1[j]<array1[i]) 
				{
					int swap = array1[i];
					array1[i]=array1[j];
					array1[j]=swap;
				}
			}
		}
		for(int k:array1) 
		{
			System.out.print(k);
		}
	}

}

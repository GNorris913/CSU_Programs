
public class Main {
	
		public static void main(String[] args) 
	{
			int[] numArr = new int[1024];
			int[] numArr2 = new int[1048576];
			for (int i =0; i < 1024; i++) 
			{
				numArr2[i] = 1048576 - i;
			}
			for (int i =0; i < 1024; i++) 
			{
				numArr[i] = 1024 - i;
			}
			int[] testNum = {500,499,498,497,496,495,494,493,492,491,490,489, 487,486,485,484};
			
			Test test = new Test();
			test.method1(numArr2, 1048576);
			test.method1(numArr, 1024);
			test.method1(testNum, 4);
			test.method1(testNum, 8);
			test.method1(testNum, 16);
			
	}

		
		
}

/*		Portfolio Project 1, Module 8
*		Gregory Norris
*		Colorado State University Global Campus
*		CSC-450
*
*		This program is designed to execute two threads which act as counters. One thread counts up to 20, the other counts down from 20.
*		Thread one should run first, then thread two will run sequentially after thread one has finished.
*/
public class Portfolio_1 implements Runnable{
	//Main
	public static void main(String[] args) 
	{
		//Place threads in try block to catch thread errors related to hung / unresponsive threads.
		try {
		Thread thread1 = new Thread(countUp(1));	//Create thread one, uses runnable method countup(). (1) indicates which thread ran the method.
		Thread thread2 = new Thread(countDown(2));	//Create thread two, uses runnable method countup(). (2) indicates which thread ran the method.
		thread1.start();							//Start thread one
		thread1.join();								//Join thread one. Placing this here ensures that thread one will finish execution before thread two is started.
		thread2.start();							//Starts thread two
		thread2.join();								//Joins thread two after it finishes executing.
		}
		catch (InterruptedException e) 				//Catch statement, print exception to stack trace
		{
			e.printStackTrace();
		}
		
	}

	@Override										//Override required for runnable methods
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public static Runnable countUp(int threadNumber)	//counts up to 20 and prints each iteration. Initialized as runnable for compatablity with thread. 
	{
		int max = 20;
		for (int x = 0; x < max;x++) 
		{
			System.out.println("Thread"+threadNumber+": "+x);	//No mystery as to what is happening here.
			
		}
		return null;									//Runnable methods must have return value, even if null. Can not safely initialize as method type void.
		
	}
	
	public static Runnable countDown(int threadNumber) {//Same thing as count up.
		
		for (int x = 20; x>0 ;x--) 
		{
			System.out.println("Thread"+threadNumber+": "+x);
			
		}
		return null;
	}
	

}

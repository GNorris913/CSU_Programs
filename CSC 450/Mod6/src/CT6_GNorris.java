import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

//Might have to compile with compatibility settings set to 1.8 if you get unsupported class version error https://www.baeldung.com/java-lang-unsupportedclassversion

public class CT6_GNorris {

	public static void main(String[] args) 
	{
		compliant1_GNorris();
	}

	//Non-compliant Code Section from Java Coding Guidelines (Long et all, 2013). 
	//*Not executed*
	private void readData() throws IOException 
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream("file")));
		String data = br.readLine();
	}
	
	//Compliant Code Section from Java Coding Guidelines (Long et all, 2013).
	//*Not executed*
	private void exampleCompliant()
	{
				ByteBuffer buffer = ByteBuffer.allocateDirect(16*1024);
				try (FileChannel rdr = (new FileInputStream("File")).getChannel())
				{
					while (rdr.read(buffer)>0) 
					{
						buffer.clear();
					}
				} 
				catch(Throwable e) 
				{
					System.out.println(e);
				}
	}
	
	//***********************   Compliant Examples   ***********************   
	//Sample code provided by Gregory Norris, contains multiple examples of 
	//compliant code with theme "Limiting lifespace of sensitive data"
	private static void compliant1_GNorris() 
	{
		//I love visual / functional examples.
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Uses JPasswordField to obscure password entry before returning char[]
		JPasswordField passF = new JPasswordField();
		
		//Will run a password check when the user presses Enter
		passF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {	
				//Pass password into a char array which can be cleared manually.
				char [] usrPassword = passF.getPassword();
				
				//Example 1
				//Clear text from passF immediately after use.
				//Even though passF does not contain the password at this point,
				//It still displays the length of the password as ********
				//Which contains some information about the password.
				//passF text is a string, so this only protects shoulder surfing
				passF.setText("");
				if(!checkPassword(usrPassword)) //If password is incorrect:
				{
					//Example 2
					//Clear password array as soon as it has been used. 
					//char[] cleared before the
					//check method returns true/false.
					Arrays.fill(usrPassword, ' ');
					System.out.println("Wrong Password.");	
				}
				else {
					//This is to show that the checkPassword() method
					//has actually cleared the password field before returning
					//a value. There are a number of steps between validation and this point
					//so I wanted to show the importance of clearing the char array immediately.
					System.out.println(usrPassword);//Password should be cleared before this point.
					Arrays.fill(usrPassword, ' ');
					System.out.println("Correct Password.");
				}
				

				//Arrays.fill(usrPassword, ' '); initially I cleared char[] here, but realized.
				//a lot of other steps happen before this point.
			}
		});
		//Make a simple password accepting frame. It's small so look for it
		//Should print correct / incorrect. Correct will attempt to print password. 
		frame.add(passF);
		frame.setVisible(true);
		frame.pack();
	}
	
	//Second compliant method.
	public static boolean checkPassword (char[] password) 
	{
		//Insert password check logic here: -->  <--
		
		//Clearing the array here will clear the passed char[] array
		//before returning true.
		//This is the first opportunity in the program to clear the password.
		Arrays.fill(password, ' ');//Clear array from check method immediately after use.
		
		
		return Math.random() <0.5; //Dummy method has 50/50 chance of accepting password (twice as secure as returning True!);
	}
}

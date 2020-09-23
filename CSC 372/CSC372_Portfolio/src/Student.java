/*
*	GREGORY NORRIS
*	PORTFOLIO ASSIGNMENT OPTION 1
*	CSC372-1, BASS
*	AUGUST 2 2019
*	COLORADO STATE UNIVERSITY GLOBAL CAMPUS
*
*
*	This program stores student data in an a linked list, sorts by proper name (last, first, middle, title)
*	and allows the user to save student data to a text document. Deletion by student number is allowed,
*	there was an option to modify existing student data, but it's not a requirement and I'm happy enough with
*	how this program operates.
*/
import java.text.DecimalFormat;

public class Student {
	private int studentNumber;
	private String fullName;
	private String address;
	private String properName;
	private Double gpa;
	
	
	Student(int inSNumber, String inName, String inAddress, Double inGPA)
	{
		
		setStudentNumber(inSNumber);
		setName(inName);
		setAddress(inAddress);
		setGPA(inGPA);
		setProperName("");
		
	} 
	public void setStudentNumber(int in_sNumber) {this.studentNumber = in_sNumber;}
	public int getStudentNumber() {return studentNumber;}
	
	public void setName (String in_name) {this.fullName = in_name;}
	public void setAddress (String in_address) {this.address = in_address;}
	public void setProperName(String in_pName) 
	{
		this.properName = in_pName;
	}
	public void setGPA (Double in_GPA) 
	{
		if (in_GPA >0 && in_GPA <=4.0) 
		{
			this.gpa = in_GPA;
		}
	}
	public String getGPA () {
	
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(gpa);
	}
	
	public String getName() {return fullName;}
	public String getAddress() {return address;}
	
	public void printContents() {System.out.println("\nNumber: "+studentNumber+"\nName: "+fullName+"\nAddress: "+address+"\nGPA: "+gpa);}
	public String getContents() 
	{
		String gcOUT = "\nID: "+studentNumber+" Name: "+fullName+" Address: "+address+" GPA: "+gpa;
		return gcOUT;
	}
	public String getProperName() 
	{return properName;}
}

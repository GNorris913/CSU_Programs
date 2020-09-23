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
import java.util.ArrayList;
import java.util.LinkedList;

public class SortName 
{	private LinkedList<Student> students = new LinkedList<Student>();
	private String sName;
	
	public SortName (LinkedList<Student> in_students) 
	{	this.students = in_students;

		this.students = makeProperName(students);
		this.students = sortByName(students);
		
		System.out.println("********SORTED*************SORTED***");
		for (Student outStu : students) {System.out.println(outStu.getProperName());}
	}//CONSTRUCTOR END	
	
	private LinkedList<Student> sortByName(LinkedList<Student> in_student)
	{
		LinkedList<Student> sortStu = in_student;
		int maxI = sortStu.size();
		for(int i=0; i<maxI; i++) 
		{	int lowestIndex = i;
			Student scanStu = sortStu.get(i);
			String name1 = scanStu.getProperName();

			for(int j=i;j<maxI;j++) 
			{
				Student compStu = sortStu.get(j);
				String name2 = compStu.getProperName();
				if(name1.compareToIgnoreCase(name2)>0) //compareToIgnoreCase compares two strings by unicode value then returns a positive or negative number.
					{
						name1 = name2;
						lowestIndex = j;
					}
			} // for compStu : sortStu
			Student swapStu = sortStu.get(i);
			sortStu.set(i, sortStu.get(lowestIndex));
			sortStu.set(lowestIndex, swapStu);
			
			
		}//for scanStu : sortStu
		for (Student printStu : sortStu) {System.out.println(printStu.getProperName());}
		return sortStu;
		
	}// SortByName()

	
//########################## FIX THIS FIRST ############################	
	public LinkedList<Student> makeProperName(LinkedList<Student> in_Students)
	{
		int maxi = in_Students.size();
		for(int i=0;i<maxi;i++) {
			Student propStudent = in_Students.get(i);
			String sName = propStudent.getName();
			String names1[] = sName.split(" ");				//Split strings according to space characters
			if (sName.split("\\w+").length>3) 			// Special case for names with more than 3 fields (first, middle, last, title)
			{ 											// Another case would be needed for .length>2 for first,middle,last but since the only fringe case has 4...
				int nMax = names1.length;
				String first = names1[0];
				String middle = names1[1];//
				middle = Character.toString(middle.charAt(0));
				String last = names1[2];
				String title = names1[nMax-1];
				first = last+" "+first+" "+middle+", "+title;
				propStudent.setProperName(first);
				//students[foo] = studentFoo;				//Write reformatted name to Student class object then reinsert into array.
				//System.out.println(studentFoo.getName());
			}
			else if(sName.split("\\w+").length>2)
			{
				int nMax = names1.length;
				String first = names1[0];
				String middle = names1[1];//
				middle = Character.toString(middle.charAt(0));
				String last = names1[2];
				String title = names1[nMax-1];
				first = last+", "+first+" "+middle;
				propStudent.setProperName(first);
			}
			else 
			{										// For all other names using "First Last" format, reformat as "Last, First"
				String names[] = sName.split(" ");		//Split string and reorder name elements
				sName = names[1]+", "+names[0];
				propStudent.setProperName(sName);		//*** SET PROPER NAME IS UNINITIALIZED UNTIL SORTED ***
				//students[foo] = studentFoo;				//Write reformatted name to Student class object then reinsert into array.
				//System.out.println(studentFoo.getName());
			}//else END
			in_Students.set(i, propStudent);
		}//End For Loop
	//For scanStu:students END
		return in_Students;
	}
	public LinkedList<Student> getSorted()
	{
		return students;
	}	
}//CLASS END






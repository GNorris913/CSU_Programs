
public class Person {
	private String firstName = "x";
	private String lastName = "x";
	private int age = -1;
	
	
	Person (String fName, String lName, int iAge)
	{
		setFirst(fName);
		setLast(lName);
		setAge(iAge);
	}
	public String getFirst() {return firstName;}
	public String getLast() {return lastName;}
	public int getAge() {return age;}
	public void setFirst(String inFirst) {this.firstName = inFirst;}
	public void setLast(String inLast) {this.lastName = inLast;}
	public void setAge(int inAge) {this.age = inAge;}
	
	public String toString() 
	{
		String first = getFirst();
		String last = getLast();
		int oAge = getAge();
		return last+", "+first+", "+oAge;
	}
	
}

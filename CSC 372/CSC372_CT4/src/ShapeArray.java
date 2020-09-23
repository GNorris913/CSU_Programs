
public class ShapeArray 
{
	ShapeArray()
	{
		/*Sphere sphere = new Sphere(12);
		Cone cone = new Cone(4,8);
		Cylinder cylinder = new Cylinder(4,8);
		String sOut1 = sphere.to_String();
		String sOut2 = cone.to_String();
		String sOut3 = cylinder.to_String();
		System.out.println(sOut1+"\n"+sOut2+"\n"+sOut3);
	*/
	}


	public static void main(String[] args) 
	{
		Shapes[] shapes = new Shapes[3];
		shapes[0] = new Sphere(12);
		shapes[1] = new Cone(4,8);
		shapes[2] = new Cylinder(4,5);
		for (int i = 0 ; i < 3; i = i + 1) 
		{
			String shapeString =shapes[i].to_String();
			System.out.println(shapeString);
		}
	}
}
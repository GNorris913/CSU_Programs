
public class Cone extends Shapes {
	private double radius = 0;
	private double height = 0;
	private double side = 0;
	private double volume = 0;
	private double surface = 0;
	
	@Override
	public double surface_area() {
		//Surface Area of a Cone = πr2 + πrs
		double in_surface = Math.PI*Math.pow(radius,2) + Math.PI*radius*side;
		return in_surface;
	}

	@Override
	public double volume() 
	{ //Volume of a Cone = 1⁄3( πr2h )
		double in_volume = 0.333*(Math.PI)*(Math.pow(radius, 2.0))*height;
		//double in_volume = 5;
		return in_volume;
	}
	
	double side() {
		//Side of Cone = sqrt(Height^2 + Radius^2) 
		double in_side = Math.sqrt(Math.pow(radius, 2)+Math.pow(height, 2));
		return in_side;
	}
	
	@Override
	public String to_String() 
	{
		String sVolume = Double.toString(volume);
		String sArea = Double.toString(surface);
		String sOut = "\nShape: Cone\nSuface Area: "+sArea+"\nVolume :"+sVolume;
		return sOut;
	}
	Cone(double radius, double height){
		this.radius = radius;
		this.height = height;
		this.side = side();
		this.volume = volume();
		this.surface = surface_area();
		
	}

}	

/*s2 = r2 + h2
or
s = √( r2 + h2 )

Surface Area of a Cone = πr2 + πrs
math.PI*math.pow(radius,2) + math.PI*radius*side

Volume of a Cone = 1⁄3( πr2h )
*/
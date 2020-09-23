
public class Cylinder extends Shapes {
	private double radius = 1;
	private double height = 1;
	private double surface = 1;
	private double volume = 1;
	
	@Override
	public double surface_area() {
		//Surface Area of a Cylinder = 2πr2 + 2πrh
		double cArea = 2*Math.PI*Math.pow(radius, 2);
		return cArea;
	}

	@Override
	public double volume() {
		//Volume of a Cylinder = πr2h
		double cVolume = Math.PI*Math.pow(radius, 2)*height;
		return cVolume;
	}

	@Override
	public String to_String() {
		// TODO Auto-generated method stub
		String sSurf = Double.toString(surface);
		String sVol = Double.toString(volume);
		String cString = "\nShape: Cylinder\nSurface Area: "+sSurf+
				"\nVolume: "+sVol;
		
		return cString;
	}
	Cylinder(double radius, double height){
		this.radius = radius;
		this.height = height;
		this.surface = surface_area();
		this.volume = volume();
	}
}

//Surface Area of a Cylinder = 2πr2 + 2πrh

//Volume of a Cylinder = πr2h

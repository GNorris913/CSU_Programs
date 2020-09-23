
public class Sphere extends Shapes {
	private double radius;
	private double surface;
	private double volume;
	
	@Override
	public double surface_area() {
		double sArea = 4*Math.PI*Math.pow(radius,2);
		return sArea;
	}

	@Override
	public double volume() {
		double sVol = (4/3)*Math.PI*Math.pow(radius,2);		
		return sVol;
	}
	Sphere(double in_radius)
	{
		this.radius = in_radius;
		this.surface = surface_area();
		this.volume = volume();
	}
	public String to_String() {
		String sVoll = Double.toString(volume);
		String sSurf = Double.toString(surface);
		String sOut = "\nShape: Sphere.\nSurface Area: "+sSurf+"\nVolume: "+sVoll;
		return sOut;
	}

}
// Surface area = 4πr2
// Volume = 4⁄3πr3
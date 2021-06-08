package hikingProgram;
//class used to hold information on what a hiking trail should have location, name, and duration.
public class Hiker {
	private String hikerName;
	private String location;
	private int duration;
	
	public String getHikerName() {return this.hikerName;}
	public String getLocation() {return this.location;}
	public int getDuration() {return this.duration;}
	
//constructor used to set information about hiker object.
	public Hiker(String hikerName, String location, int duration) {
		this.hikerName = hikerName;
		this.location = location;
		this.duration = duration;
	}
}

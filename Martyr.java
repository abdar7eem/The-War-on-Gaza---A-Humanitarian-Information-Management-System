
public class Martyr extends Person {

	private String DateOfMasrtyrdom;
	private String CauseOfDeath;
	private String PlaceOfDeath;

	// Constructor to initialize a Martyr object
	public Martyr(String iD, String name, int age, String gender, String address, String contactinfo,
			String dateOfMasrtyrdom, String causeOfDeath, String placeOfDeath) {
		// Call the constructor of the superclass (Person)
		super(iD, name, age, gender, address, contactinfo);
		this.DateOfMasrtyrdom = dateOfMasrtyrdom;
		this.CauseOfDeath = causeOfDeath;
		this.PlaceOfDeath = placeOfDeath;
	}

	// Getter for the date of martyr
	public String getDateOfMasrtyrdom() {
		return DateOfMasrtyrdom;
	}

	// Getter for the cause of death
	public String getCauseOfDeath() {
		return CauseOfDeath;
	}

	// Getter for the place of death
	public String getPlaceOfDeath() {
		return PlaceOfDeath;
	}

	// Override toString method 
	@Override
	public String toString() {
		return "Role=" + getRole() + ", ID=" + getID() + ", Name=" + getName()
				+ ", Age=" + getAge() + ", Gender=" + getGender() + ", Address=" + getAddress()
				+ ", Contactinfo=" + getContactinfo() + ", DateOfMartyrdom=" + DateOfMasrtyrdom + ", CauseOfDeath=" + CauseOfDeath + ", PlaceOfDeath="
						+ PlaceOfDeath  ;
	}

	//method to clone martyr object
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Martyr m= (Martyr)super.clone();	
		return m;
	}




}

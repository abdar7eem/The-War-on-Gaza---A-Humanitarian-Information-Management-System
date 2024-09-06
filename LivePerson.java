
public class LivePerson extends Person {

	// Constructor to initialize a LivePerson
	public LivePerson(String id, String name, int age, String gender, String address, String contactinfo) {
		super(id, name, age, gender, address, contactinfo);
	}

	// Override toString method of LivePerosn
	@Override
	public String toString() {
		return "Role=" + getRole() + ", ID=" + getID() + ", Name()=" + getName()
		+ ", Age=" + getAge() + ", Gender()=" + getGender() + ", Address=" + getAddress()
		+ ", Contactinfo()=" + getContactinfo() ;
	}
	
	//method to clone livePerson
	@Override
	protected Object clone() throws CloneNotSupportedException {
		LivePerson lp= (LivePerson)super.clone();	
		return lp;
		}
	

}

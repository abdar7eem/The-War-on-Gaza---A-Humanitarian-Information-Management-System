import java.util.ArrayList;

public abstract class Person implements Cloneable {
	private String ID;
	private String Name;
	private int Age;
	private String Gender;
	private String Address;
	private String Contactinfo;
	private String Role;
	
	
	//Default constructor
	public Person() {
		
	}


	// Constructor to initialize a Person object
	public Person(String iD, String name, int age, String gender, String address, String contactinfo) {
		// Call the constructor of the superclass (Person){super() is implicitly called}
		super();
		ID = iD;
		Name = name;
		Age = age;
		Gender = gender;
		Address = address;
		Contactinfo = contactinfo;

	}


	// Getter for the role of the person
	public String getRole() {
		return Role;
	}

	// Getter for the ID of the person
	public String getID() {
		return ID;
	}
	
	// Setter for the ID of the person
	public void setID(String iD) {
		ID = iD;
	}
	
	// Getter for the name of the person
	public String getName() {
		return Name;
	}
	
	// Setter for the name of the person
	public void setName(String name) {
		Name = name;
	}
	
	// Getter for the age of the person
	public int getAge() {
		return Age;
	}
	
	// Setter for the age of the person
	public void setAge(int age) {
		Age = age;
	}
	
	// Getter for the gender of the person
	public String getGender() {
		return Gender;
	}
	
	// Setter for the gender of the person
	public void setGender(String gender) {
		Gender = gender;
	}
	
	// Getter for the address of the person
	public String getAddress() {
		return Address;
	}
	
	// Setter for the address of the person
	public void setAddress(String address) {
		Address = address;
	}
	
	// Getter for the contact information of the person
	public String getContactinfo() {
		return Contactinfo;
	}
	
	// Setter for the contact information of the person
	public void setContactinfo(String contactinfo) {
		Contactinfo = contactinfo;
	}

	// Setter for the role of the person
	public void setRole(String role) {
		Role = role;
	}

	// Override toString method
	@Override
	public abstract String toString() ;

	// override clone method
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Person p= (Person)super.clone();	
		return p;
		}
	



}

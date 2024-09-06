import java.util.ArrayList;
import java.util.Collections;

public class Family implements Sortable,Cloneable {

	// Instance variables
	private String familyName ;
	private ArrayList <Person> parents = new ArrayList<Person>();
	private ArrayList <Person> members = new ArrayList<Person>();

	// Constructor to initialize Family with a name
	public Family( String Name) {
		this.familyName = Name;
	}

	public Family() {
		// TODO Auto-generated constructor stub
	}

	// Method to add a member to the family and checking his role
	public boolean addMember(Person member,String role) throws ParentsExciption  {
		if (role.equalsIgnoreCase("MOM")|| role.equalsIgnoreCase("DAD")) {
			if(checkRole(role)) {
				members.add(member);
				parents.add(member);
				member.setRole(role);
			}
			else {
				System.out.println("There is a parent with same role in this family");
				return false;
			}
			return true;

		}
		else if( role.equalsIgnoreCase("DAUGHTER") || role.equalsIgnoreCase("SON")) {
			
				if(parents.size()==2) {
					members.add(member);
					member.setRole(role);
					return true;
				}
				else {
					throw new ParentsExciption("Parents must be added first");
				}

	
		}
		else {
			return false;}
	}

	// Getter for the list of family members
	public ArrayList <Person> getMembers() {
		return members;
	}

	// Method to remove a member from the family
	public boolean remveMember(Person member) {
		members.remove(member);
		System.out.println("Member removed Successfully ...");
		return true;
	}

	// Method to add a parent to the family
	public void addParent(Person Parent ) {
		boolean test=false;
		for(int i=0;i<parents.size();i++) {
			if(Parent.getGender().equalsIgnoreCase(parents.get(i).getGender())) {
				test=true;
			}
		}
		if(test=true) {
			System.out.println("ERROR, you can`t add this parent with this role");
		}
		else {
			parents.add(Parent);
			System.out.println("Added Successfully ...");
		}
	}

	// Method to remove a parent from the family
	public void removeParent(Person Parent ) {
		parents.remove(Parent);
		members.remove(Parent);
		System.out.println("Removed Successfully ...");
	}

	// Getter for the family name
	public String getFamilyName() {
		return familyName;
	}

	// Setter for the family name
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	// Getter for the list of parents
	public ArrayList <Person> getParents() {
		return parents;
	}

	// Method to get the role of a member in the family
	public String getMemberRole(Person member,String role) {
		return role;
	}

	// Override toString method
	@Override
	public String toString() {
		return "familyName=" + familyName + ", parents=" + parents.toString() + ", Members()="
				+ getMembers().toString() ;
	}

	// Override equals method to compare families based on Martyrs count
	@Override
	public boolean equals(Object o) {
		if( o instanceof Family) {
			if(this.Martyrscount()  == ((Family)o).Martyrscount() )
				return true;
		}

		return false;
	}

	// Method to return the number of Martyrs in the family
	public int Martyrscount() {
		int Count=0;
		for(int j=0;j<getMembers().size();j++) {
			if(getMembers().get(j) instanceof Martyr) {
				Count++;
			}
		}
		return Count;
	}

	// Method to check if both mother and father are living persons
	public int Check(ArrayList <Person> parents) {
		boolean mother= true;
		boolean father= true;

		for(int i=0;i<parents.size();i++) {	
			if(parents.get(i).getRole().equalsIgnoreCase("mom") && parents.get(i)instanceof LivePerson) {
				mother=false;
			}
			else if(parents.get(i).getRole().equalsIgnoreCase("dad") && parents.get(i)instanceof LivePerson) {
				father=false;
			}

		}

		if(mother==true && father==true) {
			return 1;
		}
		else
			return 0;

	}
	
	//Method to return families sorted by martyrs count
	@Override
	public ArrayList<Family> sortByMartyrs(ArrayList<Family> families) {
		{
			ArrayList <Family> family = new ArrayList<>();
			ArrayList <Integer> arr=new ArrayList<>();

			for(int i=0;i<families.size();i++) {
				arr.add(families.get(i).Martyrscount());
			}

			Collections.sort(arr);

			for(int i=families.size()-1;i>=0;i--) {
				for(int j=0;j<families.size();j++) {
					if(arr.get(i)==families.get(j).Martyrscount()) {
						family.add(families.get(j));
					}
				}
			}

			return family;
		}

	}

	//Method to return families sorted by orphans count
	@Override
	public ArrayList<Family> sortByOrphans (ArrayList<Family> families){

		ArrayList <Family> family = new ArrayList<Family>();
		ArrayList<Integer>arr=new ArrayList<>();

		for(int i=0;i<families.size();i++) {
			arr.add(families.get(i).orphans());
		}

		Collections.sort(arr);

		for(int i=families.size()-1;i>=0;i--) {
			for(int j=0;j<families.size();j++) {
				if(arr.get(i)==families.get(j).orphans()) {
					family.add(families.get(j));
				}
			}
		}
		return family;
	}

	public int orphans() {
		int Count=0;
		for(int i=0;i<members.size();i++) {
			if(Check(parents)==1) {
				Count+=members.size()-2;
			}
		}

		return Count;
	}

	// method to clone family objects
	@Override
	protected Object clone() throws CloneNotSupportedException {

		Family family = (Family) super.clone();
		ArrayList <Person> arr = new ArrayList<>();

		for (int i=0;i<members.size();i++) {
			arr.add(i,(Person)members.get(i).clone());

		}
		family.setMembers(arr);



		return family;
	}

	public boolean checkRole(String role) {
		for(int i=0;i<parents.size();i++) {
			if(parents.get(i).getRole().equalsIgnoreCase(role)) {
				return false;
			}
		}
		return true;
	}

	public void setParents(ArrayList<Person> parents) {
		this.parents = parents;
	}

	public void setMembers(ArrayList<Person> members) {
		this.members = members;
	}
}



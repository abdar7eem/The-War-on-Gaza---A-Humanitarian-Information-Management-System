import java.util.ArrayList;
import java.util.Arrays;

public class Manager {
	Family family=new Family();
	// Instance variable to store a list of families
	private ArrayList <Family> families = new ArrayList<>();
	
	public ArrayList<Family> getFamilies() {
		return families;
	}
	
	// Method to add a family to the list
	public boolean addFamily(Family family) {
		for(int i=0;i<families.size();i++) {
			if(family.getFamilyName().equalsIgnoreCase(families.get(i).getFamilyName())) {
				System.out.println("Error ,there is a family with the same name");
			}
		}
		families.add(family);
		System.out.println("Family Added Successfully ...");
		return true;
	}

	// Method to delete a family based on the family name
	public boolean deleteFamily(String familyName) {
		for(int i=0;i<families.size();i++) {
			if(families.get(i).getFamilyName().equalsIgnoreCase(familyName)) {
				families.remove(i);
				System.out.println("Removed Successfully ...");
				return true;
			}
		}
		System.out.println("Family not founded ...");
		return false;
	}

	// Method to update a family based on the family name
	public boolean updateFamily(String familyName, Family updatedFamily) {
		for(int i=0;i<families.size();i++) {
			if(families.get(i).getFamilyName().equalsIgnoreCase(familyName)) {
				families.set(i, updatedFamily);
				System.out.println("Updated Successfully ...");
				return true;
			}
		}
		System.out.println("Family not founded ...");
		return false;
	}
	
	// Method to search for a person by ID across all families
	public Person searchPersonByID(String personID) {
		for(int i=0;i<families.size();i++) {
			for(int j=0;j<families.get(i).getMembers().size();j++) {
				if(families.get(i).getMembers().get(j).getID().equalsIgnoreCase(personID)) {
					System.out.println("Person Founded ...");
					return families.get(i).getMembers().get(j);
				}
			}
		}
		System.out.println("Person Not Found ...");
		return null;

	}

	// Method to search for a family by name
	public Family searchByName(String familyName) {
		for(int i=0;i<families.size();i++) {
			if(families.get(i).getFamilyName().equalsIgnoreCase(familyName)) {
				System.out.println("Family Founded ...");
				return families.get(i);
			}
		}
		System.out.println("Family Not Found ...");
		return null;

	}

	// Method to calculate the total number of live persons from all families
	public int calculateTotalLivePersons(){
		int LiveCount=0;
		for(int i=0;i<families.size();i++) {
			for(int j=0;j<families.get(i).getMembers().size();j++) {
				if(families.get(i).getMembers().get(j) instanceof LivePerson) {
					LiveCount++;
				}
			}
		}
		return LiveCount;
	}

	 // Method to calculate the total number of martyrs from all families
	public int calculateTotalMartyrs() {
		int Count=0;
		for(int i=0;i<families.size();i++) {
			for(int j=0;j<families.get(i).getMembers().size();j++) {
				if(families.get(i).getMembers().get(j) instanceof Martyr) {
					Count++;
				}
			}
		}
		return Count;
	}

	// Method to calculate the total number of orphans from all families
	public int calculateTotalOrphans() {
		int Count=0;
		
		for(int i=0;i<families.size();i++) {
			if(families.get(i).Check(families.get(i).getParents())==1) {
				Count+=(families.get(i).getMembers().size()-2);
			}
		}

		return Count;
	}
	
	// Method to calculate global statistics (martyrs, live persons, orphans)
	public ArrayList<Integer> calculateGlobalStatistics(){

		ArrayList <Integer> arr =new ArrayList <>();
		arr=new ArrayList <> (Arrays.asList(calculateTotalMartyrs(),calculateTotalLivePersons(), calculateTotalOrphans()));
		return  arr;
	}

	// Method to calculate family-specific statistics (martyrs, live persons, orphans) by family name
	public ArrayList<Integer> calculateFamilyStatistics(String familyName){
		int MCount=0;
		int LCount=0;
		int OCount=0;

		ArrayList<Integer> arr=new ArrayList<>();
		for(int i=0;i<families.size();i++) {
			if(families.get(i).getFamilyName().equalsIgnoreCase(familyName)) {

				for(int j=0;j<families.get(i).getMembers().size();j++) {

					if(families.get(i).getMembers().get(j) instanceof LivePerson) {
						LCount++;
					}
					else if(families.get(i).getMembers().get(j)instanceof Martyr) {
						MCount++;
					}

				}

				if(families.get(i).Check(families.get(i).getParents())==1) {
					OCount=families.get(i).getMembers().size()-(2);

				}
			}
			arr=new ArrayList<>(Arrays.asList(MCount,LCount,OCount));
		}		return  arr;
	}



	// Override toString method for better representation
	@Override
	public String toString() {
		return "TotalMartyrs()=" + calculateTotalMartyrs() + ", TotalOrphans()="
				+ calculateTotalOrphans() + ", TotalLivePersons()=" + calculateTotalLivePersons()
				+ ", GlobalStatistics()=" + calculateGlobalStatistics() + "]";
	}



}

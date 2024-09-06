import java.util.*;
import java.io.*;

class Driver{
	public static void main(String []args) throws FileNotFoundException, CloneNotSupportedException {
		boolean checker=true;
		do {
			try {
				// Specify file path
				File file=new File("C:\\Users\\abdar\\OneDrive\\Desktop\\BZU\\Ritaj\\Second Year\\Java FX\\Eclipse Workspace\\Project_phase2\\src\\Data.txt");
				// Create scanner for user input
				Scanner sc =new Scanner(System.in) ;
				// Create scanner for file input
				Scanner input =new Scanner(file);
				int choise=0;
				boolean test=true;
				do {
					try {

						System.out.println("Select the best Choise: ");
						System.out.println(" 1-Read Input from user");
						System.out.println(" 2-Read Input from file");
						System.out.print("Your choise: ");
						choise=sc.nextInt();
						test=false;
					}catch(InputMismatchException ex) {
						System.out.println(ex);
						sc.next();
					}
				}while(test);
				// Create a manager object
				Manager manager=new Manager();
				switch (choise) {
				case 1:{
					int num=0;

					do {
						// Call a method to display the menu
						displayMenuConsle();
						num=sc.nextInt();

						switch(num) {
						// add family
						case (1):{

							System.out.print("Enter family name: ");
							String familyName=sc.next();
							Family family =new Family(familyName);
							manager.addFamily(family);
						}
						break;
						//delete family
						case (2):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							manager.deleteFamily(fname);


						}
						break;
						//update family
						case (3):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							System.out.print("Enter new family name: ");
							String newfname=sc.next();
							manager.updateFamily(fname, new Family(newfname));
						}
						break;
						//add member
						case (4):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.println("1-LivePerson");
							System.out.println("2-Martyr");
							System.out.print("Enter your choise: ");
							int num1=sc.nextInt();

							if(num1 == 1) {
							 	boolean check=true;
								System.out.print("Enter the Person Role: ");
								String role=sc.next();
								System.out.print("Enter ID: ");
								String id=sc.next();
								System.out.print("Enter name: ");
								String name=sc.next();
								int age=0;
								do{

									try {
										System.out.print("Enter Age: ");
										age=sc.nextInt();
										check=false;
									}catch(InputMismatchException ex) {
										System.out.println("! Invalid age,enter a number !");
										sc.next();
									}
								}while(check);
								System.out.print("Enter Gender: ");
								String gender=sc.next();
								System.out.print("Enter Adress: ");
								String adress=sc.next();
								System.out.print("Enter ContactInfo: ");
								String contact=sc.next();
								System.out.println();
								manager.getFamilies().get(i).addMember(new LivePerson(id,name,age,gender,adress,contact), role);
							}
							else if(num1 == 2 ) {

								boolean check=true;
								System.out.print("Enter the Person Role: ");
								String role=sc.next();
								System.out.print("Enter ID: ");
								String id=sc.next();
								System.out.print("Enter name: ");
								String name=sc.next();
								int age=0;
								do{

									try {
										System.out.print("Enter Age: ");
										age=sc.nextInt();
										check=false;
									}catch(InputMismatchException ex) {
										System.out.println("! Invalid age,enter a number !");
										sc.next();
									}
								}while(check);
								System.out.print("Enter Gender: ");
								String gender=sc.next();
								System.out.print("Enter Adress: ");
								String adress=sc.next();
								System.out.print("Enter ContactInfo: ");
								String contact=sc.next();
								System.out.print("Enter dateOfMasrtyrdom: ");
								String dod=sc.next();
								System.out.print("Enter causeOfDeath: ");
								String cod=sc.next();
								System.out.print("Enter placeOfDeath: ");
								String pod=sc.next();
								System.out.println();
								manager.getFamilies().get(i).addMember(new Martyr(id,name,age,gender,adress,contact,dod,cod,pod), role);
							}

						}
						break;
						//add parent
						case (5):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.println("1-LivePerson");
							System.out.println("2-Martyr");
							System.out.print("Enter your choise: ");
							int num1=sc.nextInt();

							if(num1 == 1) {
								boolean check=true;
								System.out.print("Enter the Person Role: ");
								String role=sc.next();
								System.out.print("Enter ID: ");
								String id=sc.next();
								System.out.print("Enter name: ");
								String name=sc.next();
								int age=0;
								do{

									try {
										System.out.print("Enter Age: ");
										age=sc.nextInt();
										check=false;
									}catch(InputMismatchException ex) {
										System.out.println("! Invalid age,enter a number !");
										sc.next();
									}
								}while(check);
								System.out.print("Enter Gender: ");
								String gender=sc.next();
								System.out.print("Enter Adress: ");
								String adress=sc.next();
								System.out.print("Enter ContactInfo: ");
								String contact=sc.next();
								System.out.println();
								manager.getFamilies().get(i).addMember(new LivePerson(id,name,age,gender,adress,contact), role);
							}
							else if(num1 == 2 ) {
								boolean check =true;
								System.out.println("Enter the Person Role: ");
								String role=sc.next();
								System.out.print("Enter ID: ");
								String id=sc.next();
								System.out.print("Enter name: ");
								String name=sc.next();
								int age=0;
								do{

									try {
										System.out.print("Enter Age: ");
										age=sc.nextInt();
										check=false;
									}catch(InputMismatchException ex) {
										System.out.println("! Invalid age,enter a number !");
										sc.next();
									}
								}while(check);
								System.out.print("Enter Gender: ");
								String gender=sc.next();
								System.out.print("Enter Adress: ");
								String adress=sc.next();
								System.out.print("Enter ContactInfo: ");
								String contact=sc.next();
								System.out.print("Enter dateOfMasrtyrdom: ");
								String dod=sc.next();
								System.out.print("Enter causeOfDeath: ");
								String cod=sc.next();
								System.out.print("Enter placeOfDeath: ");
								String pod=sc.next();
								System.out.println();
								manager.getFamilies().get(i).addMember(new Martyr(id,name,age,gender,adress,contact,dod,cod,pod), role);
							}
						}
						break;
						// remove member
						case (6):{
							System.out.print("Enter the member family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.print("Enter mamber name: ");
							String mname=sc.next();
							int k;
							if(SearchInFamily(i,mname,manager) != -1) {
								k=SearchInFamily(i,mname,manager);
							}
							else {
								System.out.println("Member not found");
								break;
							}
							Person p=manager.searchPersonByID(manager.getFamilies().get(i).getMembers().get(k).getID());
							manager.getFamilies().get(i).remveMember(p);
						}
						break;
						//remove parent
						case (7):{
							System.out.print("Enter the member family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.print("Enter Parent name: ");
							String pname=sc.next();
							int k;
							if(SearchInFamily(i,pname,manager) != -1) {
								k=SearchInFamily(i,pname,manager);
							}
							else {
								System.out.println("Member not found");
								break;
							}
							Person p=manager.searchPersonByID(manager.getFamilies().get(i).getMembers().get(k).getID());
							if(p.getRole().equalsIgnoreCase("dad") || p.getRole().equalsIgnoreCase("mom")) {
								manager.getFamilies().get(i).remveMember(p);

							}
							else {
								System.out.println("The Member is not a Parent ...");
								break;
							}
						}
						break;
						//set a name for a family
						case (8):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.print("Enter the new name for family: ");
							String newfname=sc.next();
							manager.getFamilies().get(i).setFamilyName(newfname);
						}
						break;
						//search a person by name
						case(9):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.print("Enter Person Name: ");
							String pname=sc.next();
							int j=SearchInFamily(i,pname,manager);
							System.out.println(manager.getFamilies().get(i).getMembers().get(j));

						}
						break;
						//calculate total LivePerson
						case(10):{
							System.out.println("Total Live Person: "+manager.calculateTotalLivePersons());
						}
						break;
						//calculate total Orphans
						case(11):{
							System.out.println("Total Orphans: "+manager.calculateTotalOrphans());
						}
						break;
						//calculate total Martyr
						case(12):{
							System.out.println("Total Martyrs: "+manager.calculateTotalMartyrs());
						}
						break;
						// calculate Global statics
						case(13):{
							for(int i=0;i<manager.getFamilies().size();i++) {
								System.out.println("Global Statistics: TotalMartyrs: "+manager.calculateGlobalStatistics().get(0) +" TotalLivePerson: "+manager.calculateGlobalStatistics().get(1)+" TotalOrphans: " +manager.calculateGlobalStatistics().get(2));
							}
						}
						break;
						//calculate family statics
						case(14):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.println("Family Statistics: TotalMartyrs: "+manager.calculateFamilyStatistics(fname).get(0) +" TotalLivePerson: "+manager.calculateFamilyStatistics(fname).get(1)+" TotalOrphans: " +manager.calculateFamilyStatistics(fname).get(2)); 

						}
						break;
						//print manager toString
						case(15):{
							System.out.println(manager.toString());
						}
						break;
						// print families sorted by martyr
						case(16):{
							for(int i=0;i<manager.getFamilies().size();i++) {
								System.out.println(manager.family.sortByMartyrs(manager.getFamilies()).get(i)); ;
							}
						}
						break;
						//print families sorted by orphans
						case(17):{
							for(int i=0;i<manager.getFamilies().size();i++) {
								System.out.println(manager.family.sortByOrphans(manager.getFamilies()).get(i)); ;
							}
						}
						break;
						//check if two methods are equals according to martyr count
						case(18):{
							System.out.println("Enter the first family name: ");
							String fname1=sc.next();
							System.out.println("Enter the second family name: ");
							String fname2=sc.next();

							int i1,i2;
							if(SearchFamilyByName(fname1,manager) != -1) {
								i1=SearchFamilyByName(fname1,manager); 
							}
							else {
								System.out.println("The first Family not found");
								break;
							}
							if(SearchFamilyByName(fname2,manager) != -1) {
								i2=SearchFamilyByName(fname2,manager); 
							}
							else {
								System.out.println("The second Family not found");
								break;
							}
							manager.getFamilies().get(i1).equals(manager.getFamilies().get(i2));
						}
						break;
						//copy a martyr person data
						case (19):{
							System.out.print("Enter the name of the person: ");
							String name=sc.next();
							System.out.print("From which family ??: ");
							String fname=sc.next();
							int pindex=0;
							int findex=0;
							int nfindex=0;

							findex=SearchFamilyByName(fname,manager);

							if(findex==-1) {
								System.out.println("family not found");
								break;
							}

							pindex=SearchInFamily(findex,name,manager);

							if(pindex==-1) {
								System.out.println("Person not found");
								break;
							}

							if(! (manager.getFamilies().get(findex).getMembers().get(pindex) instanceof Martyr)) {
								System.out.println("These person is not a martyr !");
								break;
							}

							System.out.print("For what family you want to add him ??: ");
							String nfname=sc.next();
							for(int j=0;j<manager.getFamilies().size();j++) {
								if(nfname.equalsIgnoreCase(manager.getFamilies().get(j).getFamilyName())) {
									nfindex=j;
								}

							}

							Person p=(Martyr) manager.getFamilies().get(findex).getMembers().get(pindex).clone();
							manager.getFamilies().get(nfindex).addMember(p,p.getRole());

						}
						break;
						// copy a livePerson data
						case (20):{
							System.out.print("Enter the name of the person: ");
							String name=sc.next();
							System.out.print("From which family ??: ");
							String fname=sc.next();
							int pindex=0;
							int findex=0;
							int nfindex=0;

							findex=SearchFamilyByName(fname,manager);

							if(findex==-1) {
								System.out.println("family not found");
								break;
							}

							pindex=SearchInFamily(findex,name,manager);

							if(pindex==-1) {
								System.out.println("Person not found");
								break;
							}

							if(! (manager.getFamilies().get(findex).getMembers().get(pindex) instanceof LivePerson)) {
								System.out.println("These person is not a LivePerson !");
								break;
							}

							System.out.print("For what family you want to add him ??: ");
							String nfname=sc.next();
							for(int j=0;j<manager.getFamilies().size();j++) {
								if(nfname.equalsIgnoreCase(manager.getFamilies().get(j).getFamilyName())) {
									nfindex=j;
								}

							}

							Person p=(Martyr) manager.getFamilies().get(findex).getMembers().get(pindex).clone();
							manager.getFamilies().get(nfindex).addMember(p,p.getRole());

						}
						break;
						//display a list of families info
						case(21):{
							for(int i=0;i<manager.getFamilies().size();i++) {
								System.out.println("Family Name: "+manager.getFamilies().get(i).getFamilyName());
								System.out.println("Members: ");
								for(int j=0;j<manager.getFamilies().get(i).getMembers().size();j++) {
									System.out.println(manager.getFamilies().get(i).getMembers().get(j).getRole() +": "+manager.getFamilies().get(i).getMembers().get(j).getName());
								}
							}
						}
						break;
						//exit from code
						case (22):{
							System.out.println("Good Bye");

							System.exit(0);
						}
						break;
						default :System.out.println("Enter a valid number");
						}





					}while(num != 22); //continue while num is not equal 22

				}
				break;

				case 2:{
					// specify if the file is exists
					if(!file.exists()) {
						System.out.println("The file is not found");
					}

					//reading data from the file
					while(input.hasNextLine()) {
						//save file contents inside an array
						String line =input.nextLine();
						String []tokens=line.split("#");
						//start of family data
						if(tokens[0].equalsIgnoreCase("family")) {

							Family family=new Family(tokens[1]);
							manager.addFamily(family);

						}
						else if(tokens[0].equalsIgnoreCase("Person")) {
							//add data for live person
							if(tokens[7].equalsIgnoreCase("Live")) {
								Person p=(new LivePerson(tokens[1],tokens[2],Integer.parseInt(tokens[3]),tokens[4],tokens[5],tokens[6]));
								manager.getFamilies().get(manager.getFamilies().size()-1).addMember(p, tokens[8]);
							}
							//add data for dead person
							else if(tokens[10].equalsIgnoreCase("MARTYR")) {
								Person p=(new Martyr(tokens[1],tokens[2],Integer.parseInt(tokens[3]),tokens[4],tokens[5],tokens[6],tokens[7],tokens[8],tokens[9]));
								manager.getFamilies().get(manager.getFamilies().size()-1).addMember(p, tokens[11]);

							}



						}

					}
					input.close();
					System.out.println("Data added succefuly");
					int num=0;
					do {
						//method to display a menu  
						displayMenuFile();

						num =sc.nextInt();




						switch(num) {
						case (1):{
							//add family
							System.out.print("Enter family name: ");
							String familyName=sc.next();
							Family family =new Family(familyName);
							manager.addFamily(family);
						}
						break;
						//delete family
						case (2):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							manager.deleteFamily(fname);


						}
						break;
						//update a family
						case (3):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							System.out.print("Enter new family name: ");
							String newfname=sc.next();
							manager.updateFamily(fname, new Family(newfname));
						}
						break;
						//add member
						case (4):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.println("1-LivePerson");
							System.out.println("2-Martyr");
							System.out.print("Enter your choise: ");
							int num1=sc.nextInt();

							if(num1 == 1) {
								System.out.print("Enter the Person Role: ");
								String role=sc.next();
								System.out.print("Enter ID: ");
								String id=sc.next();
								System.out.print("Enter name: ");
								String name=sc.next();
								int age=0;
								boolean check=true;
								do{

									try {
										System.out.print("Enter Age: ");
										age=sc.nextInt();
										check=false;
									}catch(InputMismatchException ex) {
										System.out.println("! Invalid age,enter a number !");
										sc.next();
									}
								}while(check);
								System.out.print("Enter Gender: ");
								String gender=sc.next();
								System.out.print("Enter Adress: ");
								String adress=sc.next();
								System.out.print("Enter ContactInfo: ");
								String contact=sc.next();
								System.out.println();
								manager.getFamilies().get(i).addMember(new LivePerson(id,name,age,gender,adress,contact), role);
							}
							else if(num1 == 2 ) {
								System.out.print("Enter the Person Role: ");
								String role=sc.next();
								System.out.print("Enter ID: ");
								String id=sc.next();
								System.out.print("Enter name: ");
								String name=sc.next();
								int age=0;
								boolean check=true;
								do{

									try {
										System.out.print("Enter Age: ");
										age=sc.nextInt();
										check=false;
									}catch(InputMismatchException ex) {
										System.out.println("! Invalid age,enter a number !");
										sc.next();
									}
								}while(check);
								System.out.print("Enter Gender: ");
								String gender=sc.next();
								System.out.print("Enter Adress: ");
								String adress=sc.next();
								System.out.print("Enter ContactInfo: ");
								String contact=sc.next();
								System.out.print("Enter dateOfMasrtyrdom: ");
								String dod=sc.next();
								System.out.print("Enter causeOfDeath: ");
								String cod=sc.next();
								System.out.print("Enter placeOfDeath: ");
								String pod=sc.next();
								System.out.println();
								manager.getFamilies().get(i).addMember(new Martyr(id,name,age,gender,adress,contact,dod,cod,pod), role);
							}

						}
						break;
						//add parent
						case (5):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.println("1-LivePerson");
							System.out.println("2-Martyr");
							System.out.print("Enter your choise: ");
							int num1=sc.nextInt();

							if(num1 == 1) {
								System.out.print("Enter the Person Role: ");
								String role=sc.next();
								System.out.print("Enter ID: ");
								String id=sc.next();
								System.out.print("Enter name: ");
								String name=sc.next();
								int age=0;
								boolean check=true;
								do{

									try {
										System.out.print("Enter Age: ");
										age=sc.nextInt();
										check=false;
									}catch(InputMismatchException ex) {
										System.out.println("! Invalid age,enter a number !");
										sc.next();
									}
								}while(check);
								System.out.print("Enter Gender: ");
								String gender=sc.next();
								System.out.print("Enter Adress: ");
								String adress=sc.next();
								System.out.print("Enter ContactInfo: ");
								String contact=sc.next();
								System.out.println();
								manager.getFamilies().get(i).addMember(new LivePerson(id,name,age,gender,adress,contact), role);
							}
							else if(num1 == 2 ) {
								System.out.println("Enter the Person Role: ");
								String role=sc.next();
								System.out.print("Enter ID: ");
								String id=sc.next();
								System.out.print("Enter name: ");
								String name=sc.next();
								int age=0;
								boolean check=true;
								do{

									try {
										System.out.print("Enter Age: ");
										age=sc.nextInt();
										check=false;
									}catch(InputMismatchException ex) {
										System.out.println("! Invalid age,enter a number !");
										sc.next();
									}
								}while(check);
								System.out.print("Enter Gender: ");
								String gender=sc.next();
								System.out.print("Enter Adress: ");
								String adress=sc.next();
								System.out.print("Enter ContactInfo: ");
								String contact=sc.next();
								System.out.print("Enter dateOfMasrtyrdom: ");
								String dod=sc.next();
								System.out.print("Enter causeOfDeath: ");
								String cod=sc.next();
								System.out.print("Enter placeOfDeath: ");
								String pod=sc.next();
								System.out.println();
								manager.getFamilies().get(i).addMember(new Martyr(id,name,age,gender,adress,contact,dod,cod,pod), role);
							}
						}
						break;
						//remove member
						case (6):{
							System.out.print("Enter the member family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.print("Enter mamber name: ");
							String mname=sc.next();
							int k;
							if(SearchInFamily(i,mname,manager) != -1) {
								k=SearchInFamily(i,mname,manager);
							}
							else {
								System.out.println("Member not found");
								break;
							}
							Person p=manager.searchPersonByID(manager.getFamilies().get(i).getMembers().get(k).getID());
							manager.getFamilies().get(i).remveMember(p);
						}
						break;
						//remove parent
						case (7):{
							System.out.print("Enter the member family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.print("Enter Parent name: ");
							String pname=sc.next();
							int k;
							if(SearchInFamily(i,pname,manager) != -1) {
								k=SearchInFamily(i,pname,manager);
							}
							else {
								System.out.println("Member not found");
								break;
							}
							Person p=manager.searchPersonByID(manager.getFamilies().get(i).getMembers().get(k).getID());
							if(p.getRole().equalsIgnoreCase("dad") || p.getRole().equalsIgnoreCase("mom")) {
								manager.getFamilies().get(i).remveMember(p);

							}
							else {
								System.out.println("The Member is not a Parent ...");
								break;
							}
						}
						break;
						//set a name for a family
						case (8):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.print("Enter the new name for family: ");
							String newfname=sc.next();
							manager.getFamilies().get(i).setFamilyName(newfname);
						}
						break;
						//search a person for name
						case(9):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.print("Enter Person Name: ");
							String pname=sc.next();
							int j=SearchInFamily(i,pname,manager);
							System.out.println(manager.getFamilies().get(i).getMembers().get(j));

						}
						break;
						//calculate total live person
						case(10):{
							System.out.println("Total Live Person: "+manager.calculateTotalLivePersons());
						}
						break;
						//calculate total orphans
						case(11):{
							System.out.println("Total Orphans: "+manager.calculateTotalOrphans());
						}
						break;
						//calculate total martyr
						case(12):{
							System.out.println("Total Martyrs: "+manager.calculateTotalMartyrs());
						}
						break;
						//calculate global statics
						case(13):{
							for(int i=0;i<manager.getFamilies().size();i++) {
								System.out.println("Global Statistics: TotalMartyrs: "+manager.calculateGlobalStatistics().get(0) +" TotalLivePerson: "+manager.calculateGlobalStatistics().get(1)+" TotalOrphans: " +manager.calculateGlobalStatistics().get(2));
							}
						}
						break;
						//calculate family statics
						case(14):{
							System.out.print("Enter family name: ");
							String fname=sc.next();
							int i;
							if(SearchFamilyByName(fname,manager) != -1) {
								i=SearchFamilyByName(fname,manager); 
							}
							else {
								System.out.println("Family not found");
								break;
							}
							System.out.println("Family Statistics: TotalMartyrs: "+manager.calculateFamilyStatistics(fname).get(0) +" TotalLivePerson: "+manager.calculateFamilyStatistics(fname).get(1)+" TotalOrphans: " +manager.calculateFamilyStatistics(fname).get(2)); 

						}
						break;
						//print manager toString
						case(15):{
							System.out.println(manager.toString());
						}
						break;
						//print families sorted by martyr
						case(16):{
							for(int i=0;i<manager.getFamilies().size();i++) {
								System.out.println(manager.family.sortByMartyrs(manager.getFamilies()).get(i).toString()); ;
							}
						}
						break;
						//print families sorted by orphans
						case(17):{
							for(int i=0;i<manager.getFamilies().size();i++) {
								System.out.println(manager.family.sortByOrphans(manager.getFamilies()).get(i).toString()); ;
							}
						}
						break;
						//check if two families are equal according to the number of martyr
						case(18):{
							System.out.println("Enter the first family name: ");
							String fname1=sc.next();
							System.out.println("Enter the second family name: ");
							String fname2=sc.next();

							int i1,i2;
							if(SearchFamilyByName(fname1,manager) != -1) {
								i1=SearchFamilyByName(fname1,manager); 
							}
							else {
								System.out.println("The first Family not found");
								break;
							}
							if(SearchFamilyByName(fname2,manager) != -1) {
								i2=SearchFamilyByName(fname2,manager); 
							}
							else {
								System.out.println("The second Family not found");
								break;
							}

							if(manager.getFamilies().get(i1).equals(manager.getFamilies().get(i2))) {
								System.out.println("True ,equals");
							}
							else {
								System.out.println("False ,Don`t equals");
							}
						}
						break;
						//print data on the file
						case (19):{
							try (PrintWriter print=new PrintWriter(file);){
								ArrayList <Family> arr=new ArrayList<>();
								arr=manager.family.sortByMartyrs(manager.getFamilies());

								for(int i=0;i<manager.getFamilies().size();i++) {
									print.write("\nFamily "+(i+1) +": "+arr.get(i).getFamilyName()+" Martyrs ("+arr.get(i).Martyrscount()+")\n");	
									print.write("\n*****************");
									print.write("\nParents: ");
									for(int j=0;j<arr.get(i).getParents().size();j++) {
										print.write(arr.get(i).getParents().get(j).getName()+" , ");
									}
									print.write("\nMembers: ");
									for(int j=0;j<arr.get(i).getMembers().size();j++) {
										print.write(arr.get(i).getMembers().get(j).getName()+" , ");
									}
									print.write("\n");
								}

							}
							System.out.println("File saved :) Good bye");

						}
						break;
						//print family statics on the file
						case (20):{
							try (PrintWriter p =new PrintWriter(file);){
								for(int i=0;i<manager.getFamilies().size();i++) {
									p.write("Family "+(i+1)+" "+manager.getFamilies().get(i).getFamilyName()+" : Martyre:"+manager.calculateFamilyStatistics(manager.getFamilies().get(i).getFamilyName()).get(0)+" Live:"+manager.calculateFamilyStatistics(manager.getFamilies().get(i).getFamilyName()).get(1));

									if(manager.calculateFamilyStatistics(manager.getFamilies().get(i).getFamilyName()).get(2)>0) {
										p.write(" Orphans:"+manager.calculateFamilyStatistics(manager.getFamilies().get(i).getFamilyName()).get(2)+"\n");
									}
									else {
										p.write(" Orphans: 0 \n");
									}
								}
							}
							System.out.println("Ready ,Look to your file ");

						}
						break;
						//copy a martyr person
						case (21):{
							System.out.print("Enter the name of the person: ");
							String name=sc.next();
							System.out.print("From which family ??: ");
							String fname=sc.next();
							int pindex=0;
							int findex=0;
							int nfindex=0;

							findex=SearchFamilyByName(fname,manager);

							if(findex==-1) {
								System.out.println("family not found");
								break;
							}

							pindex=SearchInFamily(findex,name,manager);

							if(pindex==-1) {
								System.out.println("Person not found");
								break;
							}

							if(! (manager.getFamilies().get(findex).getMembers().get(pindex) instanceof Martyr)) {
								System.out.println("This person is not a martyr !");
								break;
							}

							System.out.print("For what family you want to add him ??: ");
							String nfname=sc.next();
							for(int j=0;j<manager.getFamilies().size();j++) {
								if(nfname.equalsIgnoreCase(manager.getFamilies().get(j).getFamilyName())) {
									nfindex=j;
								}

							}

							Person p=(Martyr) manager.getFamilies().get(findex).getMembers().get(pindex).clone();
							manager.getFamilies().get(nfindex).addMember(p,p.getRole());

						}
						break;
						//copy a live person 
						case (22):{
							System.out.print("Enter the name of the person: ");
							String name=sc.next();
							System.out.print("From which family ??: ");
							String fname=sc.next();
							int pindex=0;
							int findex=0;
							int nfindex=0;

							findex=SearchFamilyByName(fname,manager);

							if(findex==-1) {
								System.out.println("family not found");
								break;
							}

							pindex=SearchInFamily(findex,name,manager);

							if(pindex==-1) {
								System.out.println("family not found");
								break;
							}

							if(! (manager.getFamilies().get(findex).getMembers().get(pindex) instanceof LivePerson)) {
								System.out.println("This person is not a LivePerson !");
								break;
							}

							System.out.print("For what family you want to add him ??: ");
							String nfname=sc.next();
							for(int j=0;j<manager.getFamilies().size();j++) {
								if(nfname.equalsIgnoreCase(manager.getFamilies().get(j).getFamilyName())) {
									nfindex=j;
								}

							}

							Person p=(LivePerson) manager.getFamilies().get(findex).getMembers().get(pindex).clone();
							manager.getFamilies().get(nfindex).addMember(p,p.getRole());

						}
						break;
						//exit from the code
						case(23):{
							System.out.println("Good Bye");
							System.exit(0);
						}
						default :System.out.println("Enter a valid number");
						}





					}while(num != 23); //continue while num is not equal 23


				}
				break;
				default: System.out.println("Enter a valid number");
				}

			}catch(InputMismatchException ex) {
				System.out.println(ex);
				checker=false;
			}catch(IndexOutOfBoundsException ex1) {
				System.out.println(ex1);
				checker=false;
			}catch(FileNotFoundException ex2) {
				System.out.println(ex2);
				checker=false;
			}catch(ParentsExciption ex3) {
				System.out.println("You must add parents first \n");
			}
		}while(checker);
	}






	public static int SearchFamilyByName(String fname,Manager manager) {
		for(int i=0;i<manager.getFamilies().size();i++) {
			if(manager.getFamilies().get(i).getFamilyName().equalsIgnoreCase(fname)) {
				return i;
			}
		}
		return -1;

	}

	public static int SearchInFamily(int i,String mname,Manager manager) {
		for(int j=0;j<manager.getFamilies().get(i).getMembers().size();j++) {
			if(manager.getFamilies().get(i).getMembers().get(j).getName().equals(mname)) {
				return j;
			}
		}
		return -1;
	}


	public static void displayMenuConsle() {

		System.out.println("***********************************");
		System.out.println("*Select the best choise;          *");
		System.out.println("* 1-Add family                    *");
		System.out.println("* 2-Delete family                 *");
		System.out.println("* 3-Update family                 *");
		System.out.println("* 4-Add member                    *");
		System.out.println("* 5-Add parent                    *");
		System.out.println("* 6-Remove member                 *");
		System.out.println("* 7-Remove parent                 *");
		System.out.println("* 8-Set familyName                *");
		System.out.println("* 9-Serach person by name         *");
		System.out.println("* 10-Calculate total LivePerson   *");
		System.out.println("* 11-Calculate total Orphans      *");
		System.out.println("* 12-Calculate total Martyr       *");
		System.out.println("* 13-Calculate Global Statistics  *");
		System.out.println("* 14-Calculate family Statistics  *");
		System.out.println("* 15-Print Manager toString       *");
		System.out.println("* 16-Sort by Martyr               *");
		System.out.println("* 17-Sort by Orphans              *");
		System.out.println("* 18-Equals Method                *");
		System.out.println("* 19-Copy a Martyre               *");
		System.out.println("* 20-Copy a Live Person           *");
		System.out.println("* 21-Display Family List          *");
		System.out.println("* 22-Exit                         *");
		System.out.println("***********************************");
		System.out.print("Enter your choise: ");
	}
	public static void displayMenuFile() {
		System.out.println("***********************************");
		System.out.println("*Select the best choise;          *");
		System.out.println("* 1-Add family                    *");
		System.out.println("* 2-Delete family                 *");
		System.out.println("* 3-Update family                 *");
		System.out.println("* 4-Add member                    *");
		System.out.println("* 5-Add parent                    *");
		System.out.println("* 6-Remove member                 *");
		System.out.println("* 7-Remove parent                 *");
		System.out.println("* 8-Set familyName                *");
		System.out.println("* 9-Serach person by name         *");
		System.out.println("* 10-Calculate total LivePerson   *");
		System.out.println("* 11-Calculate total Orphans      *");
		System.out.println("* 12-Calculate total Martyr       *");
		System.out.println("* 13-Calculate Global Statistics  *");
		System.out.println("* 14-Calculate family Statistics  *");
		System.out.println("* 15-Print Manager toString       *");
		System.out.println("* 16-Sort by Martyr               *");
		System.out.println("* 17-Sort by Orphans              *");
		System.out.println("* 18-Equals Method                *");
		System.out.println("* 19-Print Family on file         *");		
		System.out.println("* 20-print statistics on file     *");
		System.out.println("* 21-Copy a Martyre               *");
		System.out.println("* 22-Copy a Live Person           *");
		System.out.println("* 23-Exit                         *");
		System.out.println("***********************************");
		System.out.print("Enter your choise: ");
	}
}




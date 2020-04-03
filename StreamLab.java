package StreamIO;

public class StreamLab {
public static void main(String[] args) {
	
	Student student1 = new Student();
	Address address1 = new Address();
	
	
	
	student1.setFirstName("Kateryna");
	student1.setLastName("Tsymbal");
	student1.setAge(26);
	student1.setGpa(1.8);
	student1.setEmail("tsymbal.katena@gmail.com");
	address1.setStreet("123 melov st");
	address1.setCity("Maryland HTS");
	address1.setState("MO");
	address1.setZip("63444");
	student1.setAddress(address1);
	student1.saveToFile();
	
	
	Student s = Student.readFromFile("tsymbal.katena@gma");
	 System.out.println(s);
	 Address  a2 = new Address("Vading","Naples","FL","34135");
	Student s2 = new Student("Viki","Vash","vasg@gmail.com",28,1.8,a2);
	s2.saveToFile();
	System.out.println(s2);
	
}
}

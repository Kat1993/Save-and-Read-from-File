package StreamIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Student {
private String firstName;
private String lastName;
private String email;
private int age;
private double gpa;
private Address address;
private static final String path ="/Users/katerynatsymbal/Desktop/Streams/";

public Student() {
	
}

public Student(String firstName, String lastName, String email, int age, double gpa, Address address) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.age = age;
	this.gpa = gpa;
	this.address = address;
	
	
	
	
}
public void saveToFile() {
	String fileName = path+this.email+".txt";
	
	try {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		bw.write(formatData());
		bw.close();
	}catch(IOException e){
		System.out.println("Error writing to file ");
		
	}
	
}
private String formatData() {
	return  this.firstName+","+this.lastName+","+this.email+","+this.age+","+this.gpa+","+this.address.formatData();
	
}
public static Student readFromFile(String email) {
	String fileName = path+ email+".txt";
	Student student = new Student();
	Address address = new Address();
	try {
	Scanner in = new Scanner(new File(fileName));
	String line = in.nextLine();
	String[] parsedLine = line.split(",");
	String firstName = parsedLine[0];
	String lastName = parsedLine[1];
	String emailAddres = parsedLine[2];
	String ageAsString = parsedLine[3];
	int ageAsInt = Integer.parseInt(ageAsString);
	String gpaAsString = parsedLine[4];
    String street = parsedLine[5];
    String city = parsedLine[6];
    String state = parsedLine[7];
    String zip = parsedLine[8];
    address.setStreet(street);
    address.setCity(city);
    address.setState(state);
    address.setZip(zip);
    
	
	
	double gpaAsDouble = Double.parseDouble(gpaAsString); 
	student.firstName =  firstName;
	student.lastName = lastName;
	student.email = emailAddres;
	student.age = ageAsInt;
	student.gpa = gpaAsDouble;
	student.address = address;
	
	
	
	
	
	}catch(FileNotFoundException e) {
		System.out.println(" Error reading from file");
		
	}
	return student;
}


public Address getAddress() {
	return address;
}


public void setAddress(Address address) {
	this.address = address;
}


public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public double getGpa() {
	return gpa;
}


public void setGpa(double gpa) {
	this.gpa = gpa;
}


@Override
public String toString() {
	return "Firts Name: " + firstName + "\nLast Name: " + lastName + "\nEmail: " + email + "\nAge: " + age + "\nGPA: "
			+ gpa + "\nAddress: " + address ;
}

}

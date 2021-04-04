package com.addressbook;
import java.util.Scanner;
import java.util.ArrayList;
/*@Description- this class represents a address book.
 *contact information  */
/*@Parameters- taken Contacts class object as variable so that we can
 * Add multiple persons
 *  add a new contact to AddressBook*/
public  class AddressBook {
	//Add multiple persons
	static ArrayList listing = new ArrayList();
	public static Scanner sc = new Scanner(System.in);
	static AddressBook addressBook = new AddressBook();
	static  final int i=0;
	 public void addContact() {
		System.out.println("Enter how many persons you want to add");
		int numOfPerson=sc.nextInt();
	    for(int i=0; i<=numOfPerson; i++)
	    {
	    	System.out.println("\nPerson :  "+i+" Enter First Name");
	        String fn= sc.next();
	        sc.nextLine();
	        System.out.println("Person : " +i+ " Enter Last Name");
	        String ln = sc.next();
	        sc.nextLine();
	        System.out.println("Person : " +i+ " Enter Address");
	        String add = sc.next();
	        sc.nextLine();
	        System.out.println("Person : " +i+ " Enter City");
	        String city = sc.nextLine();
	        System.out.println("Person : " +i+ " Enter State");
	        String state = sc.next();
	        sc.nextLine();
	        System.out.println("Person : " +i+ " Enter postal_Code");
	        String zip = sc.next();
	        System.out.println("Person : " +i+ " Enter Country_Name");
	        String country = sc.next();
	        System.out.println("person :" +i+ "Enter Mobile number");
	        String mob=sc.next();
	        System.out.println("Person : " +i+ " Enter E-mail");
	        String mail = sc.next();
	        ContactInfo contact = new ContactInfo(fn, ln, add, city, state, zip,country,mob, mail);
	        listing.add(contact);
	          
	    }
	   
}
	   
public static void main(String args[]) {
	
	addressBook.addContact();	
	System.out.println("--------The person records are listed below:--------\n");
	System.out.println(listing);
	System.out.println("\n contacts added sccessfully");
	}
}

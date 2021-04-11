package com.addressbook;
import java.util.Scanner;
/*@Description- this class represents a address book.
 *contact information  */
/*@Parameters- taken Contacts class object as variable so that we can
 *  add a new contact to AddressBook*/
public  class AddressBook {
<<<<<<< HEAD
	Scanner sc=new Scanner(System.in);
	static ContactInfo[] contactList=new ContactInfo[15];
	// To add a new contact to address book by taking values from user
	int add(int increment)
	{
		System.out.println("Enter First Name:");
		String firstname=sc.next();
		System.out.println("Enter last name:");
		String lastname=sc.next();
		System.out.println("Enter Address:");
		String address=sc.next();
		System.out.println("Enter City:");
		String city=sc.next();
		System.out.println("Enter State:");
		String state=sc.next();
		System.out.println("Enter postal_code:");
		String zipcode=sc.next();
		System.out.println("Enter Country-code");
		String country=sc.next();
		System.out.println("Enter contact number:");
		String mob=sc.next();
		System.out.println("Enter email :");
		String mail=sc.next();
		contactList[increment++]=new  ContactInfo(firstname, lastname, address, city, state,zipcode,country,mob,mail);
		return increment;
	 }
	
	/*
	 * To update existing contact details by taking input from user 
	 * details user wants to edit and also checking if the name entered by user
	 * exist is Address Book or not
	 */
	void Edit(int increment)
	{
		int i;
		for(i=0;i<10;i++)
		{
			if(i==increment)
			{
			
			System.out.println("Enter First Name:");
			String firstname=sc.next();
      		System.out.println("Enter last name:");
      		String lastname=sc.next();
      		System.out.println("Enter Address:");
      		String address=sc.next();
      		System.out.println("Enter City:");
      		String city=sc.next();
      		System.out.println("Enter State:");
      		String state=sc.next();
      		System.out.println("Enter postal_code:");
      		String zipcode=sc.next();
      		System.out.println("Enter Country:");
      		String country=sc.next();
      		System.out.println("Enter contact number:");
      		String mob=sc.next();
      		System.out.println("Enter email :");
      		String mail=sc.next();
      		contactList[increment++]=new  ContactInfo(firstname, lastname, address, city, state,zipcode,country,mob,mail);
				break;
				
			}	
		}
		System.out.println("Your changes replicated to the Book successfully....");
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		AddressBook ab=new AddressBook();
		ab.Edit(0); 
	
=======
	//Add multiple persons
	static ArrayList listing = new ArrayList();
	public static Scanner sc = new Scanner(System.in);
	static AddressBook addressBook = new AddressBook();
	//create one addContact() method 
	public void addContact() {
		System.out.println("Enter how many persons you want to add");
		int numOfPerson=sc.nextInt();
		for(int i=0; i<numOfPerson; i++)
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
>>>>>>> UC5-AddressBook
	}
}
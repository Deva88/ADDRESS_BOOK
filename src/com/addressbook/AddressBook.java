package com.addressbook;
import java.util.Scanner;
/*@Description- this class represents a address book.
 *contact information  */
/*@Parameters- taken Contacts class object as variable so that we can
 *  add a new contact to AddressBook*/
public  class AddressBook {
	Scanner sc=new Scanner(System.in);
	static ContactInfo[] contactList=new ContactInfo[15];
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
	
	public static void main(String args[]){
		AddressBook ab=new AddressBook();
		ab.toString();
		System.out.println("adding a new Contact to Address Book");
	}
}
package com.addressbook;
import java.util.Scanner;
/*@Description- this class represents a address book.
 *contact information  */
/*@Parameters- taken Contacts class object as variable so that we can
 *  add a new contact to AddressBook*/
public  class AddressBook {
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
		int flag;
		for(flag=0;flag<10;flag++)
		{
			if(flag==increment)
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
	
	}
}
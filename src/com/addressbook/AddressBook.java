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
		String fn=sc.next();
		System.out.println("Enter last name:");
		String ln=sc.next();
		System.out.println("Enter Address:");
		String add=sc.next();
		System.out.println("Enter City:");
		String city=sc.next();
		System.out.println("Enter State:");
		String state=sc.next();
		System.out.println("Enter postal_code:");
		String zip=sc.next();
		System.out.println("Enter Country_name");
		String country=sc.next();
		System.out.println("Enter contact number:");
		String mob=sc.next();
		System.out.println("Enter email :");
		String mail=sc.next();
		contactList[increment++]=new  ContactInfo(fn, ln, add, city, state,zip,country,mob,mail);
		return increment;
	}
	void edit(int increment)
	{
		int i;
		for(i=0;i<10;i++)
		{
			if(i==increment)
			{
				System.out.println("Enter First Name:");
				String fn=sc.next();
				System.out.println("Enter last name:");
				String ln=sc.next();
				System.out.println("Enter Address:");
				String add=sc.next();
				System.out.println("Enter City:");
				String city=sc.next();
				System.out.println("Enter State:");
				String state=sc.next();
				System.out.println("Enter postal_code:");
				String zip=sc.next();
				System.out.println("Enter Country:");
				String country=sc.next();
				System.out.println("Enter contact number:");
				String mob=sc.next();
				System.out.println("Enter email :");
				String mail=sc.next();
				contactList[increment++]=new  ContactInfo(fn, ln, add, city, state,zip,country,mob,mail);
				break;
			}
		}
		System.out.println("Your changes replicated to the Book manager successfully....");

	}
	/*
	 * deleting contact by name given by user and also checking whether address book
	 * is empty or not
	 */
	void remove(int increment)
	{
		int i;
		for(i=0;i<15;i++)
		{
			if(i==increment)
			{
				contactList[increment]=null;
				break;
			}
		}
		System.out.println("!!Deleted!!");
	}

	void display()
	{
		for(int increment=0;increment<15;increment++)
		{
			System.out.println(increment+" "+contactList[increment]);
		}
	}
	/*
	 * using case in loop so that user can enter its choices to add, delete, edit or
	 * print the contact in address book
	 */
	public static void main(String args[]){
		System.out.println("---------------WELCOME TO THE ADDRESS_BOOK_MANAGEMENT SYSTEM-------------"); 
		Scanner sc=new Scanner(System.in);
		AddressBook ab=new AddressBook();
		int increment=0;
		System.out.println("Enter valid option to perform Book-Manager_Application(1-->ENTER,2-->EXIT):");
		int option=sc.nextInt();
		while(option !=2) {
			System.out.println("select the operations(1,2,3) you want to perform 1)Add 2)Edit 3)Remove 4)display \n");
			int choose =sc.nextInt();
			switch(choose) 
			{
			case 1:
				System.out.println("Adding credentials to the Application");
				increment=ab.add(increment);
				break;
			case 2:
				System.out.println("welcome to the editing mode ..!");
				System.out.println("Enter the row number(record) you want to edit");
				int record_edit=sc.nextInt();
				ab.edit(record_edit);
				ab.display();
				break;
			case 3:
				System.out.println("currently you are in Delete-mode ,once you delete it's not revert back \n");
				System.out.println("Enter record number to delete :");
				int record_del=sc.nextInt();
				ab.remove(record_del);
				break;
			case 4:
				System.out.println("-------These are the Records avalibale in your Application------- \n");
				ab.display();
				break;
			default:
				System.out.println("select valid operation[1/2/3/4]");
			}
			System.out.println("Enter choice(1-Enter/2-Exit):");
			int option1=sc.nextInt();
			if (option1==2)
			{
				System.out.println("OOPS!! you are choosing an Exit mode");
				break;
			}
		}
		System.out.println("THANKS FOR USING BOOK MANAGER-APPLICATION");
	}
}
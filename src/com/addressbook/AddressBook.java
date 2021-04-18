package com.addressbook;
import java.util.*;

/*@Description- this class represents a address book.
 *contact information  */
/*@Parameters- taken Contacts class object as variable so that we can
 *  add a new contact to AddressBook*/

public class AddressBook {
	public int indexValue = 1;
	public HashMap<Integer, ContactInfo> contacts = new HashMap<>();
	public HashMap<String, AddressBookList> addressBookList = new HashMap<String, AddressBookList>();
	public static Scanner sc = new Scanner(System.in);
	static AddressBook addressbook = new AddressBook();


	/*
	 * create one menu() method in  address book show all function.
	 */
	public void menu() {
		int choice = 1;
		do {
			System.out.println("Enter your choice\n 1. Add Contact 2. Edit Contact 3. Delete Contact  4. Create New AddressBook  0. Exit");
			int userInput = sc.nextInt();
			switch (userInput) {
			case 1:
				addressbook.addContact();
				break;
			case 2:
				addressbook.editContact();
				break;
			case 3:
				addressbook.deleteContact();
				break;
			case 4:
				addressbook.createNewAddressBook();
				break;
			default:
				System.out.println("You press exit button....\nThanks for using Book-Management-Application!");
						choice = 0;
						break;
			}
		}
		while (choice != 0);
	}

	/*
	 * Using addContact() method in  address book
	 * add multiple Address Book to the System. Each Address Book has a unique Name
	 */
	public void addContact() {
		System.out.println("Enter Number of person you want to add");
		int numOfPerson = sc.nextInt();
		for (int add = 1; add <= numOfPerson; add++) {
			System.out.println("\nPerson : " + add + " Enter First Name");
			String first = sc.next();
			sc.nextLine();
			System.out.println("Person : " + add + " Enter Last Name");
			String last = sc.next();
			sc.nextLine();
			System.out.println("Person : " + add + " Enter Address");
			String address = sc.next();
			sc.nextLine();
			System.out.println("Person : " + add + " Enter City");
			String city = sc.nextLine();
			System.out.println("Person : " + add + " Enter State");
			String state = sc.next();
			sc.nextLine();
			System.out.println("Person : " + add + " Enter Zip Code");
			int zip = sc.nextInt();
			System.out.println("Person : " + add + " Enter Phone Number");
			long phone = sc.nextLong();
			System.out.println("Person : " + add + " Enter E-mail");
			String email = sc.next();
			if (addressbook.check(first)) {
				add--;
				//continue;
			}
			ContactInfo contact = new ContactInfo(first, last, address, city, state, zip, phone, email);
			contacts.put(indexValue, contact);
			indexValue++;
		}
		System.out.println("\nContacts added Successfully");
	}

	
	public Boolean check(String checkName) {
		if (contacts.isEmpty())
			return false;
		else {
			Iterator<Integer> itr = contacts.keySet().iterator();
			while (itr.hasNext()) {
				int key = itr.next();
				if (contacts.get(key).firstName.equals(checkName)) {
					System.out.println("\nAdd contact again with different first name.");
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * Using editContact() method in  address book
	 */
	public void editContact() {
		if (contacts.isEmpty()) {
			System.out.println("Contact list is empty.");
		} 
		else {
			System.out.println("Enter the first name to edit contact.");
			String name = sc.next();
			Iterator<Integer> itr = contacts.keySet().iterator();
			while (itr.hasNext()) {
				int key = itr.next();
				if (contacts.get(key).firstName.equals(name)) {
					System.out.println("\nEnter First Name to Edit");
					String first = sc.next();
					sc.nextLine();
					System.out.println("Enter Last Name to Edit");
					String last = sc.next();
					sc.nextLine();
					System.out.println("Enter Address to Edit");
					String address = sc.next();
					sc.nextLine();
					System.out.println("Enter City to Edit");
					String city = sc.nextLine();
					System.out.println("Enter State to Edit");
					String state = sc.next();
					sc.nextLine();
					System.out.println("Enter Zip Code to Edit");
					int zip = sc.nextInt();
					System.out.println("Enter Phone Number to Edit");
					long phone = sc.nextLong();
					System.out.println("Enter E-mail to Edit");
					String email = sc.next();
					ContactInfo contact = new ContactInfo(first, last, address, city, state, zip, phone, email);
					contacts.put(key, contact);
					System.out.println("Contact edited with given first name : " + name);
				}
			}
		}
	}

	/*
	 * Using deleteContact() method in  address book
	 */
	public void deleteContact() {
		if (contacts.isEmpty()) {
			System.out.println("Contact list is empty.");
		} 
		else {
			System.out.println("Enter the first name to delete contact.");
			String name = sc.next();
			Iterator<Integer> itr = contacts.keySet().iterator();
			while (itr.hasNext()) {
				int key = itr.next();
				if (contacts.get(key).firstName.equals(name)) {
					contacts.remove(key);
					System.out.println("Contact deleted with first name : " + name);
				}
			}
		}
	}
	/*
	 * Using createNewAddressBook() method in address book
	 */
	public void createNewAddressBook() {
		System.out.println("Enter the name for Address Book");
		String addressBookName = sc.next();
		AddressBookList addressBookList= new AddressBookList(addressBookName);
	}

	public static void main(String[] args) {
		System.out.println("-----Welcome to Address BOOK MANAGEMENT SYSTEM-----\n");
		addressbook.menu();  
	}
}

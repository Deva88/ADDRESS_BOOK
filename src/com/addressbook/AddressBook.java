package com.addressbook;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/*@Description- this class represents a address book.
 *contact information  */
/*@Parameters- taken Contacts class object as variable so that we can
 *  add a new contact to AddressBook*/
public class AddressBook {
    public int indexValue = 1;
    public HashMap<Integer,ContactInfo> contacts = new HashMap<>();
    public static Scanner sc = new Scanner(System.in);
    static AddressBook addressbook = new AddressBook();

    /*
	 * Using addContact() method in  address book
	 * add multiple Address Book to the System. Each Address Book has a unique Name
	 */
    public void addContact () {
        System.out.println("Enter Number of person you want to add");
        int numOfPerson = sc.nextInt();
        for (int add = 0; add < numOfPerson; add++)
        {
        System.out.println("\nPerson : " + add+ " Enter First Name");
        String first = sc.next();
        sc.nextLine();
        System.out.println("Person : " + add+ " Enter Last Name");
        String last = sc.next();
        sc.nextLine();
        System.out.println("Person : " + add+ " Enter Address");
        String address = sc.next();
        sc.nextLine();
        System.out.println("Person : " + add+ " Enter City");
        String city = sc.nextLine();
        System.out.println("Person : " + add+ " Enter State");
        String state = sc.next();
        sc.nextLine();
        System.out.println("Person : " + add+ " Enter Zip Code");
        int zip = sc.nextInt();
        System.out.println("Person : " + add+ " Enter Phone Number");
        long phone = sc.nextLong();
        System.out.println("Person : " + add+ " Enter E-mail");
        String email = sc.next();
        
        ContactInfo contact = new ContactInfo(first, last, address, city, state, zip, phone, email);
        
        contacts.put(indexValue, contact);
        indexValue++;
        }
        System.out.println("\nContacts added Successfully");
    }

    /*
	 * check contact by name given by user and also checking whether address book
	 * is empty or not
	 */
    public Boolean check(String checkName) {
        if (contacts.isEmpty())
                return false;
        else {
            System.out.println("\nAdd contact again with different first name.");
            Iterator<Integer> itr = contacts.keySet().iterator();
            while (itr.hasNext()) {
                int key = itr.next();
                if (contacts.get(key).firstName.equals(checkName)) {
                    return true;
                }
            }
        }
        return false;
    }
    /*
	 * deleting contact by name given by user and also checking whether address book
	 * is empty or not
	 */
    public void deleteContact() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Enter the first name to delete contact.");
            String name = sc.next();
            Iterator<Integer> itr = contacts.keySet().iterator();
            while(itr.hasNext()) {
                int key = itr.next();
                if (contacts.get(key).firstName.equals(name)) {
                    contacts.remove(key);
                    System.out.println("Contact deleted with first name : "+name);
                }
            }
        }
    }
   
    public static void main (String [] args){
 
    	System.out.println("---------------WELCOME TO THE ADDRESS_BOOK_MANAGEMENT SYSTEM-------------"); 
    	Scanner sc=new Scanner(System.in);
    	int increment=0;
    	System.out.println("Enter valid option to perform Book-Manager_Application:");
    	System.out.println("Press 1-->ENTER Address Book:");
    	System.out.println("Press 2-->EXIT Address Book:");
    	int option=sc.nextInt();
    		while(option !=2) {
    			System.out.println("select the operations(1,2) you want to perform 1)Add 2)Delete \n");
    			int choose =sc.nextInt();
    			switch(choose) 
    			{
    				case 1:
    					System.out.println("Adding credentials to the Application");
    					  addressbook.addContact();
    					break;
    				
    				case 2:
    					System.out.println("currently you are in Delete-mode ,once you delete it's not revert back \n");
    					 addressbook.deleteContact();
    					break;
    				
    				default:
    					System.out.println("select valid operation[1/2]");
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
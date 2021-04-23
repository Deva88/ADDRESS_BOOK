package com.addressbook;
import java.util.*;

public class AddressBook {
    public int indexValue = 1;
    public HashMap<Integer, ContactInfo> contacts = new HashMap<>();
    public HashMap<String, AddressBookList> addressBookList = new HashMap<String, AddressBookList>();
    public static Scanner sc = new Scanner(System.in);
    static AddressBook addressbook = new AddressBook();


    //create one method menu()
    public void menu() {
        int choice = 1;
        do {
            System.out.println("Enter your choice 1.)Add Contact 2.) Edit Contact 3.) Delete Contact 4.) Create New AddressBook 5.)Get name by using city 6.)Get name by using State 0.) Exit");
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
                case 5:
                    addressbook.searchPersonByCity();
                    break;
                case 6:
                    addressbook.searchPersonByState();
                    break;
                default:
                    System.out.println("You press Exit button....\nThanks for using Book-Management-Application !");
                    choice = 0;
                    break;
            }
        }
        while (choice != 0);
    }

    //create method addContact()
    public void addContact() {
        System.out.println("Enter Number of persons you want to add");
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
                continue;
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

    //create method editContact()
    public void editContact() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
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

    //create method deleteContact()
    public void deleteContact() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
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

    //create method createNewAddressBook()
    public void createNewAddressBook() {
        System.out.println("Enter the name for Address Book");
        String addressBookName = sc.next();
        AddressBookList addressBookList1 = new AddressBookList(addressBookName);
    }

    //create method searchPersionByCity()
    public void searchPersonByCity(){
        System.out.println("Enter the city to search person.");
        String cityName = sc.next();
        Iterator<Integer> itr = contacts.keySet().iterator();
        while (itr.hasNext()) {
            int key = itr.next();
            if (contacts.get(key).city.equals(cityName)) {
                System.out.println("These are the candidates whose from " +cityName);
                System.out.println(contacts.get(key).firstName +" " + contacts.get(key).lastName);
            }
        }
    }
    /*public void displayAddressBook()
    {
        System.out.println("Existing AddressBook Names are : ");
        System.out.println(addressBookList);
    }*/

  //create method searchPersionByState()
    public void searchPersonByState(){
        System.out.println("Enter the state to search person.");
        String stateName = sc.next();
        Iterator<Integer> itr = contacts.keySet().iterator();
        while (itr.hasNext()) {
            int key = itr.next();
            if (contacts.get(key).state.equals(stateName)) {
                System.out.println("These are the candidates whose from " +stateName );
                System.out.println(contacts.get(key).firstName +" " + contacts.get(key).lastName);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("-------Welcome to Address Book Manager-----\n");
        addressbook.menu();               //listing like menu-bar
    }
}
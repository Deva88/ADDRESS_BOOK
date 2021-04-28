package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;

/*@Description Here In Address Book Created a MenuBar
 * There is number of function created like 
 * Add Contact, Show contact, Edit Contact, Delete Contact
 * Search The Contact Using City
 * Search The Contact Using state
 * Count by city
 * Count by state
 * sorting names in order
 * sorting persons by city
 * sorting persons by pin
 * Choose any case from above.
 * */
public class AddressBook {
    public ArrayList<ContactInfo> contactbook = new ArrayList<>();
    ArrayList<AddressBookList> addressBookNameList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    /* @Description- Add new contacts in address book  */
    public void addContact()
    {
        System.out.println("Enter First Name");
        String first = scan.nextLine();
        duplicateCheck(first);

        System.out.println("Enter Last Name");
        String last = scan.nextLine();
        System.out.println("Enter Address");
        String address = scan.nextLine();
        System.out.println("Enter City");
        String city = scan.nextLine();
        System.out.println("Enter State");
        String state = scan.nextLine();
        System.out.println("Enter Zip Code");
        int zip = Integer.parseInt(scan.nextLine());
        System.out.println("Enter Phone Number");
        long mobileNo = Long.parseLong(scan.nextLine());
        System.out.println("Enter E-mail");
        String email = scan.nextLine();
        ContactInfo contact = new ContactInfo(first, last, address, city, state,  email,mobileNo, zip);
        contactbook.add(contact);
        System.out.println("Contact added Successfully");

    }
    
    /* Description - display contacts address book */
    public void displayPerson()
    {
        System.out.println("\nEntered Person Details is:");
        for (ContactInfo person : contactbook)
        {
            System.out.println(person.toString());
        }
    }

    /* Description - edit contacts address book */
    public void editPerson()
    {
        System.out.println("\n enter First name to edit details:");
        String name = scan.nextLine();
        for (ContactInfo person : contactbook) {
            System.out.println(person.toString());
            if (name.equals(person.firstName)) {
                System.out.println("\"Select the option to edit: \n"
                        + "1) Mobile no\n"
                        + "2) Email-Id\n"
                        + "3) Address\n"
                        + "4) Quit");
                int numb = Integer.parseInt(scan.nextLine());
                switch (numb) {
                    case 1 : {
                        System.out.println("enter new Mobile number:");
                        long mobileNo = Long.parseLong(scan.nextLine());
                        person.setMobileNo(mobileNo);
                        System.out.println("mobile no. is updated\n");
                        break;
                    }
                    case 2 : {
                        System.out.println("enter new Email-id:");
                        String email = scan.nextLine();
                        person.setEmail(email);
                        System.out.println("Email-id is updated\n");
                        break;
                    }
                    case 3 : {
                        System.out.println("enter your city");
                        String city = scan.nextLine();
                        System.out.println("enter your state");
                        String state = scan.nextLine();
                        System.out.println("enter your zip code");
                        int zip = Integer.parseInt(scan.nextLine());
                        person.setCity(city);
                        person.setState(state);
                        person.setZip(zip);
                        System.out.println("Address is updated\n");
                        break;
                    }
                    default : System.out.println("please enter right choice");
                }
            }
            else
                System.out.println("Person is not registered");
        }
    }

    /* Description - delete contacts in address book  using their name */
    public void deletePerson()
    {
        System.out.println("enter First name to delete details:");
        String name = scan.nextLine();
        for (int i=0; i < contactbook.size(); i++)
        {
            String personName = contactbook.get(i).firstName;
            if (name.equals(personName))
            {
                contactbook.remove(i);
                System.out.println("this person details is deleted");
                break;
            }
            else
                System.out.println("please enter valid name");
        }
    }


    /* Description - to create address book */
    public void newAddressBook()
    {
        System.out.println("Enter AddressBook Name");
        String userInputBookName = scan.nextLine();
        AddressBookList addressbook = new AddressBookList(userInputBookName);
        addressBookNameList.add(addressbook);
        System.out.println("New Address Book Name is added to list");
    }
    
    /* Description - display new address book */
    public void displayAddressBook()
    {
        System.out.println("Existing AddressBook Names are : ");
        for (AddressBookList addressBookList : addressBookNameList)
        {
            System.out.println(addressBookList);
        }
    }

    /* to check duplicate entry if find duplicate are not allowed */
    public void duplicateCheck(String first)
    {
        for (int k = 0; k < contactbook.size(); k++)
        {
            String contactName = contactbook.get(k).firstName;
            if (first.equals(contactName))
            {
                System.out.println("This Person is Already Present");

            }
            else
            {
                System.out.println("You can Add this Person");
                break;
            }
        }
    }

    /* Description - to search person by city name */
    public void searchPersonByCity()
    {
        System.out.println("Enter City name to search Person by city name");
        String userCity = scan.nextLine();
        Dictionary Citywisedict = new Hashtable();
        contactbook.stream().filter(map -> map.getCity().contains(userCity)).forEach(contactbook -> Citywisedict.put(contactbook.getFirstName(),userCity));
        System.out.println("City Name: " + userCity);
        for (Enumeration i = Citywisedict.keys(); i.hasMoreElements();)
        {
            System.out.println("Name : " + i.nextElement());
        }
    }
    
    /* Description - to search person by state wise */
    public void searchPersonByState()
    {
        System.out.println("Enter the state name to search Person by state name");
        String userState = scan.nextLine();
        Dictionary Statewisedict = new Hashtable();
        contactbook.stream().filter(map -> map.getState().contains(userState)).forEach(contactbook -> Statewisedict.put(contactbook.getFirstName(),userState));
        System.out.println("State Name: " + userState);
        for (Enumeration i = Statewisedict.keys(); i.hasMoreElements();)
        {
            System.out.println("Name : " + i.nextElement());
        }
    }
    /* Description - to count  person by city name */
    public void countByCity(){
        System.out.println(contactbook.stream().collect(Collectors.groupingBy((ContactInfo C) -> C.getCity())));
        System.out.println((contactbook.stream().collect(Collectors.groupingBy((ContactInfo C) -> C.getCity(),Collectors.counting()))));
    }
    
    /* Description - to count  person by state name */
    public void countByState(){
        System.out.println(contactbook.stream().collect(Collectors.groupingBy((ContactInfo C) ->C.getState(),Collectors.counting())));
    }
    
    /* Description - sort the entries in the address book alphabetically by Person’s name */
    public void sortPerson()
    {     //ContactInfo::getFirstName
        System.out.println("------Names are sorted alphabetical order----");
        contactbook.stream().sorted(Comparator.comparing(contactInfo -> contactInfo.getFirstName())).forEach(contactInfo -> System.out.println(contactInfo));
    }
    
    /* Description - sort the entries in the address book alphabetically by Person’s city */
    public void sortPersonByCity(){
	    /*
	    	for proper understanding this concept run the program by commenting duplicateCheck method.
	    		contactbook.stream().parallel().sequential().sorted(Comparator.comparing(contactInfo->contactInfo.getFirstName())).sorted(Comparator.comparing(contactInfo -> contactInfo.getCity())).forEachOrdered(contactInfo -> System.out.println(contactInfo));
				Comparator<Employee> compareByFullName = compareByFirstName.thenComparing(compareByLastName);
				Comparator<Employee> compareByFirstName = Comparator.comparing( Employee::getFirstName );
	     */

        System.out.println("sorting the persons by using city names");
        Comparator<ContactInfo> compareFirstName=Comparator.comparing(ContactInfo::getFirstName);
        Comparator<ContactInfo> compareCity=Comparator.comparing(ContactInfo::getCity);
        Comparator<ContactInfo> compareBoth =compareFirstName.thenComparing(compareCity);
        contactbook.stream().sorted( compareBoth ).forEach(contactInfo -> System.out.println(contactInfo));
    }
    
    /* Description - sort the entries in the address book alphabetically by Person’s zip code */
    public void sortPersonByPin(){

        System.out.println("sorting the persons by using postal codes ");
        Comparator<ContactInfo> compareFirstName=Comparator.comparing(ContactInfo::getFirstName);
        Comparator<ContactInfo> comparePostal=Comparator.comparing(ContactInfo::getZip);
        Comparator<ContactInfo> compareBoth =compareFirstName.thenComparing(comparePostal);
        contactbook.stream().sorted( compareBoth ).forEach(contactInfo -> System.out.println(contactInfo));
    }


    public static void main(String[] args)
    {
        AddressBook address = new AddressBook();
        System.out.println("-------------Welcome To the ADDRESS_BOOK_MANAGEMENT-APPLICATION------------------");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter valid option to perform Book-Manager_Application(1-->ENTER,2-->EXIT):");
        int option=sc.nextInt();
        while(option!=2) {

            System.out.println("1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Display Contact");
            System.out.println("4.Delete Contact");
            System.out.println("5.Add New Address Book");
            System.out.println("6.Display New Address Book");
            System.out.println("7.Search Person By City");
            System.out.println("8.Search Person By State");
            System.out.println("9.Count by city");
            System.out.println("10.Count by state");
            System.out.println("11.sorting names in order");
            System.out.println("12.sorting persons by city");
            System.out.println("13.sorting persons by pin");
            System.out.println("Enter the choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    address.addContact();
                    break;
                case 2:
                    address.editPerson();
                    break;
                case 3:
                    address.displayPerson();
                    break;

                case 4:
                    address.deletePerson();
                    break;
                case 5:
                    address.newAddressBook();
                    break;
                case 6:
                    address.displayAddressBook();
                    break;
                case 7:
                    address.searchPersonByCity();
                    break;
                case 8:
                    address.searchPersonByState();
                    break;
                case 9:
                    address.countByCity();
                    break;
                case 10:
                    address.countByState();
                    break;
                case 11:
                    address.sortPerson();
                    break;
                case 12:
                    address.sortPersonByCity();
                    break;
                case 13:
                    address.sortPersonByPin();
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

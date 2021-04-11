package com.addressbook;
/*
 * contact information has first name, last name, number,address
 * state,city,zipcode,country and email
 */

public class ContactInfo {
	String FIRST_NAME;
	String LAST_NAME;
	String ADDRESS;
	String CITY;
	String STATE;
	String POSTAL_CODE;
	String COUNTRY;
	String CONTACT_NUMBER;
	String EMAIL;
	ContactInfo(String firstname,String lastname,String address,String city,String state,String zipcode,String country,String mob,String mail)
	{
		this.FIRST_NAME=firstname;
		this.LAST_NAME=lastname;
		this.ADDRESS=address;
		this.CITY=city;
		this.STATE=state;
		this.POSTAL_CODE=zipcode;
		this.COUNTRY=country;
		this.CONTACT_NUMBER=mob;
		this.EMAIL=mail;
	}
	// to print the contact details
		@Override
	public String toString() {
		return String.format(FIRST_NAME+" "+LAST_NAME+" "+ADDRESS+" "+CITY+" "+STATE+" "+POSTAL_CODE+" "
									 +COUNTRY+" "+CONTACT_NUMBER+" "+EMAIL);
	}

}
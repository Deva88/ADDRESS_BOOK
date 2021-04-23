package com.addressbook;
public class AddressBookList
{
    public String userInputBookName;

    public AddressBookList(String userInputBookName)
    {
        this.userInputBookName = userInputBookName;
    }
    public String getUserInputBookName()
    {
        return  userInputBookName;
    }
    public void setUserInputBookName(String firstName)
    {
        this.userInputBookName = userInputBookName;
    }
    public String toString()
    {
        return "AddressBookName:" + userInputBookName + "\n";
    }
}
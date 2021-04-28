package com.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookIO {
    static AddressBookIO addressBookNew = new AddressBookIO();
    static Scanner sc = new Scanner(System.in);
    public boolean addContact(ArrayList<Contact> contact) {
    	//taken IOException to Handling exceptions
        try {
            if (addressBookNew.checkAndWriteIntoFile(contact)) {  //check and write file
                System.out.println("\nContacts added Successfully");
            }
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.\nContact not added.");
            return false;
        }
    }


    //check and write to a file using try catch to Handling exceptions
    public boolean checkAndWriteIntoFile(ArrayList<Contact> contact) throws IOException {
        //getting home directory of current working directory=user.dir
        String HOME = System.getProperty("user.dir");
        String fileName = "AddressBookIO.txt";
        Path homePath = Paths.get(HOME);
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {
                if (Files.exists(filePath)) {
                    if (writeIntoFile(new File(fileName), contact)) {   //creating new file and passing contact
                        return true;
                    }
                } else {
                    Files.createFile(filePath);		//creating a file:createFile(args-path)
                    if (writeIntoFile(new File(fileName), contact)) {
                        return true;
                    }
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

    //code to write to a file
    public boolean writeIntoFile(File filename, ArrayList<Contact> contact) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            for (Contact content : contact) {
                myWriter.write(content + "\n");
            }
            myWriter.close(); //run close() method
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); 
            return false;
        }
    }

    /*
     //Followed by IO-concept
     public void read() throws IOException {
         File f = new File("user.dir");
         File f1 = new File("AddressBookIO");
         FileReader fr = new FileReader(f1);
         int i =fr.read();
         while(i!=-1) {
          System.out.print((char)i);
          i=fr.read();
         }
         fr.close();
         }
     */
	/*
    // followed by streams for reading data
    public boolean readData() {
        try {
            Files.lines(new File("AddressBookIO").toPath()).map(line -> line.trim()).forEach(line -> System.out.println(line));
        } catch (IOException e) { }
		return false;
    }
    */
    
   //reading a file
    public boolean viewContact() {
    	//getting home directory of current working directory=user.dir
        String HOME = System.getProperty("user.dir");
        String fileName = "AddressBookIO";
        Path homePath = Paths.get(HOME);
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);  //getting the path of a file
            if (Files.exists(filePath)) {
                //File filename = new File("AddressBookIO.txt");
                Scanner myReader = new Scanner("AddressBookIO.txt"); 
                while (myReader.hasNextLine()) {	// we can use int method(unicode) also here.
                    String data = myReader.nextLine();
                    System.out.println(data);
                    myReader.close(); // close reading file
                }
                return true;
            }
        }
        return false;
    }
}
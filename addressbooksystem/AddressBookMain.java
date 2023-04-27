package com.bridgelabz.addressbooksystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class AddressBookMain {

		public static void main(String[] args) {
			

			AddressBookSystem addressBook = new AddressBookSystem();
			Scanner scanner = new Scanner(System.in);
			addressBook.addAddressBook();
	        addressBook.addContacts();

	        // Writing the address book to a file
	        addressBook.writeToFile("address_book.txt");

	        // Clearing the address book to read from file
	        addressBook.contacts.getFirstName();

	        // Reading the address book from a file
	        addressBook.readFromFile("address_book.txt");

	        // Printing the contacts
	        for (Contacts person : addressBook.Contacts) {
	            System.out.println(person.getFirstName() + " \n" + person.getLastName() + " \n" + person.getEmail()+ "\n" + person.getAddress() + "\n " + person.getPhoneNumber()+ "\n" + person.getCity());
	        }
	    
	

			while (true) {
				System.out.println("Enter 1 to add Address Book");
				System.out.println("Enter 2 to display Address Book");
				System.out.println("Enter 3 to open Address Book");
				System.out.println("Enter 4 to add contact");
				System.out.println("Enter 5 to search Contacts By City Or State");
				System.out.println("Enter 6 to search & view Contacts By City");
				System.out.println("Enter 7 to search Contacts By State");
				System.out.println("Enter 8 to search Contact Numbers in a City Or State");
				System.out.println("Enter 9 to sort Contacts By Alphabetically");
				System.out.println("Enter 10 to sort Contacts By City");
				System.out.println("Enter 11 to sort Contacts By State");
				System.out.println("Enter 12 to sort Contacts By Zip");
				System.out.println("Enter 13 to display all contacts");
				System.out.println("Enter 14 to edit a contact");
				System.out.println("Enter 15 to delete a contact");
				System.out.println("Enter 16 to exit Address Book");
				System.out.println("Enter 0 to exit");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 0:
					System.out.println("Exiting Address Book");
					System.exit(0);
				case 1:
					addressBook.addAddressBook();
					break;
				case 2:
					addressBook.displayAddressBooks();
					break;
				case 3:
					addressBook.openAddressBook();
					break;
				case 4:
					addressBook.addContacts();
					break;
				case 5:
					addressBook.searchContactsByCityOrState();

					break;
				case 6:
					addressBook.viewPersonByCity();
					break;
				case 7:
					addressBook.viewContactsByState();
					break;
				case 8:
					addressBook.searchContactNumbersByCityOrState();
					break;
				case 9:
					addressBook.sortContactsByName();
					break;
				case 10:
					addressBook.sortContactsByCity();
					break;
				case 11:
					addressBook.sortContactsByState();
					break;
				case 12:
					addressBook.sortContactsByZip();
					break;
				case 13:
					addressBook.displayContacts();
					break;
				case 14:
					System.out.println("Enter the first name of the contact to edit:");
					String firstName = scanner.nextLine();
					System.out.println("Enter the last name of the contact to edit:");
					String lastName = scanner.nextLine();
					addressBook.editContact(firstName, lastName);
					break;
				case 15:
					System.out.println("Enter the first name of the contact to delete:");
					String firstName1 = scanner.nextLine();
					System.out.println("Enter the last  name of the contact to delete:");
					String lastName1 = scanner.nextLine();
					addressBook.deleteContact(firstName1, lastName1);
					break;
				case 16:
					System.exit(0);
				default:
					System.out.println(" Contact details not found. ");
				}
			}
		}
	}

		
	
package com.bridgelabz.addressbooksystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

	  Scanner scanner = new Scanner(System.in);
	    Map<String, AddressBook> addressBooks = new HashMap<>();

	    public void createAddressBook() {
	        System.out.println("Enter a unique name for the new address book:");
	        String name = scanner.nextLine();
	        if (addressBooks.containsKey(name)) {
	            System.out.println("Address book already exists with the given name.");
	            return;
	        }
	        AddressBook addressBook = new AddressBook();
	        addressBooks.put(name, addressBook);
	        System.out.println("New address book created successfully with name: " + name);
	    }

	    public void displayAddressBooks() {
	        if (addressBooks.isEmpty()) {
	            System.out.println("No address books found.");
	            return;
	        }
	        System.out.println("List of address books:");
	        for (String name : addressBooks.keySet()) {
	            System.out.println(name);
	        }
	    }

	    public void openAddressBook() {
	        System.out.println("Enter the name of the address book you want to open:");
	        String name = scanner.nextLine();
	        AddressBook addressBook = addressBooks.get(name);
	        if (addressBook == null) {
	            System.out.println("No address book found with the given name.");
	            return;
	        }
	    
	    }

	    public static void main(String[] args) {
	        AddressBook addressBookSystem = new AddressBook();
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.println("Enter an option:\n1. Create address book\n2. Display address books\n3. Open address book\n4. Exit");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // consume the newline character
	            switch (choice) {
	                case 1:
	                    addressBookSystem.createAddressBook();
	                    break;
	                case 2:
	                    addressBookSystem.displayAddressBooks();
	                    break;
	                case 3:
	                    addressBookSystem.openAddressBook();
	                    break;
	                case 4:
	                    System.out.println("Exiting...");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid option.");
	            }
	        }
	    }
	}

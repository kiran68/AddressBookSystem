package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBook extends Contacts {

	Contacts contacts = new Contacts();
	Scanner scanner = new Scanner(System.in);
	List<Contacts> Contacts = new ArrayList<Contacts>();

	public void addContacts() {

		boolean addingContacts = true;
		while (addingContacts) {

			System.out.println("Enter First Name : ");
			String firstName = scanner.nextLine();
			contacts.setFirstName(firstName);

			System.out.println("Enter Last Name : ");
			String lastName = scanner.nextLine();
			contacts.setLastName(lastName);

			System.out.println("Enter Address :");
			String address = scanner.nextLine();
			contacts.setAddress(address);

			System.out.println("Enter City : ");
			String city = scanner.nextLine();
			contacts.setCity(city);

			System.out.println("Enter State : ");
			String state = scanner.nextLine();
			contacts.setState(state);

			System.out.println("Enter Email : ");
			String email = scanner.nextLine();
			contacts.setEmail(email);

			System.out.println("Enter ZIP : ");
			int zip = scanner.nextInt();
			contacts.setZip(zip);

			System.out.println("Enter Phone Number");
			long phoneNumber = scanner.nextLong();
			contacts.setPhoneNumber(phoneNumber);

			Contacts.add(contacts);
			System.out.println("Person is Created Scussfully");
			System.out.println("Do You Want To Add Another Person ? (Y/N)");
			String choice = scanner.nextLine();
			if (choice.equalsIgnoreCase("N")) {
				addingContacts = false;
			}
		}
	}

	public void displayContacts() {
		if (Contacts.isEmpty()) {
			System.out.println("Address Book Is Empty");
		}
		System.out.println("Address book");
		for (Contacts contacts : Contacts) {
			System.out.println(contacts.address);
			System.out.println(contacts.getLastName());
			System.out.println(contacts.getAddress());
			System.out.println(contacts.getCity());
			System.out.println(contacts.getState());
			System.out.println(contacts.getEmail());
			System.out.println(contacts.getZip());
			System.out.println(contacts.getPhoneNumber());
		}

	}

	public void editPerson(String firstName, String lastName) {
		System.out.println("Enter the First name you want to edit. \n");

		firstName = scanner.nextLine();

		for (int i = 0; i < Contacts.size(); i++) {
			if (Contacts.get(i).getFirstName().equals(firstName)) {
				Contacts.get(i).setFirstName(firstName);

				System.out.println("Enter Last Name : ");
				lastName = scanner.nextLine();
				Contacts.get(i).setLastName(lastName);

				System.out.println("Enter Address :");
				String address = scanner.nextLine();
				Contacts.get(i).setAddress(address);

				System.out.println("Enter City : ");
				String city = scanner.nextLine();
				Contacts.get(i).setCity(city);

				System.out.println("Enter State : ");
				String state = scanner.nextLine();
				Contacts.get(i).setState(state);

				System.out.println("Enter Email : ");
				String email = scanner.nextLine();
				Contacts.get(i).setEmail(email);

				System.out.println("Enter ZIP : ");
				int zip = scanner.nextInt();
				Contacts.get(i).setZip(zip);

				System.out.println("Enter Phone Number");
				long phoneNumber = scanner.nextLong();
				Contacts.get(i).setPhoneNumber(phoneNumber);

				System.out.println("Person Edited Succesfully");
			} else {
				System.out.println("Person Not Found in Address Book ");
			}
			
		}
		
		
	}



Scanner scanner1 = new Scanner(System.in);
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
    addressBook.menu();
}

private void menu() {
	
	
}
}

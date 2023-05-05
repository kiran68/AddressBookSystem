package com.bridgelabz.advaddressbook;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class AddressBookSystemJDBC extends BaseDemo {

    public void retrieveData() throws SQLException {
        connection = setUpDatabase();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM address_book";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            String zip = resultSet.getString("zip");
            String email = resultSet.getString("email");
            long phone= resultSet.getLong("phone");
            String name = resultSet.getString("name");
            String type = resultSet.getString("type");
            System.out.println(id + " " + firstName + " " + lastName + " " + address + " " + city + " " + state + " "
                    + zip + " " + email + " " + phone + " " + name + " " + type);
        }
        System.out.println("Retrieve all the data from the addressbook table");
    }

	/*
	 * public void updateContactInformation(int id) throws SQLException { connection
	 * = setUpDatabase(); PreparedStatement statement =
	 * connection.prepareStatement("SELECT * FROM address_book WHERE id=?");
	 * statement.setInt(1, id); ResultSet resultSet = statement.executeQuery(); if
	 * (resultSet.next()) { // Retrieve the current information from the database
	 * String firstName = resultSet.getString("first_name"); String lastName =
	 * resultSet.getString("last_name"); String address =
	 * resultSet.getString("address"); String city = resultSet.getString("city");
	 * String state = resultSet.getString("state"); String zip =
	 * resultSet.getString("zip"); String email = resultSet.getString("email");
	 * String phone = resultSet.getString("phone");
	 * 
	 * // Display the current information to the user and ask for new information
	 * System.out.println("Current Information:"); System.out.println("First Name: "
	 * + firstName); System.out.println("Last Name: " + lastName);
	 * System.out.println("Address: " + address); System.out.println("City: " +
	 * city); System.out.println("State: " + state); System.out.println("Zip: " +
	 * zip); System.out.println("Email: " + email);
	 * System.out.println("Phone Number: " + phone); Scanner scanner = new
	 * Scanner(System.in); //
	 * System.out.print("Enter the ID of the contact you want to update:"); int
	 * contactId = scanner.nextInt(); scanner.nextLine();
	 * System.out.print("Enter new First Name: "); String newFirstName =
	 * scanner.nextLine();
	 * 
	 * System.out.print("Enter new Last Name: "); String newLastName =
	 * scanner.nextLine();
	 * 
	 * System.out.print("Enter new Address: "); String newAddress =
	 * scanner.nextLine();
	 * 
	 * System.out.print("Enter new City: "); String newCity = scanner.nextLine();
	 * 
	 * System.out.print("Enter new State: "); String newState = scanner.nextLine();
	 * 
	 * System.out.print("Enter new Zip: "); String newZip = scanner.nextLine();
	 * 
	 * System.out.print("Enter new Email: "); String newEmail = scanner.nextLine();
	 * 
	 * System.out.print("Enter new Phone Number: "); String newPhone =
	 * scanner.nextLine();
	 * 
	 * // Update the contact information in the database PreparedStatement
	 * updateStatement = connection.prepareStatement(
	 * "UPDATE address_book SET first_name=?, last_name=?, address=?, city=?, state=?, zip=?, email=?, phone=? WHERE id=?"
	 * ); updateStatement.setString(1, newFirstName); updateStatement.setString(2,
	 * newLastName); updateStatement.setString(3, newAddress);
	 * updateStatement.setString(4, newCity); updateStatement.setString(5,
	 * newState); updateStatement.setString(6, newZip); updateStatement.setString(7,
	 * newEmail); updateStatement.setString(8, newPhone); updateStatement.setInt(9,
	 * contactId); int rowsAffected = updateStatement.executeUpdate(); if
	 * (rowsAffected >0 ) {
	 * System.out.println("Contact information updated successfully!"); } else {
	 * System.out.println("Contact information update failed."); } } else {
	 * System.out.println("No contact found with ID " + id); } connection.close();
	 */
    
    public void retrieveData(LocalDate startDate, LocalDate endDate) throws SQLException {
		connection = setUpDatabase();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM address_book WHERE date_joining BETWEEN ? AND ?");
		preparedStatement.setDate(1, Date.valueOf(startDate));
		preparedStatement.setDate(2, Date.valueOf(endDate));
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			String address = resultSet.getString("address");
			String city = resultSet.getString("city");
			String state = resultSet.getString("state");
			String zip = resultSet.getString("zip");
			String email = resultSet.getString("email");
			String phone = resultSet.getString("phone");
			String name = resultSet.getString("name");
			String type = resultSet.getString("type");
			String date_joining = resultSet.getString("date_joining");
			System.out.println(id + " " + firstName + " " + lastName + " " + address + " " + city + " " + state + " "
					+ zip + " " + email + " " + phone + " " + name + " " + type + " " + date_joining);
		}
		System.out.println("Retrieved data from the addressbook table for the date range between "
				+ startDate.toString() + " and " + endDate.toString());
	}
}


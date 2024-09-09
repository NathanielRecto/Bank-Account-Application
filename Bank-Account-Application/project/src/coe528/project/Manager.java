/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author Nathaniel Recto
 */
public class Manager {
    static Manager m;
    static ArrayList<Customer> customers = new ArrayList<Customer>(); // List of customers

    public Manager() {
    }
    
    /**
     *
     * @param user The username of the customer
     * @param pass The password of the customer
     * @return true if the customer account is successfully created, false otherwise
     */
    public boolean createCustomer(String user, String pass) {
        // Check if the username is already taken
        for (Customer c : customers) {
        if (c.username.equals(user)) {
            System.out.println("Username is taken");
            return false;
        }
    }

    try {
        // Adds customer to list with initial balance of $100
        customers.add(new Customer(user, 100));
        // Create a new file for the customer
        File f = new File(user + ".txt");
        f.createNewFile();
        // Create file
        PrintWriter pw = new PrintWriter(new FileWriter(f, true));
        pw.println(pass); // write password in the file
        pw.close();
    } catch (IOException e) {
        System.out.println("Error");
        return false;
    }
    return true;
}
    /**
     * 
     * @param user The username of the customer to be deleted
     * @return true if the customer account is successfully deleted, false otherwise
     */
    public boolean deleteCustomer(String user) {
        for (Customer c : customers) {
            if (c.username.equals(user)) {
                customers.remove(c);
                File f = new File(user + ".txt");
                if (f.delete()) {
                    return true;
                } else {
                    System.out.println("Failed to delete the file");
                    return false;
                }
            }
        }
        return false;
    }
    /**
     * 
     * @param user The username of the customer to be deleted
     * @return true if the customer account is successfully deleted, false otherwise
     */
    public Customer customerExists(String user) {
        for (Customer c : customers) {
            if (c.username.equals(user)) {
                return c;
            }
        }
        return null;
    }
  
    /**
     * 
     * @param username The username of the customer
     * @param password The password to verify
     * @return true if the password is correct, false otherwise
     */
    public static boolean verifyPassword(String username, String password) {
    File file = new File(username + ".txt");
    if (!file.exists()) {
        return false; // Username file does not exist
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String storedPassword = br.readLine(); // Read password from file
        if (storedPassword != null && storedPassword.equals(password)) { // If password matches
            return true;
        }
    } catch (IOException e) {
        // Handle IO exception
    }

    return false; // Username exists, but password doesn't match
    }
}
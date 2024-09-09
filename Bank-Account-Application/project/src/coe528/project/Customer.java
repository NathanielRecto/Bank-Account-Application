/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Nathaniel Recto
 */
public class Customer {
    public String username;
    public double balance;
    public static Level level;
    
    /**
     * Constructs a customer with the given username.
     * @param user The username of the customer
     */
    public Customer (String user) {
        username = user;
    }
    /**
     * 
     * @param user The username of the customer
     * @param bal The balance of the customer
     */
    public Customer (String user, double bal) {
        username = user;
        balance = bal;
        if (balance < 10000) {
            level = new Silver();
        }
        else if (balance >= 10000 && balance < 20000) {
            level = new Gold ();
        }
        else
            level = new Platinum();
    }
    
    public Customer getCustomer () {
        return this;
    }
    
    /**
     * 
     * @param b
     */
    public void setBalance (double b) {
        balance = b;
    }
    
    /**
     * 
     * @param l
     */
    public void setLevel (Level l) {
        level = l;
    }
    
    /**
     * 
     * @param amount
     */
    public void deposit (double amount) {
        balance = balance + amount;
    }
    
    /**
     * 
     * @param cost
     */
    public void purchase (double cost) {
        balance = balance - cost;
    }
    
    @Override
    public String toString() {
        return username;
    }
}

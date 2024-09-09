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
public class Platinum extends Level {    
    
    // OVERVIEW: A user can create bank accounts that
    //           are assigned a level ranging from 
    //           silver to platinum. If a user's balance
    //           falls below 10000, they are level silver.
    //           If the balance is between 10000 and 20000, 
    //           they are level gold.The platinum class is 
    //           immutable.
    //
    // AF(c) = A bank account B
    //         where balance = c.balance
    //               balance = sum of all deposits,
    //                         withdraws, and purhcases
    
    // RI(c) = true if ((c.balance > 0) AND (c.balance = (double)c.balance))
    //         false otherwise
    //
    public final double FEE = 0;
    static double balance;
    
    /**
     * 
     * @param c 
     */
    @Override
    public void changeLevel (Customer c) {
        balance = c.balance;
        if (c.balance < 10000) {
            c.setLevel(new Silver());
        }
        if (c.balance >= 10000 && c.balance < 20000) {
            c.setLevel(new Gold());
        }
    }
    /**
     * 
     * @return FEE
     */
    @Override
    public double getFee() {
        return FEE;
    }
    /**
     * 
     * @return Platinum
     */
    @Override
    public String toString() {
        return "PLATINUM";
    }
    /**
     * 
     * Return true if balance is greater than 0
     * and balance is a double
     * Return false otherwise
     * @return
     */
    public boolean repOk() {
        if (balance > 0 && balance == (double)balance) {
            return true;
        }
        return false;
    }
}

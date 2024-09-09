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
public class Silver extends Level {
    public final double FEE = 20;
    
    /**
     * 
     * @param c
     */
    @Override
    public void changeLevel (Customer c) {
        if (c.balance >= 10000 && c.balance < 20000) {
            c.setLevel(new Gold());
        }
        if (c.balance >= 20000) {
            c.setLevel (new Platinum());
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
     * @return Silver
     */
    @Override
    public String toString() {
        return "SILVER";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * 
 *
 * @author Nathaniel Recto
 */
public class CustomerController implements Initializable {
    public double amount = 0;
    @FXML
    public TextField Amount;
    @FXML
    public Label Balance;
    @FXML
    public Label Level;
    
    /**
     * Returns to the starting Login GUI
     * @param event The event triggering the action (e.g., button click)
     * @throws java.lang.Exception
     */
    @FXML
    public void logoutButton(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    /**
     * Deposits amount entered in TextField into customer's account
     */
    @FXML
    public void depositButton() {
        try {
            amount = Double.parseDouble(Amount.getText());
            if (amount < 0) {
                Balance.setText("Not a valid amount");
                return;
            }
            StartController.customer.setBalance(amount + StartController.customer.balance);
            StartController.customer.level.changeLevel(StartController.customer);
            Balance.setText(Double.toString(StartController.customer.balance));
            Level.setText(StartController.customer.level.toString());
        } catch (Exception e) {
            Balance.setText("Not a valid amount");
        }
    }   
    
    /**
     * Withdraws amount entered in TextField from customer's account
     */
    @FXML
    public void withdrawButton() {
        try{
            amount = Double.parseDouble(Amount.getText());
            if (amount < 0) {
                Balance.setText("Not a valid amount");
                return;
            }
            if (StartController.customer.balance < amount)
                Balance.setText("Not enough money");
            else{
                Balance.setText(Double.toString(StartController.customer.balance -= amount));
                StartController.customer.level.changeLevel(StartController.customer);
                Level.setText(StartController.customer.level.toString());
            }
        } catch (Exception e){
            Balance.setText("Not a valid amount");
            }
        
    } 
    /**
     * Deducts amount entered in TextField from customer's account
     */
    @FXML 
    public void purchaseButton() {
        try{
            amount = Double.parseDouble(Amount.getText());
            if (amount <0) {
                Balance.setText("Not a valid amount");
                return;
            }
            if (amount >= 50){
                if (StartController.customer.balance < amount + StartController.customer.level.getFee())
                    Balance.setText("Not enough money");
                else{
                    Balance.setText(Double.toString(StartController.customer.balance -= (amount + StartController.customer.level.getFee())));
                    StartController.customer.level.changeLevel(StartController.customer);
                    Level.setText(StartController.customer.level.toString());
                }
            }
            else 
                Balance.setText("Must purchase at least $50");
        } catch (Exception e){
            Balance.setText("Not a valid amount");
        }
    }
    
    /**
     * Initializes the controller class.
     * @param url The location used to resolve relative paths for the root object
     * @param rb The resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Shows the initial balance and level
        Balance.setText(Double.toString(StartController.customer.balance));
        Level.setText(StartController.customer.level.toString());
    }
}
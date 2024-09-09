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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nathaniel Recto
 */
public class ManagerController implements Initializable {
    protected Manager m = new Manager(); 
    
    @FXML
    private PasswordField Password;
    
    @FXML
    private TextField Username;
    
    @FXML 
    private Label prompt;
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
     * adds customer username and password to a text file
     */
    @FXML
    public void addCustomerButton(){
        try {
            if (m.createCustomer(Username.getText(), Password.getText())){
                prompt.setText("Customer added with $100");
            }
            else {
                prompt.setText("Username already taken. Try again");
            }
        } catch (Exception e) {
                    prompt.setText("Enter a valid amount");
        }
    }
    /**
     * delete customer text file containing their username and password
     */
    @FXML
    public void deleteCustomerButton(){
        if (m.deleteCustomer(Username.getText()))
            prompt.setText(Username.getText() + " has been deleted");
        else
            prompt.setText(Username.getText() + " does not exist");
    }
    
    /**
     * Initializes the controller class.
     * @param url The location used to resolve relative paths for the root object
     * @param rb The resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
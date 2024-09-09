/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Nathaniel Recto
 */
public class StartController implements Initializable {

    BufferedReader br = null;
    ObservableList<String> userList = FXCollections.observableArrayList("Customer", "Manager");
    public final String USERNAME = "admin";
    public final String PASSWORD = "admin";

    static Manager manager = new Manager();
    static Customer customer;

    @FXML
    public ChoiceBox Menu;
    @FXML
    public Label prompt;
    @FXML
    public TextField Username;
    @FXML
    public PasswordField Password;
    
    /**
     * Handles the login button action
     * Checks if the entered username and password are correct
     * Navigates to the appropriate GUI (Manager or Customer) based on user input
     * @param event The event triggering the action (e.g., button click)
     * @throws Exception
     */
    @FXML
    public void loginButton(ActionEvent event) throws Exception {
    String username = Username.getText();
    String password = Password.getText();

    if (Menu.getValue().equals("Manager")) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) { // If username and password match
            Parent root = FXMLLoader.load(getClass().getResource("Manager.fxml")); // Load Manager GUI
            Scene scene = new Scene(root); // Create new scene
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow(); // Get current window
            window.setScene(scene); // Set scene to Manager GUI
            window.show();  // Show window
        } else {
            prompt.setText("Wrong Username or Password. Try again"); //display error message
        }
    } else if (Menu.getValue().equals("Customer")) {
        if (Manager.verifyPassword(username, password)) {
            customer = manager.customerExists(username);
            if (customer != null) {
                // Navigate to Customer GUI
                Parent customerUIParent = FXMLLoader.load(getClass().getResource("Customer.fxml"));
                Scene customerUIScene = new Scene(customerUIParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(customerUIScene);
                window.show();
            } else {
                prompt.setText("Customer account not found or deleted");
            }
        } else {
            prompt.setText("Wrong Username or Password. Try again");
        }
    }
    }
    /**
     * Initializes the controller class.
     * @param url The location used to resolve relative paths for the root object
     * @param rb The resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Menu.getItems().addAll("Customer", "Manager");
        Menu.setValue("Customer");
    }
}
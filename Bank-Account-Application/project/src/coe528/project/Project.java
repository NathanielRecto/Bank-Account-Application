/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nathaniel Recto
 */
public class Project extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Load the Start.fxml file as the initial scene
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        // Create a new scene with the loaded FXML file
        Scene scene = new Scene (root);
        primaryStage.setTitle("Bank Account Application");
        primaryStage.setScene(scene); // Set the scene for the stage
        primaryStage.show();
            
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

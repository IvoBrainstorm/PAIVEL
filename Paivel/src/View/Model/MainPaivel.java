/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author brainstorm
 */
public class MainPaivel extends Application {
    
    public static Stage stage = null;
    
    @Override
    public void start(Stage stage) throws Exception {
        
//        Parent root = FXMLLoader.load(getClass().getResource("/View/View/Principal.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/View/View/Login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        this.stage = stage;
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author brainstorm
 */
public class PrincipalController implements Initializable {
    
    private double xOffset = 0;
    private double yOffset = 0;
 
     @FXML
    private BorderPane borderPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
          // Parent slideArea = FXMLLoader.load(getClass().getResource("slideBarra.fxml"));
           // Parent barramenu = FXMLLoader.load(getClass().getResource("BarraMenu.fxml"));
            Parent AreaPrincipal = FXMLLoader.load(getClass().getResource("/View/View/AreaPrincipal.fxml"));
            
           // borderPane.setTop(barramenu);
        //    borderPane.setLeft(slideArea);
            borderPane.setCenter(AreaPrincipal);
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    
}

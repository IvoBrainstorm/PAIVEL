/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Control;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author brainstorm
 */
public class AreaPrincipalController implements Initializable {
    
      @FXML
    private VBox AreaPrincipal;

    @FXML
    private HBox barramenu;
    
     @FXML
    private JFXButton btnFechar;

   


    /**
     * Initializes the controller class.
     */
    
    boolean flag = true;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        @FXML
    private void open_sidebar(ActionEvent event) throws IOException {
        BorderPane borderPane = (BorderPane) ((Node) event.getSource()).getScene().getRoot();
        if (flag) {
            Parent slideArea = FXMLLoader.load(getClass().getResource("/View/View/SlideBarra.fxml"));
            borderPane.setLeft(slideArea);
            flag = false;
        } else {
            borderPane.setLeft(null);
            flag = true;
        }
        
    }
    
     @FXML
    private void fechar(ActionEvent event) {
         Platform.exit();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Principal;

import com.jfoenix.effects.JFXDepthManager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ivo Brainstorm
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane painelDados;
    @FXML
    private FontAwesomeIcon btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        JFXDepthManager.setDepth(painelDados, 2);
    }    

    @FXML
    private void closeEvento(MouseEvent event) {
        //Fechar o stage no clique do icone
        Platform.exit();
    }
    
}

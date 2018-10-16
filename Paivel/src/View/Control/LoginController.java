/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Control;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ivo Brainstorm
 */
public class LoginController implements Initializable {
    
    @FXML
    private JFXButton btnEntrar;

    @FXML
    void abrirPrincipal(ActionEvent event) {
        try {
            FXMLLoader painel_productos = new FXMLLoader(getClass().getResource("/View/View/AreaPrincipal.fxml"));
            Parent root1 = (Parent) painel_productos.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Erro ao abrir a tela nova");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

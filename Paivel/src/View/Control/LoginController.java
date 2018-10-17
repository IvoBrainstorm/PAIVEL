/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Ivo Brainstorm
 */
public class LoginController implements Initializable {
    
    @FXML
    private JFXButton btnEntrar;
    
    @FXML
    private JFXButton btnFechar;
    
     @FXML
    private JFXTextField txtUser;

    @FXML
    private JFXPasswordField txtPass;

    @FXML
    void abrirPrincipal(ActionEvent event) {
        String userName = txtUser.getText();
        String password = txtPass.getText();
        if(userName.equals("IvoMatavele")&&(password.equals("1234567890"))){
            
            try {
                FXMLLoader painel_productos = new FXMLLoader(getClass().getResource("/View/View/AreaPrincipal.fxml"));
                Parent root1 = (Parent) painel_productos.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException e) {
                System.out.println("Erro ao abrir a tela nova");
            }
        }else{
            Image img = new Image("/View/Icons/cancelErro.png");
            Notifications notificacaoErro = Notifications.create()
                    .title("Erro")
                    .text("Invalido \nOu senha invalida")
                    .graphic(new ImageView(img))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);
            notificacaoErro.darkStyle();
            notificacaoErro.showError();
            
        }
    }

    @FXML
    void fecharLogin(ActionEvent event) {
        Platform.exit();
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Principal;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author brainstorm
 */
public class SlideBarraController implements Initializable {

    @FXML
    private VBox slideArea;

    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnCliente;

    @FXML
    private JFXButton btnProductos;

    @FXML
    private JFXButton btnConfig;

    @FXML
    private JFXButton btnUsuario;

    boolean flag = true;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void open_AddProductos(ActionEvent event) {
        try {
            FXMLLoader painel_productos = new FXMLLoader(getClass().getResource("Material.fxml"));
            Parent root1 = (Parent) painel_productos.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Erro ao abrir a tela nova");
        }
    }

    @FXML
    void open_Cliente(ActionEvent event) {
        try {
            FXMLLoader painel_clientes = new FXMLLoader(getClass().getResource("Clientes.fxml"));
            Parent root1 = (Parent) painel_clientes.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Erro ao abrir a tela nova");
        }
    }

    @FXML
    void open_config(ActionEvent event) {
        try {
            FXMLLoader painel_configuracoes = new FXMLLoader(getClass().getResource("Configuracoes.fxml"));
            Parent root1 = (Parent) painel_configuracoes.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Erro ao abrir a tela nova");
        }
    }

    @FXML
    void open_menu(ActionEvent event) throws IOException {
        BorderPane borderPane = (BorderPane) ((Node) event.getSource()).getScene().getRoot();
        if (flag) {
            Parent slideArea = FXMLLoader.load(getClass().getResource("slideBarra.fxml"));
            borderPane.setLeft(slideArea);
            flag = false;
        } else {
            borderPane.setLeft(null);
            flag = true;
        }
    }

    @FXML
    void open_usuario(ActionEvent event) {
        try {
            FXMLLoader painel_usuario = new FXMLLoader(getClass().getResource("Usuarios.fxml"));
            Parent root1 = (Parent) painel_usuario.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Erro ao abrir a tela nova");
        }
    }
}

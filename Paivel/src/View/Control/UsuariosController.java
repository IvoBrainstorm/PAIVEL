/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author brainstorm
 */
public class UsuariosController implements Initializable {

        @FXML
    private VBox painel_usuario;

    @FXML
    private TableView<?> tableListaUsuarios;

    @FXML
    private TableColumn<?, ?> colunnaNome;

    @FXML
    private TableColumn<?, ?> colunaUsuario;

    @FXML
    private TableColumn<?, ?> colunaNivel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

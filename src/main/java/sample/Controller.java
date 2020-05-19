package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LoginSinUpButtom;

    @FXML
    private TextField Login_field;

    @FXML
    private PasswordField Password_field;

    @FXML
    private Button aithSingUpButtom;

    @FXML
    private Button Password_Restore;

    @FXML
    private Button Politics_buttom;

    @FXML
    void initialize() {
        assert LoginSinUpButtom != null : "fx:id=\"LoginSinUpButtom\" was not injected: check your FXML file 'aut.fxml'.";
        assert Login_field != null : "fx:id=\"Login_field\" was not injected: check your FXML file 'aut.fxml'.";
        assert Password_field != null : "fx:id=\"Password_field\" was not injected: check your FXML file 'aut.fxml'.";
        assert aithSingUpButtom != null : "fx:id=\"aithSingUpButtom\" was not injected: check your FXML file 'aut.fxml'.";
        assert Password_Restore != null : "fx:id=\"Password_Restore\" was not injected: check your FXML file 'aut.fxml'.";
        assert Politics_buttom != null : "fx:id=\"Politics_buttom\" was not injected: check your FXML file 'aut.fxml'.";

    }
}


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controllerreg {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LoginAutButtom;

    @FXML
    private TextField Login_field;

    @FXML
    private TextField FirstName_field;

    @FXML
    private Button BackButtom;

    @FXML
    private TextField SecondName_field1;

    @FXML
    private TextField LoginAut_field;

    @FXML
    private TextField Email_field;

    @FXML
    private PasswordField PasswordAut_field;

    @FXML
    void initialize() {

        LoginAutButtom.setOnAction(event -> {

            signUpNewUser();

        });

        LoginAutButtom.setOnAction(event -> {
            LoginAutButtom.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Главное меню общее!.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        BackButtom.setOnAction(event -> {
            BackButtom.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/aut.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String name = FirstName_field.getText();
        String lastname = SecondName_field1.getText();
        String passvord = PasswordAut_field.getText();
        String login = LoginAut_field.getText();
        String strana = Login_field.getText();
        String email = Email_field.getText();

        User user = new User(name, lastname, passvord, login, strana, email);

        dbHandler.signUpUser(user);
    }
}
 
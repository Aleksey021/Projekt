import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        LoginSinUpButtom.setOnAction(event -> {
            LoginSinUpButtom.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Регистрация.fxml"));
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

        aithSingUpButtom.setOnAction(event -> {
            String loginText = Login_field.getText().trim();
            String loginPassword = Password_field.getText().trim();
            if (!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
                System.out.println("Неправильный логин или пароль!");
        });
    }

    private void loginUser(String loginText, String loginPassword) {

        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassvord(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }

        if (counter >= 1) {

            aithSingUpButtom.setOnAction(event -> {
                aithSingUpButtom.getScene().getWindow().hide();
                FXMLLoader loader2 = new FXMLLoader();
                loader2.setLocation(getClass().getResource("/Главное меню общее!.fxml"));
                try {
                    loader2.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader2.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            });

            System.out.println("Успех!");
        }
    }
}


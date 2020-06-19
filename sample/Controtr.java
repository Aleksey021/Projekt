import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class Controtr {
    @FXML
    private TextField Login_field;

    @FXML
    private TextField Password_field;

    @FXML
    private Button ButtomCreatOtr;

    @FXML
    private Button ButtomCreatOtrBack;

    @FXML
    void initialize() {
        ButtomCreatOtr.setOnAction(event -> {
            signUpNewOtr();

            ButtomCreatOtr.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        ButtomCreatOtrBack.setOnAction(event ->{
            ButtomCreatOtrBack.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void signUpNewOtr() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String nameotr = Login_field.getText();
        String passv = Password_field.getText();

        Otrady2 otr = new Otrady2(nameotr, passv);

        dbHandler.signUpOtr(otr);
    }

}

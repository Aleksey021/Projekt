import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controllergl {

    @FXML
    private AnchorPane AGory;

    @FXML
    private AnchorPane AOtrady;

    @FXML
    private AnchorPane AProfil;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button HomeButtom;

    @FXML
    private Button GoraButtom;

    @FXML
    private Button FriendButtom;

    @FXML
    private Button GruppButtom;

    @FXML
    private Button SettButtom;

    @FXML
    private Button ProfButtom;

    @FXML
    void CreateGruppButtom(ActionEvent event) {
    }

    @FXML
    void goinGruppButtom(ActionEvent event) {
    }

    @FXML
    Text Nameid;

    @FXML
    Text Lastnameid;

    @FXML
    Text Emailid;

    @FXML
    Text Loginid;

    @FXML
    private TableView Tgory;

    @FXML
    private TableColumn<Mountain, String> Kver;

    @FXML
    private TableColumn<Mountain, Integer> Kvis;

    @FXML
    private TableColumn<Mountain, String> Kmes;

    @FXML
    private TableColumn<Mountain, String> Kgs;


    @FXML
    void initialize() {
        GoraButtom.setOnAction(event -> {
            AGory.setOpacity(1);
            AOtrady.setOpacity(0);
            AProfil.setOpacity(0);
        });

        GruppButtom.setOnAction(event -> {
            AGory.setOpacity(0);
            AOtrady.setOpacity(1);
            AProfil.setOpacity(0);
        });

        ProfButtom.setOnAction(event -> {
            AGory.setOpacity(0);
            AOtrady.setOpacity(0);
            AProfil.setOpacity(1);
        });

        GoraButtom.setOnAction(event -> {

                    initData();

                    // устанавливаем тип и значение которое должно хранится в колонке
                    Kver.setCellValueFactory(new PropertyValueFactory<Mountain, String>("vershina"));
                    Kvis.setCellValueFactory(new PropertyValueFactory<Mountain, Integer>("visota"));
                    Kmes.setCellValueFactory(new PropertyValueFactory<Mountain, String>("mestopoloqenie"));
                    Kgs.setCellValueFactory(new PropertyValueFactory<Mountain, String>("sistema"));

                    // заполняем таблицу данными
                    Tgory.setItems(usersData);
                }

                // подготавливаем данные для таблицы
                // вы можете получать их с базы данных
        private void initData() {
            usersData.add(new User(1, "Alex", "qwerty", "alex@mail.com"));
            usersData.add(new User(2, "Bob", "dsfsdfw", "bob@mail.com"));
            usersData.add(new User(3, "Jeck", "dsfdsfwe", "Jeck@mail.com"));
            usersData.add(new User(4, "Mike", "iueern", "mike@mail.com"));
            usersData.add(new User(5, "colin", "woeirn", "colin@mail.com"));
        }

            {String ver = Kver.getText().trim();
            int vis = Integer.parseInt(Kvis.getText().trim());
            String mes = Kmes.getText().trim();
            String gs = Kgs.getText().trim();
            if (!ver.equals("") && mes.equals("") && gs.equals(""))
                loginUser(ver, vis, mes, gs);
            else
                System.out.println("ERROR!");}
        });
    }

    private void loginUser(String ver, int vis, String mes, String gs) {

        DatabaseHandler dbHandler = new DatabaseHandler();
        Mountain mountain = new Mountain();
        mountain.setVershina(ver);
        mountain.setVisota(vis);
        mountain.setMestopoloqenie(mes);
        mountain.setSistema(gs);
        ResultSet result = dbHandler.getMountain(mountain);

        int counter = 0;

        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }

        /*if (counter >= 1) {

            GoraButtom.setOnAction(event -> {
                aithSingUpButtom.getScene().getWindow().hide();
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

            System.out.println("Успех!");
        }
    }*/

    }
}
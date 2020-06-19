import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controllergl implements Initializable {

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
    private Button CreateGruppButtom;

    //@FXML
    //private Button goinGruppButtom;

    @FXML
    Text Nameid;

    @FXML
    Text Lastnameid;

    @FXML
    Text Emailid;

    @FXML
    Text Loginid;

    @FXML
    private TableView<Mountain> Tgory;

    @FXML
    private TableColumn<Mountain, String> Kver;

    @FXML
    private TableColumn<Mountain, Integer> Kvis;

    @FXML
    private TableColumn<Mountain, String> Kmes;

    @FXML
    private TableColumn<Mountain, String> Kgs;

    private ObservableList<Mountain> data;


    @FXML
    private TableView<Otrady1> Totrady;

    @FXML
    private TableColumn<Otrady1, String> Kotrady1;

    @FXML
    private TableColumn<Otrady1, Integer> Kych;

    @FXML
    private TableColumn<Otrady1, String> Kkv;

    private ObservableList<Otrady1> data2;


    @FXML
    private TableView<Poxody1> Tpoxod;

    @FXML
    private TableColumn<Poxody1, String> Kotrady2;

    @FXML
    private TableColumn<Poxody1, Integer> Kgora;

    @FXML
    private TableColumn<Poxody1, String> Kdatan;

    private ObservableList<Poxody1> dat;



    private DBClass dc;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

        dc=new DBClass();

        GoraButtom.setOnAction(event -> {
            AGory.setOpacity(1);
            AOtrady.setOpacity(0);
            AProfil.setOpacity(0);

            AGory.toFront();
            AGory.toFront();
            AOtrady.toBack();
            AProfil.toBack();

            AGory.setMinSize(722, 620);
            AGory.setMaxSize(722, 620);
            AGory.setPrefSize(722, 620);

            AOtrady.setMinSize(0, 0);
            AOtrady.setMaxSize(0, 0);
            AOtrady.setPrefSize(0, 0);

            AProfil.setMinSize(0, 0);
            AProfil.setMaxSize(0, 0);
            AProfil.setPrefSize(0, 0);

            {try {
                Connection conn = dc.Connect();
                data = FXCollections.observableArrayList();
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM mountans");
                while (rs.next()) {
                    data.add(new Mountain(rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
                }

            } catch (SQLException ex){
                System.err.println("ERROR" + ex);
            }

            Kver.setCellValueFactory(new PropertyValueFactory<>("vershina"));
            Kvis.setCellValueFactory(new PropertyValueFactory<>("visota"));
            Kmes.setCellValueFactory(new PropertyValueFactory<>("mestopoloqenie"));
            Kgs.setCellValueFactory(new PropertyValueFactory<>("sistema"));

            Tgory.setItems(null);
            Tgory.setItems(data);}

        });

        GruppButtom.setOnAction(event -> {
            {AGory.setOpacity(0);
            AOtrady.setOpacity(1);
            AProfil.setOpacity(0);

            AGory.toBack();
            AOtrady.toFront();
            AOtrady.toFront();
            AProfil.toBack();

            AGory.setMinSize(0, 0);
            AGory.setMaxSize(0, 0);
            AGory.setPrefSize(0, 0);

            AOtrady.setMinSize(722, 620);
            AOtrady.setMaxSize(722, 620);
            AOtrady.setPrefSize(722, 620);

            AProfil.setMinSize(0, 0);
            AProfil.setMaxSize(0, 0);
            AProfil.setPrefSize(0, 0);}


            {try {
                Connection conn = dc.Connect();
                data2 = FXCollections.observableArrayList();
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM otrady");
                while (rs.next()) {
                    data2.add(new Otrady1(rs.getString(2), rs.getInt(3), rs.getInt(4)));
                }

            } catch (SQLException ex){
                System.err.println("ERROR" + ex);
            }

                Kotrady1.setCellValueFactory(new PropertyValueFactory<>("nameotr"));
                Kych.setCellValueFactory(new PropertyValueFactory<>("ycasniki"));
                Kkv.setCellValueFactory(new PropertyValueFactory<>("vosh"));

                Totrady.setItems(null);
                Totrady.setItems(data2);}


            {try {
                Connection conn1 = dc.Connect();
                dat = FXCollections.observableArrayList();
                ResultSet rs1 = conn1.createStatement().executeQuery("SELECT * FROM poxody");
                while (rs1.next()) {
                    dat.add(new Poxody1(rs1.getString(1), rs1.getString(2), rs1.getString(3)));
                }

            } catch (SQLException ex){
                System.err.println("ERROR" + ex);
            }

                Kotrady2.setCellValueFactory(new PropertyValueFactory<>("otrad"));
                Kgora.setCellValueFactory(new PropertyValueFactory<>("gora"));
                Kdatan.setCellValueFactory(new PropertyValueFactory<>("datavos"));

                Tpoxod.setItems(null);
                Tpoxod.setItems(dat);}

        });

        ProfButtom.setOnAction(event -> {
            {AGory.setOpacity(0);
            AOtrady.setOpacity(0);
            AProfil.setOpacity(1);

            AGory.toBack();
            AOtrady.toBack();
            AProfil.toFront();
            AProfil.toFront();

            AGory.setMinSize(0, 0);
            AGory.setMaxSize(0, 0);
            AGory.setPrefSize(0, 0);

            AOtrady.setMinSize(0, 0);
            AOtrady.setMaxSize(0, 0);
            AOtrady.setPrefSize(0, 0);

            AProfil.setMinSize(722, 620);
            AProfil.setMaxSize(722, 620);
            AProfil.setPrefSize(722, 620);}



        });

        CreateGruppButtom.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Otrad.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                Stage stage = new Stage();
                stage.setTitle("New Window");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        });

    }


}
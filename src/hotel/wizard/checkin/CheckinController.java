package hotel.wizard.checkin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import hotel.wizard.dbconnection.DBHandler;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CheckinController implements Initializable {

    @FXML
    private DatePicker tanggalCheckin;
    @FXML
    private DatePicker tanggalCheckout;
    @FXML
    private JFXTextField lamaInap;
    @FXML
    private JFXTextField namaTamu;
    @FXML
    private JFXComboBox<String> jenisKelamin;
    ObservableList<String> comboGender = FXCollections.observableArrayList("Pria", "Wanita");

    @FXML
    private JFXComboBox<String> jenisIdentitas;
    ObservableList<String> comboIdentitas = FXCollections.observableArrayList("KTP", "SIM", "Paspor");

    @FXML
    private JFXTextField nomorIdentitas;
    @FXML
    private JFXButton simpan;
    @FXML
    private Label lamaInapLabel;

    @FXML
    private JFXComboBox<String> tipeKamar;
    ObservableList<String> comboTipe = FXCollections.observableArrayList("Bronze", "Silver", "Gold");

    @FXML
    private JFXComboBox<Integer> nomorKamar;
    ObservableList<Integer> comboNomor = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    @FXML
    private AnchorPane homeAnchor;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jenisKelamin.setItems(comboGender);
        jenisIdentitas.setItems(comboIdentitas);
        tipeKamar.setItems(comboTipe);
        nomorKamar.setItems(comboNomor);
        handler = new DBHandler();
    }

    @FXML
    private void simpanCheckin(ActionEvent event) throws SQLException, ParseException {

        Date tgl1 = Date.valueOf(tanggalCheckin.getValue());
        Date tgl2 = Date.valueOf(tanggalCheckout.getValue());

        String insert = "INSERT INTO `order`(`tanggal_checkin`, `tanggal_checkout`, `lama_inap`, `nama_tamu`,"
                + "`jenis_kelamin`, `jenis_identitas`, `nomor_identitas`,`tipe_kamar`,`nomor_kamar`) VALUES (?,?,?,?,?,?,?,?,?)";

        System.out.println(insert);
        connection = handler.getConnection();
        try {
            pst = connection.prepareStatement(insert);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            pst.setDate(1, tgl1);
            pst.setDate(2, tgl2);
            pst.setString(3, lamaInap.getText());
            pst.setString(4, namaTamu.getText());
            pst.setObject(5, jenisKelamin.getValue());
            pst.setObject(6, jenisIdentitas.getValue());
            pst.setString(7, nomorIdentitas.getText());
           
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
        }
        
    }


    @FXML
    private void jumlahInap(MouseEvent event) {
        Integer lama, tgl1, tgl2;
        tgl1 = tanggalCheckin.getValue().getDayOfMonth();
        tgl2 = tanggalCheckout.getValue().getDayOfMonth();
        lama = tgl2 - tgl1;
        String hari = String.valueOf(lama);
        lamaInap.setText(hari);
    }
    
    private void lihat(){
        System.out.println(tipeKamar.getValue());
    }

    @FXML
    private void lihatNilai(MouseEvent event) {
        lihat();
    }
}


package hotel.wizard.dashboard;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class DashboardController implements Initializable {

    @FXML
    private JFXButton daftarKamar;
    @FXML
    private JFXButton checkIn;
    @FXML
    private JFXButton tagihan;
    @FXML
    private ImageView avatar;
    @FXML
    private Label banner;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void daftarKamarAction(ActionEvent event) {
        
    }

    @FXML
    private void checkInAction(ActionEvent event) {
        checkIn.getScene().getWindow().hide();
        Stage menuCheckIn = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/hotel/wizard/checkin/Checkin.fxml"));
            Scene scene = new Scene(root);
            menuCheckIn.setScene(scene);
            menuCheckIn.show();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void tagihanAction(ActionEvent event) {
    }

    @FXML
    private void avatarAction(MouseEvent event) {
    }

    @FXML
    private void bannerAction(MouseEvent event) {
    }
    
}

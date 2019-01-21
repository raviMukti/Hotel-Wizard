
package hotel.wizard.dashboard;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


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
    @FXML
    private AnchorPane holderPane;
    
    AnchorPane home;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       homeKosong();
    }    

    @FXML
    private void daftarKamarAction(ActionEvent event) {
       daftarKamar();
    }

    @FXML
    private void checkInAction(ActionEvent event) {
        checkIn();
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
    
    private void setNode (Node node){
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node)node);
        
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
    private void homeKosong() {
        try {
            home = FXMLLoader.load(getClass().getResource("/hotel/wizard/home/Home.fxml"));
            setNode(home);
            
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    private void daftarKamar() {
        try {
            home = FXMLLoader.load(getClass().getResource("/hotel/wizard/kamar/DaftarKamar.fxml"));
            setNode(home);
            
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    private void checkIn() {
        try {
            home = FXMLLoader.load(getClass().getResource("/hotel/wizard/checkin/Checkin.fxml"));
            setNode(home);
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


package hotel.wizard.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import hotel.wizard.dbconnection.DBHandler;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import hotel.wizard.dashboard.Dashboard;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController implements Initializable {
    
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton login;
    @FXML
    private ImageView progress;
    
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    private Dashboard dashboard;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        progress.setVisible(false);
        username.setStyle("-fx-text-inner-color: #FAFAFA");
        password.setStyle("-fx-text-inner-color: #FAFAFA");
        
        dashboard = new Dashboard();
        handler = new DBHandler();
    }    

    @FXML
    private void loginButton(ActionEvent event) throws SQLException {
        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(ev ->{
        
            try {
                //Mengambil data pada database
                connection = handler.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        String qu = "SELECT * from user where nama=? and password=?";
            System.out.println(qu);
        try {
            pst = connection.prepareStatement(qu);
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            ResultSet result = pst.executeQuery();
            
            int count = 0;
            
            while(result.next()){
                count=count+1;
            }
            if(count==1){
                login.getScene().getWindow().hide();
                
                Stage home = new Stage();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/hotel/wizard/dashboard/Dashboard.fxml"));
                    Scene scene = new Scene(root);
                    home.setScene(scene);
                    home.show();
                } catch (IOException e) {
                }
                
            }else{
                System.out.println("User dan password salah");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("User dan password salah");
                alert.show();
                progress.setVisible(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }    
            
        });
        pt.play();
                    
    }
    
}

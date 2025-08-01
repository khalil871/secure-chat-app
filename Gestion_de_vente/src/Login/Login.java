
package Login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class Login implements Initializable{
    
    @FXML
    private MediaView mediaView;
    
    @FXML
    private ImageView image_close;
    
    
      @FXML
    private JFXTextField user1;
       @FXML
    private JFXPasswordField pass1;
       
       @FXML
    private Label label1;
       @FXML
    private VBox pane1;
     
       
      
      
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         /*
        Media media =new Media("file:///C:/Users/HP/Desktop/images.gestion/galaxy.mp4");
        MediaPlayer player =new MediaPlayer(media);
        mediaView.setMediaPlayer(player);
        player.setVolume(0);
        player.play();
        
         TranslateTransition transition =new TranslateTransition();
        transition.setDuration(Duration.seconds(3));
        transition.setNode(pane1);
        transition.setToX(-270);
        transition.play();*/
        
        
     }
    
     public void close(){
        
        System.exit(0);
      }
     public void snack(){
         
     }
     public void Login(ActionEvent e) throws IOException{
         
         
         List<Admin> list=Admin_DB.getAdmin();
				 
                Map<String, String> map = new HashMap<String, String>();
				 
				 for(Admin a:list){
				 
				     map.put(a.getUsername(), a.getPassword());}
				 
			 	 if (map.containsKey(user1.getText())) {
				
				       String val2=map.get(user1.getText());  
				
				if( val2.equals(pass1.getText()) ){
			 
			
                                
                    Parent root = FXMLLoader.load(getClass().getResource("Fentre_principale.fxml"));
                            Stage stage = new Stage();
                            Scene scene = new Scene(root);
                            stage.initStyle(StageStyle.TRANSPARENT);
                            stage.setScene(scene);
                            stage.show();
        
                    scene.getStylesheets().add(getClass().getResource("/StyleSheets/style.css").toExternalForm());
                            
                                }else{
			            label1.setText("Failed try again");}
				    }else{
				    label1.setText("Failed try again"); }
     }
    
    
    
    
}

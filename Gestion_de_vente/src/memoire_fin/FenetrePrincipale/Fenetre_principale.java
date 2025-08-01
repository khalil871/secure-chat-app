
package memoire_fin.FenetrePrincipale;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class Fenetre_principale implements Initializable{
    
    
       @FXML
    private MediaView MediaView2;


    
    @FXML
    private ImageView menu_image,menu_image2;


    
    @FXML
    private AnchorPane anchor2;
    @FXML
    private Pane Panel_02,Panel_03,Panel_01,Panel_04,Panel_05,Panel_06;
    @FXML
    private Label Client,Fournisseur;
    @FXML
    private Button btn;
    
  
    

    
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        vedio();
        traslation();
       
        
    Panel_01.setOnMouseClicked(e->{
         Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("Fenetre_vente.fxml"));
                Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(getClass().getResource("/StyleSheets/Style_Vente.css").toExternalForm());
        
            } catch (IOException ex) {
                Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    });
    Panel_02.setOnMouseClicked(e->{
                 
    Parent root;
            try {
        root = FXMLLoader.load(getClass().getResource("Fentre_change.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(getClass().getResource("/StyleSheets/Style_modifier.css").toExternalForm());

            } catch (IOException ex) {
                Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
            }
        

    });
    Panel_03.setOnMouseClicked(e->{
        Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("Fentre_stock.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                scene.getStylesheets().add(getClass().getResource("/StyleSheets/Style_Stock.css").toExternalForm());
    
            } catch (IOException ex) {
                Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    });
    Panel_04.setOnMouseClicked(e->{
        
        Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("Recherche.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    });
    Panel_05.setOnMouseClicked(e->{
        Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("FXChart.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                scene.getStylesheets().add(getClass().getResource("/StyleSheets/FXChart.css").toExternalForm());
    
            } catch (IOException ex) {
                Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        
    });
    Panel_06.setOnMouseClicked(e->{
        System.exit(0);
    });
    Client.setOnMouseClicked(e->{
        Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("Client.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                scene.getStylesheets().add(getClass().getResource("/StyleSheets/adiministra.css").toExternalForm());
    
            } catch (IOException ex) {
                Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        
        
    });
    Fournisseur.setOnMouseClicked(e->{
        Parent root;
        try {
                root = FXMLLoader.load(getClass().getResource("FOURNISSUR.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                scene.getStylesheets().add(getClass().getResource("/StyleSheets/adiministra.css").toExternalForm());
    
            } catch (IOException ex) {
                Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    });
    
   
   
      
     }
    
    public void vedio(){
        
        Media media =new Media("file:///C:/Users/HP/Desktop/images.gestion/surface.mp4");
        MediaPlayer player =new MediaPlayer(media);
        MediaView2.setMediaPlayer(player);
        player.setVolume(2);
        player.play();
    }

    
    public void traslation(){
        
        TranslateTransition transition1 =new TranslateTransition();
        transition1.setDuration(Duration.seconds(3));
        transition1.setNode(Panel_01);
        transition1.setToX(-860);
        transition1.setByY(650);
        transition1.play();
        
        TranslateTransition transition2 =new TranslateTransition();
        transition2.setDuration(Duration.seconds(3));
        transition2.setNode(Panel_02);
        transition2.setToX(-580);
        transition2.setToY(650);
        transition2.play();
        
        TranslateTransition transition3 =new TranslateTransition();
        transition3.setDuration(Duration.seconds(3));
        transition3.setNode(Panel_03);
        transition3.setToX(-300);
        transition3.setToY(650);
        transition3.play();
        
         TranslateTransition transition4 =new TranslateTransition();
        transition4.setDuration(Duration.seconds(4));
        transition4.setNode(Panel_04);
        transition4.setToX(-860);
        transition4.setToY(950);
        transition4.play();
       
          TranslateTransition transition5 =new TranslateTransition();
        transition5.setDuration(Duration.seconds(4));
        transition5.setNode(Panel_05);
        transition5.setToX(-580);
        transition5.setToY(950);
        transition5.play();
        
         TranslateTransition transition6 =new TranslateTransition();
        transition6.setDuration(Duration.seconds(4));
        transition6.setNode(Panel_06);
        transition6.setToX(-300);
        transition6.setToY(950);
        transition6.play();
    }
    
  
  
    

    

   

   
    
    


  }
    
    
    
    
    
    
    
    
    


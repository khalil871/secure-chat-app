package memoire_fin.Search_Bon;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import memoire_fin.Client.Client_1;
import memoire_fin.FxChart.FXChart;
import org.controlsfx.control.Notifications;


public class Serch_Bon implements Initializable {

    @FXML
    private StackPane MENU;
    @FXML
    private StackPane MINUS;
    @FXML
    private VBox Vbox_panel;
    @FXML
    private Button Accueil;
    @FXML
    private Button Vente;
    @FXML
    private Button Stock;
    @FXML
    private Button Statistique;
    @FXML
    private StackPane Start;
    @FXML
    private JFXCheckBox Check1;
    @FXML
    private Label Client;
    @FXML
    private Label Total;
    @FXML
    private Label Tva;
    @FXML
    private Label NbProduit;
    @FXML
    private JFXTextField N_Bon;
    @FXML
    private Label NBon;
 
    Image Attention = new Image("/Photo/Attention.png");
    @FXML
    private StackPane Remove;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    Accueil.setOnAction(e->{
        Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("Fentre_principale.fxml"));
                Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(getClass().getResource("/StyleSheets/Style_principale.css").toExternalForm());
        
            } catch (IOException ex) {
                Logger.getLogger(FXChart.class.getName()).log(Level.SEVERE, null, ex);
            }});
   Stock.setOnAction(e->{
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
                Logger.getLogger(FXChart.class.getName()).log(Level.SEVERE, null, ex);
            }});
    
    Vente.setOnAction(e->{
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
                Logger.getLogger(FXChart.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    
    Statistique.setOnAction(e->{
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
                Logger.getLogger(FXChart.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    
    Start.setOnMouseClicked(e->{
        
        if(emptyValidation(" Enter Numéro d'un Bon", N_Bon.getText().isEmpty())){    
            View();
        }
    });
    Remove.setOnMouseClicked(e->{
        
       NBon.setText(null);Client.setText(null);Tva.setText(null);NbProduit.setText(null);Total.setText(null);
 });
    
    }
    
  
    
    
    
 private void  View(){
           Search.Facture_Edentifier Pro;
        int Num =Integer.valueOf(N_Bon.getText());
        
        try {
            
            Pro = Search.getProduitnom(Num);
        NBon.setText(String.valueOf(Pro.getNum_Bon()));
        Total.setText(String.valueOf(Pro.getTotal()));
        Tva.setText(String.valueOf(Pro.getTva()));
        NbProduit.setText(String.valueOf(Pro.getNBproduit()));
        Client.setText(Pro.getClient());
       
        
        } catch (SQLException ex) {
            Logger.getLogger(Client_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 private boolean emptyValidation(String field, boolean empty) {
        if (!empty) {
            return true;
        } else {
            Notification(Attention,field,"Attention");
            return false;
        }
    }
private void Notification(Image img,String Text,String Title){
      Notifications notifications = Notifications.create()
                                     .title(Title).text(Text)
                                     .graphic(new ImageView(img)).position(Pos.CENTER);
       notifications.darkStyle();
       notifications.show();
       
   } 

    

}

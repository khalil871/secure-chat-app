package memoire_fin.Client;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.FileNotFoundException;
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
import memoire_fin.Client.Client;
import memoire_fin.FxChart.FXChart;
import org.controlsfx.control.Notifications;

public class Client_1 implements Initializable {

    @FXML
    private JFXTextField NOM;
    @FXML
    private JFXTextField PRENOM;
    @FXML
    private JFXTextField ADRESSE;
    @FXML
    private JFXTextField TELEPHONE;
    @FXML
    private JFXTextField VILLE;
    @FXML
    private JFXTextField NUM;
    @FXML
    private StackPane MENU;
    @FXML
    private StackPane MINUS;
    @FXML
    private StackPane Insert;
    @FXML
    private VBox Vbox_panel;
    @FXML
    private Button Accueil,Vente,Stock,Statistique;
    
    
    Image saveimg =new Image("/Photo/check.png");
    Image Attention = new Image("/Photo/Attention.png");
    @FXML
    private StackPane Update;
    @FXML
    private StackPane Delete;
    @FXML
    private StackPane Visible;
    @FXML
    private StackPane Invisible;
    @FXML
    private JFXComboBox Choix;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Choix.getItems().setAll("INSERT", "UPDATE", "DELETE"); 
        Choix.setValue("INSERT");
        
    Choix.setOnAction(e->{
        if(Choix.getValue().equals("INSERT")){
            Insert.setVisible(true);
            Update.setVisible(false);
            Delete.setVisible(false);
            Visible.setVisible(false);
        }else if(Choix.getValue().equals("UPDATE")){
            Update.setVisible(true);
            Insert.setVisible(false);
            Delete.setVisible(false);
            Visible.setVisible(true);
        }else if(Choix.getValue().equals("DELETE")){
            Delete.setVisible(true);
            Update.setVisible(false);
            Insert.setVisible(false);
            Visible.setVisible(true);
        }
    });
       
    Insert.setOnMouseClicked(e ->{
        
        if(emptyValidation("Numéro d'un Client", NUM.getText().isEmpty())&& emptyValidation("Nom", NOM.getText().isEmpty()) &&
            emptyValidation("Prenom", PRENOM.getText().isEmpty())&& emptyValidation("Ville", VILLE.getText().isEmpty())&& emptyValidation(" Adresse ", ADRESSE.getText().isEmpty())
            ){
       
        String nom =NOM.getText();
        String prenom = PRENOM.getText();
        String adresse =ADRESSE.getText();
        String ville =VILLE.getText();
        int num =Integer.valueOf(NUM.getText()) ;
        int telephone = Integer.valueOf(TELEPHONE.getText()) ;
        
        
         
        Client.Client_Edentifier client =new Client.Client_Edentifier();
         
           client.setNumClient(num);
           client.setNom(nom);
           client.setPrenom(prenom);
           client.setAdresse(adresse);
           client.setVille(ville);
           client.setTelephone(telephone);
           
            
            int status;

        try {
            
            status = Client.save(client);
            if (status > 0) {
                
                Notification(saveimg,"Saved successfully", " SAVE ");
                
            } else {
                Notification(Attention,"  This Number Exists \n "+" Please Enter another name ! ", " SAVE ");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
         
         
     });
    
    Update.setOnMouseClicked(e->{
        
         String nom =NOM.getText();
         String prenom =PRENOM.getText();
         String ville =VILLE.getText();
         String adresse =ADRESSE.getText();
         int num =Integer.valueOf(NUM.getText());
         int telephone =Integer.valueOf(TELEPHONE.getText());
         
         Client.Client_Edentifier client=new Client.Client_Edentifier();
         
          client.setNumClient(num);
          client.setTelephone(telephone);
          client.setNom(nom);
          client.setPrenom(prenom);
          client.setAdresse(adresse);
          client.setVille(ville);
          
          int status=Client.update(client); 
	 if(status>0){  
					 
              Notification(saveimg,"update successfully!" , " UPDATE " );
		        	
		  
}else{ 
	Notification(Attention,"Sorry! unable to update record" , " UPDATE " );	        	
		        	
		        	
		        }
    });
    
    Delete.setOnMouseClicked(e->{
        
       int Num=Integer.parseInt(NUM.getText());   
				
	    Client.delete(Num) ;
		
                int status=  Client.delete(Num) ;
		    if(status>0){  
			Notification(saveimg,"error has been created \n"," DELETE ");	
			      
		    }else{ 
			Notification(Attention," successfully Deleted \n"," DELETE ");
                    } 
     });
  
    
    Visible.setOnMouseClicked(e ->{
        Image img = new Image("/Photo/attentionchek.png");
        
        if(emptyValidation(" Enter Numéro d'un Client", NUM.getText().isEmpty())){    
            Visible.setVisible(false);
            Invisible.setVisible(true);
            View();
        }
        });
    
    Invisible.setOnMouseClicked(e ->{
        Invisible.setVisible(false);
        Visible.setVisible(true);
        Clear();
    });
   
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

    
    private void  View(){
           Client.Client_Edentifier Pro;
        int Num =Integer.valueOf(NUM.getText());
        
        try {
            Pro = Client.getProduitnom(Num);
        NUM.setText(String.valueOf(Pro.getNumClient()));
        TELEPHONE.setText(String.valueOf(Pro.getTelephone()));
        PRENOM.setText(Pro.getPrenom());
        NOM.setText(Pro.getNom());
        ADRESSE.setText(Pro.getAdresse());
        VILLE.setText(Pro.getVille());
        
        } catch (SQLException ex) {
            Logger.getLogger(Client_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   private void Clear(){
       NUM.clear();NOM.clear();PRENOM.clear();ADRESSE.clear();TELEPHONE.clear();VILLE.clear();
    }

}

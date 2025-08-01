package memoire_fin.Fournissuer;

import memoire_fin.Client.Client_1;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import memoire_fin.Fournissuer.Fournisseur_1;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FOURNISSUR implements Initializable {

    @FXML
    private AnchorPane INSERER;
    @FXML
    private JFXTextField NUM;
    @FXML
    private JFXTextField NOM;
    @FXML
    private JFXTextField PRENOM;
    @FXML
    private JFXTextField VILLE;
    @FXML
    private JFXTextField ADRESSE;
    @FXML
    private JFXTextField EMAIL;
    @FXML
    private JFXTextField CODEPOSTAL;
    @FXML
    private JFXTextField TELEPHONE;
    @FXML
    private JFXTextField MOBILE;
    @FXML
    private JFXTextField FAX;
    @FXML
    private JFXButton Insert;
    @FXML
    private JFXButton delete,update;
    @FXML
    private JFXButton View;
    
    Image saveimg =new Image("/Photo/check.png");
    Image errimg =new Image("/Photo/attentionchek.png");
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     Insert.setOnAction(e ->{
       
         if(emptyValidation(" Numéro de fourniseur ", NUM.getText().isEmpty()) || emptyValidation(" Nom ", NOM.getText().isEmpty()) || emptyValidation("Prenom", PRENOM.getText().isEmpty())
           || emptyValidation(" Adresse ", ADRESSE.getText().isEmpty())){
        String nom =NOM.getText();
        String prenom = PRENOM.getText();
        String adresse =ADRESSE.getText();
        String email =EMAIL.getText();
        String ville =VILLE.getText();
        int num =Integer.valueOf(NUM.getText()) ;
        int telephone = Integer.valueOf(TELEPHONE.getText()) ;
        int  mobil = Integer.valueOf(MOBILE.getText()) ;
        int fax = Integer.valueOf(FAX.getText()) ;
        int code = Integer.valueOf(CODEPOSTAL.getText()) ;
        
        
         
        Fournisseur_1.Fournisseur_Edentifier fournisseur =new Fournisseur_1.Fournisseur_Edentifier();
         
           fournisseur.setNumfournisseur(num);
           fournisseur.setNom(nom);
           fournisseur.setPrenom(prenom);
           fournisseur.setAdresse(adresse);
           fournisseur.setEmail(email);
           fournisseur.setVille(ville);
           fournisseur.setTelephone(telephone);
           fournisseur.setMobile(mobil);
           fournisseur.setFax(fax);
           fournisseur.setCodePostal(code);
           
            
            int status;

        try {
            
            status = Fournisseur_1.save(fournisseur);
            if (status > 0) {
                
                Notification(saveimg,"Saved successfully", " SAVE ");
                
            } else {
                Notification(errimg,"  This Number Exists \n "+" Please Enter another name ! ", " SAVE ");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client_1.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         }   
        
      });
    View.setOnAction(e ->{
        
        Fournisseur_1.Fournisseur_Edentifier Pro;
        int Num =Integer.valueOf(NUM.getText());
        
        try {
            Pro = Fournisseur_1.getProduitnom(Num);
        NUM.setText(String.valueOf(Pro.getNumFournisseur()));
        TELEPHONE.setText(String.valueOf(Pro.getTelephone()));
        MOBILE.setText(String.valueOf(Pro.getMobile()));
        CODEPOSTAL.setText(String.valueOf(Pro.getCodePostal()));
        FAX.setText(String.valueOf(Pro.getFax()));
        PRENOM.setText(Pro.getPrenom());
        NOM.setText(Pro.getNom());
        ADRESSE.setText(Pro.getAdresse());
        EMAIL.setText(Pro.getEmail());
        VILLE.setText(Pro.getVille());
        
        } catch (SQLException ex) {
            Logger.getLogger(Client_1.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    });
    
    delete.setOnAction(e->{
        
	int Num=Integer.parseInt(NUM.getText());   
				
	    Fournisseur_1.delete(Num) ;
		
                int status=  Fournisseur_1.delete(Num) ;
		    if(status>0){  
			Notification(saveimg,"error has been created \n"," DELETE ");	
			      
		    }else{ 
			Notification(errimg," successfully Deleted \n"," DELETE ");
                    }
        
        
        
        
    });
    update.setOnAction(e->{
         
         
         String nom =NOM.getText();
         String prenom =PRENOM.getText();
         String ville =VILLE.getText();
         String adresse =ADRESSE.getText();
         String email =EMAIL.getText();
         int num =Integer.valueOf(NUM.getText());
         int telephone =Integer.valueOf(TELEPHONE.getText());
         int mobil =Integer.valueOf(MOBILE.getText());
         int fax =Integer.valueOf(FAX.getText());
         int code =Integer.valueOf(CODEPOSTAL.getText());
         
         Fournisseur_1.Fournisseur_Edentifier pro=new Fournisseur_1.Fournisseur_Edentifier();
         
          pro.setNumfournisseur(num);
          pro.setTelephone(telephone);
          pro.setMobile(mobil);
          pro.setFax(fax);
          pro.setCodePostal(code);
          pro.setNom(nom);
          pro.setPrenom(prenom);
          pro.setAdresse(adresse);
          pro.setVille(ville);
          pro.setEmail(email);
          
          int status=Fournisseur_1.update(pro); 
	 if(status>0){  
					 
              Notification(saveimg,"update successfully!" , " UPDATE " );
		        	
		  
}else{ 
	Notification(errimg,"Sorry! unable to update record" , " UPDATE " );	        	
		        	
		        	
		        }
          
        
    });
       
    }
    
    
   
    
    


public void Notification(Image img,String Text,String Title ){
      Notifications notifications = Notifications.create()
                                     .title(Title).text(Text)
                                     .graphic(new ImageView(img)).position(Pos.CENTER);
       notifications.darkStyle();
       notifications.show();
       
   }
 private boolean emptyValidation(String field, boolean empty) {
        if (!empty) {
            return true;
        } else {
            validationAlert(field, true);
            return false;
        }
    }
 private void validationAlert(String field, boolean empty) {
           
        

        if (empty) {
            Notification(errimg, "Please Enter " + field, "Validation Error");
        } else {
            Notification(errimg, "Please Enter Valid " + field, "Validation Error");
        }
}
    
}

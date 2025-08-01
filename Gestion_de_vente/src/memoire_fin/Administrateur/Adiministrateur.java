/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoire_fin.Administrateur;

import memoire_fin.Fentre_Stock.Fentre_Stock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import memoire_fin.Fentre_Change.DB_Produit;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Adiministrateur implements Initializable {

    @FXML
    private Label NOM;
    @FXML
    private Label PRENOM;
    @FXML
    private Label EMAIL;
    @FXML
    private Label ADRESSE;
    @FXML
    private Label TEL;
    @FXML
    private Label ANNEE;
    Stage stage;
    @FXML
    private ImageView IMage;
     Connection conn = DB_Produit.getConnection();
    PreparedStatement ps = null ;
    @FXML
    private Label date;
    @FXML
    private Label city;
    @FXML
    private Label Date;
    @FXML
    private Label City;
    @FXML
    private Label fax;
    @FXML
    private Label TEL1;
    @FXML
    private Label Tfax;
    @FXML
    private Label TEL11;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affiche();
    }
  @FXML
    private void Exit(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void affiche(){
        
         try {
                 
            String query ="SELECT * FROM `admin` WHERE 1";
                ps =conn.prepareStatement(query);
                
            ResultSet rs =ps.executeQuery();
                while(rs.next()){
                    
                    NOM.setText(rs.getString("First Name"));
                    PRENOM.setText(rs.getString("Last Name"));
                    Date.setText(rs.getString("Dob"));
                    City.setText(rs.getString("City"));
                    EMAIL.setText(rs.getString("EMAIL"));
                    ADRESSE.setText(rs.getString("ADRESSE"));
                    TEL.setText(rs.getString("TELEPHONE"));
                    Tfax.setText(rs.getString("Fax"));
                   
                    
                    InputStream is =rs.getBinaryStream("Image");
                    OutputStream os =new FileOutputStream(new File("photo.jpg"));
                    byte [] content =new byte[1024];
                    int size =0;
                    while((size = is.read(content)) != -1){
                        os.write(content, 0, size);
                }
                os.close();
                is.close();
                    Image image =new Image("file:photo.jpg", 250, 350, true, true);
                    IMage.setImage(image);
                    IMage.setPreserveRatio(true);
                }
                ps.close();
                rs.close();
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(Fentre_Stock.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
            Logger.getLogger(Fentre_Stock.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Fentre_Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}

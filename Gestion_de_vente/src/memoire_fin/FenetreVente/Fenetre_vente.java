package memoire_fin.FenetreVente;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import memoire_fin.Client.Client;
import memoire_fin.Fentre_Change.DB_Produit;
import memoire_fin.Fournissuer.Fournisseur_1;
import memoire_fin.Fentre_Change.Produit;
import memoire_fin.Client.Client_1;
import memoire_fin.Fentre_Stock.Fentre_Stock;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;

public class Fenetre_vente implements Initializable {


    @FXML
    private Pane pane_v;
    @FXML
    private JFXTextField brand,quantite, pu, vergul1, totale, vergul2,Ram, annonced, stockage
            ,client1,client,quantite1,pu1,vergul11,totale1,vergul21,TVA;
    @FXML
    private HBox barretitre,print,HBOXAchat,print1,HBOXVente,Exit_Anchor;
    @FXML
    private Label Label_Question,nb;
    @FXML
    private JFXButton Ajoute,change,Ajoute1,btn3,btn1, btn2;
    @FXML
    private ImageView IMageView,IMageView1;
    @FXML
    private Label label_tva,label_tva1,bon,Label_Question1,nb1;
    @FXML
    private AnchorPane ANCHOR,Fentre2,Fentre1;
    @FXML
    private JFXDatePicker DATE,DATE1;
    @FXML
    private JFXListView list1,list2,list11,list21;
    @FXML
    private Pane Min,Exit;
    
     Connection conn = DB_Produit.getConnection();
    PreparedStatement ps;
    ObservableList LIST1 = FXCollections.observableArrayList();
    int total = 0;
    int total1 = 0;
    int mun,plus ;
    
    Stage stage = null;
    Image saveimg =new Image("/Photo/check.png");
    Image errimg =new Image("/Photo/attentionchek.png");
    @FXML
    private Label Liste1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList List;
        
        try {
            List = DB_Produit.GetAutoName();
            TextFields.bindAutoCompletion(brand, List);
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_vente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        autotextfieldclient();
        autotextfieldfornisseur();
        try {
            GetNumFacture();
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_vente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        Label_Question.setOnMouseClicked(e -> {
          /*  Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING ALERT");
            alert.setHeaderText(null);
            alert.setContentText("ARE YOU SHURE TO CHANGE TVA ?");
            alert.showAndWait();
*/
            ANCHOR.setVisible(true);
            Fentre1.setOpacity(0.2);
            Fentre2.setOpacity(0.2);

        });
        change.setOnAction(e -> {
            label_tva.setText(TVA.getText());
            ANCHOR.setVisible(false);

        });
        btn3.setOnAction(e -> {
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
                Logger.getLogger(Fenetre_vente.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
       print.setOnMouseClicked(e->{
          /* String query ="C:\\Users\\HP\\Documents\\NetBeansProjects\\Mémoire Fin etude\\src\\IReport\\IReport.jrxml";
             try {
                 JasperReport report = JasperCompileManager.compileReport(query);
                 HashMap<String,Object> map = new HashMap<>();
                 map.put("Total", totale.getText());
                 ArrayList<Product> list = new ArrayList<Product>();
                 JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(list);
                 JasperPrint print = JasperFillManager.fillReport(report, map, source);
                 JasperViewer.viewReport(print);
                 
             } catch (JRException ex) {
                 Logger.getLogger(Fenetre_vente.class.getName()).log(Level.SEVERE, null, ex);
             }
           */
       });
       
    Ajoute.setOnAction(e->{
       
        String cliente =client.getText();
        String date = this.DATE.getEditor().getText();
        int NUM_BON = Integer.valueOf(bon.getText());
        int tva = Integer.valueOf(label_tva.getText()) ;
        int nombre = Integer.valueOf(nb.getText()) ;
        int total = Integer.valueOf(totale.getText()) ;
        
        
        
         
        Facture_1.DB_Facture client =new Facture_1.DB_Facture();
          
           client.setclient(cliente);
           client.setDate(date);
           client.setNum_produit(NUM_BON);
           client.setTva(tva);
           client.setNb_produit(nombre);
           client.setMountant(total);
          
           
           int status;

        try {
            
            status = Facture_1.InsertFacture(client);
            if (status > 0) {
                
                Notification(saveimg,"Saved successfully", " SAVE ");
                
            } else {
                Notification(errimg,"  This Number Exists \n "+" Please Enter another name ! ", " SAVE ");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    
    HBOXAchat.setOnMouseClicked(e ->{
        Fentre1.setVisible(false);
        Fentre2.setVisible(true);
        btn1.setVisible(false);
        btn2.setVisible(true);
        Clear2();
    });
    HBOXVente.setOnMouseClicked(e ->{
        Fentre1.setVisible(true);
        Fentre2.setVisible(false);
        btn2.setVisible(false);
        btn1.setVisible(true);
        Clear();
        
    });
    Exit.setOnMouseClicked(e ->{
      stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    });
    Min.setOnMouseClicked(e ->{
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setIconified(true);
    });
    btn1.setOnAction(e->{
        
        try {

            String query = "select * from appareil where nom_appareil = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, brand.getText());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                brand.setText(rs.getString("nom_appareil"));
                Ram.setText(rs.getString("CARD SLOT"));
                annonced.setText(rs.getString("Annonced"));
                quantite.setText(rs.getString("QUANTITE"));
                mun = Integer.parseInt(quantite.getText()); 
                stockage.setText(rs.getString("INTERNAL"));
                pu.setText(rs.getString("PRIX"));
                

                InputStream is = rs.getBinaryStream("Image");
                OutputStream os = new FileOutputStream(new File("photo.jpg"));
                byte[] content = new byte[1024];
                int size = 0;
                while ((size = is.read(content)) != -1) {
                    os.write(content, 0, size);
                }
                os.close();
                is.close();
                Image image = new Image("file:photo.jpg", 250, 350, true, true);
                IMageView.setImage(image);
                IMageView.setPreserveRatio(true);
                
                
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
        
    });
    btn2.setOnAction(e->{
        
        try {

            String query = "select * from appareil where nom_appareil = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, brand.getText());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                brand.setText(rs.getString("nom_appareil"));
                Ram.setText(rs.getString("CARD SLOT"));
                annonced.setText(rs.getString("Annonced"));
                quantite1.setText(rs.getString("QUANTITE"));
                mun = Integer.parseInt(quantite.getText()); 
                stockage.setText(rs.getString("INTERNAL"));
                pu1.setText(rs.getString("PRIX"));
                

                InputStream is = rs.getBinaryStream("Image");
                OutputStream os = new FileOutputStream(new File("photo.jpg"));
                byte[] content = new byte[1024];
                int size = 0;
                while ((size = is.read(content)) != -1) {
                    os.write(content, 0, size);
                }
                os.close();
                is.close();
                Image image = new Image("file:photo.jpg", 250, 350, true, true);
                IMageView1.setImage(image);
                IMageView1.setPreserveRatio(true);
                
                
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
    });
    Exit_Anchor.setOnMouseClicked(e->{
         ANCHOR.setVisible(false);
         Fentre1.setOpacity(1);
         Fentre2.setOpacity(1);
    });
    
    }
    private void Montant() {
      //  String produit;
   ObservableList    list = FXCollections.observableArrayList();
    ObservableList   list_1 = FXCollections.observableArrayList();
        
        list1.getSelectionModel().selectLast();
        

        int prix, montant;

        int nombre, nombreproduit;

        String produit = brand.getText();
        prix = Integer.parseInt(pu.getText());
        nombre = Integer.parseInt(quantite.getText());

        montant = prix * nombre;
        
        list.addAll(produit);
        list_1.addAll(String.valueOf(montant));
      
        
       // list1.getItems().addAll(list);
       // list2.getItems().addAll(list_1);
       
       
        
        nombreproduit = list1.getSelectionModel().getSelectedIndex();
        nb.setText(String.valueOf(nombreproduit+1));
      
      
        total = total + montant;
        totale.setText(String.valueOf(total));
        
        
    }
    
    // fait les calcules de vente .......
    @FXML
    private void Calcule(KeyEvent e) throws SQLException {
        
        list1.getSelectionModel().selectLast();
        
        
         if(e.getCode() == KeyCode.ENTER){
            int Quntite =getquantite();
              if(DATE.getEditor().getText().isEmpty() || client.getText().isEmpty()){
                  Notification(errimg," ERROR ", " PLEASE ! ENTER DATE AND NAME ");
              }else if(stop()){
              Montant();
              munis(Quntite); 
             
              
              }}
        
       else if(e.getCode() == KeyCode.DELETE){
           
             plus(plus);
       
            }
    }
    private void Delete(){
        
        
        
          
        
        
        
        
        
        /*

        list1.getSelectionModel().selectFirst();
         C_list = (String) list1.getSelectionModel().getSelectedItem();
        list1.getSelectionModel().selectNext(); 
         C_list1 = (String) list1.getSelectionModel().getSelectedItem();
        
        if(C_list.equals(C_list1)){
            client.setText("secces !");
        }
        */
        
        
        
        /*
        
        // moins total 
        list1.getSelectionModel().selectFirst();
        C_list = (String) list1.getSelectionModel().getSelectedItem();
        list1.getSelectionModel().selectNext();
        C_list1 = (String) list1.getSelectionModel().getSelectedItem();
        if(C_list.equals(C_list1)){
           
        }
        */
        
        
        
        
        
        
       /*     
        list2.getSelectionModel().selectLast();
        M_list = (String) list2.getSelectionModel().getSelectedItem(); 
        int mlist =Integer.valueOf(M_list);
        int TOTAL = Integer.valueOf(totale.getText());
        TOTAL = TOTAL-mlist;
        totale.setText(String.valueOf(TOTAL));
        */
                 
            
             
        
        
        
        
        
        
    }
    
    private void munis(int Qunt){
        int muns1 =Integer.parseInt(quantite.getText());
        //mun = mun-muns1;
        
         Qunt =Qunt - muns1;
       String Name = brand.getText();
         
	Produit pro=new Produit();
          pro.setName(Name);
          pro.setQuantite(Qunt);
           
          
          int status=DB_Produit.update_Quantite(pro);
   
		        }
    private void plus(int Qunt){
       int plus =Integer.parseInt(quantite1.getText());
        //mun = mun-muns1;
        
         Qunt =Qunt + plus;
        String Name = brand.getText();
         
	Produit pro=new Produit();
          pro.setName(Name);
          pro.setQuantite(Qunt);
           
          
          int status=DB_Produit.update_Quantite(pro);
		        }
    
      public int getquantite() throws SQLException{
          int Quantite =0;
      
      String SQL ="SELECT `QUANTITE` FROM `appareil` WHERE `nom_appareil` =?";
      
            Connection con =DB_Produit.getConnection();
            
        
            PreparedStatement  ps =con.prepareStatement(SQL);
            ps.setString(1, brand.getText());
            
            ResultSet rs =ps.executeQuery();
                while(rs.next()){
                    
                    Quantite = rs.getInt("QUANTITE");
                
      
  }
                ps.close();
                rs.close();
                con.close();
     
   return Quantite;
  }
  
    private boolean stop() throws SQLException{
         int Q =getquantite();
         
         if(Q <= 0){
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING ALERT");
            alert.setHeaderText(null);
            alert.setContentText("Your QUNITITE ARE NULL "+Q);
            alert.getOnHidden();
            alert.showAndWait();
            return false;
         }else return true;
         
        
        
     }
    public void Notification(Image img,String Title,String Text){
       Notifications notifications = Notifications.create()
                                     .title(Title).text(Text)
                                     .graphic(new ImageView(img)).position(Pos.CENTER);
       notifications.darkStyle();
       notifications.show();
       
   }
    public void NotificationAlert(String Title,String Text){
       Image img = new Image("/Photo/spam.png");
       Notifications notifications = Notifications.create()
                                     .title(Title).text(Text)
                                     .graphic(new ImageView(img)).position(Pos.CENTER)
                                     .darkStyle();
       notifications.showConfirm();
       
   }
     @FXML
    private void CalculeAchat(KeyEvent e) throws SQLException {
        
      
        if(e.getCode() == KeyCode.ENTER){
            int Quntite =getquantite();
              if(DATE1.getEditor().getText().isEmpty() || client1.getText().isEmpty()){
                  Notification(errimg," ERROR ", " PLEASE ! ENTER DATE AND NAME ");
              }else{
              MontantAchat();
              plus(Quntite); 
              }
           
           
        }
        
       else if(e.getCode() == KeyCode.DELETE){
           
           double montant,totall;
           int index,nombre,convert;
           totall = Integer.parseInt(totale.getText());
           convert = Integer.parseInt(pu.getText());
            
           index = Integer.parseInt((String) list2.getSelectionModel().getSelectedItem());
        totall = totall - index;
        totale.setText(String.valueOf(totall));
        list2.getSelectionModel().selectLast();
        
        
           /*liste2.getSelectionModel().selectFirst();
 	    String ind = (String) liste2.getSelectionModel().getSelectedItem();
            index = Integer.parseInt(ind);
            totall = totall-index;
            totale.setText(String.valueOf(totall));*/
            }
        
        
        
    }

    private void Clear(){
        brand.clear();Ram.clear();annonced.clear();stockage.clear();bon.setText("");
        client.clear();quantite.clear();pu.clear();totale.clear();DATE.getEditor().setText("");
        IMageView.setImage(null);
    }
    private void Clear2(){
        brand.clear();Ram.clear();annonced.clear();stockage.clear();
        client1.clear();quantite1.clear();pu1.clear();totale1.clear();DATE1.getEditor().setText("");
        IMageView1.setImage(null);
    }
    
     private void autotextfieldclient(){
        
                  ObservableList Liste;
        try {
            Liste = Client.GetAutoName();
            TextFields.bindAutoCompletion(client, Liste);
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_vente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void autotextfieldfornisseur(){
        
                  ObservableList Liste;
        try {
            Liste = Fournisseur_1.GetAutoName();
            TextFields.bindAutoCompletion(client1, Liste);
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_vente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void GetNumFacture() throws SQLException{
        
        int Num = Facture_1.getIdFacture();
        bon.setText(String.valueOf(Num));
    }
    
    
    private void MontantAchat() {
        String produit;
        ObservableList list = FXCollections.observableArrayList();
        ObservableList list_1 = FXCollections.observableArrayList();

        int prix, montant;

        int nombre, nombreproduit;

        produit = brand.getText();
        prix = Integer.parseInt(pu1.getText());
        nombre = Integer.parseInt(quantite1.getText());

        montant = prix * nombre;

        list.addAll(produit);
        list11.getItems().addAll(list);
        list_1.addAll(String.valueOf(montant));
        list21.getItems().addAll(list_1);

        // nombreproduit = (int) list1.getSelectionModel().getSelectedItem();
      //  nb.setText(String.valueOf(nombreproduit));
        total1 = total1 + montant;
        totale1.setText(String.valueOf(total1));
    }
     
    }
    




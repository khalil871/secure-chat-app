package memoire_fin.Recherche;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import memoire_fin.Fentre_Change.DB_Produit;
import memoire_fin.Fentre_Stock.User;


public class Recherche implements Initializable {
    
    Stage stage =null;
    @FXML
    private JFXComboBox brand,network,size,multiple,os,ram,notch,nfc;
    @FXML
    private JFXTextField  rcamera,selfie;
    @FXML
    private JFXButton refuse,go;
    @FXML
    private Label label;
    final ObservableList<User> data = FXCollections.observableArrayList();
    @FXML
    private AnchorPane anchor2,anchor1;
    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, String> Clmn1,Clmn2,Clmn3,Clmn4,Clmn5,Clmn6,Clmn7,Clmn8,Clmn9,Clmn10,Clmn11,Clmn12,Clmn13;
    
 
   
     
       private void Combo(){
    ObservableList List = FXCollections.observableArrayList("YES","NO");
       
        notch.setItems(List);
        nfc.setItems(List);
        brand.getItems().setAll("SAMSUNG", "APPLE", "LG", "HTC", "MOTOROLA", "XIAOMI", "CONDOR", "HUAWEI", "NOKIA", "SONY", "MOTOROLLA", "LENOVO", "GOOGLE", "HONOR", "OPPO", "REALME", "ONE PLUS", "VIVO", "MEIZU", "BLACKBERRY", "ASUS", "ALCATEL", "ZTE", "ACER");
        multiple.getItems().setAll("One Sim", "Dual SIM", "Triple SIM", "Quad SIM");
        size.getItems().setAll("3.0", "4.0", "5.0", "6.0", "7.0", "8.0", "9.0", "10.0", "11.0", "Other");
        os.getItems().setAll("Android", "Ios", "Windows", "BlackBerry", "Other");
        network.getItems().setAll("NONE", "avec 3G", "avec 4G", "avec 5G");
        ram.getItems().setAll("4", "6", "8", "10", "12", "16");
}
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    refuse.setOnAction(e->{
        brand.getSelectionModel().clearSelection();
        os.getSelectionModel().clearSelection();
        ram.getSelectionModel().clearSelection();
        network.getSelectionModel().clearSelection();
        size.getSelectionModel().clearSelection();
        multiple.getSelectionModel().clearSelection();
        notch.getSelectionModel().clearSelection();
        rcamera.clear();
        selfie.clear();
        
         });
    go.setOnAction(e ->{
        anchor2.setVisible(true);
        anchor1.setOpacity(0.2);
   });
    Combo();
    ViewData();
    //getData();
        
  
        
    
    }    

    @FXML
    private void Exit(MouseEvent event) {
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    private void ViewData(){
        
        Clmn1.setCellValueFactory(new PropertyValueFactory<>("id"));
        Clmn2.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Clmn3.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        Clmn4.setCellValueFactory(new PropertyValueFactory<>("technologie"));
        Clmn5.setCellValueFactory(new PropertyValueFactory<>("Size"));
        Clmn6.setCellValueFactory(new PropertyValueFactory<>("Multiple"));
        Clmn7.setCellValueFactory(new PropertyValueFactory<>("Os"));
        Clmn8.setCellValueFactory(new PropertyValueFactory<>("Ram"));
        Clmn9.setCellValueFactory(new PropertyValueFactory<>("Nfc"));
        Clmn10.setCellValueFactory(new PropertyValueFactory<>("Notch"));
        Clmn11.setCellValueFactory(new PropertyValueFactory<>("Rearcamera"));
        Clmn12.setCellValueFactory(new PropertyValueFactory<>("Selfiecamera"));
        Clmn13.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
        
        
        try {
            Connection conn = DB_Produit.getConnection();
            // String SQL ="select * from admin";
            //  PreparedStatement    prepared = conn.prepareStatement(SQL);
            //  rs = prepared.executeQuery();
            ResultSet rs = conn.createStatement().executeQuery("select * from appareil");

       
            
            while (rs.next()) {
                data.add(new User(
                        
                        rs.getString("id_appareil"),
                        rs.getString("nom_appareil"),
                        rs.getString("RAM"),
                        rs.getString("QUANTITE"),
                        rs.getString("PRIX"),
                        rs.getString("TECHNOLOGIE"),
                        rs.getString("SIZE"),
                        rs.getString("SIM MULTIPLY"),
                        rs.getString("OS"),
                        rs.getString("NFC"),
                        rs.getString("NOTCH"),
                        rs.getString("Rear Camera"),
                        rs.getString("Selfie Camera")
                        
                  ));

            }
            table.setItems(data);
            //   prepared.close();
            rs.close();
        } catch (SQLException ex) {}
      
    }}

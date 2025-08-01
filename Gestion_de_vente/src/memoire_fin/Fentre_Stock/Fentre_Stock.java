package memoire_fin.Fentre_Stock;

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import memoire_fin.Fentre_Change.DB_Produit;

public class Fentre_Stock implements Initializable {

    Stage stage = null;

    @FXML
    private TableView<User> Table;

    final ObservableList<User> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<User, String> clmn1;
    @FXML
    private TableColumn<User, String> clmn2;
    @FXML
    private TableColumn<User, String> clmn3;
    @FXML
    private TableColumn<User, String> clmn4;
    @FXML
    private TableColumn<User, String> clmn5;
    @FXML
    private TableColumn<User, String> clmn6;
    @FXML
    private TableColumn<User, String> clmn7;
    @FXML
    private TableColumn<User, String> clmn8;
    @FXML
    private TableColumn<User, String> clmn9;
    @FXML
    private TableColumn<User, String> clmn10;
    @FXML
    private TableColumn<User, String> clmn11;
    @FXML
    private TableColumn<User, String> clmn12;
    @FXML
    private TextField search;
    @FXML
    private Label lb1,lb2,lb3,lb4,lb5,lb6,lb7;
    
    Connection conn = DB_Produit.getConnection();
    PreparedStatement ps ;
    private ImageView imageView;
    @FXML
    private Button home,user,vente,update;
    @FXML
    private Circle circle1;
    
    
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        View_Data();
        
    home.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Fentre_principale.fxml"));
                Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(getClass().getResource("/StyleSheets/Style_principale.css").toExternalForm());
       
            } catch (IOException ex) {
                Logger.getLogger(Fentre_Stock.class.getName()).log(Level.SEVERE, null, ex);
            }});
    vente.setOnAction(e->{
        try {
                Parent root = FXMLLoader.load(getClass().getResource("Fenetre_vente.fxml"));
                Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(getClass().getResource("/StyleSheets/Style_Vente.css").toExternalForm());
       
            } catch (IOException ex) {
                Logger.getLogger(Fentre_Stock.class.getName()).log(Level.SEVERE, null, ex);
            }
    });
     update.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Fentre_change.fxml"));
                Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(getClass().getResource("/StyleSheets/Style_modifier.css").toExternalForm());
       
            } catch (IOException ex) {
                Logger.getLogger(Fentre_Stock.class.getName()).log(Level.SEVERE, null, ex);
            }});
     user.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Adiministrateur.fxml"));
                Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(getClass().getResource("/StyleSheets/adiministra.css").toExternalForm());
       
            } catch (IOException ex) {
                Logger.getLogger(Fentre_Stock.class.getName()).log(Level.SEVERE, null, ex);
            }});
     
   
    
        
      
     

    }

    public void View_Data() {

        clmn1.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmn2.setCellValueFactory(new PropertyValueFactory<>("Name"));
        clmn3.setCellValueFactory(new PropertyValueFactory<>("Annonced"));
        clmn4.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        clmn5.setCellValueFactory(new PropertyValueFactory<>("Color"));
        clmn6.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        clmn7.setCellValueFactory(new PropertyValueFactory<>("Rearcamera"));
        clmn8.setCellValueFactory(new PropertyValueFactory<>("Selfiecamera"));
        clmn9.setCellValueFactory(new PropertyValueFactory<>("ram"));
        clmn10.setCellValueFactory(new PropertyValueFactory<>("cpu"));
        clmn11.setCellValueFactory(new PropertyValueFactory<>("size"));
        clmn12.setCellValueFactory(new PropertyValueFactory<>("battery"));

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
                        rs.getString("Annonced"),
                        rs.getString("QUANTITE"),
                        rs.getString("Colors"),
                        rs.getString("PRIX"),
                        rs.getString("Rear Camera"),
                        rs.getString("Selfie Camera"),
                        rs.getString("RAM"),
                        rs.getString("CPU"),
                        rs.getString("SIZE"),
                        rs.getString("BATTERY")
                        
                        
                ));

            }
            //   prepared.close();
            rs.close();
        } catch (SQLException ex) {
        }

        Table.setItems(data);

    }
    @FXML
    private void Min(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void Exit(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void SearchData(KeyEvent Ke) {
        FilteredList<User> filteredData = new FilteredList<>(data, p -> true);
        search.textProperty().addListener((observable, oldvalue, newvalue) -> {
            filteredData.setPredicate(pers -> {

                if (newvalue == null || newvalue.isEmpty()) {
                    return true;
                }
                String typedtext = newvalue.toLowerCase();

                if (pers.getId().toLowerCase().indexOf(typedtext) != -1) {
                    return true;
                }
                if (pers.getName().toLowerCase().indexOf(typedtext) != -1) {
                    return true;
                }
                if (pers.getAnnonced().toLowerCase().indexOf(typedtext) != -1) {
                    return true;
                }
                if (pers.getQuantite().toLowerCase().indexOf(typedtext) != -1) {
                    return true;
                }
                if (pers.getColor().toLowerCase().indexOf(typedtext) != -1) {
                    return true;
                }
                if (pers.getPrix().toLowerCase().indexOf(typedtext) != -1) {
                    return true;
                }

                return false;

            });
            SortedList<User> sortedList = new SortedList<>(filteredData);
            sortedList.comparatorProperty().bind(Table.comparatorProperty());
            Table.setItems(sortedList);

        });

    }

    @FXML
    private void SELECT(MouseEvent event) {
                   
            try {
                 User user =(User)Table.getSelectionModel().getSelectedItem();
           
            String query ="select * from appareil where id_appareil = ?";
                ps =conn.prepareStatement(query);
                ps.setString(1, user.getId());
            ResultSet rs =ps.executeQuery();
                while(rs.next()){
                    
                    lb1.setText(rs.getString("size"));
                    lb2.setText(rs.getString("CARD SLOT"));
                    lb3.setText(rs.getString("Rear Camera"));
                    lb4.setText(rs.getString("Selfie Camera"));
                    lb5.setText(rs.getString("RAM"));
                    lb6.setText(rs.getString("CPU"));
                    lb7.setText(rs.getString("BATTERY"));
                    
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
                    imageView.setImage(image);
                    imageView.setPreserveRatio(true);
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


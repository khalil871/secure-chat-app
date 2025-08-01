package memoire_fin.FxChart;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import memoire_fin.Fentre_Change.DB_Produit;
import memoire_fin.Fentre_Stock.User;

public class FXChart implements Initializable {

    

    
    
    
    ObservableList<PieChart.Data> list1,list2,list3;
    ObservableList list4;
    
    
    User user;
    Connection conn = DB_Produit.getConnection();
    PreparedStatement ps= null;
    @FXML
    private JFXTextField name,value;
    
    String QUANTITE="QUANTITE";
    String prix = "PRIX";
    String internal ="INTERNAL";
    @FXML
    private PieChart piechart1,piechart2,piechart3;
    @FXML
    private JFXTextField os,id;
    @FXML
    private BarChart barchart;
    @FXML
    private NumberAxis YAxis;
    @FXML
    private CategoryAxis XAxis;
    
   
    XYChart.Series samsung =new XYChart.Series();
    XYChart.Series apple =new XYChart.Series();
    XYChart.Series lg =new XYChart.Series();
    XYChart.Series htc =new XYChart.Series();
    XYChart.Series motorolla =new XYChart.Series();
    XYChart.Series xiaomi =new XYChart.Series();
    XYChart.Series condor =new XYChart.Series();
    XYChart.Series huawei =new XYChart.Series();
    XYChart.Series nokia =new XYChart.Series();
    XYChart.Series sony =new XYChart.Series();
    XYChart.Series lenovo =new XYChart.Series();
    XYChart.Series google =new XYChart.Series();
    XYChart.Series honor =new XYChart.Series();
    XYChart.Series oppo =new XYChart.Series();
    XYChart.Series wiko =new XYChart.Series();
    XYChart.Series realme =new XYChart.Series();
    XYChart.Series onplus =new XYChart.Series();
    XYChart.Series vivo =new XYChart.Series();
    XYChart.Series mezui =new XYChart.Series();
    XYChart.Series blackberry =new XYChart.Series();
    XYChart.Series asus =new XYChart.Series();
    XYChart.Series alcatel =new XYChart.Series();
    XYChart.Series acer =new XYChart.Series();
       
     int a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,
         a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24= 0;
    @FXML
    private Button Home,User,Stock,Update;
   
        
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        list1 =FXCollections.observableArrayList();
        list2 =FXCollections.observableArrayList();
        list3 =FXCollections.observableArrayList();
        list4 =FXCollections.observableArrayList();
        
     
        
        try {
             getType();
            getpieChart(QUANTITE, piechart1,list1) ;
            getpieChart(prix, piechart2,list2);
            getpieChart(internal, piechart3,list3);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXChart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    Home.setOnAction(e->{
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
            }
        
            
        });
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
            }
        
            
        });
    User.setOnAction(e->{
        Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("Adiministrateur.fxml"));
                Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
       scene.getStylesheets().add(getClass().getResource("/StyleSheets/adiministra.css").toExternalForm());
        
            } catch (IOException ex) {
                Logger.getLogger(FXChart.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
        });
    Update.setOnAction(e->{
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
                Logger.getLogger(FXChart.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
        });
             
       
        }
    
    
      public void getpieChart(String quantite,PieChart chart,ObservableList liste) throws SQLException{
          
      String SQL ="SELECT "+quantite+" , nom_appareil FROM `appareil`";
      
            Connection con =DB_Produit.getConnection();
            
        
            PreparedStatement  ps =con.prepareStatement(SQL);
            
            
            ResultSet rs =ps.executeQuery();
                while(rs.next()){
                    
                    value.setText(String.valueOf( rs.getInt(quantite)));
                    name.setText(rs.getString("nom_appareil"));
                    liste.add(new PieChart.Data(name.getText(),Integer.valueOf(value.getText())));
                    
                
                }
                chart.setData(liste);
                
                ps.close();
                rs.close();
                con.close();
    
  }
       public void getType() throws SQLException{
       
           
        
      String SQL ="SELECT `id_appareil` FROM `appareil`";
      
            Connection con =DB_Produit.getConnection();
            
        
            PreparedStatement  ps =con.prepareStatement(SQL);
            
            
            ResultSet rs =ps.executeQuery();
                while(rs.next()){
                    
                    id.setText(rs.getString("id_appareil"));
                    int Id =Integer.valueOf(id.getText());
                 switch(Id){
                    case 1 : samsung.getData().add(new XYChart.Data<>("SAMSUNG",a1=a1+1));break;
                    case 2 : apple.getData().add(new XYChart.Data<>("APPLE",a2=a2+1));break;
                    case 3 : lg.getData().add(new XYChart.Data<>("LG",a3=a3+1));break;
                    case 4 : htc.getData().add(new XYChart.Data<>("HTC",a4=a4+1));break;
                    case 5 : motorolla.getData().add(new XYChart.Data<>("MOTOROLLA",a5=a5+1));break;
                    case 6 : xiaomi.getData().add(new XYChart.Data<>("XIAOMI",a6=a6+1));break;
                    case 7 : condor.getData().add(new XYChart.Data<>("CONDOR",a7=a7+1));break;
                    case 8 : huawei.getData().add(new XYChart.Data<>("HUAWEI",a8=a8+1));break;
                    case 9 : nokia.getData().add(new XYChart.Data<>("NOKIA",a9=a9+1));break;
                    case 10 : sony.getData().add(new XYChart.Data<>("SONY",a10=a10+1));break;
                    case 11 : wiko.getData().add(new XYChart.Data<>("LENOVO",a11=a11+1));break;
                    case 12 : lenovo.getData().add(new XYChart.Data<>("LENOVO",a12=a12+1));break;
                    case 13 : google.getData().add(new XYChart.Data<>("GOOGLE",a13=a13+1));break;
                    case 14 : honor.getData().add(new XYChart.Data<>("HONOR",a14=a14+1));break;
                    case 15 : oppo.getData().add(new XYChart.Data<>("OPPO",a15=a15+1));break;
                    case 16 : realme.getData().add(new XYChart.Data<>("REALME",a16=a16+1));break;
                    case 17 : onplus.getData().add(new XYChart.Data<>("ON PLUS",a17=a17+1));break;
                    case 18 : vivo.getData().add(new XYChart.Data<>("VIVO",a18=a18+1));break;
                    case 19 : mezui.getData().add(new XYChart.Data<>("MEIZU",a19=a19+1));break;
                    case 20 : blackberry.getData().add(new XYChart.Data<>("BLACKBERRY",a20=a20+1));break;
                    case 21 : asus.getData().add(new XYChart.Data<>("ASUS",a21=a21+1));break;
                    case 22 : alcatel.getData().add(new XYChart.Data<>("ALCATEL",a22=a22+1));break;
                    case 23 : acer.getData().add(new XYChart.Data<>("ACER",a23=a23+1));break;
                    
                    
                 }
       
                    
                    
                }
               barchart.getData().addAll(samsung,apple,lg,htc,motorolla,xiaomi,condor,huawei,nokia,sony,lenovo,google
                       ,honor,oppo,realme,onplus,vivo,mezui,blackberry,asus,alcatel,acer);
                
                
                ps.close();
                rs.close();
                con.close();
                
               
    
  } 
       
    
      

                
  }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


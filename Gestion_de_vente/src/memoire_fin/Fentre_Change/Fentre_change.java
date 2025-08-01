package memoire_fin.Fentre_Change;

import memoire_fin.FenetreVente.Fenetre_vente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.TranslateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;

public class Fentre_change implements Initializable {

    Stage stage = null;

    @FXML
    private AnchorPane anchor02, anchor01, anchor03, anchor04, anchor_p;
    @FXML
    private JFXTextField modele,cpu, prix, battery2, battery, id, rearcamera, selfiecamera, colors, year, quantite, weight;
    @FXML
    private Label prix_2;
    @FXML
    private JFXButton RESET, update, insert, delete;
    @FXML
    private Pane Pane3, pane1, pane2;
    @FXML
    private JFXComboBox card_slot;
    @FXML
    private JFXComboBox marque;
    @FXML
    private JFXComboBox Ram;
    @FXML
    private JFXComboBox internal;
    @FXML
    private JFXComboBox notch;
    @FXML
    private JFXComboBox empeint;
    @FXML
    private JFXComboBox flach;
    @FXML
    private JFXComboBox nfc;
    @FXML
    private JFXComboBox gps,size,os, appareil, build, sim_size, sim_multiply, bluetooth, serie_bluetooth, technology;
    @FXML
    public ImageView lbl_appareil;
    @FXML
    private Button addbutton,bttnadd;
    @FXML
    private StackPane stackpane,Retour,invisible,visible;
    @FXML        
    private HBox  CO2,RO1,CO1,CO3,RO2,RO3,barretitre;
   
    
    public static File file;
    public static FileInputStream stream;
    Image image;
    Image Attention = new Image("/Photo/Attention.png");
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
          traslation();
         
          Combo();
          
          marque.setOnAction(e ->{
            String Selct = (String) marque.getValue();

                switch (Selct) {
                    case "SAMSUNG":       
                        id.setText("1");
                        break;
                    case "APPLE":
                        id.setText("2");
                        break;
                    case "LG":
                        id.setText("3");
                        break;
                    case "HTC":
                        id.setText("4");
                        break;
                    case "MOTOROLA":
                        id.setText("5");
                        break;
                    case "XIAOMI":
                        id.setText("6");
                        break;
                    case "CONDOR":
                        id.setText("7");
                        break;
                    case "HUAWEI":
                        id.setText("8");
                        break;
                    case "NOKIA":
                        id.setText("9");
                        break;
                    case "SONY":
                        id.setText("10");
                        break;
                    case "WIKO":
                        id.setText("11");
                        break;
                    case "LENOVO":
                        id.setText("12");
                        break;
                    case "GOOGLE":
                        id.setText("13");
                        break;
                    case "HONOR":
                        id.setText("14");
                        break;
                    case "OPPO":
                        id.setText("15");
                        break;
                        case "REALME":
                        id.setText("16");
                        break;
                        case "ONE PLUS":
                        id.setText("17");
                        break;
                        case "VIVO":
                        id.setText("18");
                        break;
                        case "MEIZU":
                        id.setText("19");
                        break;
                        case "BLACKBERRY":
                        id.setText("20");
                        break;
                        case "ASUS":
                        id.setText("21");
                        break;
                        case "ALCATEL":
                        id.setText("22");
                        break;
                        case "ACER":
                        id.setText("23");
                        break;
                    
                }
          });
         addbutton.setOnAction(e ->{
            
           stackpane.setVisible(true);
            anchor04.setOpacity(0.2);
            bttnadd.setVisible(true);
        });
         
        bttnadd.setOnAction(e ->{
            stackpane.setVisible(false);
            bttnadd.setVisible(false);
            anchor04.setOpacity(1);
            
            
        });
        bluetooth.setOnAction(e ->{
         if(bluetooth.getValue().equals("YES")){
            serie_bluetooth.setVisible(true);}else{
            serie_bluetooth.setVisible(false);
            }
        });
      
    RO1.setOnMouseClicked(e ->{
        
        anchor01.setVisible(true);
        anchor03.setVisible(false);
        anchor04.setVisible(false);
        anchor02.setVisible(false);
    });
    RO2.setOnMouseClicked(e ->{
        anchor02.setVisible(true);
        anchor01.setVisible(false);
        anchor04.setVisible(false);
        anchor03.setVisible(false);
    });
    RO3.setOnMouseClicked(e ->{
        anchor03.setVisible(true);
        anchor04.setVisible(false);
        anchor02.setVisible(false);
        anchor01.setVisible(false);
    });
    CO1.setOnMouseClicked(e ->{
        anchor01.setVisible(false);
        anchor03.setVisible(false);
        anchor04.setVisible(false);
        anchor02.setVisible(true);
    });
    CO2.setOnMouseClicked(e ->{
        anchor01.setVisible(false);
        anchor02.setVisible(false);
        anchor04.setVisible(false);
        anchor03.setVisible(true);
    });
    CO3.setOnMouseClicked(e ->{
        anchor01.setVisible(false);
        anchor03.setVisible(false);
        anchor02.setVisible(false);
        anchor04.setVisible(true);
    });
    RESET.setOnAction(e ->{
        
        clear();
    });
    visible.setOnMouseClicked(e ->{
        Image img = new Image("/Photo/attentionchek.png");
        if (emptyValidation("Modéle", modele.getText().isEmpty())) {
            
            try {
                visible.setVisible(false);
                invisible.setVisible(true);
                choix();
            } catch (IOException ex) {
                System.out.println(ex.getMessage()+"\n");
                System.out.println(ex.getClass());
            }
        }
        
    });
    invisible.setOnMouseClicked(e ->{
        invisible.setVisible(false);
        visible.setVisible(true);
        clear();
    });
    Retour.setOnMouseClicked(e->{
        anchor01.setVisible(false);
        pane1.setVisible(true);
        pane2.setVisible(true);
        Pane3.setVisible(true);
    });
    pane1.setOnMouseClicked(e->{
        
        pane1.setVisible(false);
        pane2.setVisible(false);
        Pane3.setVisible(false);
        anchor01.setVisible(true);
        id.setVisible(false);
        visible.setVisible(false);
        marque.setVisible(true);
        delete.setVisible(false);
        update.setVisible(false);
        insert.setVisible(true);
        
    });
    pane2.setOnMouseClicked(e->{
        
        pane1.setVisible(false);
        pane2.setVisible(false);
        Pane3.setVisible(false);
        anchor01.setVisible(true);
        id.setVisible(true);
        visible.setVisible(true);
        marque.setVisible(false);
        delete.setVisible(false);
        insert.setVisible(false);
        update.setVisible(true);
        autotextfield();
        
    });
    Pane3.setOnMouseClicked(e->{
        
        pane1.setVisible(false);
        pane2.setVisible(false);
        Pane3.setVisible(false);
        anchor01.setVisible(true);
        visible.setVisible(true);
        id.setVisible(true);
        marque.setVisible(false);
        update.setVisible(false);
        insert.setVisible(false);
        delete.setVisible(true);
        autotextfield();
        
    });
    bluetooth.setOnAction(e->{
        
        if (bluetooth.getValue() == "YES") {
            serie_bluetooth.setVisible(true);
        } else {
            serie_bluetooth.setVisible(false);
        }
        
    });
    stackpane.setOnMouseClicked(e ->{
        
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        //Show open file dialog
        file = fileChooser.showOpenDialog(null);

        BufferedImage bufferedImage;
              try {
                bufferedImage = ImageIO.read(file);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                lbl_appareil.setImage(image);
              } catch (IOException ex) {
                  Logger.getLogger(Fentre_change.class.getName()).log(Level.SEVERE, null, ex);
              }
     
    });
    
        
    }

    private void choix() throws IOException {

       Produit Pro = getProduitnom();

        id.setText(String.valueOf(Pro.getId_type()));
        modele.setText(Pro.getName());
        build.setValue(Pro.getBuild());
        sim_size.setValue(Pro.getSim_size());
        sim_multiply.setValue(Pro.getSim_multiply());
        size.setValue(String.valueOf(Pro.getSize()));
        //protection.setValue(String.valueOf(Pro.getProtection()));
        cpu.setText(Pro.getCPU());
        os.setValue(Pro.getOS());
        card_slot.setValue(Pro.getCard_slot());
        internal.setValue(String.valueOf(Pro.getInternal()));
        Ram.setValue(String.valueOf(Pro.getRAM()));
        weight.setText(String.valueOf(Pro.getWeight()));
        notch.setValue(Pro.getNotch());
        nfc.setValue(Pro.getNFC());
        empeint.setValue(Pro.getEmpreint());
        gps.setValue(Pro.getGPS());
        bluetooth.setValue(Pro.getBluetooth());
        serie_bluetooth.setValue(String.valueOf(Pro.getBluetooth_serie()));
        technology.setValue(Pro.getNetwork());
        battery.setText(String.valueOf(Pro.getCharging()));
        rearcamera.setText(String.valueOf(Pro.getRear_camera()));
        selfiecamera.setText(String.valueOf(Pro.getSelfie_camera()));
        flach.setValue(Pro.getFlach());
        colors.setText(Pro.getColors());
        year.setText(String.valueOf(Pro.getAnnounced()));
        quantite.setText(String.valueOf(Pro.getQuantite()));
        prix.setText(String.valueOf(Pro.getPrix()));

    }


    public void traslation() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(5));
        transition.setNode(pane1);
        transition.setToX(-750);
        transition.setToY(600);
        transition.play();

        TranslateTransition transition2 = new TranslateTransition();
        transition2.setDuration(Duration.seconds(5));
        transition2.setNode(pane2);
        transition2.setToX(-450);
        transition2.setToY(600);
        transition2.play();
        TranslateTransition transition3 = new TranslateTransition();
        transition3.setDuration(Duration.seconds(5));
        transition3.setNode(Pane3);
        transition3.setToX(-150);
        transition3.setToY(600);
        transition3.play();

    }

   
    public void Combo(){
    ObservableList List = FXCollections.observableArrayList("YES","NO");
       bluetooth.setItems(List);
        build.setItems(List);
        notch.setItems(List);
        empeint.setItems(List);
        nfc.setItems(List);
        gps.setItems(List);
        flach.setItems(List);
        card_slot.setItems(List);
        
        marque.getItems().setAll("SAMSUNG", "APPLE", "LG", "HTC", "MOTOROLA", "XIAOMI", "CONDOR", "HUAWEI", "NOKIA", "SONY", "MOTOROLLA", "LENOVO", "GOOGLE", "HONOR", "OPPO", "REALME", "ONE PLUS", "VIVO", "MEIZU", "BLACKBERRY", "ASUS", "ALCATEL", "ZTE", "ACER");
        appareil.getItems().setAll("Smartphone", "Smartwatche", "Tablette");
        sim_size.getItems().setAll("Mini-SIM (regular size)", "Micro-SIM", "Nano-SIM", "eSIM");
        sim_multiply.getItems().setAll("One Sim", "Dual SIM", "Triple SIM", "Quad SIM");
        size.getItems().setAll("3.0", "4.0", "5.0", "6.0", "7.0", "8.0", "9.0", "10.0", "11.0", "Other");
        os.getItems().setAll("Android", "Ios", "Windows", "BlackBerry", "Other");
        internal.getItems().setAll("4", "8", "16", "32", "64", "128", "256");
        serie_bluetooth.getItems().setAll("2.0", "2.1", "3.0", "4.0", "4.1", "4.2", "5.0");
        technology.getItems().setAll("NONE", "avec 3G", "avec 4G", "avec 5G");
        Ram.getItems().setAll("4", "6", "8", "10", "12", "16");
}



    
     private void autotextfield(){
        
                  ObservableList List;
        try {
            List = DB_Produit.GetAutoName();
            TextFields.bindAutoCompletion(modele, List);
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_vente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Update(ActionEvent event) {
        Image img =new Image("/Photo/updatecheck.png");
        Image img1 =new Image("/Photo/attentionchek.png");
        

        String Nom = modele.getText();
        String Bulid = (String) build.getValue();
        String Sim_Size = (String) sim_size.getValue();
        String Sim = (String) sim_multiply.getValue();
        String Cpu = cpu.getText();
        String Card_Slot = (String) card_slot.getValue();
        String Os = (String) os.getValue();
        String Notch = (String) notch.getValue();
        String Nfc = (String) nfc.getValue();
        String Empreint = (String) empeint.getValue();
        String Gps = (String) gps.getValue();
        String Bluetooth = (String) bluetooth.getValue();
        String Technologie = (String) technology.getValue();
        String Flache = (String) flach.getValue();
        String Color = colors.getText();
        int Id = Integer.parseInt(id.getText());
        int ram =  Integer.parseInt((String) Ram.getValue());
        int Internal = Integer.parseInt((String) internal.getValue()) ;
        int Rear_Camera = Integer.parseInt(rearcamera.getText());
        int Selfie_Camera = Integer.parseInt(selfiecamera.getText());
        int Annonced = Integer.parseInt(year.getText());
        int Quantite = Integer.parseInt(quantite.getText());
        int Prix = Integer.parseInt(prix.getText());
        int Charging =Integer.parseInt( battery.getText());
        double Weight =Double.parseDouble(weight.getText());
        double Bluethooth_Serie = Double.parseDouble((String) serie_bluetooth.getValue());
        int Size = Integer.parseInt((String) size.getValue());


        Produit pro = new Produit();

        pro.setId_type(Id);
        pro.setName(Nom);
        pro.setBuild(Bulid);
        pro.setSim_size(Sim_Size);
        pro.setSim_multiply(Sim);
        pro.setPrix(Prix);
        pro.setQuantite(Quantite);
        pro.setWeight(Weight);
        pro.setRAM(ram);
        pro.setCPU(Cpu);
        pro.setCard_slot(Card_Slot);
        pro.setOS(Os);
        pro.setInternal(Internal);
        pro.setNetwork(Technologie);
        pro.setCharging(Charging);
        pro.setNFC(Nfc);
        pro.setBluetooth_serie(Bluethooth_Serie);
        pro.setNotch(Notch);
        pro.setEmpreint(Empreint);
        pro.setGPS(Gps);
        pro.setBluetooth(Bluetooth);
        pro.setAnnounced(Annonced);
        pro.setFlach(Flache);
        pro.setColors(Color);
        pro.setRear_camera(Rear_Camera);
        pro.setSelfie_camera(Selfie_Camera);
        pro.setSize(Size);
        
        
        int status = DB_Produit.update(pro);
        
        if (status > 0) {
           
            Notification(img, " update successfully! ", "  UPDATE");

        } else {
            Notification(img1, " Sorry! Unable To Update Record ", "  UPDATE");

        }
    }

    @FXML
    private void Insert(ActionEvent event) throws SQLException {
        
        Image img =new Image("/Photo/check.png");
        Image img1 =new Image("/Photo/attentionchek.png");

        if (emptyValidation("Modéle", modele.getText().isEmpty()) && validate("Quentité ", quantite.getText(), "[0-9]+") && validate("Price ", prix.getText(), "[0-9]+") && validate("Weight ", weight.getText(), "[0-9.]+") && emptyValidation("Build", build.getSelectionModel().getSelectedItem() == null) && emptyValidation("Sim Size", sim_size.getSelectionModel().getSelectedItem() == null) && emptyValidation("Sim Multiply", sim_multiply.getSelectionModel().getSelectedItem() == null) && emptyValidation("SIZE ", size.getSelectionModel().getSelectedItem() == null) && emptyValidation("RAM ", Ram.getSelectionModel().getSelectedItem() == null) && emptyValidation("CPU", cpu.getText().isEmpty()) && emptyValidation("Operating Systéme", os.getSelectionModel().getSelectedItem() == null) && emptyValidation("Card Slot", card_slot.getSelectionModel().getSelectedItem() == null)
                && emptyValidation("Internal ", internal.getSelectionModel().getSelectedItem() == null) && emptyValidation("Notch ", notch.getSelectionModel().getSelectedItem() == null) && emptyValidation("NFC ", nfc.getSelectionModel().getSelectedItem() == null) && emptyValidation("Empreint ", empeint.getSelectionModel().getSelectedItem() == null) && emptyValidation("GPS ", gps.getSelectionModel().getSelectedItem() == null) && emptyValidation("Blutthooth", bluetooth.getSelectionModel().getSelectedItem() == null)
                && emptyValidation("Network ", technology.getSelectionModel().getSelectedItem() == null) && validate("Battery ", battery.getText(), "[0-9]+") && validate("Rear Caméra ", rearcamera.getText(), "[0-9]+") && validate("Selfie Caméra ", selfiecamera.getText(), "[0-9.]+") && emptyValidation("Flach ", flach.getSelectionModel().getSelectedItem() == null) && emptyValidation("Color", colors.getText().isEmpty()) && validate("The Year ", year.getText(), "[0-9.]+")
                && validate("Selfie Caméra ", selfiecamera.getText(), "[0-9]+") && validate("Year ", year.getText(), "[0-9]+")) {
            String id = this.id.getText();
            String name = modele.getText();
            String build = (String) this.build.getValue();
            String sim_size = (String) this.sim_size.getValue();
            String simmultiply = (String) sim_multiply.getValue();
            String weight = this.weight.getText();
            String cPu = cpu.getText();
            String internal = (String) this.internal.getValue();
            String size = (String) this.size.getValue();
            String quantitee = quantite.getText();
            String pri = prix.getText();
            String os = (String) this.os.getValue();
            String cardslot = (String) card_slot.getValue();
            String ram = (String) this.Ram.getValue();
            String Charg = battery.getText();
            String bluetooth_serie = (String) serie_bluetooth.getValue();
            String notch = (String) this.notch.getValue();
            String nfc = (String) this.nfc.getValue();
            String empreint = (String) this.empeint.getValue();
            String gps = (String) this.gps.getValue();
            String bluetooth = (String) this.bluetooth.getValue();
            String network = (String) technology.getValue();
            String announced = year.getText();
            String flach = (String) this.flach.getValue();
            String colors = this.colors.getText();
            String rearcamera = this.rearcamera.getText();
            String selfiecamera = this.selfiecamera.getText();

            // convertir les donnees
            int fid = Integer.parseInt(id);
            double fweight = Double.parseDouble(weight);
            double fbleu = Double.parseDouble(bluetooth_serie);
            int fquantitee = Integer.parseInt(quantitee);
            int fannounced = Integer.parseInt(announced);
            int frearcamera = Integer.parseInt(rearcamera);
            int fselfiecamera = Integer.parseInt(selfiecamera);
            int fpri = Integer.parseInt(pri);
            int fcharg = Integer.parseInt(Charg);
            int finternal = Integer.parseInt(internal);
            int fram = Integer.parseInt(ram);
            float fsize = Float.parseFloat(size);

            Produit pro = new Produit();

            pro.setId_type(fid);
            pro.setName(name);
            pro.setBuild(build);
            pro.setSim_size(sim_size);
            pro.setSim_multiply(simmultiply);
            pro.setPrix(fpri);
            pro.setQuantite(fquantitee);
            pro.setWeight(fweight);
            pro.setRAM(fram);
            pro.setCPU(cPu);
            pro.setCard_slot(cardslot);
            pro.setOS(os);
            pro.setInternal(finternal);
            pro.setNetwork(network);
            pro.setCharging(fcharg);
            pro.setNFC(nfc);
            pro.setBluetooth_serie(fbleu);
            pro.setNotch(notch);
            pro.setEmpreint(empreint);
            pro.setGPS(gps);
            pro.setBluetooth(bluetooth);
            pro.setAnnounced(fannounced);
            pro.setFlach(flach);
            pro.setColors(colors);
            pro.setRear_camera(frearcamera);
            pro.setSelfie_camera(fselfiecamera);
            pro.setSize(fsize);

            int status;

            try {

                status = DB_Produit.save(pro);
                if (status > 0) {

                     Notification(img,"Saved successfully", " SAVE ");

                } else {
                     Notification(img1,"  This Name Exists \n "+" Please Enter another name ! ", " SAVE ");
                }
               

            } catch (FileNotFoundException e) {
            }
        }
    }

    @FXML
    private void Delete(ActionEvent event) {
        DeletAlert("Are you sure you want to delete selected?");
    }

    

    private boolean emptyValidation(String field, boolean empty) {
        if (!empty) {
            return true;
        } else {
            validationAlert(field, true);
            return false;
        }
    }

    private boolean validate(String field, String value, String pattern) {
        if (!value.isEmpty()) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(value);
            if (m.find() && m.group().equals(value)) {
                return true;
            } else {
                validationAlert(field, false);
                return false;
            }
        } else {
            validationAlert(field, true);
            return false;
        }
    }

    private void validationAlert(String field, boolean empty) {
        String Text;
        Notifications notifications = Notifications.create()
                                     .title("Validation Error")
                                     .graphic(new ImageView(Attention)).position(Pos.CENTER);
       notifications.darkStyle();
       

        if (empty) {
            notifications.text("Please Enter " + field);
        } else {
            notifications.text("Please Enter Valid " + field);
        }

        notifications.show();
    }



    private void DeletAlert(String Commentaire) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selected?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            String s_nom = modele.getText();

            //     DB_Produit.delete(s_nom) ;
            int status = DB_Produit.delete(s_nom);
            if (status > 0) {

                //    saveAlert("error has been created \n","Produit Deleted successfully.");
            } else {

//                     saveAlert(" successfully created \n","Produit Deleted successfully.");
            }
        }

    }

   



    private void clear() {

        id.clear();
        quantite.clear();
        prix.clear();
        modele.clear();
        weight.clear();
        cpu.clear();
        rearcamera.clear();
        selfiecamera.clear();
        battery.clear();
        colors.clear();
        year.clear();
        marque.getSelectionModel().clearSelection();
        appareil.getSelectionModel().clearSelection();
        sim_size.getSelectionModel().clearSelection();
        sim_multiply.getSelectionModel().clearSelection();
        build.getSelectionModel().clearSelection();
        size.getSelectionModel().clearSelection();
        Ram.getSelectionModel().clearSelection();
        os.getSelectionModel().clearSelection();
        card_slot.getSelectionModel().clearSelection();
        internal.getSelectionModel().clearSelection();
        notch.getSelectionModel().clearSelection();
        empeint.getSelectionModel().clearSelection();
        nfc.getSelectionModel().clearSelection();
        gps.getSelectionModel().clearSelection();
        bluetooth.setValue("");
        serie_bluetooth.getSelectionModel().clearSelection();
        technology.getSelectionModel().clearSelection();
        flach.getSelectionModel().clearSelection();  }

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

  

    public Produit getProduitnom() {

        Produit pro = new Produit();

        try {
            String sql = "SELECT * FROM `appareil` WHERE `nom_appareil` =?";
            Connection con = DB_Produit.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

            preparedStatement.setString(1, modele.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            
            
            
            if (resultSet.next()) {

                pro.setId_type(resultSet.getInt("id_appareil"));
                pro.setName(resultSet.getString("nom_appareil"));
                pro.setBuild(resultSet.getString("BUILD"));
                pro.setSim_size(resultSet.getString("SIM SIZE"));
                pro.setSim_multiply(resultSet.getString("SIM MULTIPLY"));
                pro.setSize(resultSet.getFloat("SIZE"));
                pro.setRAM(resultSet.getInt("RAM"));
                pro.setCPU(resultSet.getString("CPU"));
                pro.setOS(resultSet.getString("OS"));
                pro.setCard_slot(resultSet.getString("CARD SLOT"));
                pro.setInternal(resultSet.getInt("INTERNAL"));
                pro.setWeight(resultSet.getDouble("WEIGHT"));
                pro.setNotch(resultSet.getString("NOTCH"));
                pro.setNFC(resultSet.getString("NFC"));
                pro.setEmpreint(resultSet.getString("EMPREINT"));
                pro.setGPS(resultSet.getString("GPS"));
                pro.setBluetooth(resultSet.getString("Bluetooth"));
                pro.setBluetooth_serie(resultSet.getDouble("Bluetooth Serie"));
                pro.setNetwork(resultSet.getString("TECHNOLOGIE"));
                pro.setCharging(resultSet.getInt("BATTERY"));
                
                pro.setRear_camera(resultSet.getInt("Rear Camera"));
                pro.setSelfie_camera(resultSet.getInt("Selfie Camera"));
                pro.setFlach(resultSet.getString("Flach"));
                pro.setColors(resultSet.getString("Colors"));
                pro.setAnnounced(resultSet.getInt("Annonced"));
               
                pro.setQuantite(resultSet.getInt("QUANTITE"));
                pro.setPrix(resultSet.getInt("PRIX"));
                InputStream is = resultSet.getBinaryStream("Image");
                OutputStream os = new FileOutputStream(new File("photo.jpg"));
                byte[] content = new byte[1024];
                int size = 0;
                while ((size = is.read(content)) != -1) {
                    os.write(content, 0, size);

                }
                os.close();
                is.close();
                image = new Image("file:photo.jpg", 250, 350, true, true);
                lbl_appareil.setImage(image);
                lbl_appareil.setPreserveRatio(true);

            }

            con.close();

        } catch (SQLException e) {
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Fentre_change.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Fentre_change.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pro;
    }
    
   

    
   public void Notification(Image img,String Title,String Text){
      Notifications notifications = Notifications.create()
                                     .title(Title).text(Text)
                                     .graphic(new ImageView(img)).position(Pos.CENTER);
       notifications.darkStyle();
       notifications.show();
       
   } 


   


 

}

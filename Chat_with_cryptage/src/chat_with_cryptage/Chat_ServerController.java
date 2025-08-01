package chat_with_cryptage;

import com.jfoenix.controls.JFXButton;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Chat_ServerController implements Initializable {

   
    @FXML
    private JFXButton btn_sendd;
    @FXML
    private static TextArea txt_server_area;
    @FXML
    private TextField txt_server_field;
    
    static ServerSocket ss = null;
    static Socket socket = null ;
    static DataInputStream din = null;
    static DataOutputStream dout = null;
    static final int port = 1280;
    
  
    public void Connecteé(){
       
         String msgin="";
        try{
            ServerSocket ss = new ServerSocket(port);
            socket= ss.accept();
            din=new DataInputStream(socket.getInputStream());
            dout=new DataOutputStream(socket.getOutputStream());
            while(!msgin.equals("exit")){
                msgin=din.readUTF();
                txt_server_area.setText(txt_server_area.getText().trim()+ "\n"+msgin);
            } 
            
        }catch(Exception e){
            
        }      
    }
    
    
    
    public void View_Window (){
        Parent root;
      try {
                root = FXMLLoader.load(getClass().getResource("Chat_Client.fxml"));
                Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       // scene.getStylesheets().add(getClass().getResource("/StyleSheets/Style_Vente.css").toExternalForm());
        
            } catch (IOException ex) {
                Logger.getLogger(Chat_with_cryptage.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        Connecteé();
        View_Window();
    }
    
    
    
    @FXML
    public void Send_Message (){
        
        try {
              String magout= "";
       magout=txt_server_field.getText().trim();
            dout.writeUTF(magout);
        } catch (Exception e) {
            
           }
        
      
        
        
    }
    
    
    
    
    
    
}

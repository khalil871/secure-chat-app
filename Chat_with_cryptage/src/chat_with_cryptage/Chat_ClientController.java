
package chat_with_cryptage;

import com.jfoenix.controls.JFXButton;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
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


public class Chat_ClientController implements Initializable {

    @FXML
    private TextField txt_field;
    @FXML
    private TextArea txt_area;
    @FXML
    private JFXButton btn_send;

    
    static Socket s; 
    static DataInputStream io ; 
    static DataOutputStream ou ; 
    
    
    
    public void Connect (){
        
        try {
            
        s= new Socket("localhost", 1280);
        io = new DataInputStream((s.getInputStream()));
        ou = new DataOutputStream(s.getOutputStream());
        
        String msg = "";
        while(!msg.equals("Close")){
            msg = io.readUTF();
            txt_area.setText(txt_area.getText().trim()+"\n Serveur :\t"+msg);
            
        }
        
        } catch (Exception e) {
        }
        
        
        
    }
    
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Connect();
      
      
    }


  public void Send (){
      try {
          
          String msgout = "";
          msgout = txt_field.getText().trim();
          ou.writeUTF(msgout);

      } catch (Exception e) {
      }
  }

    
    
}

package memoire_fin.Fentre_Change;

import memoire_fin.Fentre_Change.Produit;
import memoire_fin.Fentre_Change.Fentre_change;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DB_Produit {
  
 static ResultSet resultSet;
 
 public static Connection getConnection(){
        
		      Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/projet_fin";
                        con = DriverManager.getConnection(url, "dbbrahim","salahbrahim");
		    } catch (ClassNotFoundException | SQLException e) {}
      
		      return con;
		}
    
    
    
  
   public static int save(Produit emp) throws FileNotFoundException{
		
		int st = 0;
                
       
		
		try {
	String sql = "INSERT INTO `appareil`(`id_appareil`, `nom_appareil`, `BUILD`, `SIM SIZE`, `SIM MULTIPLY`, `SIZE`, `RAM`, `CPU`, `OS`, `CARD SLOT`, `INTERNAL`, `WEIGHT`, `NOTCH`, `NFC`, `EMPREINT`, `GPS`, `Bluetooth`, `Bluetooth Serie`, `TECHNOLOGIE`, `BATTERY`, `Rear Camera`, `Selfie Camera`, `Flach`, `Colors`, `Annonced`, `QUANTITE`, `PRIX`, `Image`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Connection con = DB_Produit.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			
                        
                        preparedStatement.setInt(1,emp.getId_type());
                        preparedStatement.setString(2, emp.getName());
                        preparedStatement.setString(3, emp.getBuild());
                        preparedStatement.setString(4, emp.getSim_size());
                        preparedStatement.setString(5, emp.getSim_multiply());
                        preparedStatement.setFloat(6, emp.getSize());
                        preparedStatement.setInt(7, emp.getRAM());
                        preparedStatement.setString(8, emp.getCPU());
                        preparedStatement.setString(9, emp.getOS());
                        preparedStatement.setString(10, emp.getCard_slot());
                        preparedStatement.setInt(11, emp.getInternal());
                        preparedStatement.setDouble(12, emp.getWeight());
                        preparedStatement.setString(13, emp.getNotch());
                        preparedStatement.setString(14, emp.getNFC());
                        preparedStatement.setString(15, emp.getEmpreint());
                        preparedStatement.setString(16, emp.getGPS());
                        preparedStatement.setString(17, emp.getBluetooth());
                        preparedStatement.setDouble(18, emp.getBluetooth_serie());
                        preparedStatement.setString(19, emp.getNetwork());
                        preparedStatement.setInt(20, emp.getCharging());
                        
                        preparedStatement.setInt(21, emp.getRear_camera());
                        preparedStatement.setInt(22, emp.getSelfie_camera());
                        preparedStatement.setString(23, emp.getFlach());
                        preparedStatement.setString(24, emp.getColors());
                        preparedStatement.setInt(25, emp.getAnnounced());
                       
                        preparedStatement.setInt(26, emp.getQuantite());
                        preparedStatement.setInt(27, emp.getPrix());
                        
                       
                       Fentre_change.stream =new FileInputStream(Fentre_change.file);
                       preparedStatement.setBinaryStream(28,Fentre_change.stream , Fentre_change.file.length());
                        
        
                        
                        st = preparedStatement.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {}
		
		return st;}
   ///// save into marque (entreprise) 
   
   public static int update(Produit emp) {
	
	int st =0;
	Connection con = DB_Produit.getConnection();
	
	
			try {
String SQL ="UPDATE `appareil` SET `id_appareil`=?,`BUILD`=?,`SIM SIZE`=?,`SIM MULTIPLY`=?,`SIZE`=?,`RAM`=?,`CPU`=?,`OS`=?,`CARD SLOT`=?,`INTERNAL`=?,`WEIGHT`=?,`NOTCH`=?,`NFC`=?,`EMPREINT`=?,`GPS`=?,`Bluetooth`=?,`Bluetooth Serie`=?,`TECHNOLOGIE`=?,`BATTERY`=?,`Rear Camera`=?,`Selfie Camera`=?,`Flach`=?,`Colors`=?,`Annonced`=?,`QUANTITE`=?,`PRIX`=?,`Image`=? WHERE `nom_appareil`=?"; 
 
			
        PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(SQL);
	           
             
                        preparedStatement.setInt(1, emp.getId_type());
                        preparedStatement.setString(2, emp.getBuild());
                        preparedStatement.setString(3, emp.getSim_size());
                        preparedStatement.setString(4, emp.getSim_multiply());
                        preparedStatement.setFloat(5, emp.getSize());
                        preparedStatement.setInt(6, emp.getRAM());
                        preparedStatement.setString(7, emp.getCPU());
                        preparedStatement.setString(8, emp.getOS());
                        preparedStatement.setString(9, emp.getCard_slot());
                        preparedStatement.setInt(10, emp.getInternal());
                        preparedStatement.setDouble(11, emp.getWeight());
                        preparedStatement.setString(12, emp.getNotch());
                        preparedStatement.setString(13, emp.getNFC());
                        preparedStatement.setString(14, emp.getEmpreint());
                        preparedStatement.setString(15, emp.getGPS());
                        preparedStatement.setString(16, emp.getBluetooth());
                        preparedStatement.setDouble(17, emp.getBluetooth_serie());
                        preparedStatement.setString(18, emp.getNetwork());
                        preparedStatement.setInt(19, emp.getCharging());
                        preparedStatement.setInt(20, emp.getRear_camera());
                        preparedStatement.setInt(21, emp.getSelfie_camera());
                        preparedStatement.setString(22, emp.getFlach());
                        preparedStatement.setString(23, emp.getColors());
                        preparedStatement.setInt(24, emp.getAnnounced());
                        preparedStatement.setInt(25, emp.getQuantite());
                        preparedStatement.setInt(26, emp.getPrix());
                        preparedStatement.setString(28,emp.getName());
                        
            try {
               Fentre_change.stream =new FileInputStream(Fentre_change.file);
               preparedStatement.setBinaryStream(27,Fentre_change.stream , Fentre_change.file.length());

            } catch (FileNotFoundException ex) {}
        
                  st = preparedStatement.executeUpdate();
			
			     con.close();
		
		}catch (SQLException e) {}
	
		return st;}
    
    public static int delete(String nom){
	
	int st = 0;
	Connection con = DB_Produit.getConnection();
	
	
	
	
	try {
		String sql = "DELETE FROM `appareil` WHERE `nom_appareil`=?";
		
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		 
		preparedStatement.setString(1,nom);
		
		st = preparedStatement.executeUpdate();
		
		con.close();
		
	} catch (SQLException e) {}
	
	return st;
	
}
     
  public static int update_Quantite(Produit emp) {
	
	Connection con = DB_Produit.getConnection();
	int st = 0;
       
        String SQL1 ="UPDATE `appareil` SET `QUANTITE`=? WHERE `nom_appareil`=?";
                
	PreparedStatement ps;
     
     try {
        ps = con.prepareStatement(SQL1);
        ps.setInt(1, emp.getQuantite());
	ps.setString(2, emp.getName());
        st = ps.executeUpdate();
        ps.close();
     } catch (SQLException ex) {
         Logger.getLogger(DB_Produit.class.getName()).log(Level.SEVERE, null, ex);
     }
         return st;}
  
  
  
      public static ObservableList GetAutoName() throws SQLException{
          ObservableList List = FXCollections.observableArrayList();
      
      String SQL ="SELECT * FROM `appareil`";
      
            Connection con =DB_Produit.getConnection();
            
        
            PreparedStatement  ps =con.prepareStatement(SQL);
            
            
            ResultSet rs =ps.executeQuery();
                while(rs.next()){
                    
                   List.add(rs.getString("nom_appareil")) ;
                    
                   }
                 
        
        
                ps.close();
                rs.close();
                con.close();
     return List;
   
  }
      
  
  
}


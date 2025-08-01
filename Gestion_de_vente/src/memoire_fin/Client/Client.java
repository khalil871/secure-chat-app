package memoire_fin.Client;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import memoire_fin.Fentre_Change.DB_Produit;

public class Client {
 
    
    
    
    
        public static int save( Client.Client_Edentifier emp) throws FileNotFoundException{
		
		int st = 0;
                
       try {
	String sql = "INSERT INTO `client`(`Num_Client`, `Nom`, `prenom`, `Ville`, `Adress`, `Telephone`) VALUES (?,?,?,?,?,?)";
			Connection con = DB_Produit.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			
                        
                        preparedStatement.setInt(1,emp.getNumClient());
                        preparedStatement.setString(2, emp.getNom());
                        preparedStatement.setString(3, emp.getPrenom());
                        preparedStatement.setString(4, emp.getVille());
                        preparedStatement.setString(5, emp.getAdresse());
                        preparedStatement.setInt(6, emp.getTelephone());
                        
                              st = preparedStatement.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {}
		
		return st;}
       
public static int delete(int Num){
	
	int st = 0;
	Connection con = DB_Produit.getConnection();
	
	
	
	
	try {
		String sql = "DELETE FROM `client` WHERE `Num_Client` =?";
		
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		 
		preparedStatement.setInt(1, Num);
		
		st = preparedStatement.executeUpdate();
		
		con.close();
		
	} catch (SQLException e) {}
	
	return st;
	
}

public static int update( Client.Client_Edentifier client) {
	
	
	Connection con = DB_Produit.getConnection();
	int st = 0;
	
			try {
			
		   String sql = "UPDATE `client` SET `Nom`=?,`prenom`=?,`Ville`=?,`Adress`=?,`Telephone`=? WHERE `Num_Client`=?";
                       
                   
                        PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			preparedStatement.setString(1, client.getNom());
			preparedStatement.setString(2, client.getPrenom());
                        preparedStatement.setString(3, client.getVille());
                        preparedStatement.setString(4, client.getAdresse());
                        preparedStatement.setInt(5, client.getTelephone());
                        preparedStatement.setInt(6, client.getNumClient());
                        
                        
                        
              st = preparedStatement.executeUpdate();
			
			     con.close();
		
		}catch (SQLException e) {}
	
	return st;

    }

public static Client_Edentifier getProduitnom(int num) throws SQLException {

        Client_Edentifier client = new Client_Edentifier();

       
            String sql = "SELECT * FROM `client` WHERE `Num_Client`= ? ";
            Connection con = DB_Produit.getConnection();
            PreparedStatement pt = con.prepareStatement(sql);

            
          
            pt.setInt(1,num);
            
            // pt.setString(3, Ville);
            // pt.setInt(4, Integer.valueOf(TELEPHONE.getText()));
           // pt.setInt(5, Integer.valueOf(MOBILE.getText()));
            
            
            ResultSet resultSet = pt.executeQuery();
            
            
            
            if (resultSet.next()) {

                client.setVille(resultSet.getString("Ville"));
                client.setNom(resultSet.getString("Nom"));
                client.setPrenom(resultSet.getString("prenom"));
                client.setAdresse(resultSet.getString("Adress"));
                client.setTelephone(resultSet.getInt("Telephone"));
                client.setNumClient(resultSet.getInt("Num_Client"));
                
         
                
        }return client;
}

public static ObservableList GetAutoName() throws SQLException{
          ObservableList List = FXCollections.observableArrayList();
      
      String SQL = " SELECT * FROM `client` ";
      
            Connection con = DB_Produit.getConnection();
            
        
            PreparedStatement  ps = con.prepareStatement(SQL);
            
            
            ResultSet rs =ps.executeQuery();
                while(rs.next()){
                    
                   List.add(rs.getString("Nom")+" "+rs.getString("Prenom"));
                   
                }
                 
        
        
                ps.close();
                rs.close();
                con.close();
     return List;
   
  }

   
static class  Client_Edentifier{
    
        
	private String Nom;
	private String Prenom;
	private String Adresse;
	private String Ville;
        private int NumClient;
	private int Telephone;
	
        
public  Client_Edentifier(int Num , String Nom, String Prenom , String Adresse, String Ville ,int Telephone){
         
            this.NumClient=Num;
            this.Nom=Nom;
            this.Prenom=Prenom;
            this.Adresse=Adresse;
            this.Ville=Ville;
            this.Telephone=Telephone;
     }  

public Client_Edentifier(){
    
}

    public int getNumClient() {
        return NumClient;
    }
    
    public String getNom() {
        return Nom;
    }
    
    
    public String getPrenom() {
        return Prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    

    public String getVille() {
        return Ville;
    }

    /**
     * @return the Telephone
     */
    public int getTelephone() {
        return Telephone;
    }

  

  

        public void setNom(String Nom) {
            this.Nom = Nom;
        }

        public void setPrenom(String Prenom) {
            this.Prenom = Prenom;
        }

        
        public void setAdresse(String Adresse) {
            this.Adresse = Adresse;
        }

        public void setVille(String Ville) {
            this.Ville = Ville;
        }

        /**
         * @param NumClient the NumClient to set
         */
        public void setNumClient(int NumClient) {
            this.NumClient = NumClient;
        }

        /**
         * @param Telephone the Telephone to set
         */
        public void setTelephone(int Telephone) {
            this.Telephone = Telephone;
        }


    
    
    
     
    
    }
   
}

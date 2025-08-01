
package memoire_fin.Fournissuer;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import memoire_fin.Fentre_Change.DB_Produit;


public class Fournisseur_1 {
    
    
    
    
       public static int save( Fournisseur_Edentifier emp) throws FileNotFoundException{
		
		int st = 0;
                
       
		
		try {
	String sql = "INSERT INTO `fournisseur`(`Num_Fournisseur`, `Nom`, `Prenom`, `Ville`, `Adress`, `Code Postal`, `Telephone`, `Mobile`, `Fax`, `Email`) VALUES (?,?,?,?,?,?,?,?,?,?)";
			Connection con = DB_Produit.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			
                        
                        preparedStatement.setInt(1,emp.getNumFournisseur());
                        preparedStatement.setString(2, emp.getNom());
                        preparedStatement.setString(3, emp.getPrenom());
                        preparedStatement.setString(4, emp.getVille());
                        preparedStatement.setString(5, emp.getAdresse());
                        preparedStatement.setInt(6, emp.getCodePostal());
                        preparedStatement.setInt(7, emp.getTelephone());
                        preparedStatement.setInt(8, emp.getMobile());
                        preparedStatement.setInt(9, emp.getFax());
                        preparedStatement.setString(10, emp.getEmail());
                        
                              st = preparedStatement.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {}
		
		return st;}
       
public static int delete(int Num){
	
	int st = 0;
	Connection con = DB_Produit.getConnection();
	
	
	
	
	try {
		String sql = "DELETE FROM `fournisseur` WHERE `Num_Fournisseur` =?";
		
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		 
		preparedStatement.setInt(1, Num);
		
		st = preparedStatement.executeUpdate();
		
		con.close();
		
	} catch (SQLException e) {}
	
	return st;
	
}
public static int update( Fournisseur_Edentifier four) {
	
	
	Connection con = DB_Produit.getConnection();
	int st = 0;
	
			try {
			
		   String sql = "UPDATE `fournisseur` SET `Nom`=?,`Prenom`=?,`Ville`=?,`Adress`=?,`Code Postal`=?,`Telephone`=?,`Mobile`=?,`Fax`=?,`Email`=? WHERE `Num_Fournisseur`=?";
                       
                   
                        PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			preparedStatement.setString(1, four.getNom());
			preparedStatement.setString(2, four.getPrenom());
                        preparedStatement.setString(3, four.getVille());
                        preparedStatement.setString(4, four.getAdresse());
                        preparedStatement.setInt(5, four.getCodePostal());
                        preparedStatement.setInt(6, four.getTelephone());
                        preparedStatement.setInt(7, four.getMobile());
                        preparedStatement.setInt(8, four.getFax());
                        preparedStatement.setString(9, four.getEmail());
                        preparedStatement.setInt(10, four.getNumFournisseur());
                        
                        
                        
              st = preparedStatement.executeUpdate();
			
			     con.close();
		
		}catch (SQLException e) {}
	
		
	
	
	return st;}
       
public static Fournisseur_Edentifier getProduitnom(int num) throws SQLException {
          
       
        Fournisseur_1.Fournisseur_Edentifier fournisseur = new Fournisseur_Edentifier();

       
            String sql = "SELECT * FROM `fournisseur` WHERE `Num_Fournisseur` =?";
            Connection con = DB_Produit.getConnection();
            PreparedStatement pt = con.prepareStatement(sql);

            
            //pt.setString(1, email);
            pt.setInt(1,num);
           // pt.setString(1, NOM.getText());
            //pt.setString(3, PRENOM.getText());
            // pt.setInt(4, Integer.valueOf(TELEPHONE.getText()));
           // pt.setInt(5, Integer.valueOf(MOBILE.getText()));
            
            
            ResultSet resultSet = pt.executeQuery();
            
            
            
            if (resultSet.next()) {

                fournisseur.setVille(resultSet.getString("Ville"));
                fournisseur.setNom(resultSet.getString("Nom"));
                fournisseur.setPrenom(resultSet.getString("Prenom"));
                fournisseur.setAdresse(resultSet.getString("Adress"));
                fournisseur.setEmail(resultSet.getString("Email"));
                fournisseur.setCodePostal(resultSet.getInt("Code Postal"));
                fournisseur.setFax(resultSet.getInt("Fax"));
                fournisseur.setMobile(resultSet.getInt("Mobile"));
                fournisseur.setTelephone(resultSet.getInt("Telephone"));
                fournisseur.setNumfournisseur(resultSet.getInt("Num_Fournisseur"));
                
                
        }return fournisseur;
}

public static ObservableList GetAutoName() throws SQLException{
          ObservableList List = FXCollections.observableArrayList();
      
      String SQL = " SELECT * FROM `fournisseur`";
      
            Connection con = DB_Produit.getConnection();
            
        
            PreparedStatement  ps = con.prepareStatement(SQL);
            
            
            ResultSet rs =ps.executeQuery();
                while(rs.next()){
                    
                   List.add(rs.getString("Nom")+" "+rs.getString("Prenom")) ;
                    
                   }
                 
        
        
                ps.close();
                rs.close();
                con.close();
     return List;
   
  }

   
static class  Fournisseur_Edentifier{
    
        
	private String Nom;
	private String Prenom;
	private String Adresse;
	private String Ville;
        private String Email;
        private int Numfournisseur;
	private int Telephone;
	private int Mobile;
	private int Fax;
	private int CodePostal;
	
        
public  Fournisseur_Edentifier(int Num,String Nom, String Prenom,String Adresse, int CodePostal, String Ville
        ,int Telephone, int Mobile, int Fax, String  Email){
         
            this.Numfournisseur=Num;
            this.Nom=Nom;
            this.Prenom=Prenom;
            this.Adresse=Adresse;
            this.CodePostal=CodePostal;
            this.Ville=Ville;
            this.Telephone=Telephone;
            this.Mobile=Mobile;
            this.Fax=Fax;
            this.Email=Email;
     }
public  Fournisseur_Edentifier(){}

        /**
         * @return the Nom
         */
        public String getNom() {
            return Nom;
        }

        /**
         * @param Nom the Nom to set
         */
        public void setNom(String Nom) {
            this.Nom = Nom;
        }

        /**
         * @return the Prenom
         */
        public String getPrenom() {
            return Prenom;
        }

        /**
         * @param Prenom the Prenom to set
         */
        public void setPrenom(String Prenom) {
            this.Prenom = Prenom;
        }

        /**
         * @return the Adresse
         */
        public String getAdresse() {
            return Adresse;
        }

        /**
         * @param Adresse the Adresse to set
         */
        public void setAdresse(String Adresse) {
            this.Adresse = Adresse;
        }

        /**
         * @return the Ville
         */
        public String getVille() {
            return Ville;
        }

        /**
         * @param Ville the Ville to set
         */
        public void setVille(String Ville) {
            this.Ville = Ville;
        }

        /**
         * @return the Email
         */
        public String getEmail() {
            return Email;
        }

        /**
         * @param Email the Email to set
         */
        public void setEmail(String Email) {
            this.Email = Email;
        }

        /**
         * @return the NumClient
         */
        public int getNumFournisseur() {
            return Numfournisseur;
        }

        /**
         * @param NumClient the NumClient to set
         */
        public void setNumClient(int Numfournisseur) {
            this.Numfournisseur = Numfournisseur;
        }

        /**
         * @return the Telephone
         */
        public int getTelephone() {
            return Telephone;
        }

        /**
         * @param Telephone the Telephone to set
         */
        public void setTelephone(int Telephone) {
            this.Telephone = Telephone;
        }

        /**
         * @return the Mobile
         */
        public int getMobile() {
            return Mobile;
        }

        /**
         * @param Mobile the Mobile to set
         */
        public void setMobile(int Mobile) {
            this.Mobile = Mobile;
        }

        /**
         * @return the Fax
         */
        public int getFax() {
            return Fax;
        }

        /**
         * @param Fax the Fax to set
         */
        public void setFax(int Fax) {
            this.Fax = Fax;
        }

        /**
         * @return the CodePostal
         */
        public int getCodePostal() {
            return CodePostal;
        }

        /**
         * @param CodePostal the CodePostal to set
         */
        public void setCodePostal(int CodePostal) {
            this.CodePostal = CodePostal;
        }

        public void setNumfournisseur(int Numfournisseur) {
            this.Numfournisseur = Numfournisseur;
        }


       
    
    
    
    
}
}

package memoire_fin.FenetreVente;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import memoire_fin.Fentre_Change.DB_Produit;


public class Facture_1 {
    
   
    static int getIdFacture() throws SQLException{
        
        int Id = 0;
        
        String SQL ="SELECT `Num bon` FROM `facture`";
        
      Connection  Conn =DB_Produit.getConnection();
      PreparedStatement pst =Conn.prepareStatement(SQL);
      ResultSet rs =pst.executeQuery();
      
      while(rs.next()){
          
        int  Num = rs.getInt("Num bon");
        Id =Num+1;
       }
      
       return Id;
    }
    
   public static int InsertFacture( Facture_1.DB_Facture facture) throws FileNotFoundException{
		
		int st = 0;
                
            try {
	String sql = "INSERT INTO `facture`(`Num bon`, `Date`, `Client`, `Tva`, `Nombre produite`, `Totale`) VALUES (?,?,?,?,?,?)";
                Connection con = DB_Produit.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		
                
                preparedStatement.setInt(1, facture.getNum_produit());
                preparedStatement.setString(2,facture.getDate());
                preparedStatement.setString(3, facture.getclient());
                preparedStatement.setInt(4, facture.getTva());
                preparedStatement.setInt(5, facture.getNb_produit());
                preparedStatement.setInt(6, facture.getMountant());
                      
                        st = preparedStatement.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {}
		
		return st;
        }
    
     
static class DB_Facture{    
    private int Qunatite ;
    private int Prix;
    private int Tva;
    private int Mountant;
    private int Nb_produit;
    private int Num_produit;
    private String Date;
    private String Client;
    
   
    public DB_Facture (int Quantite,int Prix,int Tva,int Mountant ,int Nb_produit,int Num_produit,String Date
                    ,String Client ){
        this.Qunatite = Quantite;
        this.Prix =Prix ;
        this. Tva=Tva ;
        this. Mountant=Mountant ;
        this. Nb_produit=Nb_produit ;
        this. Num_produit=Num_produit ;
        this. Date=Date ;
        this. Client=Client ;
        
        }
    public DB_Facture(){
        
    }
    

    
    public int getQunatite() {
        return Qunatite;
    }

    
    public int getPrix() {
        return Prix;
    }

    
    public int getTva() {
        return Tva;
    }

    
    public int getMountant() {
        return Mountant;
    }

    
    public int getNb_produit() {
        return Nb_produit;
    }

    
    public int getNum_produit() {
        return Num_produit;
    }

    
    public String getDate() {
        return Date;
    }

    
    public String getclient() {
        return Client;
    }

        
        public void setQunatite(int Qunatite) {
            this.Qunatite = Qunatite;
        }

       
        public void setPrix(int Prix) {
            this.Prix = Prix;
        }

        /**
         * @param Tva the Tva to set
         */
        public void setTva(int Tva) {
            this.Tva = Tva;
        }

        /**
         * @param Mountant the Mountant to set
         */
        public void setMountant(int Mountant) {
            this.Mountant = Mountant;
        }

        /**
         * @param Nb_produit the Nb_produit to set
         */
        public void setNb_produit(int Nb_produit) {
            this.Nb_produit = Nb_produit;
        }
        public void setNum_produit(int Num_produit) {
            this.Num_produit = Num_produit;
        }

        /**
         * @param Date the Date to set
         */
        public void setDate(String Date) {
            this.Date = Date;
        }

        /**
         * @param Client the Client to set
         */
        public void setclient(String Client) {
            this.Client = Client;
        }
    
    
    
    
    
    
}  
    
}

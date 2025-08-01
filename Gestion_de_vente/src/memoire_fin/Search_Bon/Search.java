package memoire_fin.Search_Bon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import memoire_fin.Fentre_Change.DB_Produit;




public class Search {
    
    public static Search.Facture_Edentifier getProduitnom(int num) throws SQLException {

        Search.Facture_Edentifier facture = new Search.Facture_Edentifier();

       
            String sql = "SELECT `Num bon`, `Date`, `Client`, `Tva`, `Nombre produite`, `Totale` FROM `facture` WHERE `Num bon`= ? ";
            Connection con = DB_Produit.getConnection();
            PreparedStatement pt = con.prepareStatement(sql);

            
          
            pt.setInt(1,num);
            
            ResultSet resultSet = pt.executeQuery();
            
            
            
            if (resultSet.next()) {

                facture.setNum_Bon(resultSet.getInt("Num bon"));
                facture.setDate(resultSet.getString("Date"));
                facture.setClient(resultSet.getString("Client"));
                facture.setTva(resultSet.getInt("Tva"));
                facture.setNBproduit(resultSet.getInt("Nombre produite"));
                facture.setTotal(resultSet.getInt("Totale"));
                
         
                
        }return facture;
}
    
    
 
    
    
    
    
  static class Facture_Edentifier {
        
        private int Num_Bon,Tva,NBproduit,Total;
        private String Date,Client;
        
    public Facture_Edentifier (int Num_Bon,int Tva,int NBproduit,int Total, String Date, String Client){
        
        this.Num_Bon =Num_Bon;
        this.NBproduit =NBproduit;
        this.Tva =Tva;
        this.Total =Total;
        this.Date =Date;
        this.Client=Client;
     }
    public Facture_Edentifier (){
        
     }

        
        public int getNum_Bon() {
            return Num_Bon;
        }

       
        public void setNum_Bon(int Num_Bon) {
            this.Num_Bon = Num_Bon;
        }

        
        public int getTva() {
            return Tva;
        }

      
        public void setTva(int Tva) {
            this.Tva = Tva;
        }

        public int getNBproduit() {
            return NBproduit;
        }

        /**
         * @param NBproduit the NBproduit to set
         */
        public void setNBproduit(int NBproduit) {
            this.NBproduit = NBproduit;
        }

        /**
         * @return the Total
         */
        public int getTotal() {
            return Total;
        }

        /**
         * @param Total the Total to set
         */
        public void setTotal(int Total) {
            this.Total = Total;
        }

        /**
         * @return the Date
         */
        public String getDate() {
            return Date;
        }

        /**
         * @param Date the Date to set
         */
        public void setDate(String Date) {
            this.Date = Date;
        }

        /**
         * @return the Client
         */
        public String getClient() {
            return Client;
        }

        /**
         * @param Client the Client to set
         */
        public void setClient(String Client) {
            this.Client = Client;
        }



    
        
        
        
        
        
        
    }
    
}

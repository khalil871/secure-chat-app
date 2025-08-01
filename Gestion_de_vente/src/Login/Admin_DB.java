package Login;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Admin_DB {

       static Connection con = null;
	


// cette méthode pour connecter avec la base de donnes 

    public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/projet_fin";
                       
			con = (Connection) DriverManager.getConnection(url, "dbbrahim","salahbrahim");
			
			 
		} catch (ClassNotFoundException | SQLException e) {}
        return con;
    }
	
    public static List<Admin>  getAdmin(){
		
		List<Admin> list = new ArrayList<Admin>();
		
	try {
		String sql = "SELECT * FROM `admin`";
		Connection con = Admin_DB.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			
		ResultSet resultSet = preparedStatement.executeQuery();
			
		while (resultSet.next()) {
			Admin add = new Admin();
			add.setUsername(resultSet.getString(2));
			add.setPassword(resultSet.getString(3));
				 
				list.add(add);}

			    con.close();
			
		} catch (SQLException e) {}
		
		return list;}
    
        
    /*public static List<Admin>  getvendeur(){
		
		List<Admin> list = new ArrayList<Admin>();
		
	try {
		String sql = "SELECT * FROM `vendeur`";
		Connection con = Admin_DB.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			
		ResultSet resultSet = preparedStatement.executeQuery();
			
		while (resultSet.next()) {
			Admin log = new Admin();
			log.setUsername(resultSet.getString(2));
			log.setPassword(resultSet.getString(3));
				 
				list.add(log);}

			    con.close();
			
		} catch (SQLException e) {}
		
		return list;}*/


    
         



  }

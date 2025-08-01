
package Login;

public class Admin {
    
        private int id;
	private String userName;
	private String password;
	

   public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public  String userNames(){
		return userName;
	}
	
	public  String userPassword(){
		return password;
	}
    
    
    
    
    
    
}

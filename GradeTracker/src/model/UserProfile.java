package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class UserProfile  
{ 
	@Id  
	private Integer UserID; 
	@Column
	private String userName = ""; 
	@Column 
	private String password = ""; 
	
	public UserProfile(String username, String password) 
	{
		this.userName = username; 
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	

}

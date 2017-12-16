package login;

import java.io.Serializable;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id ;
	private String username;
	private String password;
	public Account(int id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Account(Integer id, String username, String passWord) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

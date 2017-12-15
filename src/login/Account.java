package login;

import java.io.Serializable;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id ;
	private String username;
	private String passWord;
	public Account(int id) {
		this.id = id;
	}
	public int getId() {
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Account(int id, String username, String passWord) {
		super();
		this.id = id;
		this.username = username;
		this.passWord = passWord;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

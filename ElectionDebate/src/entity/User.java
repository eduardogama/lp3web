package entity;

import usertype.UserType;




public class User {

	private String login;
	private String pwd;
	private UserType type;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String login, String pwd, UserType type) {
		this.login = login;
		this.pwd = pwd;
		this.type = type;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

}

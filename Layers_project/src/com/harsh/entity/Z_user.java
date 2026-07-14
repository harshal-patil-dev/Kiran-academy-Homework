package com.harsh.entity;

public class Z_user {
	
	private int uid;
	private String username;
	private String email;
	
	public Z_user() {
		super();
	}

	public Z_user(int uid, String username, String email) {
		super();
		this.uid = uid;
		this.username = username;
		this.email = email;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Z_user [uid = " + uid + ", username = " + username + ", email = " + email + "]"
				+ "\n";
	}
	
	

}

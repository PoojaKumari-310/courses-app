package com.cg.userservice.model;

import javax.persistence.Column;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

@Entity
@Table(name="user_tbl")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userId;
	
	@Column(name="name")
	@NotNull(message = "username shouldn't be null")
    private String name;
	
	@Column(name="email")
	@NotNull(message = "invalid email address")
	private String email;
	
	
	@Column(name="mobile")
	
	private long mobile;
	
	@Column(name="username")
	@NotNull(message = "username shouldn't be null")
	private String username;
	
	@Column(name="password")
	@NotNull
	@Size(min = 2, max = 30)
	private String password;

	public User(long userId, String name, @NotNull(message = "Email is required") String email, long mobile,
			@NotNull(message = "Username is required") String username,
			@NotNull(message = "Password is required") String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.username = username;
		this.password = password;
	}

	public User() {
		super();

	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", username="
				+ username + ", password=" + password + "]";
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
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
}

	
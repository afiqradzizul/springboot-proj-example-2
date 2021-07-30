package com.mbb.ib.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mbb.ib.constant.CommonConstant;
import com.mbb.ib.constant.UserConstant;

@Entity(name = UserConstant.userTable)
@Table(name = UserConstant.userTable)
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = CommonConstant.customer_Id)
	private int customer_id;

	@Column(name = CommonConstant.username)
	private String username;

	@Column(name = UserConstant.password)
	private String password;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

	public Users(int customer_id, String username, String password) {
		super();
		this.customer_id = customer_id;
		this.username = username;
		this.password = password;
	}

	public Users() {
		super();
	}
}

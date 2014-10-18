package com.jiahua.model;

import java.sql.Timestamp;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String name;
	private String gender;
	private String idCard;
	private String address;
	private String telno;
	private Timestamp regTime;
	private Double balance;
	private Integer status;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, String password, String name, String gender,
			String idCard, String address, String telno, Timestamp regTime,
			Double balance, Integer status) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.idCard = idCard;
		this.address = address;
		this.telno = telno;
		this.regTime = regTime;
		this.balance = balance;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelno() {
		return this.telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public Timestamp getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
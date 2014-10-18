package com.jiahua.model;

import java.sql.Timestamp;

/**
 * Ticket entity. @author MyEclipse Persistence Tools
 */

public class Ticket implements java.io.Serializable {

	// Fields

	private Integer id;
	private String desc;
	private Timestamp startTime;
	private Integer amount;
	private Integer balance;
	private Double price;
	private Integer status;

	// Constructors

	/** default constructor */
	public Ticket() {
	}

	/** full constructor */
	public Ticket(String desc, Timestamp startTime, Integer amount,
			Integer balance, Double price, Integer status) {
		this.desc = desc;
		this.startTime = startTime;
		this.amount = amount;
		this.balance = balance;
		this.price = price;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getBalance() {
		return this.balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
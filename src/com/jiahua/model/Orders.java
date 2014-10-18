package com.jiahua.model;

import java.sql.Timestamp;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp commitTime;
	private Double amount;
	private Integer userId;
	private Integer status;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(Timestamp commitTime, Double amount, Integer userId,
			Integer status) {
		this.commitTime = commitTime;
		this.amount = amount;
		this.userId = userId;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCommitTime() {
		return this.commitTime;
	}

	public void setCommitTime(Timestamp commitTime) {
		this.commitTime = commitTime;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
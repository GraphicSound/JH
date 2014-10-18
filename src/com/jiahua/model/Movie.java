package com.jiahua.model;

/**
 * Movie entity. @author MyEclipse Persistence Tools
 */

public class Movie implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String desc;
	private Integer duration;
	private Integer status;

	// Constructors

	/** default constructor */
	public Movie() {
	}

	/** full constructor */
	public Movie(String title, String desc, Integer duration, Integer status) {
		this.title = title;
		this.desc = desc;
		this.duration = duration;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
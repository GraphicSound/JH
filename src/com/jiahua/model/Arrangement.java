package com.jiahua.model;

import java.sql.Timestamp;

/**
 * Arrangement entity. @author MyEclipse Persistence Tools
 */

public class Arrangement implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp showTime;
	private String theater;
	private Integer amount;
	private Integer balance;
	private Double price;
	private Integer status;
	private Integer movieId;

	// Constructors

	/** default constructor */
	public Arrangement() {
	}

	/** minimal constructor */
	public Arrangement(Timestamp showTime, String theater, Integer amount,
			Integer balance, Double price, Integer status) {
		this.showTime = showTime;
		this.theater = theater;
		this.amount = amount;
		this.balance = balance;
		this.price = price;
		this.status = status;
	}

	/** full constructor */
	public Arrangement(Timestamp showTime, String theater, Integer amount,
			Integer balance, Double price, Integer status, Integer movieId) {
		this.showTime = showTime;
		this.theater = theater;
		this.amount = amount;
		this.balance = balance;
		this.price = price;
		this.status = status;
		this.movieId = movieId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getShowTime() {
		return this.showTime;
	}

	public void setShowTime(Timestamp showTime) {
		this.showTime = showTime;
	}

	public String getTheater() {
		return this.theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
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

	public Integer getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

    @Override
    public String toString() {
        return "Arrangement{" +
                "id=" + id +
                ", showTime=" + showTime +
                ", theater='" + theater + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                ", price=" + price +
                ", status=" + status +
                ", movieId=" + movieId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Arrangement that = (Arrangement) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (movieId != null ? !movieId.equals(that.movieId) : that.movieId != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (showTime != null ? !showTime.equals(that.showTime) : that.showTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (theater != null ? !theater.equals(that.theater) : that.theater != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (showTime != null ? showTime.hashCode() : 0);
        result = 31 * result + (theater != null ? theater.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (movieId != null ? movieId.hashCode() : 0);
        return result;
    }
}
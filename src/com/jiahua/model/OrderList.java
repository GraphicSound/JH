package com.jiahua.model;

/**
 * OrderList entity. @author MyEclipse Persistence Tools
 */

public class OrderList implements java.io.Serializable {

	// Fields

	private Integer id;
	private Double price;
	private Integer quantity;
	private Double amount;
	private Integer arrangementId;
	private Integer ordersId;
	private Integer status;

	// Constructors

	/** default constructor */
	public OrderList() {
	}

	/** full constructor */
	public OrderList(Double price, Integer quantity, Double amount,
			Integer arrangementId, Integer ordersId, Integer status) {
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
		this.arrangementId = arrangementId;
		this.ordersId = ordersId;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getArrangementId() {
		return this.arrangementId;
	}

	public void setArrangementId(Integer arrangementId) {
		this.arrangementId = arrangementId;
	}

	public Integer getOrdersId() {
		return this.ordersId;
	}

	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

    @Override
    public String toString() {
        return "OrderList{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", arrangementId=" + arrangementId +
                ", ordersId=" + ordersId +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderList orderList = (OrderList) o;

        if (amount != null ? !amount.equals(orderList.amount) : orderList.amount != null) return false;
        if (arrangementId != null ? !arrangementId.equals(orderList.arrangementId) : orderList.arrangementId != null)
            return false;
        if (id != null ? !id.equals(orderList.id) : orderList.id != null) return false;
        if (ordersId != null ? !ordersId.equals(orderList.ordersId) : orderList.ordersId != null) return false;
        if (price != null ? !price.equals(orderList.price) : orderList.price != null) return false;
        if (quantity != null ? !quantity.equals(orderList.quantity) : orderList.quantity != null) return false;
        if (status != null ? !status.equals(orderList.status) : orderList.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (arrangementId != null ? arrangementId.hashCode() : 0);
        result = 31 * result + (ordersId != null ? ordersId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
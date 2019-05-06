package com.bookstore.entity;
// Generated May 6, 2019, 8:25:37 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderDetailsId generated by hbm2java
 */
@Embeddable
public class OrderDetailsId implements java.io.Serializable {

	private int orderId;
	private int bookId;

	public OrderDetailsId() {
	}

	public OrderDetailsId(int orderId, int bookId) {
		this.orderId = orderId;
		this.bookId = bookId;
	}

	@Column(name = "order_id", nullable = false)
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name = "book_id", nullable = false)
	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderDetailsId))
			return false;
		OrderDetailsId castOther = (OrderDetailsId) other;

		return (this.getOrderId() == castOther.getOrderId()) && (this.getBookId() == castOther.getBookId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOrderId();
		result = 37 * result + this.getBookId();
		return result;
	}

}

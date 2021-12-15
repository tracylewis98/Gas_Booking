package com.gasbooking.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "gas_booking")
public class GasBooking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -48597437543156221L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "gas_booking_id")
	private int gasBookingId;
	
	@Column(name = "local_date")
	private LocalDate localDate;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "bill")
	private double bill;
	
	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonBackReference("4")
	private Customer customer;
	
	//constructors
	
	public GasBooking() {
		super();
	}
	
	public GasBooking(int gasBookingId, LocalDate localDate, boolean status, double bill) {
		super();
		this.gasBookingId = gasBookingId;
		this.localDate = localDate;
		this.status = status;
		this.bill = bill;
	}

	// setters and getters
	
	public int getGasBookingId() {
		return gasBookingId;
	}
	
	public void setGasBookingId(int gasBookingId) {
		this.gasBookingId = gasBookingId;
	}
	
	public LocalDate getLocalDate() {
		return localDate;
	}
	
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public double getBill() {
		return bill;
	}
	
	public void setBill(double bill) {
		this.bill = bill;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// toString
	
	@Override
	public String toString() {
		return "GasBooking [gasBookingId=" + gasBookingId + ", localDate=" + localDate + ", status=" + status
				+ ", bill=" + bill + "]";
	}
	
}

// developer - Gangireddy Geetha
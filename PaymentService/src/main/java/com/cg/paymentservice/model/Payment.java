package com.cg.paymentservice.model;

import java.time.LocalDate;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "payment_tbl")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentId")
	private long paymentId;
	
	@Column(name = "modeOfPayment")
	private String modeOfPayment;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "dateOfPayment")
	private LocalDate dateOfPayment;
	
	@Column(name = "paymentStatus")
	private String paymentStatus;

	public Payment() {
		super();
		
	}

	public Payment(long paymentId, String modeOfPayment, double amount, LocalDate dateOfPayment, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.modeOfPayment = modeOfPayment;
		this.amount = amount;
		this.dateOfPayment = dateOfPayment;
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", modeOfPayment=" + modeOfPayment + ", amount=" + amount
				+ ", dateOfPayment=" + dateOfPayment + ", paymentStatus=" + paymentStatus + "]";
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(LocalDate dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
	


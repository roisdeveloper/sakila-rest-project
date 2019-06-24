package com.sakila.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="payment",schema="public")
public class Payment {
	
	@Id
	@Column(name="payment_id")
	@GenericGenerator(
			name="payment_payment_id_seq_name",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name="payment_payment_id_seq",value="payment_payment_id_seq"),					
			}
	)
	@GeneratedValue(generator="payment_payment_id_seq_name")
	private Long paymentId;
	@Column(name="customer_id")
	private String customerId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="staff_id")
	private Staff staffId;
	@Column(name="rental_id")
	private String rentalId;
	@Column(name="amount")
	private String amount;
	@Column(name="payment_date")
	private Date paymentDate;
	
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public Staff getStaffId() {
		return staffId;
	}
	public void setStaffId(Staff staffId) {
		this.staffId = staffId;
	}
	public String getRentalId() {
		return rentalId;
	}
	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	

}

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
@Table(name="rental",schema="public")
public class Rental {
	@Id
	@Column(name="rental_id")
	@GenericGenerator(
			name="rental_rental_id_seq_name",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name="rental_rental_id_seq",value="rental_rental_id_seq"),					
			}
	)
	@GeneratedValue(generator="rental_rental_id_seq_name")
	private Long rentalId;
	@Column(name="rental_date")
	private String rentalDate;
	@Column(name="inventory_id")
	private String inventoryId;
	@Column(name="customer_id")
	private String customerId;
	@Column(name="return_date")
	private String returnDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="staff_id")
	private Staff staffId;
	@Column(name="last_update")
	private Date lastUpdate;
	public Long getRentalId() {
		return rentalId;
	}
	public void setRentalId(Long rentalId) {
		this.rentalId = rentalId;
	}
	public String getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}
	public String getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public Staff getStaffId() {
		return staffId;
	}
	public void setStaffId(Staff staffId) {
		this.staffId = staffId;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	

}

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
@Table(name="customer",schema="public")
public class Customer {
	@Id
	@Column(name="customer_id")
	@GenericGenerator(
			name="customer_customer_id_seq_name",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name="customer_customer_id_seq",value="customer_customer_id_seq"),					
			}
	)
	@GeneratedValue(generator="customer_customer_id_seq_name")
	private Long customerId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="store_id")
	private Store storeId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="address_id")
	private String addressId;
	@Column(name="activebool")
	private String activebool;
	@Column(name="create_date")
	private String createDate;
	@Column(name="last_update")
	private Date lastUpdate;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Store getStoreId() {
		return storeId;
	}
	public void setStoreId(Store storeId) {
		this.storeId = storeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getActivebool() {
		return activebool;
	}
	public void setActivebool(String activebool) {
		this.activebool = activebool;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	

}

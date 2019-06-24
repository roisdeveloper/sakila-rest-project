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
@Table(name="store",schema="public")
public class Store {
	@Id
	@Column(name="store_id")
	@GenericGenerator(
			name="store_store_id_seq_name",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name="store_store_id_seq",value="store_store_id_seq"),					
			}
	)
	@GeneratedValue(generator="store_store_id_seq_name")
	private Long storeId;
	@Column(name="manager_staff_id")
	private Long managerStaffId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="address_id")
	private Address addressId;
	@Column(name="last_update")
	private Date lastUpdate;
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public Long getManagerStaffId() {
		return managerStaffId;
	}
	public void setManagerStaffId(Long managerStaffId) {
		this.managerStaffId = managerStaffId;
	}
	public Address getAddressId() {
		return addressId;
	}
	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}

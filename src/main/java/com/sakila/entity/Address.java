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
@Table(name="address",schema="public")
public class Address {
	@Id
	@Column(name="address_id")
	@GenericGenerator(
			name="address_address_id_seq_name",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name="address_address_id_seq",value="address_address_id_seq"),					
			}
	)
	@GeneratedValue(generator="address_address_id_seq_name")
	private Long addressId;
	@Column(name="address")
	private String address;
	@Column(name="address2")
	private String address2;
	@Column(name="district")
	private String district;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="city_id")
	private City cityId;
	@Column(name="postal_code")
	private String postalCode;
	@Column(name="phone")
	private String phone;
	@Column(name="last_update")
	private Date lastUpdate;
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public City getCityId() {
		return cityId;
	}
	public void setCityId(City cityId) {
		this.cityId = cityId;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}

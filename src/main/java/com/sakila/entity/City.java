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
@Table(name="city",schema="public")
public class City {
	
	@Id
	@Column(name="city_id")
	@GenericGenerator(
			name="city_city_id_seq_name",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name="city_city_id_seq",value="city_city_id_seq"),					
			}
	)
	@GeneratedValue(generator="city_city_id_seq_name")
	private Long cityId;
	@Column(name="city")
	private String city;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country countryId;
	@Column(name="last_update")
	private Date lastUpdate;
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Country getCountryId() {
		return countryId;
	}
	public void setCountryId(Country countryId) {
		this.countryId = countryId;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}

package com.sakila.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="country",schema="public")
public class Country {
	@Id
	@Column(name="country_id")
	@GenericGenerator(
			name="country_country_id_seq_name",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name="country_country_id_seq",value="country_country_id_seq"),					
			}
	)
	@GeneratedValue(generator="country_country_id_seq_name")
	private Long countryId;
	
	@NotNull
	@NotEmpty
	@Column(name="country")
	private String country;
	
	@CreatedDate
	@Temporal(TemporalType.DATE)
	@Column(name="last_update")
	private Date lastUpdate;

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}

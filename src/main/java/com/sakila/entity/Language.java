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
@Table(name = "language",schema="public")
public class Language {
	@Id
	@Column(name = "language_id")
	@GenericGenerator(name = "language_language_id_seq_name", 
	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
	parameters = {
			@Parameter(name = "language_language_id_seq", value = "language_language_id_seq"), 
			})
	@GeneratedValue(generator = "language_language_id_seq_name")
	private Long languageId;
	@NotNull
	@NotEmpty
	@Column(name = "name")
	private String name;

	@CreatedDate
	@Temporal(TemporalType.DATE)
	@Column(name = "last_update")
	private Date lastUpdate;

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}

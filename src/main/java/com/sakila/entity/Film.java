package com.sakila.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="film",schema="public")
public class Film {
	@Id
	@Column(name="film_id")
	@GenericGenerator(
			name="film_film_id_seq_name",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name="film_film_id_seq",value="film_film_id_seq"),					
			}
	)
	@GeneratedValue(generator="film_film_id_seq_name")
	private Long filmId;
	
	@NotNull
	@NotEmpty
	@Column(name="title")
	private String title;
	
	@Column(name="description",nullable=true)
	private String description;
	
	@Column(name="release_year",nullable=true)
	private Integer releaseYear;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="language_id")
	private Language languageId;
	
	@NotNull
	@NotEmpty
	@Column(name="rental_duration")
	private Short rentalDuration;
	
	@NotNull
	@NotEmpty
	@Column(name="rental_rate")
	private BigDecimal rentalRate;
	
	@Column(name="length",nullable=true)
	private Integer length;
	
	@NotNull
	@NotEmpty
	@Column(name="replacement_cost")
	private BigDecimal replacementCost;
	
	@Column(name="rating",nullable=true)
	private String rating;
	
	@CreatedDate
	@Temporal(TemporalType.DATE)
	@Column(name="last_update")
	private Date lastUpdate;
	
	@Column(name="special_features",nullable=true)
	private String specialFeatures;
	
	@NotNull
	@NotEmpty
	@Column(name="fulltext")
	private String fulltext;
	
	
	public Long getFilmId() {
		return filmId;
	}


	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getReleaseYear() {
		return releaseYear;
	}


	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}


	public Language getLanguageId() {
		return languageId;
	}


	public void setLanguageId(Language languageId) {
		this.languageId = languageId;
	}


	public Short getRentalDuration() {
		return rentalDuration;
	}


	public void setRentalDuration(Short rentalDuration) {
		this.rentalDuration = rentalDuration;
	}


	public BigDecimal getRentalRate() {
		return rentalRate;
	}


	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}


	public Integer getLength() {
		return length;
	}


	public void setLength(Integer length) {
		this.length = length;
	}


	public BigDecimal getReplacementCost() {
		return replacementCost;
	}


	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public Date getLastUpdate() {
		return lastUpdate;
	}


	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	public String getSpecialFeatures() {
		return specialFeatures;
	}


	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}


	public String getFulltext() {
		return fulltext;
	}


	public void setFulltext(String fulltext) {
		this.fulltext = fulltext;
	}


	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof Film)) return false;
		return filmId !=null && filmId.equals(((Film)obj).getFilmId());
	}
	
	@Override
	public int hashCode() {
		return 31;
	}
}

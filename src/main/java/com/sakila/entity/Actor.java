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
@Table(name = "actor", schema = "public")
public class Actor {
	@Id
	@Column(name = "actor_id")
	@GenericGenerator(
			name = "actor_actor_id_seq_name", 
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
			parameters = {
			@Parameter(name = "actor_actor_id_seq", value = "actor_actor_id_seq"), 
			})
	@GeneratedValue(generator = "actor_actor_id_seq_name")
	private Long actorId;
	
	@NotNull
	@NotEmpty
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@NotEmpty
	@Column(name = "last_name")
	private String lastName;
	
	@CreatedDate
	@Temporal(TemporalType.DATE)
	@Column(name = "last_update")
	private Date lastUpdate;

	public Long getActorId() {
		return actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
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

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}

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
@Table(name="inventory",schema="public")
public class Inventory {
	@Id
	@Column(name="inventory_id")
	@GenericGenerator(
			name="inventory_inventory_id_seq_name",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name="inventory_inventory_id_seq",value="inventory_inventory_id_seq"),					
			}
	)
	@GeneratedValue(generator="inventory_inventory_id_seq_name")
	private Long inventoryId;
	@Column(name="film_id")
	private String filmId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="store_id")
	private Store storeId;
	@Column(name="last_update")
	private Date lastUpdate;
	public Long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getFilmId() {
		return filmId;
	}
	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}
	public Store getStoreId() {
		return storeId;
	}
	public void setStoreId(Store storeId) {
		this.storeId = storeId;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	

}

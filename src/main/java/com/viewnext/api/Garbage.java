package com.viewnext.api;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Bean de la tabla garbage
 *
 */

@Entity
public class Garbage {

	@Id
	private Integer id;

	private String description;

	public Garbage() {
	}

	public Garbage(Integer idIn, final String desc) {
		this.id = idIn;
		this.description = desc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

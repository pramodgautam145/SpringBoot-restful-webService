package com.example.rest.springrestws.JpaDynamicexample;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class JPost {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String description;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private JUser juser;

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

	public JUser getJuser() {
		return juser;
	}

	public void setJuser(JUser juser) {
		this.juser = juser;
	}

	@Override
	public String toString() {
		return "JPost [id=" + id + ", description=" + description + "]";
	}
	
}

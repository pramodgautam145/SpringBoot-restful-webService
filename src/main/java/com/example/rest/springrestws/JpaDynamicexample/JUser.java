package com.example.rest.springrestws.JpaDynamicexample;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//used for swagger document info
@ApiModel(description ="All detail about user")
@Entity
public class JUser {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message ="Name Should have atleast two character")
	@ApiModelProperty(notes ="Name Should have atleast two character") //used swagger document info
	
	private String name;
	@Past
	@ApiModelProperty(notes ="birth Should be in Past") //used swagger document info
	// @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dob;
    @OneToMany(mappedBy="juser")
	private List<JPost> jposts;
	public JUser() {
		super();
	}

	public JUser(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
     
	

	public List<JPost> getJposts() {
		return jposts;
	}

	public void setJposts(List<JPost> jposts) {
		this.jposts = jposts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
	
}

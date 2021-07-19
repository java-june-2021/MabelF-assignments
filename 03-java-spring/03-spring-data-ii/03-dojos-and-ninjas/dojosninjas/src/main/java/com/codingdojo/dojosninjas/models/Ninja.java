package com.codingdojo.dojosninjas.models;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size; // Did something weird to resolve this. idk if it works

@Entity
@Table(name="ninjas")
public class Ninja { // Model needs Getters & Setters!
	/** 1. Attributes */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; // id of ninja
	
	@Size(min = 2, max=100)
	private String firstName; // first name of ninja
	
	@Size(min = 2, max=100)
	private String lastName; // last name of ninja

	
	@Min(1)
	private int age;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	// Spring MVC forms uses this so we can't delete it
	public Ninja() {
		
	}


	
	// Overload for HTML only if you are working with forms and request param
	// Straight strings need overloaded constructor, blank java object won't cut it
	// Delete validation and super(); - reason tbd
//	public Dojo(String bandName, String albumName, int releaseYear) {
//		this.bandName = bandName;
//		this.albumName = albumName;
//		this.releaseYear = releaseYear;
//	}


	
	/** GETTERS AND SETTERS */ 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}


}

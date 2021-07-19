package com.codingdojo.dojosninjas.models;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size; // Did something weird to resolve this. idk if it works

@Entity
@Table(name="dojos")
public class Dojo { // Model needs Getters & Setters!
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; // id of dojo
	
	@Size(min = 1, max=100)
	private String name; // name of dojo

	
	@OneToMany(mappedBy="dojo", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Ninja> ninjas; // The name of the object inside Child.java
	
	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}


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
	public Dojo() {
		
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


}

package com.codingdojo.languages.models;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="languages")
public class Language { // Model needs Getters & Setters!
	
	// Attributes with validation. Make sure they are all private. 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Size(min = 2, max=20, message = "Language name should be between 2 and 20 characters inclusive.")
	private String name; // Name of language, this annotation takes care of not blank
	
	@Size(min = 2, max=20, message = "Creator name should be between 2 and 20 characters inclusive.")
	private String creator;
	
	@NotBlank
	@NotNull(message = "currentVersion cannot be null")
	private String currentVersion;
	
	

	/** Created and Updated - Do not touch*/
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
	/** Created and Updated - Do not touch*/
	
	
	// Spring MVC forms uses this constructor so we can't delete it
	public Language() {
		
	}
	
	// Overload for HTML only if you are working with forms and request param
	// Straight strings need overloaded constructor, blank java object won't cut it
	// Delete validation and super(); - reason tbd
	public Language(String name, String creator, String currentVersion) {
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
	}

	/** Generate Getters and Setters */
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	// TODO this looks dangerous to expose?
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	// TODO this looks dangerous to expose?
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


}

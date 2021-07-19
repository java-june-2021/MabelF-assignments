package com.codingdojo.dojosninjas.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="labels")
public class Label {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String city;
	
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="album_id") // This one is from mySQL
	private Album album; // Child
	
	public Album getAlbum() { // Make sure to have getter.
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Label() {
	}
	
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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
}

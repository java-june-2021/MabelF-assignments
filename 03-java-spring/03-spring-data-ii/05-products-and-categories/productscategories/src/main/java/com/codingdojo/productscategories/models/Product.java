package com.codingdojo.productscategories.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
	/** 
	 * Products have:
	 * - (an id)
	 * - Name
	 * - Description
	 * - Price
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min = 1, max=500)
	private String productName;
	@Size(min = 2, max=2000)
	private String productDescription;
	@DecimalMin(value = "0.01", inclusive = true, message = "Invalid Input")
	private BigDecimal productPrice; //https://www.baeldung.com/javax-bigdecimal-validation
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="categories_products", joinColumns = @JoinColumn(name="product_id"), inverseJoinColumns = @JoinColumn(name="category_id"))
	private List<Category> categoriesOfProduct;
	

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
	public Product() {
		
	}
	

	/** Getters and setters */
	public List<Category> getCategoriesOfProduct() {
		return categoriesOfProduct;
	}

	public void setCategoriesOfProduct(List<Category> categoriesOfProduct) {
		this.categoriesOfProduct = categoriesOfProduct;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
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

package com.codingdojo.productscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.CategoryRepository;
import com.codingdojo.productscategories.repositories.ProductRepository;

@Service
public class ProductService {
//	@Autowired
//	ProductRepository pRepo; //TODO see if this works
	private ProductRepository pRepo;
	public ProductService(ProductRepository pRepo) {
		this.pRepo = pRepo;
	}
	@Autowired
	private CategoryRepository cRepo;
	
	// Display All Albums
	public List<Product> allProducts() {
		return this.pRepo.findAll();
	}
	
	// Create
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	// Read
	public Product getOneProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	// Update
	public Product updateProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	// Delete - Not required for this but here for good practice
	public String deleteProduct(Long id) {
		this.pRepo.deleteById(id);
		return "Product with this id: " + id + " has been deleted.";
 	}
	
	// NEW: Add a category to product
	public void addCategoryToProduct(Product product, Category category) {
		List<Category> currentCategories = product.getCategoriesOfProduct();
		if (!currentCategories.contains(category)) {	
			currentCategories.add(category); // Add this new category to the product's current list of categories
			this.pRepo.save(product);
		}
		
	}

}

package com.codingdojo.productscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.CategoryRepository;
import com.codingdojo.productscategories.repositories.ProductRepository;

@Service
public class CategoryService {
	private CategoryRepository cRepo;
	public CategoryService(CategoryRepository cRepo) {
		this.cRepo = cRepo;
	}
	@Autowired
	private ProductRepository pRepo;
	
	// Display All Albums
	public List<Category> allCategorys() {
		return this.cRepo.findAll();
	}
	
	// Create
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	// Read
	public Category getOneCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	// Update
	public Category updateCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	// Delete - Not required for this but here for good practice
	public String deleteCategory(Long id) {
		this.cRepo.deleteById(id);
		return "Category with this id: " + id + " has been deleted.";
 	}

//	// NEW: Add a product to category
	public void addProductToCategory(Product product, Category category) {
		List<Product> currentProducts = category.getProductsInCategory();
		if (!currentProducts.contains(product)) {	
			currentProducts.add(product); // Prevent duplicates
			this.cRepo.save(category);
		}
		
	}
}

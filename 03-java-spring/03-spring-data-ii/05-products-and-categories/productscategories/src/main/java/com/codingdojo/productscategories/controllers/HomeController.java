package com.codingdojo.productscategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.services.CategoryService;
import com.codingdojo.productscategories.services.ProductService;

@Controller
public class HomeController {
	// Dependency injection
	@Autowired 
	private ProductService pService;
	@Autowired 
	private CategoryService cService;
	
	// No home page
	
	
	/** Product-specific Controllers */
	
	/** NEW GET */
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}

	/** NEW POST */
	@PostMapping("/products/addNew")
	public String addNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,  RedirectAttributes redirectAttr) {
		if (result.hasErrors()) {
			return "/products/new.jsp";//Rerender 
		}
		this.pService.createProduct(product);
		redirectAttr.addFlashAttribute("addSuccess", "Your product has been added.");
		return "redirect:/products/new";
	}
	
	
	/** INFO GET */
	@GetMapping("/products/{product_id}")
	public String showProduct(@PathVariable("product_id") Long id, Model viewModel) {
		viewModel.addAttribute("product", this.pService.getOneProduct(id));
		viewModel.addAttribute("categoriesin", this.pService.getOneProduct(id).getCategoriesOfProduct());
		viewModel.addAttribute("allcategories", this.cService.allCategorys());
		return "/products/show.jsp";
	}
	
	/** INFO ADD - Adding category TO product via Dropdown */
	@PostMapping("/products/{product_id}")
	public String addCategoryToProduct(@PathVariable("product_id") Long id, @RequestParam("newCat") Long catId) {
		Product thisProduct = this.pService.getOneProduct(id);
		Category thisCategory = this.cService.getOneCategory(catId);
		this.pService.addCategoryToProduct(thisProduct, thisCategory); // This method is inside productService
		return "redirect:/products/{product_id}"; // Rerender
	}
	
	
	
	/** Category-specific Controllers --------------------------------------------------------------------------- */
	
	/** NEW GET */
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}

	/** NEW POST */
	@PostMapping("/categories/addNew")
	public String addNewCategory(@Valid @ModelAttribute("category") Category category, BindingResult result,  RedirectAttributes redirectAttr) {
		if (result.hasErrors()) {
			return "/categories/new.jsp";//Rerender 
		}
		this.cService.createCategory(category);
		redirectAttr.addFlashAttribute("addSuccess", "Your category has been added.");
		return "redirect:/categories/new";
	}
	
	/** INFO GET */
	@GetMapping("/categories/{category_id}")
	public String showCategory(@PathVariable("category_id") Long id, Model viewModel) {
		viewModel.addAttribute("category", this.cService.getOneCategory(id));
		viewModel.addAttribute("productsin", this.cService.getOneCategory(id).getProductsInCategory());
		viewModel.addAttribute("allproducts", this.pService.allProducts());
		return "/categories/show.jsp";
	}
	
	/** INFO ADD - Adding category TO product via Dropdown */
	@PostMapping("/categories/{category_id}")
	public String addProductToCategory(@PathVariable("category_id") Long id, @RequestParam("newProd") Long prodId) {
		Product thisProduct = this.pService.getOneProduct(prodId);
		Category thisCategory = this.cService.getOneCategory(id);
		this.cService.addProductToCategory(thisProduct, thisCategory);
		return "redirect:/categories/{category_id}"; // Rerender
	}
	

}

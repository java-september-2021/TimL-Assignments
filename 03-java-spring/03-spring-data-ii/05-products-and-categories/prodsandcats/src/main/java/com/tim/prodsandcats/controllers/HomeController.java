package com.tim.prodsandcats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tim.prodsandcats.models.Category;
import com.tim.prodsandcats.models.Product;
import com.tim.prodsandcats.services.CategoryService;
import com.tim.prodsandcats.services.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private ProductService pService;
	@Autowired
	private CategoryService cService;
	
	@GetMapping("/products/new")
	public String newProduct() {
		return "newProduct.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCategory() {
		return "newCategory.jsp";
	}
	
	@PostMapping("/newCategory")
	public String makeCategory(@RequestParam("category") String category) {
		Category newCategory = new Category();
		newCategory.setName(category);
		this.cService.createCategory(newCategory);
		return "redirect:/categories/new";
	}
	
	@PostMapping("/newProduct")
	public String makeProduct(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("price") Double price) {
		Product newProduct = new Product(name, description, price);
		this.pService.createProduct(newProduct);
		return "redirect:/products/new";
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(Model viewModel, @PathVariable("id") Long id) {
		Product productToShow = this.pService.findProduct(id);
		viewModel.addAttribute("notInProd", this.cService.findCategoryNotContainProduct(productToShow));
		viewModel.addAttribute("product", productToShow);
		return "productPage.jsp";
	}
	
	@PostMapping("/addCatToProd/{id}")
	public String addCatToProd(@RequestParam("categories") Long id, @PathVariable("id") Long productId) {
		Product productToAddCategoryTo = this.pService.findProduct(productId);
		Category categoryToAddProductTo = this.cService.findCategory(id);
		this.pService.addCategoryToProduct(productToAddCategoryTo, categoryToAddProductTo);
		return "redirect:/products/{id}";
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(Model viewModel, @PathVariable("id") Long id) {
		Category categoryToShow = this.cService.findCategory(id);
		viewModel.addAttribute("notInCat", this.pService.findProductNotContainCategory(categoryToShow));
		viewModel.addAttribute("category", categoryToShow);
		return "categoryPage.jsp";
	}
	
	@PostMapping("/addProdToCat/{id}")
	public String addProdToCat(@RequestParam("products") Long id, @PathVariable("id") Long categoryId) {
		Category categoryToAddProductTo = this.cService.findCategory(categoryId);
		Product productToAddCategoryTo = this.pService.findProduct(id);
		this.cService.addProductToCategory(categoryToAddProductTo, productToAddCategoryTo);
		return "redirect:/categories/{id}";
	}
	
}

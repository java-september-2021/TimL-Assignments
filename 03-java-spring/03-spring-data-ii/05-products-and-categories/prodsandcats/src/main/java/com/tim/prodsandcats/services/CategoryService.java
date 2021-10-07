package com.tim.prodsandcats.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim.prodsandcats.models.Category;
import com.tim.prodsandcats.models.Product;
import com.tim.prodsandcats.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	public Category findCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	public List<Category> findCategoryNotContainProduct(Product product){
		return this.cRepo.findByProductsNotContains(product);
	}
	
	public void addProductToCategory(Category category, Product product) {
		List<Product> existingProducts = category.getProducts();
		existingProducts.add(product);
		this.cRepo.save(category);
	}
}

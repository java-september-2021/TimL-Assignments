package com.tim.prodsandcats.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim.prodsandcats.models.Category;
import com.tim.prodsandcats.models.Product;
import com.tim.prodsandcats.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	public Product findProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public List<Product> findProductNotContainCategory(Category category){
		return this.pRepo.findByCategoriesNotContains(category);
	}
	
	public void addCategoryToProduct(Product product, Category category) {
		List<Category> existingCategories = product.getCategories();
		existingCategories.add(category);
		this.pRepo.save(product);
	}
}

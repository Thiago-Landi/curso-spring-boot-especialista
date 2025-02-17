package com.Thiago_Landi.produtosapi.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Thiago_Landi.produtosapi.model.Product;
import com.Thiago_Landi.produtosapi.repository.ProductRepository;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductRepository repository;
	
	// o RequestBody serve para transformar os dados recebido no postman em um objeto java
	@PostMapping
	public Product save(@RequestBody Product product) {
		System.out.println("Product received: " + product);		
		var id = UUID.randomUUID().toString();
		product.setId(id);
		repository.save(product);
		return product;
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable String id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}
		else {
			System.out.println("Id inexistente");
		}
	}
	
}

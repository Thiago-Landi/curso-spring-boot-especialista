package com.Thiago_Landi.produtosapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Thiago_Landi.produtosapi.model.Product;

@RestController
@RequestMapping("products")
public class ProductController {

	@PostMapping
	public void save(@RequestBody Product product) {
		System.out.println("Product received: " + product);
	}
}

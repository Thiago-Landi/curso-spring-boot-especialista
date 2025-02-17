package com.Thiago_Landi.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Thiago_Landi.produtosapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}

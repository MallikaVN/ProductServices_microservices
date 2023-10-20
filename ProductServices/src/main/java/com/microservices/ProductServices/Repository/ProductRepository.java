package com.microservices.ProductServices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.ProductServices.DTO.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> 
{

}

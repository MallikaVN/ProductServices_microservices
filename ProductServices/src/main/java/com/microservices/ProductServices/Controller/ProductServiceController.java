package com.microservices.ProductServices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.ProductServices.Request.ProductRequest;
import com.microservices.ProductServices.Response.ProductErrorResponse;
import com.microservices.ProductServices.Response.ProductResponse;
import com.microservices.ProductServices.Service.ProductService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/service")
public class ProductServiceController 
{
	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<Integer> addProduct(@RequestBody ProductRequest productRequest)
	{
		log.info("ProductServiceController | addProduct() | is called");
		
//		Integer id = (Integer) productService.addProduct(productRequest);
//		return ResponseEntity.ok(id);
		
//		OR
		
		int id = productService.addProduct(productRequest);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ProductResponse> getProductById(@RequestParam int productId)
	{
		log.info("ProductServiceController | getProductById() | is called");
		
		ProductResponse productResponse = productService.getProductById(productId);
		
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
		
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteProductById(@RequestParam int productId)
	{
		log.info("ProductServiceController | deleteProductById() | is called");
		productService.deleteProductById(productId);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}

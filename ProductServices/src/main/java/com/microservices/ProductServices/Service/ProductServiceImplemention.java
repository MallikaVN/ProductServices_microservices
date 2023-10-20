package com.microservices.ProductServices.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.ProductServices.DTO.Product;
import com.microservices.ProductServices.Exception.ProductServiceCustomException;
import com.microservices.ProductServices.Repository.ProductRepository;
import com.microservices.ProductServices.Request.ProductRequest;
import com.microservices.ProductServices.Response.ProductResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor  // will generate constructor implicitly for only required variables
@Log4j2  // it is used to capture the important data regarding operations.
public class ProductServiceImplemention implements ProductService
{
	@Autowired
	ProductRepository productRepository;

	@Override
	public int addProduct(ProductRequest productRequest) 
	{	
		log.info("ProductServiceImplemention | addProduct is called");   // Just to provide an information about the process in the console
		
		Product product = Product.builder()
				.productName(productRequest.getProductName())
				.price(productRequest.getPrice())
				.quantity(productRequest.getQuantity())
				.build();
		
		product = productRepository.save(product);
		
		log.info("ProductServiceImplemention | addProduct | Product object created and inserted into the database");
		log.info("ProductServiceImplemention | addProduct | Product id: " + product.getProductId());
		
		return product.getProductId();
	}
	
	@Override
	public ProductResponse getProductById(int productId) 
	{
		log.info("ProductServiceImplemention | getProductById | is called");
		log.info("ProductServiceImplemention | getProductById | Getting the product for Id : " + productId);
		
		Product product =  productRepository.findById(productId).orElseThrow(
				() -> new ProductServiceCustomException("Product with given id is not found", "0001_PRODUCT_NOT_FOUND"));
		
		ProductResponse productResponse = new ProductResponse();
		
		BeanUtils.copyProperties(product, productResponse); // it is used to copy values of variables from one class to another class when variables names are same
		
		log.info("ProductServiceImplemention | getProductById | ProductResponse is returned");
		
		return productResponse;
	}

	@Override
	public void deleteProductById(int productId) 
	{
		log.info("ProductServiceImplemention | deleteProductById | is called");
		log.info("ProductServiceImplemention | deleteProductById | Deleting the product with Id : " + productId);
		
		if (!productRepository.existsById(productId))
		{
			throw new ProductServiceCustomException("Product with given id is not found", "0001_PRODUCT_NOT_FOUND");
		}
		
		log.info("ProductServiceImplemention | deleteProductById | Deleted the product with Id : " + productId);
		
		productRepository.deleteById(productId);
		
		
	}



}

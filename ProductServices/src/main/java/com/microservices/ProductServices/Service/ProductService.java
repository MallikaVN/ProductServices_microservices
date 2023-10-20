package com.microservices.ProductServices.Service;

import com.microservices.ProductServices.Request.ProductRequest;
import com.microservices.ProductServices.Response.ProductResponse;

public interface ProductService 
{
	int addProduct(ProductRequest productRequest);
	
	void deleteProductById(int productId);
	
	ProductResponse getProductById(int productId);

}

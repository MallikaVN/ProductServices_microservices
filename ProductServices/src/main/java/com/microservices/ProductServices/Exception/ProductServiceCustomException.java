package com.microservices.ProductServices.Exception;

import lombok.Data;

@Data
public class ProductServiceCustomException extends RuntimeException
{
	private String errorCode;
	public ProductServiceCustomException(String errorMessage, String errorCode)
	{
		super(errorMessage);
		this.errorCode = errorCode;		
	}
}

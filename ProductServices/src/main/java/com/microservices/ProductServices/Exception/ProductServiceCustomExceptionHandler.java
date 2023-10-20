package com.microservices.ProductServices.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservices.ProductServices.Response.ProductErrorResponse;

@ControllerAdvice    //
public class ProductServiceCustomExceptionHandler extends ResponseEntityExceptionHandler  //ResponseEntityExceptionHandler is an inbuilt class for handling exceptions
{
	@ExceptionHandler(ProductServiceCustomException.class)
	public ResponseEntity<ProductErrorResponse> handleProductServiceException(ProductServiceCustomException exception)
	{
		return new ResponseEntity<>(new ProductErrorResponse().builder()
				.errorMessage(exception.getMessage())
				 .errorCode(exception.getErrorCode())
				 .build() , HttpStatus.NOT_FOUND);
	}
}

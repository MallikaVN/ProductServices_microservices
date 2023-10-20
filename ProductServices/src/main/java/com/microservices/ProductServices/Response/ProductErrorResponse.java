package com.microservices.ProductServices.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductErrorResponse 
{
	private String errorMessage;
	private String errorCode;
	
	
}

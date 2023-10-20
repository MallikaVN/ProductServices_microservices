package com.microservices.ProductServices.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // will generate getters and setters implicitly
@AllArgsConstructor // will generate argumented constructor with all below variables implicitly
@NoArgsConstructor //// will generate non argumented constructor implicitly
@Builder // Will generate some necessary code implicitly
public class Product 
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private long price;
	private long quantity;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productName;
	}
	public void setProductname(String productname) {
		this.productName = productname;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	
}

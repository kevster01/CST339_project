package net.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Product {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private String Sku;
	
	@Column(name = "PRODUCTNAME")
	private String productName;
	
	@Column(name = "PRODUCTDESCRIPTION")
	private String productDescription;
	
	@Column(name = "PRODUCTPRICE")
	private String productPrice;
	public String getSku() {
		return Sku;
	}
	public void setSku(String id) {
		this.Sku = Sku;
	}
	public String getproductName() {
		return productName;
	}
	public void setproductName(String productName) {
		this.productName = productName;
	}
	public String getproductDescription() {
		return productDescription;
	}
	public void productDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getproductPrice() {
		return productPrice;
	}
	public void setproductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
}

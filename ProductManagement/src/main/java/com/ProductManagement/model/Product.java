package com.ProductManagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
@Document(collection="products")
public class Product {
	
	@Id
	private String id;
	private String productName;
	private String productPrice;
	private String productDescription;
	private String productRating;
	

	
	

}

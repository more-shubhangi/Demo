package com.ProductManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private String id;
	
	private String productName;
	
	private String productPrice;
	
	private String productDescription;
	
	private String productRating;
}

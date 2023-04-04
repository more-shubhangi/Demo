package com.ProductManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.ProductManagement.dao.ProductDao;
import com.ProductManagement.dto.ProductRequest;
import com.ProductManagement.dto.ProductResponse;
import com.ProductManagement.model.Product;
import com.ProductManagement.util.Constants;
import com.ProductManagement.util.ResponseDto;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;

	@Autowired
	MongoTemplate mongoTemplate;

	public ResponseDto createProduct(ProductRequest productRequest) {
		Product product = new Product();
		ResponseDto responseDto = new ResponseDto();
		ProductResponse productResponse = new ProductResponse();

		if (productRequest.getProductName() != null && productRequest.getProductDescription() != null
				&& productRequest.getProductPrice() != null && productRequest.getProductRating() != null) {

			product.setProductName(productRequest.getProductName());
			product.setProductPrice(productRequest.getProductPrice());
			product.setProductDescription(productRequest.getProductDescription());
			product.setProductRating(productRequest.getProductRating());

			productDao.save(product);

			productResponse.setId(product.getId());
			productResponse.setProductName(product.getProductName());
			productResponse.setProductPrice(product.getProductPrice());
			productResponse.setProductDescription(product.getProductDescription());
			productResponse.setProductRating(product.getProductRating());

			responseDto.setMessage("Product Add Successfully");
			responseDto.setResponse(productResponse);
			responseDto.setStatus(Constants.RES_CODES.CREAT_SUCCESS.toString());
		} else {

			responseDto.setMessage("Error while creating Employee");
			responseDto.setStatus(Constants.RES_CODES.BAD_REQUEST.toString());
		}
		return responseDto;
	}

	public ResponseDto getAllProducts() {

		ResponseDto responseDto = new ResponseDto();
		List<ProductResponse> productResponseList = new ArrayList<ProductResponse>();
		List<Product> productList = productDao.findAll();
		
		if (Optional.ofNullable(productList).isPresent() && productList.size() > 0) {
			
		for (Product product : productList) {
			
			ProductResponse productResponse = new ProductResponse();
			
			productResponse.setId(product.getId());
			productResponse.setProductName(product.getProductName());
			productResponse.setProductPrice(product.getProductPrice());
			productResponse.setProductDescription(product.getProductDescription());
			productResponse.setProductRating(product.getProductRating());

			productResponseList.add(productResponse);
		}
			responseDto.setResponse(productResponseList);
			responseDto.setMessage("Product List Get Successfull");
			responseDto.setStatus(Constants.RES_CODES.GET_SUCCESS.toString());
		} else {
			responseDto.setMessage("Error while getting Employee list");
			responseDto.setStatus(Constants.RES_CODES.FAILED.toString());
		}
	
		return responseDto;
	}

	public ResponseDto getProductById(String id) {
		ResponseDto responseDto = new ResponseDto();
		ProductResponse productResponse = new ProductResponse();
		
		Optional<Product> product = productDao.findById(id);
		
		if(product.isPresent()) {
		productResponse.setId(product.get().getId());
		productResponse.setProductName(product.get().getProductName());
		productResponse.setProductPrice(product.get().getProductPrice());
		productResponse.setProductDescription(product.get().getProductDescription());
		productResponse.setProductRating(product.get().getProductRating());
		
		responseDto.setResponse(productResponse);
		responseDto.setMessage("Product Get By Id Successfull");
		responseDto.setStatus(Constants.RES_CODES.GET_SUCCESS.toString());
	} else {
		responseDto.setMessage("Error while getting Employee list");
		responseDto.setStatus(Constants.RES_CODES.FAILED.toString());
	}

		return responseDto;
	}

	public ResponseDto updateProduct(String id, ProductRequest productRequest) {
		
		ResponseDto responseDto = new ResponseDto();
		ProductResponse productResponse = new ProductResponse();
		  Optional<Product>product = productDao.findById(id);
		if(product.isPresent()) {
			
		if (Optional.ofNullable(productRequest.getProductDescription()).isPresent()) {
			product.get().setProductDescription(productRequest.getProductDescription());
		}
		
		if (Optional.ofNullable(productRequest.getProductName()).isPresent()) {
			product.get().setProductName(productRequest.getProductName());
		}
		
		if (Optional.ofNullable(productRequest.getProductPrice()).isPresent()) {
			product.get().setProductPrice(productRequest.getProductPrice());
		}
		
		if (Optional.ofNullable(productRequest.getProductRating()).isPresent()) {
			product.get().setProductRating(productRequest.getProductRating());
		}
		
		productDao.save(product.get());
			
		productResponse.setId(product.get().getId());
		productResponse.setProductName(product.get().getProductName());
		productResponse.setProductPrice(product.get().getProductPrice());
		productResponse.setProductDescription(product.get().getProductDescription());
		productResponse.setProductRating(product.get().getProductRating());
		
		responseDto.setResponse(productResponse);
		responseDto.setMessage("Product Update Successfull");
		responseDto.setStatus(Constants.RES_CODES.GET_SUCCESS.toString());
	} else {
		responseDto.setMessage("Error while getting Employee list");
		responseDto.setStatus(Constants.RES_CODES.FAILED.toString());
	}

	return responseDto;
	}

	public ResponseDto deleteProductById(String id) {
	    ResponseDto responseDto = new ResponseDto();
	    Optional<Product>product = productDao.findById(id);
	     
	    if(product.isPresent()) {
	    productDao.deleteById(product.get().getId());
	    
	    responseDto.setMessage("Employee for given id deleted successfull");
		responseDto.setStatus(Constants.RES_CODES.GET_SUCCESS.toString());
	} else {
		responseDto.setMessage("Error while deleting Employee");
		responseDto.setStatus(Constants.RES_CODES.FAILED.toString());
	}
	return responseDto;
 }
}
		
		
		
		
		
		
		



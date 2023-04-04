package com.ProductManagement.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProductManagement.dto.ProductRequest;
import com.ProductManagement.service.ProductService;
import com.ProductManagement.util.ResponseDto;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public ResponseEntity<ResponseDto> addProduct(@Valid @RequestBody ProductRequest productRequest) {
		ResponseDto responseDto = productService.createProduct(productRequest);
		return new ResponseEntity<ResponseDto>(responseDto, null, responseDto.getStatus());
	}
	
	@GetMapping("/product/all")
	public ResponseEntity<ResponseDto> getAllProducts(){
		ResponseDto responseDto = productService.getAllProducts();
	    return new ResponseEntity<ResponseDto>(responseDto, null, responseDto.getStatus());
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ResponseDto>getProductById(@PathVariable String id){
		ResponseDto responseDto = productService.getProductById(id);
		return new ResponseEntity<ResponseDto>(responseDto, null, responseDto.getStatus());
		
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<ResponseDto>updateProduct(@PathVariable String id, @RequestBody ProductRequest productRequest){
		ResponseDto responseDto = productService.updateProduct(id, productRequest);
		return new ResponseEntity<ResponseDto>(responseDto, null, responseDto.getStatus());
		
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<ResponseDto>deleteProductById(@PathVariable String id){
		ResponseDto responseDto = productService.deleteProductById(id);
		return new ResponseEntity<ResponseDto>(responseDto, null, responseDto.getStatus());
	}
}

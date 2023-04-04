package com.ProductManagement.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ProductManagement.model.Product;

@Repository
public interface ProductDao extends MongoRepository<Product, String> {

}

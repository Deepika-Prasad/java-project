package com.example.demo12.service;

import com.example.demo12.dto.Product;

import java.util.List;

public interface TestService {
//    void getProduct(String name);
    public List<Product> getAllProduct();
    public Product getOneObject(String name);

    public void saveAllProduct(Product product);
     void deleteRecord(Long productId);

}

package com.example.demo12.service.impl;

import com.example.demo12.dto.Product;
import com.example.demo12.service.TestService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private RestTemplate restTemplate;

//    @Override
//    public void getProduct(String name) {
//        String url ="http://localhost:8080/p1/name?name="+name;
//        ResponseEntity<String> response =restTemplate.getForEntity(url,String.class);
//        System.out.println(response.getBody());
//
//    }

    @Override
    public List<Product> getAllProduct() {
        String url ="http://localhost:8080/p1/all/product";
        ResponseEntity<String> response =restTemplate.getForEntity(url,String.class);
        System.out.println("get all product"+response.getBody());
        ObjectMapper mapper=new ObjectMapper();
        List<Product> productList=null;
        try {
            productList = mapper.readValue(response.getBody(), new TypeReference<List<Product>>() {
            });
        }
        catch (Exception e)
        {
            System.out.print("Error");
        }
        return productList;
    }

    @Override
    public Product getOneObject(String name) {
        String url ="http://localhost:8080/p1/name?name="+name;
        ResponseEntity<String> response =restTemplate.getForEntity(url,String.class);
        System.out.println(response.getBody());
        ObjectMapper mapper=new ObjectMapper();
        try {
            Product product = mapper.readValue(response.getBody(), Product.class);
            System.out.print("\n response of single object"+product);
            return product;
        }
        catch (Exception e)
        {
            System.out.print("Error");
        }
        return null;
    }
//deepika git practice
    // llllllllll
    @Override
    public void saveAllProduct(Product product) {
        String url="http://localhost:8080/p1/product";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
        ResponseEntity<String> allData = restTemplate.postForEntity(url,entity,String.class);
        System.out.print("Forsaveall product"+allData);


    }

    @Override
    public void deleteRecord(Long productId) {
        String url="http://localhost:8080/delete/"+productId;
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type","application/json");
//        HttpEntity<Product> entity = new HttpEntity<Product>(headers);
             restTemplate.delete(url);
//        System.out.print("Forsaveall product"+allData);
    }


//    public List<Product> getAllProduct() {
//        String url ="http://localhost:8080/p1/all/product";
//        Product response =restTemplate.getForObject(url,Product.class);
//        System.out.println("Object Data"+response.);
//        ObjectMapper mapper=new ObjectMapper();
//        List<Product> productList= null;
//        try {
//            productList = Collections.singletonList(mapper.readValue(response.getProductName(), Product.class));
//        }
//        catch (Exception e)
//        {
//            System.out.print("Error");
//        }
//        return productList;
//    }

}

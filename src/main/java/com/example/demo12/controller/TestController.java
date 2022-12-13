package com.example.demo12.controller;

import com.example.demo12.dto.Product;
import com.example.demo12.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;


//    @GetMapping("/get/p")
//    public void getProduct(@RequestParam("name") String name){
//        testService.getProduct(name);
//
//    }

    @GetMapping("/get/p")
    public Product getProduct(@RequestParam("name") String name) {
        return testService.getOneObject(name);
    }

    @GetMapping("/p/all")
    public List<Product> getAllEmployee(){
//        System.out.print(testService.getAllProduct());
        return testService.getAllProduct();
    }

    @PostMapping("/p/save/product")
    public  void postTest(@RequestBody Product product){
        testService.saveAllProduct(product);
    }

    @DeleteMapping("/delete/p/{productId}")
    public  void deleteProduct(@PathVariable("productId") Long productId)
    {
        testService.deleteRecord(productId);
    }

}

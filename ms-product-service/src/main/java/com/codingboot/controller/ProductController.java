package com.codingboot.controller;

import com.codingboot.command.ProductOrderCommand;
import com.codingboot.controller.entity.Product;
import com.codingboot.repository.ProductRepository;
import com.codingboot.vo.ProductOrderSummary;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductOrderCommand productOrdercommand;

    @Autowired
    private Environment environment;

    @GetMapping("/product-list")
    public ResponseEntity<List<Product>> getProductList() {
        System.out.println("nish is trying");
        System.out.println(productRepository.findAll().size());
        System.out.println(productRepository.findAll().get(0).getId());
        return ResponseEntity.ok(productRepository.findAll());

    }

    @GetMapping("/product-order-summary")
    public ResponseEntity<List<ProductOrderSummary>> getProductOrderSummaries() {

        List<Product> products = productRepository.findAll();
        List<ProductOrderSummary> productOrderSummaries = productOrdercommand.invokeProductOrderSummary();

        for (ProductOrderSummary productOrderSummary : productOrderSummaries) {
            productOrderSummary.setName(products.get(0).getName());
        }

        return ResponseEntity.ok(productOrderSummaries);

    }

    @GetMapping("/customers")
    public String getCustomers() {
        return environment.getProperty("endpoint.customer.customers") + "nish";
    }


}

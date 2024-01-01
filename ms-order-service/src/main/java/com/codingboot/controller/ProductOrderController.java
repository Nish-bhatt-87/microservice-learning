package com.codingboot.controller;

import com.codingboot.vo.ProductOrderSummary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductOrderController {


    @GetMapping("/order-summary")
    public ResponseEntity<List<ProductOrderSummary>> getProductOrderSummary() {

        System.out.println("being called");
        List<ProductOrderSummary> abc = Arrays.asList(
                new ProductOrderSummary(1, 1232),
                new ProductOrderSummary(2, 5454),
                new ProductOrderSummary(3, 9967),
                new ProductOrderSummary(4, 3456),
                new ProductOrderSummary(5,281415)

        );

        return ResponseEntity.ok(abc);
    }
}

package com.codingboot.command;

import com.codingboot.controller.entity.Product;
import com.codingboot.vo.ProductOrderSummary;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductOrderCommand {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    public List<ProductOrderSummary> invokeProductOrderSummary() {

       ProductOrderSummary[] productOrderSummaries= restTemplate.getForObject(env.getProperty("endpoint.ms-order-service.order-summary"), ProductOrderSummary[].class);
       return Arrays.asList(productOrderSummaries);
    }
}

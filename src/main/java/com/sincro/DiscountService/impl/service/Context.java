package com.sincro.DiscountService.impl.service;

import com.sincro.DiscountService.inf.CustomerType;
import org.springframework.stereotype.Service;


public class Context {

    private final CalculateDiscountStrategy calculateDiscountStrategy;

    public Context(CalculateDiscountStrategy calculateDiscountStrategy) {
        this.calculateDiscountStrategy = calculateDiscountStrategy;
    }


    public Double executeStrategy(CustomerType customerType , Double bill){
        return calculateDiscountStrategy.calculateDiscount(customerType,bill);
    }
}

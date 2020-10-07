package com.sincro.DiscountService.inf;

import org.springframework.stereotype.Component;

@Component
public interface CalculateDiscountInterface {

    public Double calculateDiscount(String customerType , Double billAmount);
}

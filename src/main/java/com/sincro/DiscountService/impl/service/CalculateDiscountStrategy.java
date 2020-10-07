package com.sincro.DiscountService.impl.service;

import com.sincro.DiscountService.inf.CustomerType;
import org.springframework.stereotype.Service;

@Service
public interface CalculateDiscountStrategy {

 public Double calculateDiscount(CustomerType customerType , Double bill);

}

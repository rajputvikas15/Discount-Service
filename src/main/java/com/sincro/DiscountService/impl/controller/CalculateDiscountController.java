package com.sincro.DiscountService.impl.controller;

import com.sincro.DiscountService.impl.service.CalculateDiscountService;
import com.sincro.DiscountService.inf.CalculateDiscountInterface;
import com.sincro.DiscountService.inf.CustomerType;
import org.springframework.stereotype.Service;

@Service
public class CalculateDiscountController implements CalculateDiscountInterface {

    private final CalculateDiscountService calculateDiscountService;

    public CalculateDiscountController(CalculateDiscountService calculateDiscountService) {
        this.calculateDiscountService = calculateDiscountService;
    }

    @Override
    public Double calculateDiscount(String customerType, Double bill) {
        CustomerType customerType1 = validateCustomerType(customerType);
        return calculateDiscountService.execute(customerType1,bill);
    }

    private static CustomerType validateCustomerType(String customerTypeString) {
        for (CustomerType customerType : CustomerType.values()) {
            if (customerType.name().equalsIgnoreCase(customerTypeString)) {
                return customerType;
            }
        }
        throw new RuntimeException("Invalid Customer Type. Valid customer type is PREMIUM and REGULAR.");
    }

}

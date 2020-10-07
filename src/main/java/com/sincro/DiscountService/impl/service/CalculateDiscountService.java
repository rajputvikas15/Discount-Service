package com.sincro.DiscountService.impl.service;


import com.sincro.DiscountService.impl.persistent.CustomerTypeEntity;
import com.sincro.DiscountService.impl.persistent.CustomerTypeRepository;
import com.sincro.DiscountService.impl.persistent.DiscountSlabEntity;
import com.sincro.DiscountService.impl.persistent.DiscountSlabRepository;
import com.sincro.DiscountService.inf.CustomerType;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CalculateDiscountService {

    private final CustomerTypeRepository customerTypeRepository;

    public CalculateDiscountService(CustomerTypeRepository customerTypeRepository) {
        this.customerTypeRepository = customerTypeRepository;
    }

    public  Double execute(CustomerType customerType , Double bill){
        Context context;
        switch (customerType.name()){
            case  "PREMIUM":
                context = new Context(new PremiumDiscountStrategy(customerTypeRepository));
                break;
            case  "REGULAR":
                context = new Context(new RegularDiscountStrategy(customerTypeRepository));
                break;
            default:
                throw new RuntimeException("Invalid Customer Type. Valid customer type are PREMIUM and REGULAR.");
        }

        return context.executeStrategy(customerType, bill);
    }
}

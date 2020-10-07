package com.sincro.DiscountService.impl.service;

import com.sincro.DiscountService.impl.persistent.CustomerTypeEntity;
import com.sincro.DiscountService.impl.persistent.CustomerTypeRepository;
import com.sincro.DiscountService.impl.persistent.DiscountSlabEntity;
import com.sincro.DiscountService.inf.CustomerType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PremiumDiscountStrategy implements CalculateDiscountStrategy {

    private final CustomerTypeRepository customerTypeRepository;

    public PremiumDiscountStrategy(CustomerTypeRepository customerTypeRepository) {
        this.customerTypeRepository = customerTypeRepository;
    }


    @Override
    public Double calculateDiscount(CustomerType customerType, Double bill) {
        {
            Optional<CustomerTypeEntity> optionalCustomerTypeEntity = customerTypeRepository.findById("2");
            if(optionalCustomerTypeEntity.isEmpty()){
                throw new RuntimeException("Customer Type not found");
            }

            List<DiscountSlabEntity> discountSlabEntitieList = new ArrayList<>();
            discountSlabEntitieList.addAll(optionalCustomerTypeEntity.get().getDiscountSlabEntities());

            Collections.sort(discountSlabEntitieList, new CustomComparator());

            Double discount = 0.0;
            Double amountOnWhichDiscountToBeGiven = 0.0;
            Double previousSlabEndAmount = 0.0;

            for(DiscountSlabEntity discountSlabEntity : discountSlabEntitieList){
                if(bill >= discountSlabEntity.getSlabStartAmount()){
                    amountOnWhichDiscountToBeGiven = bill > discountSlabEntity.getSlabEndAmount()? discountSlabEntity.getSlabEndAmount()- discountSlabEntity.getSlabStartAmount(): bill- previousSlabEndAmount;
                    discount = discount + (discountSlabEntity.getDiscount()*amountOnWhichDiscountToBeGiven)/100;
                    previousSlabEndAmount = discountSlabEntity.getSlabEndAmount();
                }

            }
            return discount;
        }
    }
}

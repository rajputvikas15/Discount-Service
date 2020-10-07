package com.sincro.DiscountService.impl.service;

import com.sincro.DiscountService.impl.persistent.CustomerTypeEntity;
import com.sincro.DiscountService.impl.persistent.CustomerTypeRepository;
import com.sincro.DiscountService.impl.persistent.DiscountSlabEntity;
import com.sincro.DiscountService.impl.persistent.DiscountSlabRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SeedData {

    private final CustomerTypeRepository customerTypeRepository;
    private final DiscountSlabRepository discountSlabRepository;
    public SeedData(CustomerTypeRepository customerTypeRepository,DiscountSlabRepository discountSlabRepository) {
        this.customerTypeRepository = customerTypeRepository;
        this.discountSlabRepository=discountSlabRepository;
    }

    @PostConstruct
    @Transactional(propagation = Propagation.MANDATORY)
    public void seedData(){

        Set<DiscountSlabEntity> discountSlabEntities = new HashSet<>();

        DiscountSlabEntity discountSlabEntity = new DiscountSlabEntity();
        discountSlabEntity.setId("1");
        discountSlabEntity.setDiscount(0.0);
        discountSlabEntity.setSlabStartAmount(0.0);
        discountSlabEntity.setSlabEndAmount(5000.0);
        discountSlabEntities.add(discountSlabEntity);

        DiscountSlabEntity discountSlabEntity1 = new DiscountSlabEntity();
        discountSlabEntity1.setId("2");
        discountSlabEntity1.setDiscount(10.0);
        discountSlabEntity1.setSlabStartAmount(5000.0);
        discountSlabEntity1.setSlabEndAmount(10000.0);
        discountSlabEntities.add(discountSlabEntity1);

        DiscountSlabEntity discountSlabEntity2 = new DiscountSlabEntity();
        discountSlabEntity2.setId("3");
        discountSlabEntity2.setDiscount(20.0);
        discountSlabEntity2.setSlabStartAmount(10000.0);
        discountSlabEntity2.setSlabEndAmount(Double.MAX_VALUE);
        discountSlabEntities.add(discountSlabEntity2);

        discountSlabRepository.saveAll(discountSlabEntities);



        CustomerTypeEntity regulerCustomerTypeEntity = new CustomerTypeEntity();
        regulerCustomerTypeEntity.setCustomerType("Regular");
        regulerCustomerTypeEntity.setDiscountSlabEntities(discountSlabEntities);
        regulerCustomerTypeEntity.setId("1");

        List<CustomerTypeEntity> customerTypeEntities = new ArrayList<>();
        customerTypeEntities.add(regulerCustomerTypeEntity);

        Set<DiscountSlabEntity> discountSlabEntities1 = new HashSet<>();

        DiscountSlabEntity discountSlabEntity11 = new DiscountSlabEntity();
        discountSlabEntity11.setId("11");
        discountSlabEntity11.setDiscount(10.0);
        discountSlabEntity11.setSlabStartAmount(0.0);
        discountSlabEntity11.setSlabEndAmount(4000.0);
        discountSlabEntities1.add(discountSlabEntity11);

        DiscountSlabEntity discountSlabEntity22 = new DiscountSlabEntity();
        discountSlabEntity22.setId("22");
        discountSlabEntity22.setDiscount(15.0);
        discountSlabEntity22.setSlabStartAmount(4000.0);
        discountSlabEntity22.setSlabEndAmount(8000.0);
        discountSlabEntities1.add(discountSlabEntity22);

        DiscountSlabEntity discountSlabEntity33 = new DiscountSlabEntity();
        discountSlabEntity33.setId("33");
        discountSlabEntity33.setDiscount(20.0);
        discountSlabEntity33.setSlabStartAmount(8000.0);
        discountSlabEntity33.setSlabEndAmount(12000.0);
        discountSlabEntities1.add(discountSlabEntity33);

        DiscountSlabEntity discountSlabEntity44 = new DiscountSlabEntity();
        discountSlabEntity44.setId("44");
        discountSlabEntity44.setDiscount(30.0);
        discountSlabEntity44.setSlabStartAmount(12000.0);
        discountSlabEntity44.setSlabEndAmount(Double.MAX_VALUE);
        discountSlabEntities1.add(discountSlabEntity44);

        discountSlabRepository.saveAll(discountSlabEntities1);


        CustomerTypeEntity premiumCustomerTypeEntity = new CustomerTypeEntity();
        premiumCustomerTypeEntity.setCustomerType("Premium");
        premiumCustomerTypeEntity.setDiscountSlabEntities(discountSlabEntities1);
        premiumCustomerTypeEntity.setId("2");
        customerTypeEntities.add(premiumCustomerTypeEntity);

        customerTypeRepository.saveAll(customerTypeEntities);



    }
}

package com.sincro.DiscountService.impl.persistent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerTypeRepository extends JpaRepository<CustomerTypeEntity,String> {
}

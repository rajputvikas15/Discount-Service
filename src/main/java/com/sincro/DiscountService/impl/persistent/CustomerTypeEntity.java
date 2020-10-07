package com.sincro.DiscountService.impl.persistent;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Customer_Type")
@Data
public class CustomerTypeEntity {

    @Id
    private String id;

    @Column(name = "Customer_Type")
    private String CustomerType;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="customer_type_id")
    private Set<DiscountSlabEntity> discountSlabEntities;
}

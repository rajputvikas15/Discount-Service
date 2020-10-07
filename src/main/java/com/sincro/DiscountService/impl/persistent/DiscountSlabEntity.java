package com.sincro.DiscountService.impl.persistent;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity(name = "Discount_Slab")
public class DiscountSlabEntity {

    @Id
    private String id;

    @Column(name = "Slab_Start_Amount")
    private Double slabStartAmount;

    @Column(name = "Slab_End_Amount")
    private Double slabEndAmount;

    @Column(name = "discount")
    private Double discount;

    @ManyToOne
    private CustomerTypeEntity customerTypeEntity;

}

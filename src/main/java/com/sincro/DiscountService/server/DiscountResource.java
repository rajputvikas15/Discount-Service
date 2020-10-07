package com.sincro.DiscountService.server;


import com.sincro.DiscountService.inf.CalculateDiscountInterface;
import com.sincro.DiscountService.inf.CustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/discount/")
public class DiscountResource {

    @Autowired
    CalculateDiscountInterface calculateDiscountInterface;

    @RequestMapping(value = "/customerType/{customerType}/bill/{bill}" , method = RequestMethod.GET)
    public ResponseEntity calculateDiscount(@PathVariable  String customerType ,@PathVariable Double bill){
        try {
            return new ResponseEntity<>(bill - calculateDiscountInterface.calculateDiscount(customerType, bill),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }
}
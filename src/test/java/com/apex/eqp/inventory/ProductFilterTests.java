package com.apex.eqp.inventory;

import com.apex.eqp.inventory.entities.Product;
import com.apex.eqp.inventory.helpers.ProductFilter;
import com.apex.eqp.inventory.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;



public class ProductFilterTests {

    @Autowired
    ProductService productService;

    private Product createTestProduct(String productName, Double price, Integer quantity) {
        return Product.builder()
                .name(productName)
                .price(price)
                .quantity(quantity)
                .build();
    }
    @Test
    @DisplayName("Should filter recalled product by name")
    //@ValueSource( strings = {"p1","p2","p3","p4"})
    public void FilterRecalledProductTest(){
        List<String> recallList = new ArrayList<>();
        recallList.add("p1");
        recallList.add("p2");
        ProductFilter pf = new ProductFilter(recallList);
        List<Product> productList = new ArrayList<>();
        productList.add(createTestProduct("p1",1.2,10));
        productList.add(createTestProduct("p2",1.2,9));
        productList.add(createTestProduct("p3",1.2,10));

        List<Product> res = pf.removeRecalled(productList);

        Assertions.assertEquals(1,res.size());


    }

}

package com.apex.eqp.inventory.helpers;

import com.apex.eqp.inventory.entities.Product;
import com.apex.eqp.inventory.entities.RecalledProduct;
import com.apex.eqp.inventory.services.ProductService;
import com.apex.eqp.inventory.services.RecalledProductService;

import java.util.*;
import java.util.stream.Collectors;

public class ProductFilter {

    private final List<String> recalledProducts;
    //private RecalledProductService recalledProductService;
    public static List<String> rpList = new ArrayList<>();

    public ProductFilter(List<String> recalledProducts) {
        if (recalledProducts == null) recalledProducts = new ArrayList<>();

        this.recalledProducts = recalledProducts;
        rpList = recalledProducts;
    }

    public List<Product> removeRecalled(Collection<Product> allProduct) {
        return allProduct.stream().filter(ProductFilter::filterByName).collect(Collectors.toList());
    }



    private static boolean filterByName(Product product) {
        //RecalledProductService RRS = new RecalledProductService();
        //List<RecalledProduct> recalledProductList=

        Set<String> dir = new HashSet<String>(rpList);
        return !dir.contains(product.getName());
    }
}

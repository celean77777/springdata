package com.celean.springdata.controllers;

import com.celean.springdata.models.Product;
import com.celean.springdata.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public Page<Product> findAll(@RequestParam(name = "p", defaultValue = "1") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex - 1, 10);
    }


    @GetMapping("/product/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id).orElse(null);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProductById (@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @PostMapping("/products")
    public Product save(@ModelAttribute Product product){
        return productService.save(product);
    }



    @GetMapping("/products/pricemin")
    public List<Product> findProductsByPriceAfter (@RequestParam (name = "minprice") int minprice){
        return productService.findProductsByPriceAfter(minprice);
    }

    @GetMapping("/products/pricemax")
    public List<Product> findProductsByPriceBefore (@RequestParam (name = "maxprice") int maxprice){
        return productService.findProductsByPriceBefore(maxprice);
    }

    @GetMapping("/products/pricebetween")
    public List<Product> findProductsByPriceBetween(@RequestParam(name = "minprice") int minprice,
                                                    @RequestParam(name = "maxprice") int maxprice){
        return productService.findProductsByPriceBetween(minprice, maxprice);
    }



}

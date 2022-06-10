package com.celean.springdata.services;

import com.celean.springdata.models.Product;
import com.celean.springdata.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteProductById (Long id){
        productRepository.deleteById(id);
    }

    public List<Product> findProductsByPriceAfter(int minprice){
        return productRepository.findProductsByPriceAfter(minprice);
    }

    public List<Product> findProductsByPriceBefore(int maxprice){
        return productRepository.findProductsByPriceBefore(maxprice);
    }

    public List<Product> findProductsByPriceBetween(int minprice, int maxprice){
        return productRepository.findProductsByPriceBetween(minprice, maxprice);
    }
}

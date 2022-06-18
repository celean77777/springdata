package com.celean.springdata.services;

import com.celean.springdata.models.Product;
import com.celean.springdata.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private final ProductRepository productRepository;
@Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Page<Product> findAll(int pageIndex, int pageSize){
        return productRepository.findAll(PageRequest.of(pageIndex, pageSize));
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

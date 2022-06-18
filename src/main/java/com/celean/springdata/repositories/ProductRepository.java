package com.celean.springdata.repositories;

import com.celean.springdata.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, CrudRepository<Product, Long> {
  List<Product> findProductsByPriceAfter(int minprice);

  List<Product> findProductsByPriceBefore(int maxprice);

  List<Product> findProductsByPriceBetween(int minprice, int maxprice);






}

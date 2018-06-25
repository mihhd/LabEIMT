package com.mihhd.lab2sports.repository.jpa;

import com.mihhd.lab2sports.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long id);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"category", "manufacturer"})
    List<Product> findAll();


    List<Product> findByManufacturerNameLike(String manufacturer);
}

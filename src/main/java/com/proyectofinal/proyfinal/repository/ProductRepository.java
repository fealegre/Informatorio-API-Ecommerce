package com.proyectofinal.proyfinal.repository;
import java.util.List;

import com.proyectofinal.proyfinal.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProdNameContaining(String prodName);
    List<Product> findByPublished(Boolean published);
    
}

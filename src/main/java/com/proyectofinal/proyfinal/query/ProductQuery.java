package com.proyectofinal.proyfinal.query;

import java.util.List;

import com.proyectofinal.proyfinal.domain.Product;
import com.proyectofinal.proyfinal.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductQuery {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> queryByNameContaining(String prodName)throws Exception{
        try {
            List<Product> product = productRepository.findByProdNameContaining(prodName);
            return product;
        } catch (Exception e) {
            throw new Exception(e.getMessage());           
        }
        
    }

    public List<Product> queryByPublished(Boolean published) throws Exception{
        try {
            List<Product> product = productRepository.findByPublished(published);
            return product;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

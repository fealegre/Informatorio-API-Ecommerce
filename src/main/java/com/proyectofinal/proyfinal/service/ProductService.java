package com.proyectofinal.proyfinal.service;

import java.util.List;

import com.proyectofinal.proyfinal.domain.Product;
import com.proyectofinal.proyfinal.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements BaseService<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() throws Exception {
        try {
            List<Product> products = productRepository.findAll();
            return products;
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Product findById(Long id) throws Exception {
        try {
            Product productOptional = productRepository.findById(id).get();
            return productOptional;
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Product save(Product entity) throws Exception {
        try {
            entity = productRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Product update(Long id, Product entity) throws Exception {
        try {
            Product product = productRepository.findById(id).get();
            if (entity.getProdName() != null) {
                product.setProdName(entity.getProdName());
            }
            if (entity.getProdPrice() != null) {
                product.setProdPrice(entity.getProdPrice());
            }
            if (entity.getProdDesc() != null) {
                product.setProdDesc(entity.getProdDesc());
            }
            if (entity.getProdContent() != null) {
                product.setProdContent(entity.getProdContent());
            }
            if (entity.getPublished() != null) {
                product.setPublished(entity.getPublished());
            }
            Product productUpdated = productRepository.save(product);
            return productUpdated;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            if (productRepository.existsById(id)) {
                productRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}

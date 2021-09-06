package com.proyectofinal.proyfinal.service;

import java.util.List;

import com.proyectofinal.proyfinal.domain.Cart;
import com.proyectofinal.proyfinal.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements BaseService<Cart>{

    @Autowired
    private CartRepository cartRepository;

    @Override    
    public List<Cart> findAll() throws Exception {
        try {
            List<Cart> cart = cartRepository.findAll();
            return cart;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
            
        }
    }

    @Override    
    public Cart findById(Long id) throws Exception {
        try {
            Cart cartOptional = cartRepository.findById(id).get();
            return cartOptional;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
       
    }

    @Override    
    public Cart save(Cart entity) throws Exception {
        try {
            entity = cartRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
       
    }

    @Override    
    public Cart update(Long id, Cart entity) throws Exception {
        try {
            Cart cart=cartRepository.findById(id).get();
            // if (entity.get!=null){
            //     cart.setFirstName(entity.getFirstName());
            // }
		    // if (entity.getLastName()!=null){
            //     cart.setLastName(entity.getLastName());
            // }
		    // if (entity.getCityName()!=null){
            //     cart.setCityName(entity.getCityName());
            // }
		    // if (entity.getCustName()!=null){
            //     cart.setCustName(entity.getCustName());
            // }
		    // if (entity.getCountryName()!=null){
            //     cart.setCountryName(entity.getCountryName());
            // }
            // if (entity.getStateName()!=null){
            //     cart.setStateName(entity.getStateName());
            // }            
		    Cart cartUpdated=cartRepository.save(cart);
		    return cartUpdated;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
       
    }

    @Override    
    public boolean delete(Long id) throws Exception {
        try {
            if (cartRepository.existsById(id)){
                cartRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
       
    }

    
}

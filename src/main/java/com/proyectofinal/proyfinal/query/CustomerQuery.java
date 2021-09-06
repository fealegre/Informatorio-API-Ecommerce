package com.proyectofinal.proyfinal.query;

import java.time.LocalDateTime;
import java.util.List;

import com.proyectofinal.proyfinal.domain.Customer;
import com.proyectofinal.proyfinal.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerQuery {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> queryByCity(String cityName) throws Exception{
        try {
            List<Customer> customer=customerRepository.findByCityName(cityName);
            return customer;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Customer> queryByCreationDate(LocalDateTime custCreationDate) throws Exception{
        try {
            List<Customer> customer=customerRepository.findByCustCreationDateAfter(custCreationDate);
            return customer;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    
}

package com.proyectofinal.proyfinal.service;

import java.util.List;

import com.proyectofinal.proyfinal.domain.Customer;
import com.proyectofinal.proyfinal.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements BaseService<Customer>{

    @Autowired
    private CustomerRepository customerRepository;

    @Override    
    public List<Customer> findAll() throws Exception {
        try {
            List<Customer> customers = customerRepository.findAll();
            return customers;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
            
        }
    }

    @Override    
    public Customer findById(Long id) throws Exception {
        try {
            Customer customerOptional = customerRepository.findById(id).get();
            return customerOptional;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
       
    }

    @Override    
    public Customer save(Customer entity) throws Exception {
        try {
            entity = customerRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
       
    }

    @Override    
    public Customer update(Long id, Customer entity) throws Exception {
        try {
            Customer customer=customerRepository.findById(id).get();
            if (entity.getFirstName()!=null){
                customer.setFirstName(entity.getFirstName());
            }
		    if (entity.getLastName()!=null){
                customer.setLastName(entity.getLastName());
            }
		    if (entity.getCityName()!=null){
                customer.setCityName(entity.getCityName());
            }
		    if (entity.getCustName()!=null){
                customer.setCustName(entity.getCustName());
            }
		    if (entity.getCountryName()!=null){
                customer.setCountryName(entity.getCountryName());
            }
            if (entity.getStateName()!=null){
                customer.setStateName(entity.getStateName());
            }            
		    Customer customerUpdated=customerRepository.save(customer);
		    return customerUpdated;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
       
    }

    @Override    
    public boolean delete(Long id) throws Exception {
        try {
            if (customerRepository.existsById(id)){
                customerRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
       
    }

    
    
}

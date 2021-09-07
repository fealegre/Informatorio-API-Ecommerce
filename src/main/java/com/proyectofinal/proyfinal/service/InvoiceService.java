package com.proyectofinal.proyfinal.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinal.proyfinal.domain.Invoice;
import com.proyectofinal.proyfinal.repository.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService implements BaseService<Invoice>{

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findAll() throws Exception {
        try {
            List<Invoice> invoiceList = invoiceRepository.findAll();
            return invoiceList;            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }

    @Override
    public Invoice findById(Long id) throws Exception {
        try {
            Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
            return invoiceOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());           
        }
        
    }

    @Override
    public Invoice save(Invoice entity) throws Exception {
       try {
           entity = invoiceRepository.save(entity);
           return entity;
       } catch (Exception e) {
           throw new Exception(e.getMessage());
       }
    }

    @Override
    public Invoice update(Long id, Invoice entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            if (invoiceRepository.existsById(id)){
                invoiceRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }

}
    


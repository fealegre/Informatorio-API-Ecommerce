package com.proyectofinal.proyfinal.repository;

import com.proyectofinal.proyfinal.domain.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
}

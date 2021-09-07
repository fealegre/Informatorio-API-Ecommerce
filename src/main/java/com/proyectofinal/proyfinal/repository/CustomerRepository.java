package com.proyectofinal.proyfinal.repository;


import java.time.LocalDateTime;
import java.util.List;

import com.proyectofinal.proyfinal.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    List<Customer> findByCityName(String cityName);
    List<Customer> findByCustCreationDateAfter(LocalDateTime custCreationDate);

}

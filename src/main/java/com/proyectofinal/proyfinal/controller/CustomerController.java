package com.proyectofinal.proyfinal.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import com.proyectofinal.proyfinal.domain.Customer;
import com.proyectofinal.proyfinal.query.CustomerQuery;
import com.proyectofinal.proyfinal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerQuery customerQuerys;

    //GET ALL CUSTOMERS (OBTENER TODOS LOS USUARIOS)
	@GetMapping("")
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	//GET ONE CUSTOMER
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	//CREATE CUSTOMER (ALTA)
	@PostMapping("")
	public ResponseEntity<?> create(@Valid @RequestBody Customer customer) {
		try {	
			return ResponseEntity.status(HttpStatus.OK).body(customerService.save(customer));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	//UPDATE CUSTOMER (MODIFICACION)
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody Customer customerDetails) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(customerService.update(id,customerDetails));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}
	
	//DELETE CUSTOMER (BAJA)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(customerService.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}
	
	//FIND CUSTOMER BY CITY OF RESIDENCE	
	@GetMapping("/query1")
	public ResponseEntity<?> getByCity(@RequestParam String cityName) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(customerQuerys.queryByCity(cityName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
		}
		
	}

	//FIND CUSTOMER BY CREATION DAY AFTER	
	@GetMapping("/query2")
	public ResponseEntity<?> getByCreationDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime custCreationDate) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(customerQuerys.queryByCreationDate(custCreationDate));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
		}
	}



	
	
	
	
    
}

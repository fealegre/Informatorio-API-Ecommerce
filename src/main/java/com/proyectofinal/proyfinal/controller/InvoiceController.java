package com.proyectofinal.proyfinal.controller;

import javax.validation.Valid;

import com.proyectofinal.proyfinal.domain.Invoice;
import com.proyectofinal.proyfinal.service.InvoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/customers")
public class InvoiceController {

    @Autowired
	private InvoiceService invoiceService;
		
    //GET ALL INVOICES (OBTENER TODOS LAS FACTURAS)
	@GetMapping("/invoices")
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(invoiceService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	//GET ONE INVOICE
	@GetMapping("/invoices/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(invoiceService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	//CREATE INVOICE (ALTA)
	@PostMapping("/invoices")
	public ResponseEntity<?> create(@Valid @RequestBody Invoice invoice) {
		try {	
			return ResponseEntity.status(HttpStatus.OK).body(invoiceService.save(invoice));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

		
	//DELETE INVOICE (BAJA)
	@DeleteMapping("/invoices/{id}")
	public ResponseEntity<?> deleteInvoice(@PathVariable(value = "id") Long id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(invoiceService.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}
    
}

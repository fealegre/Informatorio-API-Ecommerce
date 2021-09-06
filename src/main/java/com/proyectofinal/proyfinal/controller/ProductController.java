package com.proyectofinal.proyfinal.controller;

import javax.validation.Valid;

import com.proyectofinal.proyfinal.domain.Product;
import com.proyectofinal.proyfinal.query.ProductQuery;
import com.proyectofinal.proyfinal.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = "api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductQuery productQuery;

    //GET ALL PRODUCTS
	@GetMapping("")
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	//GET ONE PRODUCT
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	//CREATE PRODUCT
	@PostMapping("")
	public ResponseEntity<?> create(@Valid @RequestBody Product product) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productService.save(product));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	//UPDATE PRODUCT
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody Product productDetails) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productService.update(id,productDetails));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}
	
	//DELETE PRODUCT
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productService.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	@GetMapping("/query1")
	public ResponseEntity<?> getByProdNameContaining(@RequestParam String prodName){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productQuery.queryByNameContaining(prodName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	@GetMapping("/query2")
	public ResponseEntity<?> getProdPublished(@RequestParam Boolean published){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productQuery.queryByPublished(published));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}


    
}

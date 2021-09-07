package com.proyectofinal.proyfinal.controller;

import javax.validation.Valid;

import com.proyectofinal.proyfinal.domain.Cart;
import com.proyectofinal.proyfinal.domain.CartItem;
import com.proyectofinal.proyfinal.domain.Customer;
import com.proyectofinal.proyfinal.domain.Product;
import com.proyectofinal.proyfinal.dto.CartOp;
import com.proyectofinal.proyfinal.repository.CartRepository;
import com.proyectofinal.proyfinal.repository.CustomerRepository;
import com.proyectofinal.proyfinal.repository.ProductRepository;
import com.proyectofinal.proyfinal.service.CartService;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/customers")
public class CartController {

    @Autowired
	private CartService cartService;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	ProductRepository productRepository;
	
	

	//GET ALL CARTS (OBTENER TODOS LOS CARRITOS)
	@GetMapping("/carts")
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(cartService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	//GET ONE CART
	@GetMapping("/{id}/carts/{idcart}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(cartService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	//CREATE CART (ALTA)
	@PostMapping("/{id}/carts")
	public ResponseEntity<?> create(@PathVariable("id") Long customerId, @Valid @RequestBody Cart cart) {
		try {	
			Customer customer = customerRepository.getById(customerId);
			cart.setCustomer(customer);
			return ResponseEntity.status(HttpStatus.OK).body(cartService.save(cart));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	//UPDATE CART (MODIFICACION)
	@PutMapping("/{id}/carts/{idcart}")
	public ResponseEntity<?> update(@PathVariable("id") Long customerId,
									@PathVariable("idcart") Long cartId,
									@Valid @RequestBody CartOp cartOP) {
		try {
			Cart cart = cartRepository.getById(cartId);
			Product product = productRepository.getById(cartOP.getProductId());
			CartItem cartItem = new CartItem();
			cartItem.setCart(cart);
			cartItem.setProduct(product);
			cartItem.setQuantity(cartOP.getQuantity());
			cart.addCartItem(cartItem);
			return ResponseEntity.status(HttpStatus.OK).body(cartService.update(cartId,cart));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}
	
	//DELETE CUSTOMER (BAJA)
	@DeleteMapping("/{id}/carts/{idcart}")
	public ResponseEntity<?> deleteCart(@PathVariable(value = "id") Long id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cartService.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"ERROR. Intente de nuevo.\"}");
		}
	}

	




    
}

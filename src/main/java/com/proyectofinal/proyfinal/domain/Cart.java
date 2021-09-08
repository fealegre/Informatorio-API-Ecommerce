package com.proyectofinal.proyfinal.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;


@Entity

public class Cart extends Base {

    
    @Column
    private String device;    

    @Column
    @CreationTimestamp
    private LocalDateTime cartCreationDate;
    
    @Transient
    private BigDecimal total;

    @Transient
    private String customerName;

    @Column(nullable = false)
    private Boolean closed;

    @JsonIgnore
    @OneToMany(mappedBy= "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Cart() {
    }

    public String getDevice() {
        return this.device;
    }

    public void setDevice(String requiredBy) {
        this.device = requiredBy;
    }

    public LocalDateTime getCartCreationDate() {
        return this.cartCreationDate;
    }

    public void setCartCreationDate(LocalDateTime cartCreationDate) {
        this.cartCreationDate = cartCreationDate;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public Boolean isClosed() {
        return this.closed;
    }

    public Boolean getClosed() {
        return this.closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItems.remove(cartItem);
        cartItem.setCart(null);
    }

    public String getCustomerName() {
        return customer.getCustName();
    }


   

}

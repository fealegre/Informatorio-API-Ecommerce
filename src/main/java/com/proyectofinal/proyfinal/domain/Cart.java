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
    private String requiredBy;    

    @Column
    @CreationTimestamp
    private LocalDateTime cartCreationDate;
    
    @Transient
    private BigDecimal total;

    @Column(nullable = false)
    private Boolean open;

    @OneToMany(mappedBy= "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    // @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    // @JoinColumn(name = "customer_id", nullable = false)
    // private Customer customer;

    // @ManyToOne(fetch = FetchType.LAZY)
    // private Product product;



    public Cart() {
    }

    public Cart(String requiredBy, LocalDateTime cartCreationDate, BigDecimal total, Boolean open, List<CartItem> cartItem, Customer customer) {
        this.requiredBy = requiredBy;
        this.cartCreationDate = cartCreationDate;
        this.total = total;
        this.open = open;
        this.cartItems = cartItem;
    }
   

    public String getRequiredBy() {
        return this.requiredBy;
    }

    public void setRequiredBy(String requiredBy) {
        this.requiredBy = requiredBy;
    }

    public LocalDateTime getCartCreationDate() {
        return this.cartCreationDate;
    }

    public void setCartCreationDate(LocalDateTime cartCreationDate) {
        this.cartCreationDate = cartCreationDate;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean isOpen() {
        return this.open;
    }

    public Boolean getOpen() {
        return this.open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
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


   

}

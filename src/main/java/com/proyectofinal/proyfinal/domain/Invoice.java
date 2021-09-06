package com.proyectofinal.proyfinal.domain;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity

public class Invoice extends Base {

    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(length = 200)
    private String observations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "invoice_citem",
            joinColumns = @JoinColumn(name = "invoice_id"),
            inverseJoinColumns = @JoinColumn(name = "citem_id")
            )

    private List<CartItem> cartItem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Invoice() {
    }

    public Invoice(LocalDateTime creationDate, String observations, Cart cart, List<CartItem> cartItem, Customer customer) {
        this.creationDate = creationDate;
        this.observations = observations;
        this.cart = cart;
        this.cartItem = cartItem;
        this.customer = customer;
    }



    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getObservations() {
        return this.observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<CartItem> getCartItem() {
        return this.cartItem;
    }

    public void setCartItem(List<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




    
}

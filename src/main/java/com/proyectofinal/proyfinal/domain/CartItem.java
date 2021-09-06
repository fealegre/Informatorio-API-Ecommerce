package com.proyectofinal.proyfinal.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity

public class CartItem extends Base{    
    
    @Transient
    private BigDecimal subTotal;

    @Column
    private BigDecimal quantity;

    @Column
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;


    public CartItem() {
    }

    public CartItem(BigDecimal subTotal, BigDecimal quantity, BigDecimal price, Cart cart, Product product) {
        this.subTotal = subTotal;
        this.quantity = quantity;
        this.price = price;
        this.cart = cart;
        this.product = product;
    }



    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    

    public BigDecimal getSubTotal() {
        this.subTotal=this.price.multiply(quantity);
        return this.subTotal;
    }

}

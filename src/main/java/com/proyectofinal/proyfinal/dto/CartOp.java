package com.proyectofinal.proyfinal.dto;

import java.math.BigDecimal;

public class CartOp {

    private BigDecimal quantity;
    private Long productId;

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setCantidad(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }




    
}

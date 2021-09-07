package com.proyectofinal.proyfinal.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity

public class Product extends Base{

    @Column
    private String prodName;

    @Column
    private String prodDesc;

    @Column(nullable = false)
    @Positive
    private BigDecimal prodPrice;

    @Column    
    private String prodContent;
    
    @CreationTimestamp
    private LocalDateTime prodCreationDate;

    @UpdateTimestamp
    private LocalDateTime prodLastChangeDate;

    @Column
    private Boolean published;


    public Product() {
    }

    public Product(String prodName, String prodDesc, BigDecimal prodPrice, String prodContent, LocalDateTime prodCreationDate, LocalDateTime prodLastChangeDate, Boolean published) {
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
        this.prodContent = prodContent;
        this.prodCreationDate = prodCreationDate;
        this.prodLastChangeDate = prodLastChangeDate;
        this.published = published;
    }

    public String getProdName() {
        return this.prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return this.prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public BigDecimal getProdPrice() {
        return this.prodPrice;
    }

    public void setProdPrice(BigDecimal prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdContent() {
        return this.prodContent;
    }

    public void setProdContent(String prodContent) {
        this.prodContent = prodContent;
    }

    public LocalDateTime getProdCreationDate() {
        return this.prodCreationDate;
    }

    public void setProdCreationDate(LocalDateTime prodCreationDate) {
        this.prodCreationDate = prodCreationDate;
    }

    public LocalDateTime getProdLastChangeDate() {
        return this.prodLastChangeDate;
    }

    public void setProdLastChangeDate(LocalDateTime prodLastChangeDate) {
        this.prodLastChangeDate = prodLastChangeDate;
    }

    public Boolean isPublished() {
        return this.published;
    }

    public Boolean getPublished() {
        return this.published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

}

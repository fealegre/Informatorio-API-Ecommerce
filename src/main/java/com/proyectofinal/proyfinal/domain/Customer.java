package com.proyectofinal.proyfinal.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "customer")

public class Customer extends Base{
    
    @Column
    private String firstName;

    @Column
     private String lastName;

    @Column(unique = true)
    @Email(regexp = ".*@.*")
    private String custName;

    @Column
    private String password;

    @CreationTimestamp
    private LocalDateTime custCreationDate;

    @Column
    private String cityName;

    @Column
    private String stateName;

    @Column
    private String countryName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts = new ArrayList<>();



    public Customer() {
    }

    public Customer(String firstName, String lastName, String custName, String password, LocalDateTime custCreationDate, String cityName, String stateName, String countryName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.custName = custName;
        this.password = password;
        this.custCreationDate = custCreationDate;
        this.cityName = cityName;
        this.stateName = stateName;
        this.countryName = countryName;
    }



    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustName() {
        return this.custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCustCreationDate() {
        return this.custCreationDate;
    }

    public void setCustCreationDate(LocalDateTime custCreationDate) {
        this.custCreationDate = custCreationDate;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void addCart(Cart cart) {
        carts.add(cart);
        cart.setCustomer(this);
    }

    public void removeCart(Cart cart) {
        carts.remove(cart);
        cart.setCustomer(null);
    }
   
        
    
}

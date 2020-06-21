package com.altasbookshop;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product { // this will also create a product table in the database (MYSQL)
    private Long id;
    private String name;
    private String brand;
    private String madein;
    private Float price;
//2. create an empty constructor
     protected Product() {
         //Super();
    }

    //4. Add annotation for the ID from JPA to indicate that this matches the priamry column in the database
    // Next - GenetateValue annotation from JPA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //3.
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}

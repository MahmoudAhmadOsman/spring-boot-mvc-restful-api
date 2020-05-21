package com.altasbookshop;

// Annotate this class with Spring Boot Annotation class

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    // get the ProductRepository and wire it here
    @Autowired
    private ProductRepository repo;

    //Here is where you will put all the crud logic

    //1. Read () method -  Get all the products from the database - a list of all products usin list<> method

    public List<Product> listAll(){
        return  repo.findAll();
    }

    //2. Save () all products using save method

    public void  save(Product product){
         repo.save(product);
    }


    //3. Get Product by ID  or Edit() method
    public Product get(Long id){
        return repo.findById(id).get(); // in order to get the actual id use get() method
    }


    //4 . Delete () Method
    // delete product by its id

public void delete(Long id){
    repo.deleteById(id);
}




}

//Step 3

package com.altasbookshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//Annotate this class with Spring Boot annotation class
@Controller
public class AppController {
    //1st get the domain class here in controller
    //2nd user autowire to let Spring inject products
    @Autowired
    private ProductService service;

    //Now create a view that handles requests and use RequestMapping mvc
    // And specify the route using double quotes
    @RequestMapping("/")
    public  String viewHomePage(Model model){
        //use the List () method and get all the products
        // this method is defined in the ProductService class
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

            //Now return the page you want this request to go
        return  "index";
    }


// Creating new product route
//Map the form URL to /new
@RequestMapping("/new")
public String showNewProductForm(Model model){
        //Create new product object
    Product product = new Product();
    model.addAttribute("prodcut", product);
return  "new_product";
}


// Save the product to the database
@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveProduct(@ModelAttribute ("product") Product product){
    service.save(product);
    return  "redirect:/";
}


}

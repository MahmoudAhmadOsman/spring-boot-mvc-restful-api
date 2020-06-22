//Step 3

package com.altasbookshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//======= Product Controller ==========

//Annotate this class with Spring Boot annotation class
@Controller
public class ProductController {
    //1st get the domain class here in controller
    //2nd user autowire to let Spring inject products
    @Autowired
    private ProductService service;

    //Now create a view that handles requests and use RequestMapping mvc
    // And specify the route using double quotes
    @RequestMapping("/")
    public  String HomePage(Model model){
        //use the List () method and get all the products
        // this method is defined in the ProductService class
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

    //Now return the page you want this request to go
        return  "index";
    }


    //======= Creating New Product ==========

// Creating new product route
//Map the form URL to /new page that holds the HTML form
@RequestMapping("/products/new")
public String showProduct(Model model){
   //1st Create new product object
    Product product = new Product();
    model.addAttribute("prodcut", product);
return  "new_product"; // new_product is the name of the form that holds the HTML form
}


//2nd Save the product into the database
@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveProduct(@ModelAttribute ("product") Product product){
    service.save(product);
    return  "redirect:/"; // Redirect the user to the home page
}





//======= Edit product  ==========
@RequestMapping("/edit/{id}")
public ModelAndView EditProduct(@PathVariable(name ="id") long id){
        ModelAndView mav = new ModelAndView("edit_product");

        Product product = service.get(id);
        mav.addObject("product", product);

    return mav;
}


//======= Delete product  ==========

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") long id) {
        service.delete(id);
        return "redirect:/";
    }


}

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

//@Annotate with Spring Boot Controller annotation  class
@Controller
public class ProductController {
    //1st get the domain or @Service class here
    //2nd use autowired to let Spring inject product service here
    @Autowired
    private ProductService productServiceservice;

    //@Annotate with RequestMapping
    // then, specify the route
    @RequestMapping("/")
    public  String HomePage(Model model){
        //use the List<Modal Class> method to get all the products

        List<Product> listProducts = productServiceservice.listAll();
        model.addAttribute("listProducts", listProducts);

    //Now return the page you want this request to go. in this case is the homepage or the index.html
        return  "index";
    }


    //======= CREATE METHOD ==========

// Create new product route
//Map the form URL to /new page that holds the HTML form
@RequestMapping("/products/new")
public String showProduct(Model model){
   //1st, create new product object
    Product product = new Product();
    model.addAttribute("prodcut", product);
    return  "create"; // 'create' is the view that hold  html form
}


//SAVE METHOD
//2nd Save the product into the database
@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveProduct(@ModelAttribute ("product") Product product){
    productServiceservice.save(product);
    return  "redirect:/"; // Redirect the user to the home page
}





//======= EDIT METHOD  ==========
@RequestMapping("/edit/{id}")
public ModelAndView EditProduct(@PathVariable(name ="id") long id){
        // [ModelAndView] => returns both model and view in a single return value
        ModelAndView edit = new ModelAndView("edit");

        Product product = productServiceservice.get(id);
        edit.addObject("product", product);
        //edit.addObject("message", "Edit successfully completed");

    return edit;
}


//======= DELETE METHOD  ==========

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") long id) {
        productServiceservice.delete(id);


        return "redirect:/";
    }


}

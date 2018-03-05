package controller;

import games.shop.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GamesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);


    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProduct(Model model){
        LOGGER.debug("add product is executed!");
        Product product = new Product();
        model.addAttribute("product", product);
        return "productForm";
    }


    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){

        return "redirect:/index";
    }
}

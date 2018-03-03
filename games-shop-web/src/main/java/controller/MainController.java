package controller;

import games.shop.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer customer, Model model){

        LOGGER.debug("add customer is executed!");
        model.addAttribute("customer", customer);
        return "customerForm";
    }
}

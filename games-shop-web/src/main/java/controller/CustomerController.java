package controller;

import games.shop.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public String addCustomer(Model model){
        LOGGER.debug("add customer is executed!");
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customerForm";
    }

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        return "redirect:/index";
    }
}

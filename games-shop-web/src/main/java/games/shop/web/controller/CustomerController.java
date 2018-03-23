package games.shop.web.controller;

import games.shop.entity.Customer;
import games.shop.service.customer.CustomerCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final CustomerCommandService customerCommandService;

    @Autowired
    public CustomerController(CustomerCommandService customerCommandService) {
        this.customerCommandService = customerCommandService;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public String addCustomer(Model model){
        LOGGER.debug("add customer is executed!");
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customerForm";
    }

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer, Model model){

        int sizeBefore = customerCommandService.customerCount();
        customerCommandService.createCustomer(customer);
        int sizeAfter = customerCommandService.customerCount();
        if(sizeBefore == sizeAfter){
            model.addAttribute("info", "Nie udało się dodać klienta do bazy.");
        } else {
            model.addAttribute("info", "Udało się dodać klienta do bazy.");
        }
        return "adminMain";
    }

    @RequestMapping(value = {"/showCustomers"})
    public String showAllTeachers(Model model) {
        LOGGER.debug("show all customers is executed");
        List<Customer> allCustomers = customerCommandService.showAllCustomers();

        model.addAttribute("customers", allCustomers);

        return "showCustomers";
    }
}

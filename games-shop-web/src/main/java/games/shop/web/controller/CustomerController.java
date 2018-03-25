package games.shop.web.controller;

import games.shop.entity.Customer;
import games.shop.service.customer.CustomerCommandService;
import games.shop.service.customer.CustomerQueryService;
import games.shop.service.customer.dto.SearchCustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final CustomerCommandService customerCommandService;
    private final CustomerQueryService customerQueryService;

    @Autowired
    public CustomerController(CustomerCommandService customerCommandService,
                              CustomerQueryService customerQueryService) {
        this.customerCommandService = customerCommandService;
        this.customerQueryService = customerQueryService;
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
        if(customer.getId()==null) {
            int sizeBefore = customerCommandService.customerCount();
            customerCommandService.createCustomer(customer);
            int sizeAfter = customerCommandService.customerCount();
            if (sizeBefore == sizeAfter) {
                model.addAttribute("info", "Nie udało się dodać klienta do bazy.");
            } else {
                model.addAttribute("info", "Udało się dodać klienta do bazy.");
            }
        } else {
            customerCommandService.updateCustomer(customer);
        }
        return "adminMain";
    }

    @RequestMapping(value = {"/showCustomers"})
    public String showAllCustomers(Model model) {
        LOGGER.debug("show all customers is executed");
        List<Customer> allCustomers = customerCommandService.showAllCustomers();

        model.addAttribute("customers", allCustomers);

        return "showCustomers";
    }

    @RequestMapping(value = "/customer/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        Customer customer = customerCommandService.findCustomerById(id);
        String message = String.format("Udało się usunąć studenta %s %s", customer.getFirstName(), customer.getLastName());
        customerCommandService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("info", message);

        return "redirect:/showCustomers";
    }

    @RequestMapping(value = "/customer/edit/{id}")
    public String editCustomer(@PathVariable("id") Long id, Model model){
        Customer customer = customerCommandService.findCustomerById(id);
        model.addAttribute("customer", customer);

        return "customerForm";
    }

    @RequestMapping(value = "/findCustomer", method = RequestMethod.GET)
    public String findCustomer(Model model){
        model.addAttribute("searchCustomer", new SearchCustomerDTO());

        return "findCustomer";
    }

    @RequestMapping(value = "/findCustomer", method = RequestMethod.POST)
    public String findCustomerByLastName(@ModelAttribute SearchCustomerDTO searchCustomerDTO, Model model){
        List<Customer> foundCustomer = customerQueryService.searchCustomer(searchCustomerDTO);
        model.addAttribute("searchCustomer", new SearchCustomerDTO());
        model.addAttribute("foundCustomer", foundCustomer);

        return "findCustomer";
    }
}

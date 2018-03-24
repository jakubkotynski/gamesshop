package games.shop.service.customer;

import games.shop.entity.Customer;
import games.shop.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerCommandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCommandService.class);

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerCommandService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Long createCustomer(Customer customer) {
        customerRepository.save(customer);

        return customer.getId();
    }

    public int customerCount(){
        return customerRepository.findAll().size();
    }

    public List<Customer> showAllCustomers(){
        return customerRepository.findAll();
    }

    public void updateCustomer(Customer customer){
        Customer dbCustomer = customerRepository.findOne(customer.getId());
        if(dbCustomer == null){
            LOGGER.debug("Klient nie widnieje w bazie danych");
        } else {
            dbCustomer.setFirstName(customer.getFirstName());
            dbCustomer.setLastName(customer.getLastName());
            dbCustomer.setAddress(customer.getAddress());
            dbCustomer.setEmail(customer.getEmail());
        }
    }

    public void deleteCustomer(Long id){
        customerRepository.delete(id);
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findOne(id);
    }
}

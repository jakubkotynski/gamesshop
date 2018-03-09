package games.shop.service.customer;

import games.shop.entity.Customer;
import games.shop.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerCommandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCommandService.class);

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerCommandService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Long create(Customer customer) {
        customerRepository.save(customer);

        return customer.getId();
    }
}

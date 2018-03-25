package games.shop.service.customer;

import games.shop.entity.Customer;
import games.shop.repository.CustomerRepository;
import games.shop.service.customer.dto.SearchCustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerQueryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerQueryService.class);

    private final CustomerRepository customerRepository;

    public CustomerQueryService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> searchCustomer(SearchCustomerDTO searchCustomerDTO){

        List<Customer> foundCustomer = new ArrayList<>();

        if(!searchCustomerDTO.getFirstName().isEmpty()){
            foundCustomer = customerRepository.findAll().stream()
                    .filter(c -> c.getFirstName().equals(searchCustomerDTO.getFirstName()))
                    .collect(Collectors.toList());
        }

        if(!searchCustomerDTO.getLastName().isEmpty()){
            foundCustomer = customerRepository.findAll().stream()
                    .filter(c -> c.getLastName().equals(searchCustomerDTO.getLastName()))
                    .collect(Collectors.toList());
        }

        return foundCustomer;
    }
}

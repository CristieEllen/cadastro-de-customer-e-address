package br.com.project.register.services;

import br.com.project.register.forms.CustomerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.project.register.dto.CustomerDto;
import br.com.project.register.entities.Customer;
import br.com.project.register.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class CustomerServiceImpl{

    @Autowired
    private CustomerRepository customerRepository;

    public Page<CustomerDto> findAllCustomer(Pageable pageable) {
        Page<Customer> resultCustomer = customerRepository.findAll(pageable);
        Page<CustomerDto> customerDto = resultCustomer.map(x -> new CustomerDto(x));
        return customerDto;
    }

    public CustomerDto findByIdCustomer(Long id) {
        Customer resultCustomer = customerRepository.findById(id).get();
        return new CustomerDto(resultCustomer);
    }

    public ResponseEntity<CustomerDto> createCustomer(CustomerForm customerForm, UriComponentsBuilder uriBuilder) {
        System.out.print(customerForm.getAddressFormList());

        Customer customer = customerRepository.save(customerForm.converter());

        System.out.print(customer);


        URI uri = uriBuilder.path("/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomerDto(customer));
    }

    public ResponseEntity remove(Long id){
        customerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
package com.hotel.service.impl;

import com.hotel.entity.Customer;
import com.hotel.repository.CustomerRepository;
import com.hotel.service.CustomerService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }


    @Override
    public Customer getById(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy khách hàng"));
    }


    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public Customer update(Long id, Customer customer) {

        Customer oldCustomer = getById(id);

        oldCustomer.setFullName(customer.getFullName());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setPhone(customer.getPhone());
        oldCustomer.setAddress(customer.getAddress());

        return customerRepository.save(oldCustomer);
    }


    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
package com.abc.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Cart;
import com.abc.ecom.entity.Customer;
import com.abc.ecom.exception.CustomerNotFoundException;
import com.abc.ecom.repository.CartRepository;
import com.abc.ecom.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		
		Cart cart=new Cart();
		cartRepository.save(cart);
		customer.setCart(cart);
		// TODO Auto-generated method stub
		Customer newCustomer=customerRepository.save(customer);
		return newCustomer;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not existing with Id: "+customerId);
		}
		Customer customer=optionalCustomer.get();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	
}

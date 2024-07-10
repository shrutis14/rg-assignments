package com.shruti.spring.batch.config;

import org.springframework.batch.item.ItemProcessor;

import com.shruti.spring.batch.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {

	@Override
	public Customer process(Customer customer) throws Exception {
		return customer;
	}

}

package com.shruti.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shruti.spring.batch.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}

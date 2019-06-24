package com.sakila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sakila.entity.Payment;

@Repository
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long>{

}

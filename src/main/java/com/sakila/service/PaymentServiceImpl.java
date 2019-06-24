package com.sakila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sakila.entity.Payment;
import com.sakila.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository repository;
	@Override
	public Page<Payment> showAllPayment(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Payment showPaymentByPaymentId(Long payment_id) {
		Optional<Payment> optionalPayment=repository.findById(payment_id);		
		if(optionalPayment.isPresent()) {
			return optionalPayment.get();
		}
		return null;
	}

}

package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sakila.entity.Payment;
public interface PaymentService {
	public Page<Payment> showAllPayment(Pageable pageable);
	public Payment showPaymentByPaymentId(Long payment_id);
}

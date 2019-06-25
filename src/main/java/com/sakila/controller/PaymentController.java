package com.sakila.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sakila.entity.Payment;
import com.sakila.exception.EntityNotFoundException;
import com.sakila.service.PaymentService;

@RestController
@RequestMapping(value="/api/payment/")
public class PaymentController {
	private static Logger LOG=LoggerFactory.getLogger(PaymentController.class);
	@Autowired
	private PaymentService service;
	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Payment>> showAllPayment(Pageable pageable){
		Page<Payment> paymentPage=service.showAllPayment(pageable);
		if(paymentPage.isEmpty()) {
			LOG.info("NO CONTENT");
			return new ResponseEntity<Page<Payment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Payment>>(paymentPage,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{payment_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Payment> showByPaymentId(@PathVariable(name="payment_id") Long payment_id){
		Payment payment=service.showPaymentByPaymentId(payment_id);
		if(payment == null) {	
			LOG.info("NO CONTENT");
			throw new EntityNotFoundException("ID "+payment_id+" not found.");
		}
		return new ResponseEntity<Payment>(payment,new HttpHeaders(),HttpStatus.OK);
	}
}

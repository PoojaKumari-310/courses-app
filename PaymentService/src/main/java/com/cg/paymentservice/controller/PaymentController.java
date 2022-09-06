package com.cg.paymentservice.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.paymentservice.exception.PaymentNotFoundException;

import com.cg.paymentservice.model.Payment;

import com.cg.paymentservice.service.PaymentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="payment")
public class PaymentController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PaymentService paymentService;
	@PostMapping("/save")
	
	public ResponseEntity addPayment( @RequestBody Payment payment) {
	
	Payment newPayment = paymentService.savePayment(payment);
	
	
	ResponseEntity<Payment> responseEntity = new ResponseEntity<>(newPayment, HttpStatus.CREATED);
	return responseEntity;

}

	@GetMapping("/find/{paymentId}")
	public ResponseEntity<Payment> fetchMobileById(@PathVariable("paymentId") int paymentId) throws PaymentNotFoundException {

		Payment payment=paymentService.getPaymentById(paymentId);

		return new ResponseEntity<>(payment, HttpStatus.OK);
		
		
	  

	    }
		
	
    }



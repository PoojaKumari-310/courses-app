package com.cg.paymentservice.service;

import java.time.LocalDate;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentservice.exception.PaymentNotFoundException;
import com.cg.paymentservice.model.Payment;
import com.cg.paymentservice.repository.PaymentRepository;
@Service
public class PaymentServiceImpl implements PaymentService {
@Autowired
private PaymentRepository paymentRepository;
	@Override
	public List<Payment> getAllPayment() {
		List<Payment> payment = paymentRepository.findAll();
		return payment;
	}
	
	
	@Override
	public Payment savePayment(Payment payment) {
		payment.setDateOfPayment(LocalDate.now());
		payment.setPaymentStatus("Success");
        Payment paymentDetails = paymentRepository.save(payment);
		return paymentDetails;
		
	}

	@Override
	public Payment getPaymentById(long paymentId) throws PaymentNotFoundException {
		Optional<Payment>optionalPayment = paymentRepository.findById(paymentId);
		if(optionalPayment.isEmpty())
		{
			throw new PaymentNotFoundException("Payment Not exsit with id:"+paymentId);
			
		}
		return optionalPayment.get();
	}



	

	
}

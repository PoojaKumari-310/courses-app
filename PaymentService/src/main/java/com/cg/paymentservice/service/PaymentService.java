package com.cg.paymentservice.service;

import java.util.List;

import com.cg.paymentservice.exception.PaymentNotFoundException;
import com.cg.paymentservice.model.Payment;

public interface PaymentService {
	
	public List<Payment> getAllPayment();
	
	public Payment savePayment(Payment payment);
	
	public Payment getPaymentById(long paymentId) throws PaymentNotFoundException;;

	

}

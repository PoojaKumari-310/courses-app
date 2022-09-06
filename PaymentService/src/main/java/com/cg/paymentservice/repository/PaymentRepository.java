package com.cg.paymentservice.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.paymentservice.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	

}

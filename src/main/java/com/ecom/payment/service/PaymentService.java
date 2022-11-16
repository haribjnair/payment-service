package com.ecom.payment.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.payment.entity.Payment;
import com.ecom.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public Payment doPayment(Payment payment) {
		payment.setTxnId(UUID.randomUUID().toString());
		payment.setPaymentStatus(getPaymentStatus());
		return paymentRepository.save(payment);
	}

	private String getPaymentStatus() {
		//Mocking external payment gateway attempt
		return new Random().nextBoolean() ? "success" : "failure";
	}
}

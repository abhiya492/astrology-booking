package com.astrotalk.astrology_booking.service;

import com.astrotalk.astrology_booking.model.Booking;
import com.astrotalk.astrology_booking.model.Payment;
import com.astrotalk.astrology_booking.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment processPayment(Booking booking, String paymentMethod, String cardNumber, String expiry, String cvv) {
        Payment payment = new Payment();
        payment.setBookingId(booking.getId());
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(booking.getAmount());
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus("Processed");

        // Implement payment processing logic here

        return paymentRepository.save(payment);
    }

    @Override
    public boolean verifyPayment(String paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElse(null);
        if (payment != null) {
            // Implement payment verification logic here
            return true;
        }
        return false;
    }

    @Override
    public Payment refundPayment(String paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElse(null);
        if (payment != null) {
            // Implement payment refund logic here
            payment.setStatus("Refunded");
            return paymentRepository.save(payment);
        }
        return null;
    }
}

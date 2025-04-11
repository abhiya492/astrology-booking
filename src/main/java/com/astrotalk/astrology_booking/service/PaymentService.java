package com.astrotalk.astrology_booking.service;

import com.astrotalk.astrology_booking.model.Booking;
import com.astrotalk.astrology_booking.model.Payment;

public interface PaymentService {
    
    Payment processPayment(Booking booking, String paymentMethod, String cardNumber, String expiry, String cvv);
    
    boolean verifyPayment(String paymentId);
    
    Payment refundPayment(String paymentId);
}
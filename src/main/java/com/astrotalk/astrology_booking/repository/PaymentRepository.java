package com.astrotalk.astrology_booking.repository;

import com.astrotalk.astrology_booking.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {}

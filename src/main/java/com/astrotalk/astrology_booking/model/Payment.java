package com.astrotalk.astrology_booking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.time.LocalDateTime;

@Document(collection = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    private String id;
    private String bookingId;
    private String paymentMethod;
    private double amount;
    private LocalDateTime paymentDate;
    private String status;

    public boolean processPayment() {
        // Implement payment processing logic here
        return true;
    }

    public boolean verifyPayment() {
        // Implement payment verification logic here
        return true;
    }

    public boolean refundPayment() {
        // Implement payment refund logic here
        return true;
    }
}

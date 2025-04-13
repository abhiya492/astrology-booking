package com.astrotalk.astrology_booking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.time.LocalDateTime;

@Document(collection = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    private String id;

    private String userId;
    private String astrologerId;
    private String slot; // e.g. "10:30 AM"
    private LocalDateTime bookedAt;
    private double amount; // Added field for payment processing
}

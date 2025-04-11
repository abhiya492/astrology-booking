package com.astrotalk.astrology_booking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private String id;
    private String userId;
    private String astrologerId;
    private String bookingId;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;
}
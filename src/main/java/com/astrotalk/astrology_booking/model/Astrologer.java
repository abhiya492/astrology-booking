package com.astrotalk.astrology_booking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.util.List;

@Document(collection = "astrologers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Astrologer {
    @Id
    private String id;
    private String name;
    private String expertise;
    private List<String> availableSlots;  // e.g. ["10:00", "11:00", "15:30"]
}

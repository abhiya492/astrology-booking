package com.astrotalk.astrology_booking.service;

import com.astrotalk.astrology_booking.model.Astrologer;
import com.astrotalk.astrology_booking.model.Booking;
import com.astrotalk.astrology_booking.repository.AstrologerRepository;
import com.astrotalk.astrology_booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private AstrologerRepository astrologerRepository;

    public Booking bookSlot(Booking booking) {
        // Validate astrologer and slot availability
        Optional<Astrologer> astrologerOpt = astrologerRepository.findById(booking.getAstrologerId());
        
        if (astrologerOpt.isEmpty()) {
            throw new IllegalArgumentException("Astrologer not found");
        }
        
        Astrologer astrologer = astrologerOpt.get();
        
        // Check if the slot exists and is available
        if (!astrologer.getAvailableSlots().contains(booking.getSlot())) {
            throw new IllegalArgumentException("Slot not available");
        }
        
        // Remove the slot from available slots
        astrologer.getAvailableSlots().remove(booking.getSlot());
        astrologerRepository.save(astrologer);
        
        // Set booking timestamp
        booking.setBookedAt(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUserId(String userId) {
        return bookingRepository.findByUserId(userId);
    }
}
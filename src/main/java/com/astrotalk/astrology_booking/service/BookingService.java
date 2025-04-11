package com.astrotalk.astrology_booking.service;

import com.astrotalk.astrology_booking.model.Booking;
import com.astrotalk.astrology_booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking bookSlot(Booking booking) {
        booking.setBookedAt(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUserId(String userId) {
        return bookingRepository.findByUserId(userId);
    }
}

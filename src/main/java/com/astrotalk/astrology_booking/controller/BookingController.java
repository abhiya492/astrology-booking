package com.astrotalk.astrology_booking.controller;

import com.astrotalk.astrology_booking.model.Booking;
import com.astrotalk.astrology_booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking bookSlot(@RequestBody Booking booking) {
        return bookingService.bookSlot(booking);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable String userId) {
        return bookingService.getBookingsByUserId(userId);
    }
}

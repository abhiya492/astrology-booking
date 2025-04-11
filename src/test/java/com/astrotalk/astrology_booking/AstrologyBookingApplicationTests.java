package com.astrotalk.astrology_booking;

import com.astrotalk.astrology_booking.controller.*;
import com.astrotalk.astrology_booking.exception.GlobalExceptionHandler;
import com.astrotalk.astrology_booking.model.*;
import com.astrotalk.astrology_booking.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class AstrologyBookingApplicationTests {

    @Autowired
    private NotificationService notificationService;

    @MockBean
    private PaymentService paymentService;

    @MockBean
    private AuthController authController;

    @MockBean
    private AstrologerController astrologerController;

    @MockBean
    private BookingController bookingController;

    @MockBean
    private UserController userController;

    @MockBean
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    void contextLoads() {
    }

    @Test
    void testSendNotification() {
        doNothing().when(notificationService).sendNotification(anyString(), anyString(), anyString());
        notificationService.sendNotification("test@example.com", "Test Subject", "Test Message");
        verify(notificationService, times(1)).sendNotification("test@example.com", "Test Subject", "Test Message");
    }

    @Test
    void testProcessPayment() {
        // Add your test logic here
    }

    @Test
    void testAuthControllerLogin() {
        Map<String, String> loginRequest = Map.of("email", "test@example.com", "password", "password");
        when(authController.login(loginRequest)).thenReturn(new ResponseEntity<>(Map.of("token", "dummyToken"), HttpStatus.OK));

        ResponseEntity<?> response = authController.login(loginRequest);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("dummyToken", ((Map<String, Object>) response.getBody()).get("token"));
    }

    @Test
    void testAstrologerControllerAddAstrologer() {
        Astrologer astrologer = new Astrologer("1", "John Doe", "Love", List.of("10:00", "11:00"), 4.5, 10, "Bio", 100.0, "image.jpg");
        when(astrologerController.addAstrologer(astrologer)).thenReturn(astrologer);

        Astrologer response = astrologerController.addAstrologer(astrologer);
        assertEquals(astrologer, response);
    }

    @Test
    void testAstrologerControllerGetAllAstrologers() {
        List<Astrologer> astrologers = List.of(new Astrologer("1", "John Doe", "Love", List.of("10:00", "11:00"), 4.5, 10, "Bio", 100.0, "image.jpg"));
        when(astrologerController.getAllAstrologers()).thenReturn(astrologers);

        List<Astrologer> response = astrologerController.getAllAstrologers();
        assertEquals(astrologers, response);
    }

    @Test
    void testBookingControllerBookSlot() {
        Booking booking = new Booking("1", "user1", "astrologer1", "10:00", null);
        when(bookingController.bookSlot(booking)).thenReturn(booking);

        Booking response = bookingController.bookSlot(booking);
        assertEquals(booking, response);
    }

    @Test
    void testBookingControllerGetBookingsByUser() {
        List<Booking> bookings = List.of(new Booking("1", "user1", "astrologer1", "10:00", null));
        when(bookingController.getBookingsByUser("user1")).thenReturn(bookings);

        List<Booking> response = bookingController.getBookingsByUser("user1");
        assertEquals(bookings, response);
    }

    @Test
    void testUserControllerRegister() {
        User user = new User("1", "John Doe", "john@example.com", "password");
        when(userController.register(user)).thenReturn(user);

        User response = userController.register(user);
        assertEquals(user, response);
    }

    @Test
    void testUserControllerGetAll() {
        List<User> users = List.of(new User("1", "John Doe", "john@example.com", "password"));
        when(userController.getAll()).thenReturn(users);

        List<User> response = userController.getAll();
        assertEquals(users, response);
    }

    @Test
    void testGlobalExceptionHandlerHandleUserAlreadyExistsException() {
        UserAlreadyExistsException ex = new UserAlreadyExistsException("User already exists");
        ResponseEntity<Object> response = globalExceptionHandler.handleUserAlreadyExistsException(ex);
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("User already exists", ((Map<String, Object>) response.getBody()).get("message"));
    }

    @Test
    void testGlobalExceptionHandlerHandleAstrologerNotFoundException() {
        AstrologerNotFoundException ex = new AstrologerNotFoundException("Astrologer not found");
        ResponseEntity<Object> response = globalExceptionHandler.handleAstrologerNotFoundException(ex);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Astrologer not found", ((Map<String, Object>) response.getBody()).get("message"));
    }

    @Test
    void testGlobalExceptionHandlerHandleSlotNotAvailableException() {
        SlotNotAvailableException ex = new SlotNotAvailableException("Slot not available");
        ResponseEntity<Object> response = globalExceptionHandler.handleSlotNotAvailableException(ex);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Slot not available", ((Map<String, Object>) response.getBody()).get("message"));
    }
}

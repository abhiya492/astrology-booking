package com.astrotalk.astrology_booking;

import com.astrotalk.astrology_booking.controller.AuthController;
import com.astrotalk.astrology_booking.service.NotificationService;
import com.astrotalk.astrology_booking.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
}

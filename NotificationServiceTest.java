
package com.example.ticketinggateway.notification;

import com.example.ticketinggateway.notification.service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

@SpringBootTest
public class NotificationServiceTest {

    @Autowired
    private NotificationService notificationService;

    @MockBean
    private JavaMailSender mailSender;

    @BeforeEach
    void setUp() {
        MimeMessage mimeMessage = Mockito.mock(MimeMessage.class);
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
    }

    @Test
    void testSendEmail() {
        String recipient = "user@example.com";
        String subject = "Ticket Update";
        String body = "Your ticket status has been updated.";

        assertDoesNotThrow(() -> {
            notificationService.sendEmail(recipient, subject, body);
        });

        verify(mailSender, times(1)).createMimeMessage();
    }
}

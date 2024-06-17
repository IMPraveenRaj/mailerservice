package com.springheaven.Mailer.controller;

import com.springheaven.Mailer.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Notification Controller", description = "APIs for sending notifications")
public class TestController {

    @Autowired
    private NotificationService notificationService;


    @GetMapping("/send-notifications")
    @Operation(summary = "Send expiry notifications", description = "Send email notifications for customers whose memberships are about to expire in the next 30 days")
    public String sendNotifications() {
        notificationService.sendExpiryNotifications();
        return "notification sent";

    }

}

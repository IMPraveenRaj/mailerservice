package com.springheaven.Mailer.controller;

import com.springheaven.Mailer.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/send-notifications")
    public String sendNotifications() {
        notificationService.sendExpiryNotifications();
        return "notification sent";

    }

}

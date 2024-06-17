package com.springheaven.Mailer.service;


import com.springheaven.Mailer.model.Customer;
import com.springheaven.Mailer.repository.CustomerRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Scheduled(cron = "0 0 8 * * ?") // Runs every day at 8 AM
    public void sendExpiryNotifications() {
        LocalDate today = LocalDate.now();
        LocalDate targetDate = today.plusDays(30);
        List<Customer> expiringCustomers = customerRepository.findByMembershipExpiryDateBefore(targetDate);

        if (!expiringCustomers.isEmpty()) {
            StringBuilder messageContent = new StringBuilder("The following memberships are expiring within the next 30 days:\n\n");

            for (Customer customer : expiringCustomers) {
                messageContent.append("Name: ").append(customer.getName())
                        .append(", Email: ").append(customer.getEmail())
                        .append(", Expiry Date: ").append(customer.getMembershipExpiryDate()).append("\n");
            }


            sendEmail("mail you wish to send ", "Expiring Gym Memberships", messageContent.toString());
        }
    }

    private void sendEmail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

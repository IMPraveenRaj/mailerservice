package com.springheaven.Mailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MailerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailerServiceApplication.class, args);
	}

}

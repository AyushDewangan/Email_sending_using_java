package com.example.demo.mailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.service.EmailServiceOptima;

@Service
public class EmailSenderServiceImpl implements EmailServiceOptima {

	@Autowired
	private JavaMailSender javaMailSender;

	public boolean sendEmail(String toEmail, String subject, String body) {
		try {
			System.out.println("enter in sendMail method.");
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("ayushdewangan203@gmail.com");
			message.setTo(toEmail);
			message.setText(body);
			message.setSubject(subject);
			javaMailSender.send(message);
			System.out.println("Email sending...");
			return true;
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		return false;
	}

}

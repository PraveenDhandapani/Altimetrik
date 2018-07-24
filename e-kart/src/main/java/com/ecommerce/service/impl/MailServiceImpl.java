package com.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ecommerce.beans.Mail;
import com.ecommerce.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public String sendMail(Mail mailObj){
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(mailObj.getSendTo());
		mail.setCc(mailObj.getSendCC());
		mail.setSubject(mailObj.getSubject());
		mail.setText(mailObj.getMessage());
		
		mailSender.send(mail);
		
		
		return "Mail Sent to user Successfully";
	}

}

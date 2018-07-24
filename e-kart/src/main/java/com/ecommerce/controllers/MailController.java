package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.beans.Mail;
import com.ecommerce.service.MailService;

@RestController
@RequestMapping(value="/mail")
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value="/statusMail",method=RequestMethod.POST)
	public ResponseEntity<String> sendMail(@RequestBody Mail mail){
		return new ResponseEntity<String>(mailService.sendMail(mail),HttpStatus.OK);
	}

}

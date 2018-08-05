package com.revature.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class TLSEmail {
	public static void main(String[] args) {
		final String fromEmail = "revalocate@gmail.com"; //requires valid gmail id
		final String password = "P4ssw0rd!"; // correct password for gmail id
		final String toEmail = "brandon.scoggins44@gmail.com"; // can be any email id 
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "email-smtp.us-east-1.amazonaws.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		Email.sendMail(session, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body");
		
	}

}

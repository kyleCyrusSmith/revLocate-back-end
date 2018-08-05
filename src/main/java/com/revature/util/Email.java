package com.revature.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class Email {
	/*public static void sendMail(Session session, String target, String subject, String body) {
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("revalocate@gmail.com", "NoReply-RL"));

	      msg.setReplyTo(InternetAddress.parse("revalocate@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(target, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}*/
	}
//
//        // change accordingly
//        final String username = "revalocate@gmail.com";   
//         
//        // change accordingly
//        final String password = "P4ssw0rd!";
//         
//        // or IP address
//        final String host = "localhost"; 
// 
//        // Get system properties
//        Properties props = new Properties();             
//         
//        // enable authentication
//        props.put("mail.smtp.auth", host);               
//         
//        // enable STARTTLS
//        props.put("mail.smtp.starttls.enable", "true");    
//         
//        // Setup mail server
//        props.put("mail.smtp.host", "smtp.gmail.com");     
//         
//        // TLS Port
//        props.put("mail.smtp.port", "587");                
// 
//        // creating Session instance referenced to 
//        // Authenticator object to pass in 
//        // Session.getInstance argument
//        session = Session.getInstance(props,
//          new javax.mail.Authenticator() {
//            
//            //override the getPasswordAuthentication method
//            protected PasswordAuthentication 
//                           getPasswordAuthentication() {
//                                        
//                return new PasswordAuthentication(username, 
//                                                 password);
//            }
//          });
// 
//        try {
//             
//            // compose the message
//            // javax.mail.internet.MimeMessage class is 
//            // mostly used for abstraction.
//            Message message = new MimeMessage(session);    
//             
//            // header field of the header.
//            message.setFrom(new InternetAddress(username)); 
//             
//            message.setRecipients(Message.RecipientType.TO,
//                InternetAddress.parse(target));
//            message.setSubject(subject);
//            message.setText(body);
// 
//            Transport.send(message);         //send Message
// 
//            System.out.println("Done");
// 
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }
		/*
		try
		{
			Transport transport = session.getTransport();
			MimeMessage msg = new MimeMessage(session);
			//set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("revalocate@gmail.com", "NoReply-RL"));
			msg.setReplyTo(InternetAddress.parse("revalocate@gmail.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(target, false));
			transport.connect("email-smtp.us-east-1.amazonaws.com", "AKIAI5QLZX3SMW2LUVGQ", "AsLhxMFpsMyAhO4Spgn54lRYyC0i30e1yjUR5THOUFeC");
			System.out.println("Message is ready");
			transport.sendMessage(msg, msg.getAllRecipients());  
			System.out.println("EMail Sent Successfully!!");
			transport.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/

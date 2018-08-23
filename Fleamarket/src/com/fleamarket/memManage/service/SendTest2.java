package com.fleamarket.memManage.service;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

public class SendTest2 {
	
	
	public void a(String recieverEmail){
			
		  String host     = "smtp.naver.com"; //어떤 호스트를 이용할지
		  final String user   = "ffl646"; // 네이버 아이디
		  final String password  = "rjsduq646"; //페스워드
		  String to     = recieverEmail ;// "gunfreeload47@gmail.com"; //어디로 갈지

		  
		  // Get the session object
		  Properties props = new Properties();
		  props.put("mail.smtp.host", host);
		  props.put("mail.smtp.auth", "true");

		  Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		    return new PasswordAuthentication(user, password);
		   }
		  });

		  // Compose the message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(user));
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		   // Subject
		   message.setSubject("크로니 장터 가입을 진심으로 축하드립니다.");
		   
		   
		   // Text
		   message.setText("가입을 진심으로 축하 드립니다~!! 빠빠바방!");

		   // send the message
		   Transport.send(message);
		   System.out.println("message sent successfully...");

		  } catch (MessagingException e) {
		   e.printStackTrace();
		  }
		  
		
		
	}
	

}

package com.test.spark.util

  
import javax.mail.internet._
import java.util.Date
import java.util.Properties
import scala.collection.JavaConversions._

import org.apache.log4j.{ Level, Logger }
import java.util.Properties

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import scala.collection.mutable.ListBuffer
import javax.mail.Address



/*
* A Mailer config object that uses Props and auto configures for gmail
* if detected.
*/
object EmailSend {
  
  println("started email sender")
  val to: String = "chethanb98@gmail.com" 
  
 // var address:Address = new InternetAddress(to).asInstanceOf[Address]
  
  var toList:Array[String] = ("1","2","3").toString().split(",") 
  
  var address:Array[Address] = 
    
    new InternetAddress(to).asInstanceOf[Array[Address]]
  
  val from: String  = "chethanb98@gmail.com"

  val username: String  = "chethanb98@gmail.com"
    
  val password: String = "Abc123xyz&@"
  
  val host = "relay.jangosmtp.net"
  
  val props: Properties = new Properties()
  
          props.put("mail.smtp.auth", "true")
          props.put("mail.smtp.starttls.enable", "true")
          props.put("mail.smtp.host", host)
          props.put("mail.smtp.port", "25")

  val session: Session = Session.getInstance(props,
         new javax.mail.Authenticator() {
    
    override def getPasswordAuthentication = new
              PasswordAuthentication(username, password)
         })   
         
    try {

	  val message: Message  = new MimeMessage(session)
	   message.setFrom(new InternetAddress(from))
	   message.setRecipients(Message.RecipientType.TO, address)
	   message.setSubject("Testing Subject")
	   message.setText("Hello, this is sample for to check send " +
		"email using JavaMailAPI ")

	   Transport.send(message)

	   System.out.println("Sent message successfully....")

      }
  catch  {
        case e:MessagingException => throw new RuntimeException(e)
        }      
}
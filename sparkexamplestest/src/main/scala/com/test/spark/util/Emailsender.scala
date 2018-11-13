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


object Emailsender {
 
  println("chethan")
  
  def sendemail()
  {
    println("started email sender")
    
  val to: String = "cbhawarlal@collectivei.com" 
  
 // var address:Address = new InternetAddress(to).asInstanceOf[Address]
  
  var toList:Array[String] = ("1","2","3").toString().split(",") 
  
  //var address:Array[Address] =   new InternetAddress(to).asInstanceOf[Array[Address]]
  
  val from: String  = "cbhawarlal@collectivei.com"

  val username: String  = "cbhawarlal@collectivei.com"
    
  val password: String = "CHethan&@"
  
   val host = "smtp.gmail.com"
    val port = "587"
 
  val props: Properties = new Properties()
 
    props.put("mail.smtp.host", host)
    props.put("mail.smtp.port", port)
    props.put("mail.smtp.auth", "true")
    props.put("mail.smtp.starttls.enable", "true")


/*  val session: Session = Session.getInstance(props,
         new javax.mail.Authenticator() {
    
    override def getPasswordAuthentication = new
              PasswordAuthentication(username, password)
         })   
         * 
         */
    val session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
    
    override def getPasswordAuthentication = new
              PasswordAuthentication(username, password)
         }) 
         
    try {

	  val message: Message  = new MimeMessage(session)
	  // message.setFrom(new InternetAddress(from))
	   message.addRecipient(Message.RecipientType.TO,new InternetAddress(from))
	   message.setSubject("Testing Subject")
	   message.setText("Hello, this is sample for to check send " +
		"email using JavaMailAPI ")
		
		val transport = session.getTransport("smtp")
    transport.connect(host, username, password)
    transport.sendMessage(message, message.getAllRecipients)


	   System.out.println("Sent message successfully....")

      }
  catch  {
        case e:MessagingException => throw new RuntimeException(e)
        }  
  }
}
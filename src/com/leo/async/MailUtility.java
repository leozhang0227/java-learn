package com.leo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
 
@Component
public class MailUtility {
 
@Async
public void sendMail(String name){
 
System.out.println(" I Will be formatting html mail and sending it  ");
 
try {
Thread.sleep(5000);
 
} catch (InterruptedException e) {
 
e.printStackTrace();
}
 
System.out.println("Asynchronous method call of send email -- Complete");
 
}
 
}
package com.project.service;

import java.net.HttpURLConnection;
import java.net.URL;

public class OTPDemo {
	
    public void sendOTP(String phone,String msg)
    {
      try {
    	    
    	    String userid = "ieeeglobal";
            String passwd = "123123";
            String sender="IEEEGL";
            
            String requestUrl = "http://www.smswave.in/panel/sendsms.php?sender="+ sender + "&PhoneNumber=" + phone +"&Text='"+msg+"'&user=" + userid +"&password=" + passwd ; 

        
            
            URL url = new URL(requestUrl);
            HttpURLConnection uc = (HttpURLConnection)url.openConnection();
            System.out.println("URL Connection Start....");
            
            System.out.println(uc.getResponseMessage());
            
            System.out.println("Messsage Is Sent Sucessfully...");
            uc.disconnect();
            } catch(Exception ex) {
            System.out.println(ex.getMessage());
            }
        
    
        
    
}
    
}
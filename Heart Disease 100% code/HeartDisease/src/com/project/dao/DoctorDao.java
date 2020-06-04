package com.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.project.bean.Adminbean;
import com.project.bean.RegisterBean;
import com.project.bean.Test_Bean;
import com.project.db.DBConnect;

public class DoctorDao {
	Connection connection=DBConnect.getConnection();
	Boolean resultStatus=Boolean.FALSE;
	PreparedStatement psmt;
	ResultSet rs;
	
	public boolean registerDoctor(RegisterBean bean)
	   {
		try
		   {
		        String sql="Select * from tbl_doctor where doctor_name=? or doctor_email=?";
				psmt = connection.prepareStatement(sql);
				psmt.setString(1,bean.getUname());
				
				psmt.setString(2,bean.getUemail());
				rs=psmt.executeQuery();
				Boolean b=rs.next();
				
				if(b==true)
				{
				System.out.println("Record already exist");
				
				}
				
				else
				{
				
				    String SQL="insert into tbl_doctor(doctor_name,doctor_address,doctor_email,doctor_mobno,doctor_password) values(?,?,?,?,?)"; 
				
					PreparedStatement pstmt=connection.prepareStatement(SQL);
					pstmt.setString(1, bean.getUname());
					pstmt.setString(2, bean.getUaddress());
					pstmt.setString(3, bean.getUemail());
					pstmt.setString(4, bean.getUmobno());
					pstmt.setString(5, bean.getUpassword());
					
					
					int index=pstmt.executeUpdate();
					
					if(index>0)
					{
						resultStatus=Boolean.TRUE;
					}
					else
					{
						resultStatus=Boolean.FALSE;	
					}
					
			   
	     	    }
		   }
				
				catch (SQLException e) 
				  {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
					
		     return resultStatus;
				
		 }
	
	/**********************************************************************************************************************/
	
	public boolean checkDoctor(RegisterBean bean)
	{
		
		try {
			System.out.println("doctorcheck");
			String sql="Select * from tbl_doctor where doctor_email=? and doctor_password=?";
			psmt = connection.prepareStatement(sql);
			psmt.setString(1,bean.getUemail());
			psmt.setString(2,bean.getUpassword());
			ResultSet rs=psmt.executeQuery(); 
			resultStatus=rs.next();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		System.out.println(resultStatus);
		return resultStatus;
	}
	
	/**********************************************************************************************************************/
	public boolean deleteDoctor(int id) {
		boolean flag=false;
		try{
			
		 String query="delete from tbl_doctor where id='"+id+"'";
		 
		 PreparedStatement ps= connection.prepareStatement(query);
		 
		 int index = ps.executeUpdate();
			if(index>0){
			
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	/**********************************************************************************************************************/
	
	public ResultSet getDoctorDetails(String email, String password)
	{
		ResultSet rs=null;
		
		try {
			String sql="Select * from tbl_doctor where doctor_email='"+email+"' and doctor_password='"+password+"'";
			Statement stmt=connection.createStatement();
			System.out.println("In Dao");
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				
				//System.out.println("id"+i);
			}
			    
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	
		return rs;
	}
	
	/**********************************************************************************************************************/
	
	public  ArrayList<RegisterBean> doctorDetails()
	{
		
	   ResultSet rs=null;
	   
	   ArrayList<RegisterBean> details = new ArrayList<RegisterBean>();
	   
       String sql = "Select * from tbl_doctor";
		
		try {
			
			Statement stmt=connection.createStatement();
		
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				RegisterBean bean=new RegisterBean();
				bean.setUid(rs.getInt(1));
				bean.setUname(rs.getString(2));
				bean.setUaddress(rs.getString(3));
				bean.setUemail(rs.getString(4));
				bean.setUmobno(rs.getString(5));
				
				details.add(bean);
			}
			
		 } 
		catch (SQLException e) 
		   {
			
			 e.printStackTrace();
		   }
		return details;
		
		
	}
	/**********************************************************************************************************************/
	
	public RegisterBean doctorSelect(String email)
	{
		RegisterBean bean=new RegisterBean();
		String sql = "Select * from tbl_doctor where doctor_email ='"+email.toLowerCase()+"'";
		
		try {
			
			Statement stmt=connection.createStatement();
		
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
			    bean.setUname(rs.getString(2));
			    bean.setUpassword(rs.getString(6));
			    bean.setUemail(rs.getString(4));	
			}
		 } 
		catch (SQLException e) 
		   {
			
			 e.printStackTrace();
		   }
		return bean;
	}
	
	/**********************************************************************************************************************/ 
	
	public ResultSet getDetails(int id)
	{
		
	   ResultSet rs=null;
	   
	   
       String sql = "Select * from tbl_doctor where id='"+id+"'";
		
		try {
			
			Statement stmt=connection.createStatement();
		
			 rs = stmt.executeQuery(sql);
			
		 } 
		catch (SQLException e) 
		   {
			
			 e.printStackTrace();
		   }
		return rs;
		
		
	}
	
	/**********************************************************************************************************************/
	//id, patient_name, age, sex, cp, trestbps, chol, fbs, restecg, thalach, exang, oldpeak, slope, ca, thal, num, probability, result
	public boolean insertTestData(Test_Bean bean)
	   {
		try
		   {
		       
				    String SQL="insert into tbl_tested_data(patient_name, age, sex, cp, trestbps, chol, fbs, restecg, thalach, exang, oldpeak, slope, ca, thal, num, probability, result) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
				
					PreparedStatement pstmt=connection.prepareStatement(SQL);
					pstmt.setString(1, bean.getPatient_name());
					pstmt.setInt(2, bean.getAge());
					pstmt.setInt(3, bean.getSex());
					pstmt.setInt(4, bean.getCp());
					pstmt.setInt(5, bean.getTrestbps());
					pstmt.setInt(6, bean.getChol());
					pstmt.setInt(7, bean.getFbs());
					pstmt.setInt(8, bean.getRestecg());
					pstmt.setInt(9, bean.getThalach());
					pstmt.setInt(10, bean.getExang());
					pstmt.setInt(11, bean.getOldpeak());
					pstmt.setInt(12, bean.getSlope());
					pstmt.setInt(13, bean.getCa());
					pstmt.setInt(14, bean.getThal());
					pstmt.setInt(15, bean.getNum());
					pstmt.setString(16, bean.getProbability());
					pstmt.setString(17, bean.getResult());
					
					
					int index=pstmt.executeUpdate();
					
					if(index>0)
					{
						resultStatus=Boolean.TRUE;
						System.out.println("Record Inserted");
					}
					else
					{
						resultStatus=Boolean.FALSE;	
						System.out.println("Record Not Inserted");
					}
				
		   }
				
				catch (SQLException e) 
				  {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
					
		     return resultStatus;
				
		 }
	
}

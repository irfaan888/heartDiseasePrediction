package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.RegisterBean;
import com.project.dao.DoctorDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/DoctorLoginServlet")
public class DoctorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Boolean resultStatus=Boolean.FALSE; 
	int id=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); 
		String uemail=request.getParameter("doctoremail");
		String upassword=request.getParameter("password");
		
		
		RegisterBean bean=new RegisterBean();
		bean.setUemail(uemail);
		bean.setUpassword(upassword);
		
		DoctorDao ud=new DoctorDao();
		
		ResultSet rs=ud.getDoctorDetails(uemail,upassword);
		
		   try 
		   {
			  id=rs.getInt(1);
			  System.out.println("Id===="+id);
		   } 
		  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	
		
			if(resultStatus=ud.checkDoctor(bean))
			{
				HttpSession session=request.getSession();  
		        session.setAttribute("email",uemail);
		        session.setAttribute("id", id);
		        out.println("<script type=\"text/javascript\">");
				out.println("alert('Login Success!!!');");
				out.println("location='doctor_home.jsp';");
				out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Incorrect Doctorname/Password!!!');");
				out.println("location='doctor_login.jsp';");
				out.println("</script>");
				
			} 
		
	}

}

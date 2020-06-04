package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.RegisterBean;
import com.project.dao.DoctorDao;
import com.project.service.EmailDemo;

/**
 * Servlet implementation class ForgetPassServlet
 */
@WebServlet("/ForgotPassServlet")
public class ForgotPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassServlet() {
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
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		String uemail=request.getParameter("doctoremail");
		
		DoctorDao ud=new DoctorDao();
		
		RegisterBean bean=ud.doctorSelect(uemail);
	
		if(bean.getUname()!=null && bean.getUpassword()!="")
		{
		   EmailDemo ed=new EmailDemo();
		   ed.sendUserPass(uemail, bean.getUname(), bean.getUpassword());
		   out.println("<script type=\"text/javascript\">");
		   out.println("alert('Mail Send Successfully!!!');");
		   out.println("location='doctor_login.jsp';");
		   out.println("</script>");
		
		}
		else
		{
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Email Send Failed!!!');");
			out.println("location='forgotpass.jsp';");
			out.println("</script>");
			
		}
	}

}

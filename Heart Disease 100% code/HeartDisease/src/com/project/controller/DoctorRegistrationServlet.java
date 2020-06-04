package com.project.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.project.bean.RegisterBean;
import com.project.dao.DoctorDao;
import com.project.service.EmailDemo;
import com.project.service.OTPDemo;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/DoctorRegistrationServlet")
@MultipartConfig(maxFileSize=1024*1024*1024)
public class DoctorRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("doctorname");
		String uaddress=request.getParameter("doctoraddress");
		String uemail=request.getParameter("doctoremail");
		String umobno=request.getParameter("doctormobno");
		String upassword=request.getParameter("doctorpassword");
		
		RegisterBean bean=new RegisterBean();
		
		bean.setUname(uname);
		bean.setUaddress(uaddress);
		bean.setUemail(uemail);
		bean.setUmobno(umobno);
		bean.setUpassword(upassword);
		
		DoctorDao ud=new DoctorDao();
		
		
		if(ud.registerDoctor(bean))
		{
			/*EmailDemo ed=new EmailDemo();
			ed.sendEmail(uemail);*/
			OTPDemo o=new OTPDemo();
			String msg="Doctor Registraction Success!!";
			o.sendOTP(umobno, msg);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Doctor Registraction Success!!!');");
			out.println("location='doctor_login.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Record already exist!!!');");
			out.println("location='doctor_register.jsp';");
			out.println("</script>");
		}
	}

}

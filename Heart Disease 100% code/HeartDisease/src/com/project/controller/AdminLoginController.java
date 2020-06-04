package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Adminbean;
import com.project.dao.AdminDao;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Boolean resultStatus=Boolean.FALSE; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
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
		// TODO Auto-generated method stub
        PrintWriter out=response.getWriter();
		
		String adminemail=request.getParameter("adminemail");
		String adminpassword=request.getParameter("password");
		
		
		Adminbean bean=new Adminbean();
		
		bean.setEmail(adminemail);
		bean.setPassword(adminpassword);
		
		AdminDao ud=new AdminDao();
	
			if(resultStatus=ud.checkAdmin(bean))
			{
				HttpSession session=request.getSession();  
		        session.setAttribute("adminemail",adminemail);
		        out.println("<script type=\"text/javascript\">");
				out.println("alert('Login Success!!!');");
				out.println("location='admin_home.jsp';");
				out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Incorrect Username/Password!!!');");
				out.println("location='admin_login.jsp';");
				out.println("</script>");
				
			} 
		
	}

}

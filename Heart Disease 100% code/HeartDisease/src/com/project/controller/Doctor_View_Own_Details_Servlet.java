package com.project.controller;

import java.io.IOException;
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
 * Servlet implementation class Doctor_View_Own_Details_Servlet
 */
@WebServlet("/Doctor_View_Own_Details_Servlet")
public class Doctor_View_Own_Details_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doctor_View_Own_Details_Servlet() {
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
        HttpSession session=request.getSession();
		
		Object obj=session.getAttribute("id");
	    int uid=Integer.parseInt(obj.toString());
		System.out.println("id= "+uid);
		
		RegisterBean bean=new RegisterBean();
		
		bean.setUid(uid);
	    
	    DoctorDao ud=new DoctorDao();
	    
		ResultSet rs=ud.getDetails(uid);
		
		
		if(rs != null)
		{
			session.setAttribute("rs", rs);
			session.setAttribute("id", uid);
	        response.sendRedirect("doctor_view_own_details.jsp");
		}
		else
		{
			response.sendRedirect("doctor_home.jsp");
		} 	
	}

}

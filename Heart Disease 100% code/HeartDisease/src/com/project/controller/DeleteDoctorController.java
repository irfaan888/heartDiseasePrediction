package com.project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.RegisterBean;
import com.project.dao.DoctorDao;

/**
 * Servlet implementation class DeleteUserController
 */
@WebServlet("/DeleteDoctorController")
public class DeleteDoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDoctorController() {
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
		
		   int id = Integer.parseInt(request.getParameter("doctorid"));
			
		    DoctorDao d=new DoctorDao();
			
			ArrayList<RegisterBean> doc_details=new ArrayList<RegisterBean>();
			
			
			if(d.deleteDoctor(id))
			{
				
				doc_details=d.doctorDetails();
				
				if(doc_details.size()!=0)
				{
					HttpSession session = request.getSession();
					session.setAttribute("doc_details", doc_details);
					RequestDispatcher rd = request.getRequestDispatcher("admin_view_all_doctor_details.jsp");
					rd.forward(request, response);
				}else{
					request.setAttribute("ErrMsg", "Records are not found");
					RequestDispatcher rd = request.getRequestDispatcher("admin_home.jsp");
					rd.forward(request, response);
				}	
				
			}
		   
		  else{
			request.setAttribute("ErrMsg", "Doctor Not Removed");
			RequestDispatcher rd = request.getRequestDispatcher("admin_home.jsp");
			rd.forward(request, response);
		    }	
		}
		
	

}

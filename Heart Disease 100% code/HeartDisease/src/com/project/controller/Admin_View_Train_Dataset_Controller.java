package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.algo.DataBean;
import com.project.dao.AdminDao;

/**
 * Servlet implementation class Admin_View_Train_Dataset_Controller
 */
@WebServlet("/Admin_View_Train_Dataset_Controller")
public class Admin_View_Train_Dataset_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_View_Train_Dataset_Controller() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		AdminDao dao=new AdminDao();
		
		ArrayList<DataBean> data_list=new ArrayList<DataBean>();
		
		
		data_list=dao.getTrainData();
		
		if(data_list.size()!=0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("data_list", data_list);
			RequestDispatcher rd = request.getRequestDispatcher("admin_view_train_data_details.jsp");
			rd.forward(request, response);
		}else{
			request.setAttribute("ErrMsg", "Records are not found");
			RequestDispatcher rd = request.getRequestDispatcher("admin_home.jsp");
			rd.forward(request, response);
		}	
		
		
	}

}

package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.algo.NaiveBayes;
import com.project.bean.Test_Bean;
import com.project.dao.DoctorDao;
import com.project.service.EmailDemo;

/**
 * Servlet implementation class Test_Patients_Data_Controller
 */
@WebServlet("/Test_Patients_Data_Controller")
public class Test_Patients_Data_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test_Patients_Data_Controller() {
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
		
		String patient_name=request.getParameter("patient_name");
		int age=Integer.parseInt(request.getParameter("age"));
		int sex=Integer.parseInt(request.getParameter("sex"));
		int cp=Integer.parseInt(request.getParameter("cp"));
		int trestbps=Integer.parseInt(request.getParameter("trestbps"));
		int chol=Integer.parseInt(request.getParameter("chol"));
		int fbs=Integer.parseInt(request.getParameter("fbs"));
		int restecg=Integer.parseInt(request.getParameter("restecg"));
		int thalach=Integer.parseInt(request.getParameter("thalach"));
		int exang=Integer.parseInt(request.getParameter("exang"));
		int oldpeak=Integer.parseInt(request.getParameter("oldpeak"));
		int slope=Integer.parseInt(request.getParameter("slope"));
		int ca=Integer.parseInt(request.getParameter("ca"));
		int thal=Integer.parseInt(request.getParameter("thal"));
		int num=Integer.parseInt(request.getParameter("exang"));
		
		System.out.println("patient_name= "+patient_name);
		System.out.println("age= "+age);
		System.out.println("sex= "+sex);
		System.out.println("cp= "+cp);
		System.out.println("trestbps= "+trestbps);
		System.out.println("chol= "+chol);
		System.out.println("fbs= "+fbs);
		System.out.println("restecg= "+restecg);
		System.out.println("thalach= "+thalach);
		System.out.println("exang= "+exang);
		System.out.println("oldpeak= "+oldpeak);
		System.out.println("slope= "+slope);
		System.out.println("ca= "+ca);
		System.out.println("thal= "+thal);
		System.out.println("num= "+num);
		
		Test_Bean bean=new Test_Bean();
		bean.setPatient_name(patient_name);
		bean.setAge(age);
		bean.setSex(sex);
		bean.setCp(cp);
		bean.setTrestbps(trestbps);
		bean.setChol(chol);
		bean.setFbs(fbs);
		bean.setRestecg(restecg);
		bean.setThalach(thalach);
		bean.setExang(exang);
		bean.setOldpeak(oldpeak);
		bean.setSlope(slope);
		bean.setCa(ca);
		bean.setThal(thal);
		bean.setNum(num);
		
		//Apply classification to predict heart disease or not
		NaiveBayes nb=new NaiveBayes();
		nb.classify(bean);
		
		String probability=NaiveBayes.probability;
		String result=NaiveBayes.result;
		
		bean.setProbability(probability);
		bean.setResult(result);
		
		DoctorDao dao=new DoctorDao();
		
		if(dao.insertTestData(bean))
		{
		
		  if(bean.getResult()!=null)
		   {
			HttpSession session=request.getSession();
			session.setAttribute("Test_Bean", bean);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Test Data Success!!See Result!');");
			out.println("location='final_result_details.jsp';");
		 	out.println("</script>");
		   }
		  else
		   {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Test Data Failed!!!');");
			out.println("location='patient_test_details.jsp';");
			out.println("</script>");
		   }
	    }
		else
		 {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Record Inserion Failed!!!');");
			out.println("location='patient_test_details.jsp';");
			out.println("</script>");
		}
	}

}

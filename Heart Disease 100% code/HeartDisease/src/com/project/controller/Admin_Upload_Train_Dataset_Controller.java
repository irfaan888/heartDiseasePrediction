package com.project.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import au.com.bytecode.opencsv.CSVReader;

import com.project.algo.DataBean;
import com.project.dao.AdminDao;

/**
 * Servlet implementation class Admin_Upload_Train_Dataset_Controller
 */
@WebServlet("/Admin_Upload_Train_Dataset_Controller")
@MultipartConfig(maxFileSize=1024*1024*1024)
public class Admin_Upload_Train_Dataset_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Upload_Train_Dataset_Controller() {
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
		
		 Part part=request.getPart("file");
		 
	     String fileName = extractFileName(part);
	     
	     String fileName1="train_dataset.csv";
	     
         System.out.println("Filename==="+fileName);
        
        String savepath="E:/Project_Final/project_workspace/HeartDisease/WebContent/dataset";
        
        File fileSaveDir = new File(savepath);// +"/"+fileName);
        if (!fileSaveDir.exists()) 
        {
            fileSaveDir.mkdirs();
        }
        String datasetPath=fileSaveDir.getAbsolutePath() + File.separator + fileName1;
        part.write(datasetPath);
    
        System.out.println(fileSaveDir.getAbsolutePath());
		//MultipartRequest m=new MultipartRequest(request,"D:/Eclips project/ME projects/Market Prediction/WebContent/upload",1024*1024*50);
       
        String csvFile = savepath+"/train_dataset.csv";
        
       ArrayList<DataBean> dataList =  new ArrayList<DataBean>(); 
       ArrayList<String> dataArray =  new ArrayList<String>(); 
       //openCSV reader to parse the CSV file
       CSVReader reader = new CSVReader(new FileReader(csvFile));
       int i=0;
       //nextLine array contains a an entire row of data,
       //Each element represents a cell in the spreadsheet.
       String[] nextLine;

       //Iterate though the CSV while there are more lines to read
       while((nextLine = reader.readNext()) != null)
       {
    	   if(nextLine[0].startsWith("age")&&nextLine[1].startsWith("sex")){
    		   nextLine[0]=null;
    		   nextLine[1]=null;
    		   nextLine[2]=null;
    		   nextLine[3]=null;
    		   nextLine[4]=null;
    		   nextLine[5]=null;
    		   nextLine[6]=null;
    		   nextLine[7]=null;
    		   nextLine[8]=null;
    		   nextLine[9]=null;
    		   nextLine[10]=null;
    		   nextLine[11]=null;
    		   nextLine[12]=null;
    		   nextLine[13]=null;
    	   }else{
    		   dataArray.clear();
    		      //Iterate through the elements on this line
    		  DataBean bean = new DataBean();
    		  
    		 for(String s : nextLine)
               {
    			  if(s != null && s.length() > 0) 
    			  {
    		     System.out.print("................"); 
               	 dataArray.add(s);
    			  }
               }
    		  
    //public int age, sex, cp, trest_bps, chol, fbs, rest_ecg, thalach, exang, slope, ca, thal, num;
               if(dataArray.size()==14)
               {
               	bean.setAge(Integer.parseInt(dataArray.get(0)));
               	bean.setSex(Integer.parseInt(dataArray.get(1)));
               	bean.setCp(Integer.parseInt(dataArray.get(2)));
               	bean.setTrest_bps(Integer.parseInt(dataArray.get(3)));
               	bean.setChol(Integer.parseInt(dataArray.get(4)));
               	bean.setFbs(Integer.parseInt(dataArray.get(5)));
               	bean.setRest_ecg(Integer.parseInt(dataArray.get(6)));
               	bean.setThalach(Integer.parseInt(dataArray.get(7)));
               	bean.setExang(Integer.parseInt(dataArray.get(8)));
               	bean.setOld_peak(Float.parseFloat(dataArray.get(9)));
               	bean.setSlope(Integer.parseInt(dataArray.get(10)));
               	bean.setCa(Integer.parseInt(dataArray.get(11)));
               	bean.setThal(Integer.parseInt(dataArray.get(12)));
               	bean.setNum(Integer.parseInt(dataArray.get(13)));
               	dataList.add(bean);
               }
    	   }
                 
       }
       reader.close();
       
       if(dataList!=null&&dataList.size()>0)
       {
       	
       	   AdminDao dao=new AdminDao();
       	
       	  if(dao.addData(dataList))
       	   {
       		 
       		System.out.print("Successfully added...");
       	    
       	    HttpSession session = request.getSession();
          	session.setAttribute("dataDetails",dataList);
          	out.println("<script type=\"text/javascript\">");
		    out.println("alert('Upload Success!!!');");
			out.println("location='admin_add_train_dataset.jsp';");
			out.println("</script>");
       	   }
       }
       else
       {
    	    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Upload Failed!!!');");
			out.println("location='admin_add_train_dataset.jsp';");
			out.println("</script>");
       }
          		                            
            
	}	
	private String extractFileName(Part part) 
   {
          String contentDisp = part.getHeader("content-disposition");
          System.out.println("contentDisp:"+contentDisp);
          String[] items = contentDisp.split(";");
          for (String s : items) {
          if (s.trim().startsWith("filename")) 
          {
            return s.substring(s.indexOf("=") + 2, s.length()-1);
          }
    }
          
    return "";
}

}

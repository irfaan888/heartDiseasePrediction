package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.algo.DataBean;
import com.project.bean.Adminbean;
import com.project.bean.RegisterBean;
import com.project.db.DBConnect;

public class AdminDao {
	
	Connection connection=DBConnect.getConnection();
	Boolean resultStatus=Boolean.FALSE;
	PreparedStatement psmt;
	ResultSet rs;
	
	public boolean checkAdmin(Adminbean bean)
	{
		
		try {
			String sql="Select * from tbl_admin where admin_email=? and admin_password=?";
			psmt = connection.prepareStatement(sql);
			
			psmt.setString(1,bean.getEmail());
			psmt.setString(2,bean.getPassword());
			ResultSet rs=psmt.executeQuery();
			resultStatus=rs.next();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	
		return resultStatus;
	}

	public boolean addData(ArrayList<DataBean> dataList) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql1 = "Drop Table If Exists tbl_train_dataset";
		try {
			PreparedStatement pstmt1 = connection.prepareStatement(sql1);
			boolean f1=pstmt1.execute();
			if(f1){
				System.out.println("Deleted....");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql2 = "Create Table If Not Exists tbl_train_dataset(id INT(10) NOT NULL AUTO_INCREMENT,"
				+"age INT(10) NOT NULL,"
				+"sex INT(10) NOT NULL, cp INT(10) NOT NULL,"
				+"trestbps INT(10) NOT NULL, chol INT(10) NOT NULL,"
				+"fbs INT(10) NOT NULL, restecg INT(10) NOT NULL,"
				+"thalach INT(10) NOT NULL, exang INT(10) NOT NULL,"
				+"oldpeak float(10) NOT NULL, slope INT(10) NOT NULL,"
				+"ca float(10) NOT NULL, thal INT(10) NOT NULL,"
				+"num float(10) NOT NULL,"
				+"primary key (id))";
		try {
			PreparedStatement pstmt2 = connection.prepareStatement(sql2);
			boolean f2 = pstmt2.execute();
			if(f2){
				System.out.println("Created.....");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "Insert Into tbl_train_dataset values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int count=0;
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			for(int i=0;i<dataList.size();i++){
				pstmt.setInt(1, 0);
				pstmt.setInt(2, dataList.get(i).getAge());
				pstmt.setInt(3, dataList.get(i).getSex());
				pstmt.setInt(4, dataList.get(i).getCp());
				pstmt.setInt(5, dataList.get(i).getTrest_bps());
				pstmt.setInt(6, dataList.get(i).getChol());
				pstmt.setInt(7, dataList.get(i).getFbs());
				pstmt.setInt(8, dataList.get(i).getRest_ecg());
				pstmt.setInt(9, dataList.get(i).getThalach());
				pstmt.setInt(10, dataList.get(i).getExang());
				pstmt.setFloat(11, dataList.get(i).getOld_peak());
				pstmt.setInt(12, dataList.get(i).getSlope());
				pstmt.setInt(13, dataList.get(i).getCa());
				pstmt.setInt(14, dataList.get(i).getThal());
				pstmt.setInt(15, dataList.get(i).getNum());
				
				int index=pstmt.executeUpdate();
				if(index>0){
					count++;
				}	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count==dataList.size()){
			flag=true;
		}		
		return flag;	
	}
	
	public ArrayList<DataBean> getTrainData() {
		
		ArrayList<DataBean> dataList=new ArrayList<DataBean>();
		
        String sql = "Select * from tbl_train_dataset";
		
		try {
			
			Statement stmt=connection.createStatement();
		
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				DataBean bean=new DataBean();
				
				bean.setAge(rs.getInt(1));
               	bean.setSex(rs.getInt(2));
               	bean.setCp(rs.getInt(3));
               	bean.setTrest_bps(rs.getInt(4));
               	bean.setChol(rs.getInt(5));
               	bean.setFbs(rs.getInt(6));
               	bean.setRest_ecg(rs.getInt(7));
               	bean.setThalach(rs.getInt(8));
               	bean.setExang(rs.getInt(9));
               	bean.setOld_peak(rs.getFloat(10));
               	bean.setSlope(rs.getInt(11));
               	bean.setCa(rs.getInt(12));
               	bean.setThal(rs.getInt(13));
               	bean.setNum(rs.getInt(14));
               	dataList.add(bean);
			}
			
		 } 
		catch (SQLException e) 
		   {
			
			 e.printStackTrace();
		   }
		return dataList;
	
	}
	
	
}

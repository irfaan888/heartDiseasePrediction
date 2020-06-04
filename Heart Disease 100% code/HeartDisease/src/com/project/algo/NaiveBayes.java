package com.project.algo;


import com.project.bean.Test_Bean;

public class NaiveBayes {
	
	/*1st row - age
	2 row  -  male or female (1 - male)
	3 -  chest pain CP
	    cp: chest pain type
	        -- Value 1: typical angina(Chest portion)
	        -- Value 2: atypical angina
	        -- Value 3: non-anginal pain
	        -- Value 4: asymptomatic
	4 - trestbps: resting blood pressure (in mm Hg on admission to the 
	        hospital)
	5 -  chol: serum cholestoral in mg/dl
	6 - fbs: (fasting blood sugar > 120 mg/dl)  (1 = true; 0 = false)
	7 - restecg: resting electrocardiographic results
	        -- Value 0: normal
	        -- Value 1: having ST-T wave abnormality (T wave inversions and/or ST 
	                    elevation or depression of > 0.05 mV)
	        -- Value 2: showing probable or definite left ventricular hypertrophy
	                    by Estes' criteria
	8 - thalach: maximum heart rate achieved
	9 - exang: exercise induced angina (1 = yes; 0 = no)
	10 - oldpeak = ST depression induced by exercise relative to rest
	11 - slope: the slope of the peak exercise ST segment
	        -- Value 1: upsloping
	        -- Value 2: flat
	        -- Value 3: downsloping

	12 - ca: number of major vessels (0-3) colored by flourosopy
	13 - thal: 3 = normal; 6 = fixed defect; 7 = reversable defect
	14 - num: diagnosis of heart disease (angiographic disease status)
	        -- Value 0: < 50% diameter narrowing
	        -- Value 1: > 50% diameter narrowing
	        (in any major vessel: attributes 59 through 68 are vessels)*/

	public String patient_name;
	public int age,Sex,cp,trestbps,chol,fbs,restecg,thalach,exang,oldpeak,slope,ca,thal,num;
	
	public static String probability="";
	public static String result="";
	
	public static int cnt=7;
	public static int pos_cnt=0;
	public static int neg_cnt=0;

	public Test_Bean classify(Test_Bean bean)
	{
		//Test_Bean Test_Bean_result=new Test_Bean();
		
		if(bean.getCp()> 1 && bean.getCp()<= 4)
		{
			probability="POSITIVE";
			pos_cnt++;
			// Because of maximum no. of attritutes are positive related 
		}
		else if(bean.getFbs()> 0)
		{
			probability="POSITIVE";
			pos_cnt++; 
		}
		else if(bean.getRestecg()> 0 && bean.getRestecg()<= 2)
		{
			probability="POSITIVE";
			pos_cnt++; 
		}
		else if(bean.getExang()> 1)
		{
			probability="POSITIVE";
			pos_cnt++; 
		}
		else if(bean.getSlope()> 1 && bean.getSlope() <= 3)
		{
			probability="POSITIVE";
			pos_cnt++; 
		}
		else if(bean.getCa()> 0 && bean.getCa() <= 3)
		{
			probability="POSITIVE";
			pos_cnt++;  
		}
		else if(bean.getThal()> 3 && bean.getCa() <= 7)
		{
			probability="POSITIVE";
			pos_cnt++;  
		}
		else
		{
			probability="NEGATIVE";
			neg_cnt++;
			// Because of maximum no. of attritutes are negative related
		}
		
		// Checking total pos and negative cnt and probability
		
		if(pos_cnt>neg_cnt)
		{
			if(probability.equalsIgnoreCase("POSITIVE"))
			{
				probability="POSITIVE";
				result="POSITIVE";
			}
		}
		else
		{
			probability="NEGATIVE";
			result="NEGATIVE";
		}
		
		return bean;
	}
}

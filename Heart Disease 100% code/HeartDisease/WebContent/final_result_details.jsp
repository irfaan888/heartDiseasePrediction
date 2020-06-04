<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.project.bean.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Heart Disease Prediction | Final Result</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/animate.css">
	<link href="css/prettyPhoto.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet" />	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <![endif]-->
	  <!-- Bootstrap core CSS -->
  <!--  <link href="css1/bootstrap.css" rel="stylesheet"> -->
    <!--external css-->
    <link href="css1/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="css1/style.css" rel="stylesheet">
    <link href="css1/style-responsive.css" rel="stylesheet">
 <%
       response.setHeader("Cache-Control", "no-cache, no-store");
       response.setHeader("Pragma", "no-cache");
       response.setHeader("Expires","0");
     
       String uemail=(String)session.getAttribute("email");
       if(uemail!=null)
        {
   %>
  <%
}
else
{
  response.sendRedirect("doctor_login.jsp");	
}
%>
	 
  </head>
  <body>
	<header>		
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="navigation">
				<div class="container">					
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse.collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<div class="navbar-brand">
							<a href="index.jsp"><h1><span>Heart Disease </span>Prediction </h1></a>
						</div>
					</div>
					
					<div class="navbar-collapse collapse">							
						<div class="menu">
							<ul class="nav nav-tabs" role="tablist">
								<li role="presentation"><a href="doctor_home.jsp" >Home</a></li>
								<li role="presentation"><a href="doctor_add_patient_test_details.jsp" >AddDetails</a></li>								
								<li role="presentation"><a href="LogoutServlet">LogOut</a></li>						
							</ul>
						</div>
					</div>						
				</div>
			</div>	
		</nav>		
	</header>
		
	<div id="breadcrumb">
		<div class="container">	
			<div class="breadcrumb">							
				<li><a href="index.jsp"></a></li>
						
			</div>		
		</div>	
	</div>
	
	<section id="main-slider" class="no-margin">
        <div class="carousel slide">      
            <div class="carousel-inner">
                <div class="item active" >
                    <div class="container">
	<div class="login-wrap">
	<div class="row">
      <div class="col-md-12">
     
              <h2 align="center" style="color:maroon;font:bold;">REPORT</h2>
              <br>
              <br>
       <div class="col-md-2"></div>
                 <%
                   Test_Bean bean=new Test_Bean();
            	   bean=(Test_Bean)session.getAttribute("Test_Bean");
                %>
                
       <h3 style="color: black; " align="center">PATIENT NAME: <%=bean.getPatient_name() %></h3>
       <br>
       <h3 style="color: purple;" align="center">FINAL RESULT: <%=bean.getResult() %></h3>
       <br>   
       <h3 style="color: black;" align="center">SEE PATIENT'S TEST RESULT BELOW:</h3>
       <br>      
      <table border="2" align="center" class="col-md-12" >
      <thead>
	  <tr><th style="width: 20px" class="text-center">PATIENT AGE</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getAge()%></th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT SEX</th><th style="width: 50px; color: green;" class="text-center">
	  <%
	  String sex="";
	  int s=bean.getSex();
	  if(s==1)
	  {
		  sex="Male"; 
	  }
	  else
	  {
		  sex="Female";
	  }
	  
	  %>
	  <%=sex %>
	  </th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT CP</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getCp()%></th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT THRESTBPS</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getTrestbps()%></th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT CHOL</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getChol()%></th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT FBS</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getFbs()%></th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT RESTECG</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getRestecg()%></th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT THALACH</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getThalach()%></th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT EXANG</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getExang()%></th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT OLDPEAK</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getOldpeak()%></th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT SLOPE</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getSlope()%></th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT CA</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getCa()%></th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT THAL</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getThal()%></th></tr>
	  <tr><th style="width: 20px" class="text-center">PATIENT NUM</th><th style="width: 50px; color: green;" class="text-center"><%=bean.getNum()%></th></tr>
     </thead>
    </table>
    </div>

  </div>
	  	</div>

                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                
                            </div>

                    </div>
                </div><!--/.item-->             
            </div><!--/.carousel-inner-->
        </div><!--/.carousel-->
    </section><!--/#main-slider-->
	
	
	<footer>
		<div class="footer">
			<div class="container">
				<div class="social-icon">
					<div class="col-md-4">
						<ul class="social-network">
							<li><a href="#" class="fb tool-tip" title="Facebook"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#" class="twitter tool-tip" title="Twitter"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#" class="gplus tool-tip" title="Google Plus"><i class="fa fa-google-plus"></i></a></li>
							<li><a href="#" class="linkedin tool-tip" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
							<li><a href="#" class="ytube tool-tip" title="You Tube"><i class="fa fa-youtube-play"></i></a></li>
						</ul>	
					</div>
				</div>
				
				<div class="col-md-4 col-md-offset-4">
					<div class="copyright">
					&copy; 2018 by <a target="_blank" href="#" >Heart Disease Prediction</a>. All Rights Reserved.
						</div>
                  
				</div>						
			</div>
			
			<div class="pull-right">
				<a href="#home" class="scrollup"><i class="fa fa-angle-up fa-3x"></i></a>
			</div>		
		</div>
	</footer>


	
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-2.1.1.min.js"></script>	
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/jquery.isotope.min.js"></script>  
	<script src="js/wow.min.js"></script>
	<script src="js/functions.js"></script>
	
  </body>
</html>
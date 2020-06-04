<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Heart Disease Prediction | DoctorRegister</title>

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
                        <div class="row slide-margin">
                            <div class="col-sm-4">
                                
								
	  <div id="login-page" >
	  	<div class="container" >
	  	
		      <form class="form-login" action="Test_Patients_Data_Controller" method="post">
		        <h1 class="form-login-heading" style="margin: 0;
	padding: 25px 20px;
	width: 420px;
	text-align: center;
	background: #32CD32;
	border-radius: 5px 5px 0 0;
	-webkit-border-radius: 5px 5px 0 0;
	color: #fff;
	font-size: 20px;
	text-transform: uppercase;
	font-weight: 300;">ADD TEST RESULT</h1>
		  <div class="login-wrap" style="width: 430px;">
		      
		   
		       <p style="color: red"><font size="2">${message}</font></p>
		       <div class="input-group">
		            <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Patient Name</span>
		        	 <input type="text" name="patient_name" class="form-control" placeholder="Patient_name" autofocus="autofocus" required pattern="[A-Za-z ]{1,50}"/>
                        
		       </div>
		        <br>
		        
		       <div class="input-group">
		            <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Patient Age</span>
		        	 <input type="number" name="age" class="form-control" placeholder="Patient_age" autofocus="autofocus" required/>
		       </div>
		        <br>
		      
		       <div class="input-group">
			    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Sex</span>
                  <select name="sex"  class="form-control" required>
                  <option value="1">Male</option>
                  <option value="0">Female</option>
                  </select>
               </div>
               <br>
		        
		        <div class="input-group">
			    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Chest Pain(cp)</span>
                  <select name="cp"  class="form-control" required>
                  <option value="1">1 (typical angina(Chest portion))</option>
                  <option value="2">2 (atypical angina)</option>
                  <option value="3">3 (non-anginal pain)</option>
                  <option value="4">4 (asymptomatic)</option>
                  </select>
               </div>
               <br>
		        
		       <div class="input-group">
		            <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i>Resting Blood Press.(trestbps)</span>
		            <input type="number" name="trestbps" class="form-control" placeholder="Resting blood pressure" autofocus="autofocus"  required/>
		       </div>
		        <br>
		        
		       <div class="input-group">
		            <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i>Serum Cholestoral(chol)</span>
		            <input type="number" name="chol" class="form-control" placeholder="Serum Cholestoral" autofocus="autofocus"  required/>
		       </div>
		        <br>
		        		        
		       <div class="input-group">
			    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Fasting Blood Sugar(fbs)</span>
                  <select name="fbs"  class="form-control" required>
                  <option value="1">1 (true)</option>
                  <option value="0">0 (false)</option>
                  </select>
               </div>
               <br>
               
               <div class="input-group">
			    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Resting Electroc. Results(restecg)</span>
                  <select name="restecg"  class="form-control" required>
                  <option value="0">0 (normal)</option>
                  <option value="1">1 (having ST-T wave abnormality (T wave inversions and/or ST 
	                    elevation or depression of > 0.05 mV))</option>
                  <option value="2">2 (showing probable or definite left ventricular hypertrophy
	                    by Estes' criteria)</option>
                  </select>
               </div>
               <br>
               
               <div class="input-group">
		            <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i>Max Heart Rate Achieved(thalach)</span>
		            <input type="number" name="thalach" class="form-control" placeholder="Maximum Heart Rate Achieved" autofocus="autofocus"  required/>
		       </div>
		        <br>
		        
		        <div class="input-group">
			    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Exer.Induced Angina(exang) </span>
                  <select name="exang"  class="form-control" required>
                  <option value="1">1 (yes)</option>
                  <option value="0">0 (no)</option>
                  </select>
               </div>
               <br>
               
               <div class="input-group">
		            <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i>Oldpeak </span>
		            <input type="number" name="oldpeak" class="form-control" placeholder="Oldpeak" autofocus="autofocus"  required/>
		       </div>
		        <br>
		        
		       <div class="input-group">
			    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Slope</span>
                  <select name="slope"  class="form-control" required>
                  <option value="1">1 (upsloping)</option>
                  <option value="2">2 (flat)</option>
                  <option value="3">3 (downsloping)</option>
                  </select>
               </div>
               <br>
               
               <div class="input-group">
		         <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>CA</span>
                  <select name="ca"  class="form-control" required>
                   <option value="0">0 (colored by flourosopy)</option>
                   <option value="1">1 (colored by flourosopy)</option>
                   <option value="2">2 (colored by flourosopy)</option>
                   <option value="3">3 (colored by flourosopy)</option>
                  </select>
		       </div>
		        <br>
		        
		        <div class="input-group">
		           <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Thal</span>
                   <select name="thal"  class="form-control" required>
                   <option value="3">3 (normal)</option>
                   <option value="6">6 (fixed defect)</option>
                   <option value="7">7 (reversable defect)</option>
                  </select>
		       </div>
		        <br>
		        
		        <div class="input-group">
			    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Diagn. of Heart Disease(num) </span>
                  <select name="num"  class="form-control" required>
                  <option value="1">1 (< 50% diameter narrowing)</option>
                  <option value="0">0 (> 50% diameter narrowing)</option>
                  </select>
               </div>
               <br>
               
		        <div class="modal-footer">
		              <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
		              <button class="btn btn-theme" type="submit">Check</button>
		         </div>
		         
		     </div>
		         		
		      </form>	  	
	  	
	  	</div>
	  </div>

						
                            </div>

                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                
                            </div>

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
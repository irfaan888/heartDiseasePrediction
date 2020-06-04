<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.project.bean.RegisterBean" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Heart Disease Prediction | AdminHome</title>

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
                                 
       String adminemail=(String)session.getAttribute("adminemail");
       if(adminemail!=null && adminemail!="")
        {
   %>
  <%
}
else
{
  response.sendRedirect("adminlogin.jsp");	
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
								<li role="presentation"><a href="admin_home.jsp" >Home</a></li>	
								<li role="presentation"><a href="admin_add_train_dataset.jsp">UploadDataset</a></li>	
								<li role="presentation"><a href="Admin_View_Train_Dataset_Controller">ViewDataset</a></li>	
								<li role="presentation"><a href="Admin_View_All_Doctors_Details_Controller">AllDoctors</a></li>							
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
     
              <h3 align="center" style="color:maroon;font:bold;">DOCTOR DETAILS</h3>
              <br>
              <br>
     <div class="col-md-2"></div>
     
      <table border="2"  align="center" class="col-md-12" >
      <thead>
      
	  <tr >
		<th style="width: 50px" class="text-center"> DOCTOR ID</th>
		<th style="width: 70px" class="text-center"> DOCTOR NAME</th>
		<th style="width: 70px" class="text-center"> DOCTOR ADDRESS</th>
		<th style="width: 70px" class="text-center"> DOCTOR EMAIL</th>
		<th style="width: 70px" class="text-center"> DOCTOR MOB</th>
	    <th style="width: 70px" class="text-center"> DELETE</th>
	  </tr>
     </thead>
     <tbody>
               <%
            	   ArrayList<RegisterBean> details=new ArrayList<RegisterBean>();
            	   details=(ArrayList)session.getAttribute("doc_details");
            	   
            	   RegisterBean bean;
            	   
                for(int i=0;i<details.size();i++)
                {
                	bean=details.get(i);	
                %>
              <tr>
		         <td style="color:green" align="center"><%=bean.getUid() %></td>
		         <td style="color:green" align="center"><%=bean.getUname() %></td>
		         <td style="color:green" align="center"><%=bean.getUaddress() %></td>
		         <td style="color:green" align="center"><%=bean.getUemail() %></td>
		         <td style="color:green" align="center"><%=bean.getUmobno() %></td>
		         <td align="center"><a onclick="deleteRecord(<%=bean.getUid()%>);">Delete</a></td>
		      </tr>   
              
             <%
                }
              
              %>  
     </tbody> 
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
	
<script type="text/javascript">
	
	function deleteRecord(id)
	{
	  var doIt=confirm('Do you want to delete the record?');
	  
	  if(doIt==true)
	  {
		  document.location.href="DeleteDoctorController?doctorid="+id;
	  }
	  else
	  {
          alert("Record Not Deleted!!!")
	  }
	}
</script>

  </body>
</html>
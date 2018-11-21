<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


  <head>

    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>User Login Page</title>
	
    <!-- Bootstrap core CSS -->
    <link href="JSP/vendor/bootstrap/css/bootstrap.min1.css" rel="stylesheet">
	<link href="../vendor/bootstrap/css/bootstrap.min1.css" rel="stylesheet">
    <!-- Custom fonts for this template -->
    <link href="JSP/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="JSP/css/landing-page.css" rel="stylesheet">
	<link href="../css/landing-page.css" rel="stylesheet">
  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">For Ease of Evaluation</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Header -->
    <header class="intro-header">
      <div class="container">
      	
        <div class="intro-message">
        <font  color="Yellow"><s:property value="error"/> </font>	
          <h1>Performance Evaluation System</h1>
          <h3>Login as per your designation or <s:a action="gotoRegister">Register</s:a></h3>
          <hr class="intro-divider">
          <ul class="list-inline intro-social-buttons">
            <li class="list-inline-item">
             <s:url action="MainPageAction.action" var = "admin">
             	<s:param name="designation">ADMIN</s:param>
             </s:url>   
             <s:url action="MainPageAction.action" var = "teacher">
             	<s:param name="designation">TEACHER</s:param>
             </s:url>  
             <s:url action="MainPageAction.action" var = "student">
             	<s:param name="designation">STUDENT</s:param>
             </s:url>  
              <s:a href="%{admin}" cssClass="btn btn-secondary btn-lg" >              	           	    
                <i class="fa fa-github fa-fw"></i>
                <span class="network-name">Admin</span>
              </s:a>
              
            </li>
            <li class="list-inline-item">
              <s:a href="%{teacher}" cssClass="btn btn-secondary btn-lg">              	  
                <i class="fa fa-github fa-fw"></i>
                <span class="network-name">Teacher</span>
              </s:a>
            </li>
            <li class="list-inline-item">
              <s:a href="%{student}" cssClass="btn btn-secondary btn-lg">              	  
                <i class="fa fa-github fa-fw"></i>
                <span class="network-name">Student</span>
              </s:a>
            </li>
          </ul>
        </div>
      </div>
    </header>

    <!-- Footer -->
    <footer>
      <div class="container">
        <ul class="list-inline">
          <li class="list-inline-item">
            <a href="#">Home</a>
          </li>
          <li class="footer-menu-divider list-inline-item">&sdot;</li>
          <li class="list-inline-item">
            <a href="#about">About</a>
          </li>
          <li class="footer-menu-divider list-inline-item">&sdot;</li>
          <li class="list-inline-item">
            <a href="#services">Services</a>
          </li>
          <li class="footer-menu-divider list-inline-item">&sdot;</li>
          <li class="list-inline-item">
            <a href="#contact">Contact</a>
          </li>
        </ul>
        <p class="copyright text-muted small">Copyright &copy; Your Company 2017. All Rights Reserved</p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="JSP/vendor/jquery/jquery.min.js"></script>
    <script src="JSP/vendor/popper/popper.min.js"></script>
    <script src="JSP/vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>



</html>
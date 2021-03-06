<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="en">


<head>


    <meta charset="utf-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">

    <meta name="author" content="">


    <title>Register User</title>


    <!-- Bootstrap Core CSS -->

    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="JSP/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->

    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
	<link href="JSP/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->

    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">
	<link href="JSP/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->

    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="JSP/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

    <!--[if lt IE 9]>

        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>

        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->


</head>


<body>


    <div class="container">

        <div class="row">

            <div class="col-md-4 col-md-offset-4">

                <div class="login-panel panel panel-default">

                    <div class="panel-heading">

                        <h3 class="panel-title">Please Register</h3>

                    </div>

                    <div class="panel-body">
                    	<font color="red"><s:property value="error"/></font>
						<s:form action="register">
							<s:div cssClass="form-group">
								<s:label value="Name"></s:label>
								<s:textfield label="Name" name="name"  cssClass="form-control"  ></s:textfield>
							</s:div>
							<s:div cssClass="form-group">
								<s:label value="Password" ></s:label>
								<s:password label="Password" name="password" cssClass="form-control"></s:password>
							</s:div>
							<s:label value="Designation"></s:label>
							<s:select  cssClass="form-control"  list="{'ADMIN','TEACHER','STUDENT'}" name="designation">
                                	
                            </s:select>
                            
                            
                            <s:submit cssClass="btn btn-lg btn-success btn-block" value="Register"></s:submit>
						</s:form>
                        
                    </div>

                </div>

            </div>

        </div>

    </div>


    <!-- jQuery -->

    <script src="../vendor/jquery/jquery.min.js"></script>


    <!-- Bootstrap Core JavaScript -->

    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>


    <!-- Metis Menu Plugin JavaScript -->

    <script src="../vendor/metisMenu/metisMenu.min.js"></script>


    <!-- Custom Theme JavaScript -->

    <script src="../dist/js/sb-admin-2.js">
</script>


</body>


</html>


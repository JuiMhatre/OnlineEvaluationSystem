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


    <title>TeacherHomePage</title>


    <!-- Bootstrap Core CSS -->

    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="JSP/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->

    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
	<link href="JSP/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->

    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">
	<link href="JSP/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->

    <link href="../vendor/morrisjs/morris.css" rel="stylesheet">
	<link href="JSP/vendor/morrisjs/morris.css" rel="stylesheet">

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


    <div id="wrapper">


        <!-- Navigation -->

        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

            <div class="navbar-header">

                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">

                    <span class="sr-only">Toggle navigation</span>

                    <span class="icon-bar"></span>

                    <span class="icon-bar"></span>

                    <span class="icon-bar"></span>

                </button>

                <a class="navbar-brand" href="index.html">Welcome <s:property value="#session.user.name"/></a>

            </div>

            <!-- /.navbar-header -->


            <ul class="nav navbar-top-links navbar-right">

                <li class="dropdown">

                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">

                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>

                    </a>

                    <ul class="dropdown-menu dropdown-messages">

                        <li>

                            <a href="#">

                                <div>

                                    <strong>Hitakshi Raut</strong>

                                    <span class="pull-right text-muted">

                                        <em>Yesterday</em>

                                    </span>

                                </div>

                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>

                            </a>

                        </li>

                        <li class="divider"></li>

                        <li>

                            <a href="#">

                                <div>

                                    <strong>Jui Mhatre</strong>

                                    <span class="pull-right text-muted">

                                        <em>Yesterday</em>

                                    </span>

                                </div>

                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>

                            </a>

                        </li>

                        <li class="divider"></li>

                        <li>

                            <a href="#">

                                <div>

                                    <strong>Shweta Malvade</strong>

                                    <span class="pull-right text-muted">

                                        <em>Yesterday</em>

                                    </span>

                                </div>

                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>

                            </a>

                        </li>

                        <li class="divider"></li>

                        <li>

                            <a class="text-center" href="#">

                                <strong>Read All Messages</strong>

                                <i class="fa fa-angle-right"></i>

                            </a>

                        </li>

                    </ul>

                    <!-- /.dropdown-messages -->

                </li>

                <!-- /.dropdown -->

                <li class="dropdown">

                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">

                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>

                    </a>

                    <ul class="dropdown-menu dropdown-tasks">

                        <li>

                            <a href="#">

                                <div>

                                    <p>

                                        <strong>Task 1</strong>

                                        <span class="pull-right text-muted">40% Complete</span>

                                    </p>

                                    <div class="progress progress-striped active">

                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">

                                            <span class="sr-only">40% Complete (success)</span>

                                        </div>

                                    </div>

                                </div>

                            </a>

                        </li>

                        <li class="divider"></li>

                        <li>

                            <a href="#">

                                <div>

                                    <p>

                                        <strong>Task 2</strong>

                                        <span class="pull-right text-muted">20% Complete</span>

                                    </p>

                                    <div class="progress progress-striped active">

                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">

                                            <span class="sr-only">20% Complete</span>

                                        </div>

                                    </div>

                                </div>

                            </a>

                        </li>

                        <li class="divider"></li>

                        <li>

                            <a href="#">

                                <div>

                                    <p>

                                        <strong>Task 3</strong>

                                        <span class="pull-right text-muted">60% Complete</span>

                                    </p>

                                    <div class="progress progress-striped active">

                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">

                                            <span class="sr-only">60% Complete (warning)</span>

                                        </div>

                                    </div>

                                </div>

                            </a>

                        </li>

                        <li class="divider"></li>

                        <li>

                            <a href="#">

                                <div>

                                    <p>

                                        <strong>Task 4</strong>

                                        <span class="pull-right text-muted">80% Complete</span>

                                    </p>

                                    <div class="progress progress-striped active">

                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">

                                            <span class="sr-only">80% Complete (danger)</span>

                                        </div>

                                    </div>

                                </div>

                            </a>

                        </li>

                        <li class="divider"></li>

                        <li>

                            <a class="text-center" href="#">

                                <strong>See All Tasks</strong>

                                <i class="fa fa-angle-right"></i>

                            </a>

                        </li>

                    </ul>

                    <!-- /.dropdown-tasks -->

                </li>

                <!-- /.dropdown -->

                <li class="dropdown">

                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">

                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>

                    </a>

                    <ul class="dropdown-menu dropdown-alerts">

                        <li>

                            <a href="#">

                                <div>

                                    <i class="fa fa-comment fa-fw"></i> New Comment

                                    <span class="pull-right text-muted small">4 minutes ago</span>

                                </div>

                            </a>

                        </li>

                        <li class="divider"></li>

                        <li>

                            <a href="#">

                                <div>

                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers

                                    <span class="pull-right text-muted small">12 minutes ago</span>

                                </div>

                            </a>

                        </li>

                        <li class="divider"></li>

                        <li>

                            <a href="#">

                                <div>

                                    <i class="fa fa-envelope fa-fw"></i> Message Sent

                                    <span class="pull-right text-muted small">4 minutes ago</span>

                                </div>

                            </a>

                        </li>

                        <li class="divider"></li>

                        <li>

                            <a href="#">

                                <div>

                                    <i class="fa fa-tasks fa-fw"></i> New Task

                                    <span class="pull-right text-muted small">4 minutes ago</span>

                                </div>

                            </a>

                        </li>

                        <li class="divider"></li>

                        <li>

                            <a href="#">

                                <div>

                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted

                                    <span class="pull-right text-muted small">4 minutes ago</span>

                                </div>

                            </a>

                        </li>

                        <li class="divider"></li>

                        <li>

                            <a class="text-center" href="#">

                                <strong>See All Alerts</strong>

                                <i class="fa fa-angle-right"></i>

                            </a>

                        </li>

                    </ul>

                    <!-- /.dropdown-alerts -->

                </li>

                <!-- /.dropdown -->

                <li class="dropdown">

                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">

                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>

                    </a>

                    <ul class="dropdown-menu dropdown-user">

                        <li><a href="#"><i class="fa fa-user fa-fw"></i> <s:property value="#session.user.name"/> Profile</a>

                        </li>

                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>

                        </li>

                        <li class="divider"></li>

                        <li><s:a action="logout">  <i class="fa fa-sign-out fa-fw"></i> Logout</s:a>

                        </li>

                    </ul>

                    <!-- /.dropdown-user -->

                </li>

                <!-- /.dropdown -->

            </ul>

            <!-- /.navbar-top-links -->


            <div class="navbar-default sidebar" role="navigation">

                <div class="sidebar-nav navbar-collapse">

                    <ul class="nav" id="side-menu">

                        <li class="sidebar-search">

                            <div class="input-group custom-search-form">

                                <input type="text" class="form-control" placeholder="Search...">

                                <span class="input-group-btn">

                                <button class="btn btn-default" type="button">

                                    <i class="fa fa-search"></i>

                                </button>

                            </span>

                            </div>

                            <!-- /input-group -->

                        </li>

                        <li>

                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>

                        </li>

                       </ul>

                </div>

                <!-- /.sidebar-collapse -->

            </div>

            <!-- /.navbar-static-side -->

        </nav>


        <div id="page-wrapper">

            <div class="row">

                <div class="col-lg-12">

                    <h1 class="page-header"><s:property value="#session.user.name"/> -Teacher HomePage</h1>

                </div>

                <!-- /.col-lg-12 -->

            </div>

            <!-- /.row -->

            <div class="row">
            	<div class="col-lg-3 col-md-6">

                    <div class="panel panel-yellow">

                        <div class="panel-heading">

                            <div class="row">

                                <div class="col-xs-3">

                                    <i class="fa fa-copy fa-5x"></i>

                                </div>

                                <div class="col-xs-9 text-right">

                                    <div class="huge">13</div>

                                    <div>Subject Notes</div>

                                </div>

                            </div>

                        </div>

                        <a href="#">

                            <div class="panel-footer">

                                <span class="pull-left">Upload Here</span>

                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

                                <div class="clearfix"></div>

                            </div>

                        </a>

                    </div>

                </div>
		<div class="col-lg-3 col-md-6">

                    <div class="panel panel-red">

                        <div class="panel-heading">

                            <div class="row">

                                <div class="col-xs-3">

                                    <i class="fa fa-question-circle fa-5x"></i>

                                </div>

                                <div class="col-xs-9 text-right">

                                    <div class="huge">2</div>

                                    <div>Upload New Assignements</div>

                                </div>

                            </div>

                        </div>

                        <a href="#">

                            <div class="panel-footer">

                                <span class="pull-left">New Questions uploaded</span>

                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

                                <div class="clearfix"></div>

                            </div>

                        </a>

                    </div>

                </div>

		
<div class="col-lg-3 col-md-6">

                    <div class="panel panel-green">

                        <div class="panel-heading">

                            <div class="row">

                                <div class="col-xs-3">

                                    <i class="fa fa-tasks fa-5x"></i>

                                </div>

                                <div class="col-xs-9 text-right">

                                    <div class="huge">12</div>

                                    <div>Submitted Assignments</div>

                                </div>

                            </div>

                        </div>

                        <a href="#">

                            <div class="panel-footer">

                                <span class="pull-left">Check here</span>

                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

                                <div class="clearfix"></div>

                            </div>

                        </a>

                    </div>

                </div>

                <div class="col-lg-3 col-md-6">

                    <div class="panel panel-primary">

                        <div class="panel-heading">

                            <div class="row">

                                <div class="col-xs-3">

                                    <i class="fa fa-check-circle fa-5x"></i>

                                </div>

                                <div class="col-xs-9 text-right">

                                    <div class="huge">25</div>

                                    <div>Display Results Here</div>

                                </div>

                            </div>

                        </div>

                        <a href="#">

                            <div class="panel-footer">

                                <span class="pull-left">View Results</span>

                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

                                <div class="clearfix"></div>

                            </div>

                        </a>

                    </div>

                </div>

	    </div>

            <!-- /.row -->
<center><h3><strong><font color="red"><s:property value="error"/></font></strong></h3></center>

	<div class = "row">
	
		<div class="col-lg-4">

                    <div class="panel panel-default">

                        <div class="panel-heading">

                            <i class="fa fa-question-circle   fa-fw"></i> Upload Study Notes

                        </div>

                        <!-- /.panel-heading -->

                        <div class="panel-body">

                            <div class="list-group">
							
								<s:form action="notesUploadtemp"  method="post" enctype="multipart/form-data">
									<s:div cssClass="form-group">
										<s:label for="fileUpload" value="Upload Notes Here"></s:label>
										<s:file name="fileUpload"></s:file>
									</s:div>
									<s:submit value="Submit"></s:submit>
								</s:form>
                            	
                            </div>

                            <!-- /.list-group -->

                        </div>

                        <!-- /.panel-body -->

                    </div>

                    <!-- /.panel -->

                </div>
	

		<div class="col-lg-4">

                    <div class="panel panel-default">

                        <div class="panel-heading">

                            <i class="fa fa-question-circle   fa-fw"></i> Upload New Assignment

                        </div>

                        <!-- /.panel-heading -->

                        <div class="panel-body">

                            <div class="list-group">
							
                            	<s:form action="assignmentUpload"  method="post" enctype="multipart/form-data">
									
									<s:div cssClass="form-group">
										<s:label  for="fileUpload" value="Upload Questions Here"></s:label>
										<s:file name="fileUpload"></s:file>
										
									</s:div>
									
									
									
									<s:submit value="Submit"></s:submit>
								</s:form>
                           </div>

                            <!-- /.list-group -->

                            

                        </div>

                        <!-- /.panel-body -->

                    </div>

                    <!-- /.panel -->

                </div>
	</div>
        

        <div class ="row">

           <div class="col-lg-6">

           	<div class="panel panel-default">

                    <div class="panel-heading">

                       <i class="fa fa-copy fa-fw"></i>Check Assignments
                     </div>

					<s:form action="checkassignment">
						<s:label value="Select Assignment"></s:label>
						<s:select list="%{assignmentslist}" listKey="assignmentid" listValue="questionarename"  name="assignmentid">
						</s:select>
						<s:label value="Select Student Whose Assignment Is To Be Checked"></s:label>
						<s:select list="%{studentslist}" listKey="userid" listValue="name" name="userid"  >
						</s:select>
						<br/>
						<s:submit value="Download"></s:submit>
					</s:form>
			
                </div>

           	<div class="panel panel-default">

                    <div class="panel-heading">
                       <i class="fa fa-copy fa-fw"></i>Give Marks To Students
                     </div>
					<br/>
					<s:form action="markssubmit">	
						<s:label value="Select Assignment"></s:label>
						<s:select list="%{assignmentslist}" listKey="assignmentid" listValue="questionarename"  name="assignmentid">
						</s:select>
						<s:label value="Select Student Who Is To Be Evaluated"></s:label>
						<s:select list="%{studentslist}" listKey="userid" listValue="name" name="userid"  >
						</s:select>					
						<s:label value="Marks Obtained"></s:label>
						<s:textfield name="marksobtained"></s:textfield>
						<s:submit value="Give Marks"></s:submit>
					</s:form>


                </div>



           </div>

           <!-- /.col-lg-6 (nested) -->

        </div>

        <div class ="row">

            
            </div>

	    <div class="row">
            
    <!-- /.col-lg-6 -->

                <div class="col-lg-6">

                    <div class="panel panel-default">

                        <div class="panel-heading">

                            Previous Study Notes

                        </div>

                        <!-- /.panel-heading -->

                        <div class="panel-body">

                            <div class="table-responsive">

                                <table class="table">

                                    <thead>

                                        <tr>

                                            <th>#</th>

					    <th>Chapter Name</th>

                                            <th></th>

                                        </tr>

                                    </thead>

                                    <tbody>
<tr class="info">

                                            <td>1</td>

                                           
 											<td><s:property value="subjectname"/>   </td>

                                            <td>
											<s:form action="downloadNotes">
                                            <s:a  target="_blank" href="%{downloadname}" ><s:submit value=""></s:submit> </s:a>
											</s:form>
                                            </td>

                                        </tr>

                                    </tbody>

                                </table>

                            </div>

                            <!-- /.table-responsive -->

                        </div>

                        <!-- /.panel-body -->

                    </div>

                    <!-- /.panel -->

                </div>

                <!-- /.col-lg-6 -->

            </div>

        </div>

        <!-- /#page-wrapper -->


    </div>

    <!-- /#wrapper -->


    <!-- jQuery -->

    <script src="../vendor/jquery/jquery.min.js"></script>
	<script src="JSP/vendor/jquery/jquery.min.js"></script>
	<s:hidden value="%{downloadname}" id="path"></s:hidden>
	<script type="text/javascript">
	
	function run()
	{
		var path= document.getElementById('path');	
		window.open(path);
	}
	
	</script>
	<!-- Bootstrap Core JavaScript -->

    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="JSP/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->

    <script src="../vendor/metisMenu/metisMenu.min.js"></script>
	<script src="JSP/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->

    <script src="../vendor/raphael/raphael.min.js"></script>
	<script src="JSP/vendor/raphael/raphael.min.js"></script>
    <script src="../vendor/morrisjs/morris.min.js"></script>
	<script src="JSP/vendor/morrisjs/morris.min.js"></script>
    <script src="../data/morris-data.js"></script>
	<script src="JSP/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->

    <script src="../dist/js/sb-admin-2.js">
    <script src="JSP/dist/js/sb-admin-2.js">
</script>


</body>


</html>

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


    <title>AdminHomePage</title>


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

                <a class="navbar-brand" href="index.html"><s:property value="#session.user.name"/>'s HomePage</a>

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

                        <li><a href="#"><i class="fa fa-user fa-fw"></i><s:property value="#session.user.name"/> Profile</a>

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

                    <h1 class="page-header"><s:property value="#session.user.name"/>- Admin's HomePage</h1>

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

                                    <div class="huge">45</div>

                                    <div>Manage Teachers/Students</div>

                                </div>

                            </div>

                        </div>

                        <a href="#">

                            <div class="panel-footer">

                                <span class="pull-left">Manage Here</span>

                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

                                <div class="clearfix"></div>

                            </div>

                        </a>

                    </div>

                </div>
	    </div>

            <!-- /.row -->
<!-- Teacher starts here -->

	<div class = "row">
		<div class="col-lg-6">

                    <div class="panel panel-default">

                        <div class="panel-heading">

                            <i class="fa fa-question-circle   fa-fw"></i> Manage Teacher

                        </div>

                        <!-- /.panel-heading -->

                        <div class="panel-body">

                            <div class="list-group">

								<s:form action="addTeacherSubject">
									<s:div cssClass="form-group">
										<s:label value="Select Teacher "></s:label>
										<s:select  cssClass="form-control" headerValue="--select--" list="teacherswithnosubj" listValue="name" listKey="userid" name="userid" >
                                	
                            			</s:select>
                            		</s:div>
                            		<s:div cssClass="form-group">
										<s:label value="Select Subject"></s:label>
										<s:select  cssClass="form-control"  list="subjectslist"  listValue="subjectname" listKey="subjectname" headerValue="--select--"  name="subjectname">
                                	
                            			</s:select>
                            		</s:div>
                            		<s:div cssClass="form-group">                   
                            		<s:submit cssClass="btn btn-primary" value="Add"></s:submit>
									</s:div>
									
								
								</s:form>

                            </div>

                            <!-- /.list-group -->

                        </div>

                        <!-- /.panel-body -->

                    </div>

                    <!-- /.panel -->

                </div>

<!-- Student starts here -->

        <div class="col-lg-6">

                    <div class="panel panel-default">

                        <div class="panel-heading">

                            <i class="fa fa-question-circle   fa-fw"></i> Manage Student

                        </div>

                        <!-- /.panel-heading -->

                        <div class="panel-body">

                            <div class="list-group">
								<font color="red"><s:property value="error"/></font>
                           		<s:form action="addStudentSubjectClass">
									<s:div cssClass="form-group">
										<s:label value="Select Student "></s:label>
										<s:textfield name="userid"></s:textfield>
										
                            		</s:div>
                            		<s:div cssClass="form-group">
										<s:label value="Select Class"></s:label>
										<s:select  cssClass="form-control"  list="{'First Year','Second Year'}" name="studentclass">
                                	
                            			</s:select>
                            		</s:div>
                            		<s:div cssClass="form-group">
										<s:label value="Select Subject"></s:label>
										<s:select  cssClass="form-control"  list="subjectsliststudent" listKey="subjectname" listValue="subjectname" name="subjectname">
                                	
                            			</s:select>
                            		</s:div>
                            		<s:div cssClass="form-group">                   
                            		<s:submit cssClass="btn btn-primary" value="Add"></s:submit>
									</s:div>
									
								
								</s:form>
                            </div>

                            <!-- /.list-group -->

                        </div>

                        <!-- /.panel-body -->

                    </div>

                    <!-- /.panel -->

                </div>
	
<!-- Subject Starts here -->
		<div class="col-lg-6">

                    <div class="panel panel-default">

                        <div class="panel-heading">

                            <i class="fa fa-question-circle   fa-fw"></i> Manage New Subjects

                        </div>

                        <!-- /.panel-heading -->

                        <div class="panel-body">

                            <div class="list-group">
								<font color="red"><s:property value="error"/></font>
								<s:form action="addNewSubject">
									<s:div cssClass="form-group">
										<s:label value="Subject Entry "></s:label>
										
                                		<s:textfield name="subjectname"></s:textfield>
                            			
                            		</s:div>
                            		
                            		<s:div cssClass="form-group">                   
                            		<s:submit cssClass="btn btn-primary" value="Add"></s:submit>
									</s:div>
									
								
								</s:form>

                            </div>

                            <!-- /.list-group -->

                        </div>

                        <!-- /.panel-body -->

                    </div>

                    <!-- /.panel -->

                </div>

	
	</div>
        <!-- /#page-wrapper -->


    </div>

    <!-- /#wrapper -->

		</div>
    <!-- jQuery -->

    <script src="../vendor/jquery/jquery.min.js"></script>
	<script src="JSP/vendor/jquery/jquery.min.js"></script>

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

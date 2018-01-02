<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>
        <decorator:title default="Acentic Cloud Services" />
    </title>

    <!-- Font Awesome -->
    <link href="<s:url value='/js/'/>vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Bootstrap -->
    <link href="<s:url value='/js/'/>vendors/bootstrap/css/bootstrap.min.css" media="all" rel="stylesheet" type="text/css" />
    <!-- Datatables -->
    <link href="<s:url value='/js/'/>vendors/datatables/dataTables.bootstrap.min.css" media="all" rel="stylesheet" type="text/css" />
    <link href="<s:url value='/js/'/>vendors/datatables/buttons.bootstrap.min.css" rel="stylesheet">
    <!-- NProgress (waiting progressbar) -->
    <link href="<s:url value='/js/'/>vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck (schicke checkboxen) -->
    <link href="<s:url value='/js/'/>vendors/iCheck/skins/flat/blue.css" rel="stylesheet">
    <!-- Select2 (schicke selectboxen) -->
    <link href="<s:url value='/js/'/>vendors/select2/dist/css/select2.min.css" rel="stylesheet">
    <!-- PNotify -->
    <link href="<s:url value='/js/'/>vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="<s:url value='/js/'/>vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="<s:url value='/js/'/>vendors/custom.min.css" rel="stylesheet" media="all">
    <!-- // Print css // -->
    <link href="<s:url value='/js/'/>vendors/print.css" rel="stylesheet" media="print">
    <!-- Module specific headline -->
    <decorator:getProperty property="page.headlines" />
    <!-- Prevent FOUC -->
    <style type="text/css">
        .no-fouc {display: none;}
    </style>
</head>

<body class="nav-md footer_fixed no-fouc">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="/ems/index.jsp" class="site_title"><i class="fa fa-cloud"></i> <span class="acentic">EMS Cloud</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div id="menu" class="menu_section">
              </div>

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a href="<s:url value='/security/' />doAccessProfile.action" data-toggle="tooltip" data-placement="top" title="<s:text name='user.profile.edit' />">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a id="fullscreen" data-toggle="tooltip" data-placement="top" title="<s:text name='common.fullscreen' />">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a id="logout" href="<s:url value='/public/'/>doLogout.action" data-toggle="tooltip" data-placement="top" title="<s:text name='user.profile.logout' />">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="<s:url value='/security/' />doAccessProfile.action"><s:text name="user.profile.edit" /></a></li>
                    <!--<li><a href="javascript:;"><s:text name="user.profile.help" /></a></li>-->
                    <li><a href="<s:url value='/public/'/>doLogout.action"><i class="fa fa-sign-out pull-right"></i><s:text name="user.profile.logout" /></a></li>
                  </ul>
                </li>
              </ul>

            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">

            <div class="page-title">
              <div class="title_left">
                <h3><decorator:getProperty property="page.pagetitle" /></h3>
              </div>

                <decorator:getProperty property="page.pagetitle.right" />
            </div>


            <div class="clearfix"></div>

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">

                    <decorator:body />

                </div>
            </div>

          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            &copy; Cloud Services by <a class="acentic" href="https://acentic.com" target="_blank">Acentic</a>
            &nbsp; | &nbsp;
            <a href="http://acentic.com/legal/" target="_blank"><s:text name="common.legal" /></a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="<s:url value='/js/'/>vendors/jquery/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="<s:url value='/js/'/>vendors/bootstrap/js/bootstrap.min.js"></script>
    <!-- // Moment - Date formatter / -->
    <script src="<s:url value='/js/'/>vendors/moment/moment.min.js"></script>
    <!-- Datatables -->
    <script src="<s:url value='/js/'/>vendors/datatables/jquery.dataTables.min.js"></script>
    <script src="<s:url value='/js/'/>vendors/datatables/dataTables.bootstrap.min.js"></script>
    <script src="<s:url value='/js/'/>vendors/datatables/dataTables.buttons.js"></script>
    <script src="<s:url value='/js/'/>vendors/datatables/buttons.bootstrap.min.js"></script>
    <script src="<s:url value='/js/'/>vendors/datatables/buttons.html5.min.js"></script>
    <script src="<s:url value='/js/'/>vendors/datatables/buttons.print.min.js"></script>
    <!-- checkbox array to use as a basis for sorting -->
    <script>
        $.fn.dataTable.ext.order['dom-checkbox'] = function(settings, col) {
            return this.api().column( col, {order:'index'} ).nodes().map( function ( td, i ) {
                return $('input', td).prop('checked') ? '1' : '0';
            });
        };
    </script>
    <!-- NProgress -->
    <script src="<s:url value='/js/'/>vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="<s:url value='/js/'/>vendors/iCheck/icheck.min.js"></script>
    <!-- Select2 -->
    <script src="<s:url value='/js/'/>vendors/select2/dist/js/select2.full.min.js"></script>
    <!-- PNotify -->
    <script src="<s:url value='/js/'/>vendors/pnotify/dist/pnotify.js"></script>
    <script src="<s:url value='/js/'/>vendors/pnotify/dist/pnotify.buttons.js"></script>


    <decorator:getProperty property="page.footlines"/>

    <!-- Custom Theme Style -->
    <script src="<s:url value='/js/'/>vendors/custom.min.js"></script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

 <!-- Left side column. contains the sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="../../dist/img/avatar6.JPG" class="img-circ" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Wincor User</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li class="treeview">
          <a href="<s:url action="pages/forms/TableauDeBord"/>">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
            
          </a>
          
        </li>
        <li class="treeview" >
          <a href="<s:url action="pages/forms/GoDispatch"/>">
            <i class="fa fa-wheelchair"></i> <span>Suivie des signalisations</span> 
          </a>
          
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-ticket"></i>
            <span>Ticket</span>
            
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i>Ajout</a></li>
            <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i>Modification</a></li>
            <li><a  href="<s:url action="pages/forms/menu_ticket"/>" ><i class="fa fa-circle-o"></i>Recherche</a></li>
            <li><a href="pages/UI/timeline.html"><i class="fa fa-circle-o"></i>Timeline</a></li>
          </ul>
        </li>
        <li>
          <a href="/widgets.html">
		  
            <i class="fa fa-bolt"></i> <span>Signalisation</span>
			  <span class="pull-right-container">
              <small class="label pull-right bg-red">3</small>
              </span>
          </a>
		  <ul class="treeview-menu">
            <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i>Ajout</a></li>
            <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i>Modification</a></li>
            <li><a href="pages/mailbox/mailbox.html"><i class="fa fa-circle-o"></i>Recherche</a></li>
            
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-recycle"></i>
            <span>Préventive</span>
            
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i>Ajout</a></li>
            <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i>Modification</a></li>
            <li><a href="pages/calendar.html"><i class="fa fa-circle-o"></i>Liste</a></li>
          </ul>
        </li> 
        <li class="treeview">
          <a href="#">
            <i class="fa fa-laptop"></i>
            <span>Rapport</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href=""><i class="fa fa-circle-o"></i>General</a></li>
            <li><a href=""><i class="fa fa-circle-o"></i>Tickets</a></li>
            <li><a href=""><i class="fa fa-circle-o"></i>Intervention</a></li>
            <li><a href=""><i class="fa fa-circle-o"></i>Préventives</a></li>
            <li><a href=""><i class="fa fa-circle-o"></i>Techniciens</a></li>
            
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-edit"></i> <span>Administration</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/examples/profile.html"><i class="fa fa-circle-o"></i>Utilisateurs</a></li>
            <li><a href="pages/examples/profile.html"><i class="fa fa-circle-o"></i>Clients</a></li>
            <li><a href="pages/examples/profile.html"><i class="fa fa-circle-o"></i>Agence</a></li>
			<li><a href="pages/examples/profile.html"><i class="fa fa-circle-o"></i>Matériel</a></li>
			<li><a href="pages/examples/profile.html"><i class="fa fa-circle-o"></i>Gestion des privilèges</a></li>
          </ul>
        </li>
       </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
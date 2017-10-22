<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style>

 

</style>
 <!-- Left side column. contains the sidebar -->
  <aside class="main-sidebar   ">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar ">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="../../dist/img/avatar6.JPG" class="img-circle" alt="User Image">
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
            <i class="fa fa-wheelchair"></i> <span>Suivie des signalisations &nbsp; </span> 
            <span class="pull-right-container">
              <small class="label pull-right bg-red">&nbsp;5</small>
            </span>
          </a>
          
        </li>
        
         <li class="treeview" >
          <a href="<s:url action="pages/forms/preventive"/>">
             <i class="fa fa-recycle"></i></i> <span>Pr�ventive</span> 
          </a>
          
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-ticket"></i>
            <span>Ticket</span>
            
          </a>
          <ul class="treeview-menu">
          
            <li><a  href="<s:url action="pages/forms/menu_ticket"/>" ><i class="fa fa-circle-o"></i>Recherche</a></li>
            
          </ul>
        </li>
        
         
         
       </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
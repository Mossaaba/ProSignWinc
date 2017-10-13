 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
 
 <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
      Team SIMY
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2017 <a href="#">Diebold Nixdorf ALGERIA</a>.</strong> All rights reserved.
  </footer>


<SCRIPT language="javascript">

$(window).scroll(function() {
	  sessionStorage.scrollTop = $(this).scrollTop();
	});

	$(document).ready(function() {
	  if (sessionStorage.scrollTop != "undefined") {
	    $(window).scrollTop(sessionStorage.scrollTop);
	  }
	});
	
	
	
</SCRIPT>   
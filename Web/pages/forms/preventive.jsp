<%@page import="com.ProSign.Object.Tableau_Sign_Details"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page import="java.util.*" %>
<%@ page import="com.ProSign.Object.*" %>
<%@ page import="com.ProSign.Dispatch.*" %>
<%
ArrayList list_region =(ArrayList)session.getAttribute("list_region");
ArrayList list_wilaya =(ArrayList)session.getAttribute("list_wilaya");
ArrayList list_ville =(ArrayList)session.getAttribute("list_ville");
ArrayList list_agence =(ArrayList)session.getAttribute("list_agence");
ArrayList list_client =(ArrayList)session.getAttribute("list_client");
ArrayList list_tech =(ArrayList)session.getAttribute("list_tech");
List list_res_preventive =(List)session.getAttribute("list_res_preventive");

Preventive_form tf =(Preventive_form)session.getAttribute("tf");
ArrayList list_typeMachine =(ArrayList)session.getAttribute("list_typeMachine");
ArrayList liste_refrenceMachine =(ArrayList)session.getAttribute("liste_refrenceMachine");

%>
<!DOCTYPE html>
<html>

<script>
        $(document).ready(function () {
            $("#ToggleSideMenu").click(function (e) {
                e.preventDefault();
                $("#wrapper").toggleClass("toggled");
            });
        });
</script>


<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>ProSign</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- daterange picker -->
  <link rel="stylesheet" href="../../plugins/daterangepicker/daterangepicker.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="../../plugins/datepicker/datepicker3.css">
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="../../plugins/iCheck/all.css">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="../../plugins/colorpicker/bootstrap-colorpicker.min.css">
  <!-- Bootstrap time Picker -->
  <link rel="stylesheet" href="../../plugins/timepicker/bootstrap-timepicker.min.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="../../plugins/select2/select2.min.css">
    <link rel="stylesheet" href="../../plugins/datatables/dataTables.bootstrap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
 
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <!-- jQuery 2.2.3 -->
<script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="../../plugins/select2/select2.full.min.js"></script>
<!-- InputMask -->
<script src="../../plugins/input-mask/jquery.inputmask.js"></script>
<script src="../../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="../../plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="../../plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="../../plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- bootstrap color picker -->
<script src="../../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<!-- bootstrap time picker -->
<script src="../../plugins/timepicker/bootstrap-timepicker.min.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="../../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="../../plugins/iCheck/icheck.min.js"></script>
<!-- FastClick -->
<script src="../../plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>


<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables/dataTables.bootstrap.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
 
 <jsp:include page="/pages/tiles/header.jsp" />
  <!-- =============================================== -->

  <!-- Left side column. contains the sidebar -->
 <jsp:include page="/pages/tiles/menu.jsp" />
 
                            <!-- =============================================== -->
							 <!-- =============================================== -->
						     <!--       Content Wrapper. Contains page content    -->
						     <!-- =============================================== -->
						     <!-- =============================================== -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Recherche Preventive
        <small>Avanc&eacute;</small>
      </h1>
      
    </section>

    <!-- Main content -->
    <section class="content">
				
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!--------------------------------  Form -------------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->
				
     <s:form action="/Preventive.action" method="POST" id="f1" target="_parent"> 
     <input type ="hidden" name ="id_ticket" id="id_ticket" value="">
     <input type ="hidden" name ="min_date" id="min_date" >
     <input type ="hidden" name ="max_date" id="max_date"  >
  
      <!-- SELECT2 EXAMPLE -->
      <div class="box box-primary" style="width : 100%;">
      
           
      		<div class="box-header with-border text-center">
              <h3 class="box-title">
              <i class="glyphicon glyphicon-search">
              </i>&nbsp;Filter de recherche des preventives</h3>
              
            <div class="box-tools pull-right">
                
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                
              </div>
			  </div>
        
        
        <!-- /.box-header -->
        <div class="box-body">
          <div class="row">
		  <div class="col-md-12">
		  <div class="box-header with-border" style="width: 50%;">
          <h3 class="box-title"><i class="glyphicon glyphicon-map-marker">
              </i> Emplacement</h3>

        
        </div>
            <div class="col-md-4">
            <!----------------------------------------------------------------------------->
            <!-----------------------------------REGION------------------------------------>
		    <!----------------------------------------------------------------------------->
            <div class="form-group">
                <label>R&eacute;gion&nbsp;&nbsp;</label>
                <select onchange="change_region()" class="form-control select2" style="width: 100%;" name="region">
                  <option value="-1" selected="selected">...</option>
            <!------------------------------- GET LA LISTE DES REGIONS -------------------->
                 <% 
                 for(int i=0;i<list_region.size();i++)
                 {
                	 String tt="";
                	                 	 
                  if(list_region.get(i).toString().equalsIgnoreCase(tf.getRegion()))	
                  {
                  tt="selected=\"selected\""; //selection de l'option region
                  }
                 %>
		                <option <%=tt%>   
		                value="<%=list_region.get(i).toString()%>"><%=list_region.get(i).toString()%>
		                </option>
		         <%} %>
                 
                </select> 
              </div>
            </div>
            <!-- /.col --> 
            <div class="col-md-4">
            
            <!----------------------------------------------------------------------------->
            <!-----------------------------------WILAYA------------------------------------>
		    <!----------------------------------------------------------------------------->
            
              <div class="form-group">
                <label>Wilaya&nbsp;&nbsp;</label>
                <select onchange="change_wilaya()" class="form-control select2" style="width: 100%;" name="wilaya">
                  <option  value="-1" selected="selected">...</option>
             <!---------------------------- GET LA LISTE WILAYA------- -------------------->
                  <%
                    
                    for(int i=0;i<list_wilaya.size();i++){ 
                    	List tmp=(List)list_wilaya.get(i);
                    	 String tt="";
	                 	 
                         if(tmp.get(0).toString().equalsIgnoreCase(tf.getWilaya()))	
                         {
                         tt="selected=\"selected\""; //selection de l'option region
                         }
                	 %>
   					<option <%=tt%> value="<%=tmp.get(0).toString()%>"><%=tmp.get(1).toString()%></option>
                 <%} %>
                </select>
              </div>
             
            </div>   
            <div class="col-md-4">
            
            <!----------------------------------------------------------------------------->
            <!-----------------------------------VILLE------------------------------------->
		    <!----------------------------------------------------------------------------->
            
              <div class="form-group">
                <label>&nbsp;&nbsp;&nbsp;&nbsp;Ville&nbsp;&nbsp;&nbsp;</label>
                <select  onchange="change_ville()" class="form-control select2" name="ville" style="width: 100%;">
                  <option value="-1"  selected="selected">...</option>
            <!------------------------------- GET LA LISTE VILLE------- -------------------->
                   <%
                    
                    for(int i=0;i<list_ville.size();i++){ 
                    	List tmp=(List)list_ville.get(i);
                    	 String tt="";
	                 	 
                         if(tmp.get(0).toString().equalsIgnoreCase(tf.getVille()))	
                         {
                         tt="selected=\"selected\""; //selection de l'option region
                         }
                	 %>
   					<option <%=tt%>  value="<%=tmp.get(0).toString()%>"><%=tmp.get(1).toString()%></option>
                   <%} %>
                 
                </select>
              </div>
             
            </div>                   <!-- /.col -->
          </div>
          </div>
                                     <!-- /.row -->
                                     
          <div class="row">
		  <div class="col-md-12">
		  
		    <!--------------------------------------------------------------------------->
            <!-----------------------------------CLIENT---------------------------------->
		    <!--------------------------------------------------------------------------->
		   <div class="box-header with-border" style="width: 50%;">
          <h3 class="box-title">
         
			  <i class="fa  fa-bank"></i>&nbsp; Client</h3>
          
        </div>
            
            
            <div class="col-md-3">  
              <div class="form-group">
                <label>Nom Client&nbsp;&nbsp;</label>
                <select  onchange="change_client()" class="form-control select2" style="width: 100%;" name="client">
                  <option value="-1" selected="selected">...</option>
            <!---------------------------- GET LA LISTE CLIENTS-------------------------->
                  <% 
                 for(int i=0;i<list_client.size();i++)
                 {
                	 List tmp=(List)list_client.get(i);
                	 String tt="";
                	                 	 
                  if(tmp.get(0).toString().equalsIgnoreCase(tf.getClient()))	
                  {
                  tt="selected=\"selected\""; //selection de l'option region
                  }
                 %>
                <option <%=tt%>   
                value="<%=tmp.get(0).toString()%>"><%=tmp.get(1).toString()%>
                </option>
		         <%} %>  
                </select>
              </div>
              </div>
              <div class="col-md-3"> 
              <!----------------------------------------------------------------------------->
            <!-----------------------------------Agence------------------------------------->
		    <!----------------------------------------------------------------------------->
                <div class="form-group">
                <label>Agence&nbsp;&nbsp;</label>
                <select name="agence" onchange="change_agence()" class="form-control select2" style="width: 100%;">
                  <option  value="-1" selected="selected">...</option>
            <!----------------------------- GET LA LISTE AGENCE--------------------------->
                  <%
                     
                    for(int i=0;i<list_agence.size();i++){ 
                    	List tmp=(List)list_agence.get(i);
                    	 String tt="";
                    	
                    	 if(tmp.get(0).toString().equalsIgnoreCase(tf.getAgence()))	
                         {
                         tt="selected=\"selected\""; //selection de l'option region
                         }
                	 %>
   					<option  <%=tt%>
   					value="<%=tmp.get(0).toString()%>">
   					<%=tmp.get(2).toString()%></option>
   					
                 <%} %>
                  
                </select>
              </div>
              </div>
            <!--------------------------------------------------------------------------->
            <!-----------------------------------TYPE MACHINE---------------------------->
		    <!--------------------------------------------------------------------------->
              
              <div class="col-md-3"> 
              <div class="form-group">
                <label>Type&nbsp;&nbsp;</label>
                <select name="type" onchange="change_type()" class="form-control select2" style="width: 100%;">
                  <option  value="-1" selected="selected">...</option>
                  
            <!----------------------------- GET LA LISTE TYPE MACHINE---------------------->
                  <% 
                    for(int i=0;i<list_typeMachine.size();i++){ 
                    	List tmp=(List)list_typeMachine.get(i);
                    	 String tt="";
                    	 
                    	 if(tmp.get(0).toString().equalsIgnoreCase(tf.getType()))	
                         {	
                         tt="selected=\"selected\""; //selection de l'option region
                         }
                	 %>
   					<option <%=tt%>
   					value="<%=tmp.get(0).toString()%>">
   					<%=tmp.get(0).toString()%></option>
   					
                 <%} %>
                </select>
              </div>
            
              </div>
              
                <div class="col-md-3">
                        
            <!--------------------------------------------------------------------------->
            <!-----------------------------------CODE MACHINE---------------------------->
		    <!---------------------------------------------------------------------------> 
              
              
            <div class="form-group">
                <label>&nbsp;&nbsp;&nbsp;&nbsp;Code Machine&nbsp;&nbsp;&nbsp;</label>
                <select name="referece_machine"  class="form-control select2" style="width: 100%;">
                  <option value="-1" selected="selected">...</option>
                  <% 
                    for(int i=0;i<liste_refrenceMachine.size();i++){ 
                    	List tmp=(List)liste_refrenceMachine.get(i);
                    	
                    	 String tt="";
                     	
                    	 if(tmp.get(0).toString().equalsIgnoreCase(tf.getReferece_machine()))	
                         {
                         tt="selected=\"selected\""; //selection de l'option region
                         }
                	 %>
   					<option <%=tt%>
   					value="<%=tmp.get(0).toString()%>">
   					<%=tmp.get(0).toString()%></option>
   					
                 <%} %>
                </select>
              </div>
            </div>
			 </div>                          
		  </div>
		    <!---------------------------------------------------------------------------> 
		    <!-----------------------------------box ticket------------------------------>
		    <!---------------------------------------------------------------------------> 
		<div class="box-body">
          <div class="row">
		  <div class="col-md-12">
			  <div class="box-header with-border" style="width: 50%;">
			  <h3 class="box-title ">
			  <i class="fa fa-ticket"></i>
			  Ticket</h3>
			  </div>
		    <!--------------------------------------------------------------------------->
            <!-----------------------------------TECHNICIEN------------------------------>
		    <!---------------------------------------------------------------------------> 
            <div class="col-md-3">
              <div class="form-group">
                <label>Technicien &nbsp;&nbsp;</label>
                <select name="technicien" class="form-control select2" style="width: 100%;">
                  <option value="-1" selected="selected">...</option>
                  <%
                     
                    for(int i=0;i<list_tech.size();i++){ 
                    	List tmp=(List)list_tech.get(i);
                    	
                    	 String tt="";
                      	
                    	 if(tmp.get(0).toString().equalsIgnoreCase(tf.getTechnicien()))	
                         {
                         tt="selected=\"selected\""; //selection de l'option region
                         }
                    	
                	 %>
   					<option  <%=tt%> value="<%=tmp.get(0).toString()%>"><%=tmp.get(1).toString()%></option>
                 <%} %>
                </select>
              </div>
            </div>
            <!--------------------------------------------------------------------------->
            <!-----------------------------------STATUS----------------------------------->
		    <!----------------------------------------------------------------------------> 
			<div class="col-md-3">
              <div class="form-group">
                <label>Status&nbsp;&nbsp;</label>
                <select name ="status_ticket"  class="form-control select2" style="width: 100%;">
                  <option value="-3"  selected="selected" >...</option>   
                  <option value="-1"  >Non Fait</option> 
                  <option value="0"   > Fait</option> 
                 <option value="-2"   > Not Affected</option> 
                </select>
              </div>
            </div> 			
			
		 
            <!--------------------------------------------------------------------------->
            <!-----------------------------------DATE------------------------------------->
		    <!----------------------------------------------------------------------------> 
		
			  
		    <!--------------------------------------------------------------------------->
            <!-----------------------------------date debut------------------------------>
		    <!---------------------------------------------------------------------------> 
            <div class="col-md-3">
              <div class="form-group">
              <label>Date debut&nbsp;&nbsp;</label>
               <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                <input type="email" class="form-control" value="<%=tf.getDate_range_min() %>" id="min_date" name="min_date" placeholder="date debut">
              </div>              
              </div>
            </div>
            <!--------------------------------------------------------------------------->
            <!-----------------------------------date fin----------------------------------->
		    <!----------------------------------------------------------------------------> 
			<div class="col-md-3">
              <div class="form-group">
              <label>Date fin&nbsp;&nbsp;</label>
                <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                <input type="email" class="form-control" value="<%=tf.getDate_range_max() %>"  id="max_date" name="max_date" placeholder="date fine">
              </div>
              </div>
            </div> 			
         </div>
		  
		  </div>
		  
		    <!---------------------------------------------------------------------------->
            <!----------------------------------CHEREHCER--------------------------------->
		    <!----------------------------------------------------------------------------> 
		  
		  <div class="row no-print">
		  
        <div class="col-xs-12">
        
            <!---------------------------------------------------------------------------->
            <!----------------------------------CHEREHCER Filter-------------------------->
		    <!----------------------------------------------------------------------------> 
          <button type="button"  class="btn btn-primary pull-right"  onclick="genereTableau()" >
          <i class="fa fa-search"></i> 
            Chercher
          </button>
          
           <!---------------------------------------------------------------------------->
            <!----------------------------------Effacer Fi:ter -------------------------->
		    <!---------------------------------------------------------------------------->
          <button type="button"  class="btn btn-danger pull-right" style="margin-right: 5px;" onclick="effacerTableau()">
            <i class="glyphicon glyphicon-remove"></i> 
            Effacer
          </button>
        </div>
      </div> 
		 
		  
        </div>
		
	
		
		</div>
		</div>
		 </s:form> 
		 
		 
		          <!----------------------------------------------------------------------------->
		 		  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!-----------------------------------END   FORM ------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->   
         
       <div class="row" >
                
                <div class="col-xs-12 text-center" >
              <div class="box box-primary ">
            
              
              <div class="box-header with-border" style="padding: 1px;">
              <h3 class="box-title"><i class="glyphicon glyphicon-arrow-down">
              </i>&nbsp;Resultat de recherche</h3>
                 
               <div class="box-tools pull-right">
                
              </div>
			  </div>
		
			</div>
			</div>
		
			</div>

<!-- /.box -->

          <div class="row" >
             <div class="col-xs-12 " >
              <div class="box box-primary ">
            
              
              <div class="box-header with-border text-center">
              <h3 class="box-title"><i class="glyphicon glyphicon-list-alt">
              </i>&nbsp;Tableau de suivi des tickets</h3>
               <div class="box-tools pull-right">
                
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                
              </div>
			  </div>
		
			
			
			
			
            <!-- /.box-header -->
            <div class="box-body text-center">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  
                  <th>Client</th>
                  <th>Ville</th>
                  <th>Agence</th>
                  <th>Date preventive</th>
				  <th>Type Machine</th>
				  <th>Status</th>
				  <th>deadline</th>
				  <th>Reste</th>
                </tr>
                </thead>
               

			   <tbody>
			       <%  

                       for(int i=0;i<list_res_preventive.size();i++)
                    { String col="";
                    	   
                    Table_preventive tablSign = (Table_preventive)list_res_preventive.get(i) ;
                    	
                    	
                    %> 
                  <tr >
                   
                  <td align="center" ><%=tablSign.getClient()%></td>
                  <td align="center"><%=tablSign.getVille()%></td>
                  <td align="center"><%=tablSign.getAgence()%></td>
                  <td align="center"><%=tablSign.getDate_prev()%></td>
				  <td align="center"><%=tablSign.getType_machine()%></td>
				  <td align="center">
				  <%if(tablSign.getDone().equalsIgnoreCase("-1")){
				  
				  %><small class="label pull-right bg-red">#</small>
                   <%}else if(tablSign.getDone().equalsIgnoreCase("-2")){
				  
				  %>
                   <small class="label pull-right bg-yellow">@</small>
                   <%}else{
				  
				  %>
                   <small class="label pull-right bg-green">&</small>
                    <%}%>
                    </td>
                    
                  <td align="center"><%=tablSign.getDeadline()%></td>
                  <td align="center"><%=tablSign.getRest()%></td>		 
				</tr>
				
				 <% }%>
               </tbody>
                <tfoot>
                <tr>
                  <th>total</th>
                  <th></th>
                  <th></th>
                  <th></th>
                  <th></th>
				  <th></th>
				  <th></th>
				  <th></th>
                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
         </div>
          </div>
          </div>
  
          <!-- /.box -->

		
		
		
		<div class="row">
     
      
	  <div class="col-xs-12 text-center">
	  
	
	  </div> 
	  </div>               
		
      
        <!-- /.col (right) -->
      </div>
      <!-- /.row -->

    </section>
    <!-- /.content -->
	
 <jsp:include page="/pages/tiles/footer.jsp" />

  
  </div>
  <!-- /.content-wrapper -->
  
  
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->


<!-- SlimScroll -->
<!-- FastClick -->
<!-- AdminLTE App -->
<!-- AdminLTE for demo purposes -->

<!-- Page script -->
<script>
  $(function () {
    //Initialize Select2 Elements
    $(".select2").select2();

    //Datemask dd/mm/yyyy
    $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
    //Datemask2 mm/dd/yyyy
    $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
    //Money Euro
    $("[data-mask]").inputmask();

    //Date range picker
    $('#reservation').daterangepicker();
    //Date range picker with time picker
    $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
    //Date range as a button
    $('#daterange-btn').daterangepicker(
        {
          ranges: {
            'Today': [moment(), moment()],
            'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            'Last 7 Days': [moment().subtract(6, 'days'), moment()],
            'Last 30 Days': [moment().subtract(29, 'days'), moment()],
            'This Month': [moment().startOf('month'), moment().endOf('month')],
            'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
          },
          startDate: moment().subtract(29, 'days'),
          endDate: moment()
        },
        function (start, end) {
          $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
        }
    );

    //Date picker
    $('#datepicker').datepicker({
      autoclose: true
    });

    //iCheck for checkbox and radio inputs
    $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
      checkboxClass: 'icheckbox_minimal-blue',
      radioClass: 'iradio_minimal-blue'
    });
    //Red color scheme for iCheck
    $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
      checkboxClass: 'icheckbox_minimal-red',
      radioClass: 'iradio_minimal-red'
    });
    //Flat red color scheme for iCheck
    $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
      checkboxClass: 'icheckbox_flat-green',
      radioClass: 'iradio_flat-green'
    });

    //Colorpicker
    $(".my-colorpicker1").colorpicker();
    //color picker with addon
    $(".my-colorpicker2").colorpicker();

    //Timepicker
    $(".timepicker").timepicker({
      showInputs: false
    });
  });
</script>
<script>
  $(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });
  });
</script>

<script>
  $(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });
  });
  
  
  $(function() {
	  $( "#min_date" ).datepicker({
	  onClose: function( selectedDate ) {
	    
	      
	  var actualDate = new Date(selectedDate);
	  var newDate = new Date(actualDate.getFullYear(), actualDate.getMonth(), actualDate.getDate()+1);

	  $("#max_date").datepicker("option","minDate", newDate)
	  },
	    
	  });
	  $( "#max_date" ).datepicker({
	  onClose: function( selectedDate ) {
	      $( "#min_date" ).datepicker( "option", "maxDate", selectedDate );
	  }
	  });
	     });
  
</script>    




<SCRIPT language="javascript">

function change_region(){
	
 	  document.getElementById('f1').action= "change_region_prev?methodtocall=change_region_prev";
	  document.getElementById('f1').submit();
 }
   
function change_wilaya(){
	
	  document.getElementById('f1').action= "change_wilaya_prev?methodtocall=change_wilaya_prev";
	  document.getElementById('f1').submit();
}

function change_ville(){
	 
	  document.getElementById('f1').action= "change_ville_prev?methodtocall=change_ville_prev";
	  document.getElementById('f1').submit();
}

function change_client()
{
	
	  document.getElementById('f1').action= "change_client_prev?methodtocall=change_client_prev";
	  document.getElementById('f1').submit();
}

function change_agence()

{
	
	  document.getElementById('f1').action= "change_agence_prev?methodtocall=change_agence_prev";
	  document.getElementById('f1').submit();
}


function change_type()
{
	
	  document.getElementById('f1').action= "change_type_prev?methodtocall=change_type_prev";
	  document.getElementById('f1').submit();
}



function genereTableau(min_date,max_date,status_ticket)
{
	
	var min_date = document.getElementById("min_date").value;
    document.getElementById("min_date").innerHTML = min_date;
    
    var max_date = document.getElementById("max_date").value;
    document.getElementById("max_date").innerHTML = max_date;
    
    
    document.getElementById('f1').action="genereTableau_prev?methodtocall=genereTableau_prev";
    document.getElementById('f1').submit();


}

 


function effacerTableau()
{
	

document.getElementById('f1').action="effacerTableau_prev?methodtocall=effacerTableau_prev";
document.getElementById('f1').submit();


}




</SCRIPT>  
 

</body>
</html>

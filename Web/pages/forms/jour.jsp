<%@page import="com.ProSign.Object.Tableau_Sign_Details"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ProSign.Object.*" %>
<%@ page import="com.ProSign.Dispatch.*" %> 
<%
ArrayList list_tech =(ArrayList)session.getAttribute("list_tech");
ArrayList list_dispatch=(ArrayList) session.getAttribute("list_dispatch");
ArrayList historique_dispatching=(ArrayList) session.getAttribute("historique_dispatching");
Form_temp forTemp =(Form_temp)session.getAttribute("forTemp");
ArrayList list_resum_intev=(ArrayList) session.getAttribute("list_resum_intev");
String id_ticket=(String) session.getAttribute("id_ticket");


%>
<!DOCTYPE html>
<html>
<head >

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
<!-- SlimScroll -->
<!-- FastClick -->
<!-- AdminLTE App -->
<!-- AdminLTE for demo purposes -->

<!-- Page script -->
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
</head>
<body class="hold-transition fixed skin-blue sidebar-mini sidebar-toggle sidebar-collapse">
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
  <div class="content-wrapper" >
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Etat Journalier
     
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
				
                   <s:form action="/Dispatch.action" method="POST" id="f1" target="_parent"> 
     
          <input type ="hidden" name ="Id_intervention" id="Id_intervention" value="">
          <input type ="hidden" name ="Id_technicien" id="Id_technicien" value="">
          <input type ="hidden" name ="date_intervention" id="date_intervention" value="">
          <input type ="hidden" name ="id_ticket" id="id_ticket" value="">
            <input type ="hidden" name ="Etat_Validation" id="Etat_Validation" value="">
     
      <!-- SELECT2 EXAMPLE -->
    	
		 </s:form> 
		 
		          <!----------------------------------------------------------------------------->
				  <!--------------fin Modification Interventioin  ------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->
		        

				  <!----------------------------------------------------------------------------->
				  <!-----------------------------------END   FORM ------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->
				  
				  
				   <!----------------------------------------------------------------------------->
				   <!---------------------------Liste des technicien------------------------------>
				   <!----------------------------------------------------------------------------->

            <div class="box box-primary box-solid" style="width: 100%; position=center;">
 
              <div class="row" >
                
                <div class="col-xs-12 text-center" >
              <div class="box box-primary box-solid ">
            
              
              <div class="box-header with-border">
              <h3 class="box-title"><i class="glyphicon glyphicon-user">
              </i>&nbsp;Liste des techniciens</h3>
                 
               <div class="box-tools pull-right">
                
              </div>
			  </div>
		
			</div>
			 
  
			<div class="col-md-12">
			<div class="box">
			<div class="box-body">
			 <table class="table table-bordered">
			 <tr>
			 <td>
			 
			 </td>
			 
			 </tr>
			 <%
			 int max_tab=5;
			  int s=0;
			 while (s<list_resum_intev.size())
			 { %>
				  
				 <tr>
				  <%
				  for(int j = s; j < max_tab+s; j++)
				 
				 {
					 if(j<list_resum_intev.size()){
					 List tmp=(List)list_resum_intev.get(j);
					 %>
					 <td>
					<%=" "+tmp.get(0).toString()+"  "%><span title="<%=tmp.get(2).toString()%>" class="pull-right badge bg-red"><%=tmp.get(1).toString()%></span> 
			 
					</td>
				
					 <%}
				 } %>
				</tr>
				 <% 
				 s=s+max_tab;
				 
			 }
			 %>
			 
			 
		 
			 
			 
			 </table>
			  </div>
			      </div>
			      </div>
			      </div>
			    </div>
			   </div>

                   <!----------------------------------------------------------------------------->
				   <!---------------------------Fin liste des techniciens------------------------->
				   <!----------------------------------------------------------------------------->


                   <!----------------------------------------------------------------------------->
				   <!---------------------------Tableau dispatching------------------------------->
				   <!----------------------------------------------------------------------------->

          <div class="box box-primary box-solide">
           <!-- box-header -->
          
              <div class="box-header with-border text-center box-solide ">
	              <h3 class="box-title box-solid">
	              <i class="glyphicon glyphicon-flash">
	              </i>&nbsp;Liste de suivi des signalisations</h3>
	              <br>
	              	              
	              
	               <div class="box-tools pull-right">
	                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
	                </button>
	                
	                
	              </div>
	              
			   </div>
			   <div class="box-tools">
	               
	               <span class="btn btn-box-tool"><span class="label pull-right bg-red">1&nbsp;non affecté</span></span>
                   <span class="btn btn-box-tool"><span class="label pull-right bg-yellow">2&nbsp;Programme du jour</span></span>
                   <span class="btn btn-box-tool"><span class="label pull-right bg-green">3&nbsp;Intervention effectué</span></span>
                   <span class="btn btn-box-tool"><span class="fa fa-circle-o text-yellow">&nbsp;En Suspens</span></span>	                
	        
	              </div>
            <!-- /.box-header -->
            <div class="box-body with-border" >
              <table id="example1" class="table table-bordered table-striped ">
                <thead>
                
                <tr>
                 <th style="text-align: center;"><i class="glyphicon glyphicon-search"></i> </th>
                  <th style="text-align: center;">CLIENT</th>
                  <th style="text-align: center;">AGENCE </th>
				  <th style="text-align: center;">DATE SIGNALISATION</th>
				  <th style="text-align: center;">PROGRAMMER</th>
				     <th style="text-align: center;">DATE INTERVENTION</th>
				  <th style="text-align: center;">TECHNICIEN</th>
			      <th style="text-align: center;">SIGNALISATION</th>
			      <th style="text-align: center;">STATUS</th>
			   
			      <th style="text-align: center;"> </th>
			      <th style="text-align: center;"> </th>
		          <th style="text-align: center;"><i class="glyphicon glyphicon-flag"></i></th>
		          
			      <th style="text-align: center;"> <i class="glyphicon glyphicon-cog"></i></th>
                </tr> 
                </thead>

			   <tbody>
			     
			     <%
			     for(int i=0;i<list_dispatch.size();i++)
			     {
			    	 Table_Dispatch td=(Table_Dispatch)list_dispatch.get(i);
			    	 System.out.println(td.getID_CLIENT());	
			    	 System.out.println(td.getPROGRAMMER());
			   System.out.println(td.getEtat_Validation());	
			    	 String color="";
			    	  
						
						if(td.getPROGRAMMER()==null ||td.getPROGRAMMER().isEmpty())
						{
							color="danger";
						}else 
							if(td.getPROGRAMMER()!=null && td.getDATE_INTERVENTION()==null )
							{
								color="warning"; 
							}else 
							{
								color="success";
							}
						%>
			     
                  <tr class="<%=color%>">
						
						
					<td nowrap="nowrap">
				
				 
				<span class="pull-right-container">
				
				<%
				
				if(td.getPROGRAMMER()==null ||td.getPROGRAMMER().isEmpty())
				{
					%>
					<small class="label pull-right bg-red">1</small>
				<%	
				}else 
					if(td.getPROGRAMMER()!=null && td.getDATE_INTERVENTION()==null )
					{
						%>
						<small class="label pull-right bg-yellow">2</small>
					<%
					}else 
					{
						%>
						<small class="label pull-right bg-green">3</small>
				<%
					}
				%>
            </span>

				</td>	
						
						             
                  
                  <td align="center"><%=td.getID_CLIENT() %></td>
                  <td align="center"><%=td.getNOM_AGENCE() %> </td>
				  <td align="center"><%=td.getDATE_SIGNALISATION() %></td>
				  <td align="center"><%=td.getPROGRAMMER() %></td>
				   <td align="center"><%=td.getDATE_INTERVENTION() %></td>
				  <td align="center"><%=td.getNOM_TECHNICIEN() %></td>
				 <td align="center"><%=td.getTYPE_SIGNALISATION() %></td>
				  <td align="center"><%=td.getTicket_status() %></td>
				  
				 
				 <td align="center" >				 
				 <%if(td.getSMS_DATE_ENVOI()!=null){ %>
				 <i class="fa fa-mail-forward" title="<%=td.getSMS_DATE_ENVOI() %>" ></i>
				  <%} %>
				 </td>
				
				
				
				 <td align="center">
				 <%if(td.getSMS_DATE_RECEPT()!=null){ %>
				 <i class="fa fa-thumbs-up" title="<%=td.getSMS_DATE_RECEPT() %>"></i>
				  <%} %>
				 
				  </td>
				 
				<td align="center" nowrap="nowrap">
				<% if(td.getIndicateur_status().equalsIgnoreCase("0")&& td.getDATE_INTERVENTION()!=null)
				{
					%>
					<span class="fa fa-circle-o text-yellow"></span>
				<%	
				}%>
				</td>
				 
				 
				 
				 <td align="center" valign="middle" nowrap="nowrap">
								
							<button type="button" id="button_2<%=td.getId_ticket() %>" class="btn-xs btn-social-icon btn-google" data-toggle="modal" data-target="#myModal<%=td.getId_ticket() %>" onclick="genrerDetailPop()">
							<i class="glyphicon glyphicon-eye-open"></i>
							</button>
							<div class="modal fade" id="myModal<%=td.getId_ticket() %>"  role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                                   <div class="modal-dialog modal-lg ">
								      <div class="modal-content with-border">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								          <h4 class="modal-title" id="myLargeModalLabel">Détails</h4>
								        </div>
								        <div class="box box-primary with-border">
								        <div class="box-body with-border" >
								            <h4> Emplacement</h4>
													<table class="table table-bordered table-striped table-hover ">
													 <tr>          
													<th><i class="fa fa-map"></i> region</th>
													<th><i class="fa fa-map-signs"></i> Wilaya</th>
													<th><i class="fa fa-map-pin"></i> ville</th>
												 
													<th><i class="fa fa-gg"></i> Type Machine</th>
													<th><i class="fa fa-barcode"></i> refrence Machine</th>
													
													</tr>
													<tr>
													<td><%=td.getREGION()%></td>
													<td><%=td.getNOM_WILAYA()%></td>
													<td><%=td.getNOM_VILLE() %></td>
													<td><%=td.getType_machine() %></td>
													<td><%=td.getRefrence_machine() %></td>
													
													  </tr>
													</table>
													<table class="table table-bordered table-striped table-hover ">
													 <tr>          
													<th><i class="fa fa-bolt"></i> Déscription du probléme</th>
													<th><i class="fa fa-sticky-note-o"></i> Remarque</th>

													</tr>
													<tr>
													<td><%=td.getDESCRIPTION_SIGNALISATION() %>.</td>
													<td><%=td.getREMARQUE() %>.</td>
													
													  </tr>
													</table>
									    </div>
								           </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
								         
								        </div>
								      </div>
								      <!-- /.modal-content -->
								    </div>
								    <!-- /.modal-dialog -->
								  </div>
							
							
							
							
							 
       

                                                        <!-- PopOP DETAILS-->
														<!-- PopOP DETAILS-->
														<!-- PopOP DETAILS-->
														<!-- PopOP DETAILS-->
														<!-- PopOP DETAILS-->
														<!-- PopOP DETAILS-->
														<!-- PopOP DETAILS-->
             
				
								 
								
								    
								      <!-- Modal content-->
								   				
			
							      
								  
								          <!--   PopOP DETAILS-->
													
														<!-- PopOP -->
		                            <div class="modal text-center" id="myModalModif" role="dialog">
										    <div class="box-body text-center">
												     <div class="alert alert-warning alert-dismissible">
															  <button type="button" class="close" data-dismiss="modal" aria-hidden="false">&times;</button>
															  <h4><i class="icon fa fa-warning"></i> Attention!</h4>
															  Vous devez attribuer un technicien et une date d'intervention , pour que vous puissiez la modifier 
													</div>
											</div>
								     </div>
                                                        <!-- :!PopOP -->
														<!-- /!PopOP -->
 
    
               		
 
   
      
 				 
				 </td>
			       
				  
				</tr>
				 <s:if test="#session.ranifimodif!=null">
					<script>
				 
					 
					$("#button_1"+<%=td.getId_intervention()%>).prop("disabled",true);
					$("#button_2"+<%=td.getId_intervention()%>).prop("disabled",true);
					
					$("#button_4"+<%=td.getId_intervention()%>).prop("disabled",true);
					$("#button_3"+<%=td.getId_intervention()%>).prop("disabled",true);
					</script>
					
					</s:if>
				<%
			     }
			     %>
				
				
         
                </tbody>
                <tfoot>
                <tr>
                  <th>total</th>
                  
                  <th></th>
                  <th></th>
                  <th></th>
				   
				   
				   
				  <th ></th>
				  <th ></th>
				  <th ></th>
				  <th ></th>
                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          
                   <!----------------------------------------------------------------------------->
				   <!----------------------fin Tableau dispatching-------------------------------->
				   <!----------------------------------------------------------------------------->


		  <div class="box" style="width: 100%; position=center;">
              <div class="row" >
                <div class="col-xs-12 text-center" >
					<div class="box box-default collapsed-box">
					<div class="box-header with-border">
					<h3 class="box-title"><i class="glyphicon glyphicon-list-alt"></i> Tableau des interventions</h3>
					</div>
                   </div>
               </div>
              </div>
              <!-- /.row -->
          </div> 

		<div class="well " align="center">Laste Validation</div>
		           <!------------------------------------------------------------------------------>
				   <!----------------------Tableau des intervention-------------------------------->
				   <!------------------------------------------------------------------------------>
		
		<div class="row">
	    <div class="col-xs-12">
	  
	    <div class="box">
            <div class="box-header">
              <h3 class="box-title">Tableau des interventions</h3>
              <div class="box-tools">

                <div class="input-group input-group-sm pull-right" style="width: 150px;">
                  <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">
                  <div class="input-group-btn">
                    <button type="submit" class="btn btn-default">
                    <i class="fa fa-search"></i></button>
                  </div>
                  
                </div>
                
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
                
                 
                  <th>Programmer le </th>
                  <th>Date Intervention</th>
                  <th>TECHNCHIEN</th>
                  <th>status</th>
                  <th>Remarque</th>
                  
                </tr>
                
                <%
                System.out.println(historique_dispatching);
                for(int i=0;i<historique_dispatching.size();i++)
                        {  
                	
                	Form_temp frmTemp=(Form_temp)historique_dispatching.get(i);
                    	%>
                 <tr>
                  <td><%=frmTemp.getProgrammer()%></td>
                  <td><%=frmTemp.getDate_intervention()%></td>
                  <td><%=frmTemp.getTechnicien()%></td>
                  <td><%=frmTemp.getStatus()%></td>
                  <td><%=frmTemp.getRemarque()%></td>
                  
                </tr>
                <%} %>
				
              </table>
			  
			  
			  
            </div>
			<div class="box-tools pull-right">
                <ul class="pagination pagination-sm inline">
                  <li><a href="#">&laquo;</a></li>
                  <li><a href="#">1</a></li>
                  <li><a href="#">2</a></li>
                  <li><a href="#">3</a></li>
                  <li><a href="#">&raquo;</a></li>
                </ul>
              </div>
            <!-- /.box-body -->
			
			 
          </div>       
	  </div> 
	  </div>   
	             
		           <!------------------------------------------------------------------------------>
				   <!----------------------fin Tableau des intervention---------------------------->
				   <!------------------------------------------------------------------------------>
      
      
      </div>
 <jsp:include page="/pages/tiles/footer.jsp" />

  
  </div>

<s:if test="#session.ranifimodif!=null">
<script>
$('#collapseExample').collapse({
	  toggle: true
	});
</script>

<%session.removeAttribute("ranifimodif");%>
<%session.removeAttribute("ranifimodif");%>
</s:if>
<%session.setAttribute("id_ticket","");%>
<!------------------------------------------------------------------------------>
<!---------------------------------Scripte jQuery------------------------------->
<!------------------------------------------------------------------------------>
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
<!------------------------------------------------------------------------------>
<!---------------------------------Scripte javaScript---------------------------->
<!------------------------------------------------------------------------------>

<script>
$(function () {
    
    $('#example1').DataTable({
       
    	"bPaginate": false,
    	"bLengthChange": false,
    	"bFilter": true,
    	"bInfo": false,
    	"bAutoWidth": false
    });
  });

 
  
  function modifier_intervention (Id_intervention,Id_technicien,date_intervention,id_ticket,Etat_Validation)
  {
	  
	  
	  
  document.getElementById('id_ticket').value=id_ticket;
  document.getElementById('Id_intervention').value=Id_intervention;
  document.getElementById('Id_technicien').value=Id_technicien;
  document.getElementById('date_intervention').value=date_intervention;
  document.getElementById('Etat_Validation').value=Etat_Validation;
  
  if(Id_technicien=='null' ||date_intervention=='null')
	 {
	  $('#myModalModif').modal({
		  keyboard: false
		}) 
		
		
	 
	 }else{
  
  
  document.getElementById('f1').action="modifier_intervention?methodtocall=modifier_intervention";
  document.getElementById('f1').submit();
	 }

  }


function modif_dispatch (Id_intervention,id_ticket)

{
	document.getElementById('id_ticket').value=id_ticket;
 document.getElementById('Id_intervention').value=Id_intervention;
 
document.getElementById('f1').action="modif_dispatch?methodtocall=modif_dispatch";
document.getElementById('f1').submit();
	 

}

function valider_intervention (Id_intervention,tec,dat,id_ticket)
{ 
	 

	
	document.getElementById('id_ticket').value=id_ticket;
	if(tec=='null' ||dat=='null')
		 {
		 $('#myModal2').modal({
			  keyboard: false
			}) 
 
		 }
	
	else{
			 
			 document.getElementById('Id_intervention').value=Id_intervention;



			 document.getElementById('f1').action="valider_intervention?methodtocall=valider_intervention";
		document.getElementById('f1').submit();   
		 }
 
} 



function historique_ticket (id_ticket)
{ 
	
	 
 document.getElementById('id_ticket').value=id_ticket;


 
document.getElementById('f1').action="historique_ticket?methodtocall=historique_ticket";
document.getElementById('f1').submit();


}

function annuler_Modification_dispatch() 
     {


	document.getElementById('f1').action="annuler_Modification_dispatch?methodtocall=annuler_Modification_dispatch";
	document.getElementById('f1').submit();
	
	
	
	
     }
function setModalMaxHeight(element) {
	  this.$element     = $(element);  
	  this.$content     = this.$element.find('.modal-content');
	  var borderWidth   = this.$content.outerHeight() - this.$content.innerHeight();
	  var dialogMargin  = $(window).width() < 768 ? 20 : 60;
	  var contentHeight = $(window).height() - (dialogMargin + borderWidth);
	  var headerHeight  = this.$element.find('.modal-header').outerHeight() || 0;
	  var footerHeight  = this.$element.find('.modal-footer').outerHeight() || 0;
	  var maxHeight     = contentHeight - (headerHeight + footerHeight);

	  this.$content.css({
	      'overflow': 'hidden'
	  });
	  
	  this.$element
	    .find('.modal-body').css({
	      'max-height': maxHeight,
	      'overflow-y': 'auto'
	    });
	}

	$('.modal').on('show.bs.modal', function() {
	  $(this).show(); 
	  setModalMaxHeight(this);
	});

	$(window).resize(function() {
	  if ($('.modal.in').length == 1) {
	    setModalMaxHeight($('.modal.in'));
	  }
	});

	/* CodeMirror */
	$('.code').each(function() {
	  var $this = $(this),
	      $code = $this.text(),
	      $mode = $this.data('language');

	  $this.empty();
	  $this.addClass('cm-s-bootstrap');
	  CodeMirror.runMode($code, $mode, this);
	});
</script>    
<!------------------------------------------------------------------------------>
<!----------------------------fin Scripte javaScript---------------------------->
<!------------------------------------------------------------------------------>
 
</body>
</html>

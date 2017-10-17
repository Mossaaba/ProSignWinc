 
 

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
<body class="hold-transition skin-blue sidebar-mini sidebar-toggle sidebar-collapse">
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
        Validation dispatching
     
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
     
      <!-- SELECT2 EXAMPLE -->
      <div class="box box-primary collapsed-box" data-target="id_box" data-name="id_box"  id="id_box"  style="width : 100%;" >
        <div class="box-header with-border" >
          <h3 class="box-title" >Modification <a  data-skin="skin-blue" class="btn btn-xs disabled ">
                  <i class="fa fa-edit"></i>                  
                  </a></h3>
           
           <div class="box-tools pull-right">
            
          </div>
          
        </div>
        <!-- /.box-header -->
        <div class="collapse" id="collapseExample"  >
          <div class="row">
		  <div class="col-md-12">
		
           <div class="col-md-4">
          
             <div class="form-group">
                <label>Technicine:</label>
                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-male"></i>
                  </div>
                  
                  <select id="newtechnicien" name="newtechnicien" class="form-control select2" style="width: 100%;">
                  <option value="-1" selected="selected">...</option>
                   <%
                  
                        for(int i=0;i<list_tech.size();i++)
                        {  String tt="";
                    	List tmp=(List)list_tech.get(i);
                    	
                     
                    	
                    	 if(tmp.get(0).toString().equalsIgnoreCase(forTemp.getid_technicien()))	
                         {
                         tt="selected=\"selected\""; //selection de l'option region
                         }
                        %>
       		                <option <%=tt%>  value="<%=tmp.get(0).toString()%>"><%=tmp.get(1).toString()%></option>
                   <%} %>
                </select>
                  
                </div>
                <!-- /.input group -->
              </div>

            </div>   
            
            <!-- /.col -->
            <div class="col-md-4">
         
             <div class="form-group">
                <label>Programmer le:</label>

                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input name="new_date_disp" type="text" value ="<%=forTemp.getDate_intervention()%>"class="form-control pull-right" id="datepicker">
                </div>
                <!-- /.input group -->
              </div>

            </div>   
            <div class="col-md-2" onclick="modif_dispatch('<%=forTemp.getId_intervention()%>')">
            
           <a class="btn btn-app btn-twitter">
                <i class="glyphicon glyphicon-ok" ></i> Valider
              </a>
            </div> 
            <div class="col-md-2" onclick="annuler_Modification_dispatch()">
            
               <a class="btn btn-app btn-google">
                <i class="glyphicon glyphicon-remove" ></i> Effacer
              </a>
            </div> 
            
                          <!-- /.col -->
          </div>
          </div>
      
		
		</div>
		</div>
		 </s:form> 

				  <!----------------------------------------------------------------------------->
				  <!-----------------------------------END   FORM ------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->

            <div class="box box-primary" style="width: 100%; position=center;">
 
              <div class="row" >
                
                <div class="col-xs-12 text-center" >
              <div class="box box-primary ">
            
              
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
					<%=" "+tmp.get(0).toString()+"  "%><span class="pull-right badge bg-red"><%=tmp.get(1).toString()%></span> 
			 
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







<!-- /.box -->

          <div class="box box-primary">
          
              <div class="box-header with-border text-center">
              <h3 class="box-title">
              <i class="glyphicon glyphicon-flash">
              </i>&nbsp;Liste de suivi de signalisation</h3>
              
            <div class="box-tools pull-right">
                
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                
              </div>
			  </div>
          
            
              
            
            <!-- /.box-header -->
            <div class="box-body with-border" >
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>WILAYA</th>
                  <th>CLIENT</th>
                  <th>AGENCE </th>
				  <th>DATE SIGNALISATION</th>
				  <th>PROGRAMMER</th>
				  <th>TECHNICIEN</th>
			      <th>SIGNALISATION</th>
			         <th> </th>
			         <th> </th>
				    <th> </th>
                </tr>
                </thead>
               

			   <tbody>
			     
			     <%
			     for(int i=0;i<list_dispatch.size();i++)
			     {
			    	 Table_Dispatch td=(Table_Dispatch)list_dispatch.get(i);
			    	 //bg-light-blue disabled color-palette
			    	 String zeb="";
			    	 if(td.getId_ticket().equalsIgnoreCase(id_ticket))
			    	 {
			    		 zeb="bg-light-blue disabled color-palette";
			    	 }
			     %>
                <tr class="<%=zeb%>" >
                 
                  <td><%=td.getNOM_WILAYA() %></td>
                  <td><%=td.getID_CLIENT() %></td>
                  <td><%=td.getNOM_AGENCE() %> </td>
				  <td><%=td.getDATE_SIGNALISATION() %></td>
				  <td><%=td.getPROGRAMMER() %></td>
				  <td><%=td.getNOM_TECHNICIEN() %></td>
				 <td><%=td.getTYPE_SIGNALISATION() %></td>
				<td nowrap="nowrap">
				<% if(td.getIndicateur_status().equalsIgnoreCase("0")&& td.getDATE_INTERVENTION()!=null)
				{
					%>
					<span class="fa fa-circle-o text-yellow"></span>
				<%	
				}%>
				</td>
				 <td nowrap="nowrap">
				
				 
				<span class="pull-right-container">
				
				<%
				
				if(td.getPROGRAMMER()==null ||td.getPROGRAMMER().isEmpty())
				{
					%>
					<small class="label pull-right bg-red">#</small>
				<%	
				}else 
					if(td.getEtat_Validation().equalsIgnoreCase("0") )
					{
						%>
						<small class="label pull-right bg-yellow">@</small>
					<%
					}else {
						%>
						<small class="label pull-right bg-green">&</small>
				<%
					}
				%>
				 
              
              
            
            
            </span>

				</td>
				 <td align="center" valign="middle" nowrap="nowrap">
				 <% if(!(td.getIndicateur_status().equalsIgnoreCase("0")&& td.getDATE_INTERVENTION()!=null))
				{
					%>
					<button type="button" id="button_1<%=td.getId_intervention()%>" class="btn-xs btn-social-icon btn-vk  disabled" onclick="modifier_intervention('<%=td.getId_intervention()%>','<%=td.getId_technicien()%>','<%=td.getPROGRAMMER()%>')">
				     <i class="glyphicon glyphicon-pencil" ></i>
				      </button>
				<%	
				} else if  (td.getPROGRAMMER()==null || td.getId_technicien().equalsIgnoreCase("0")) {
					
					%>
					<button type="button" data-toggle="myModalModif" data-target="#myModalModif" onclick="modifier_intervention('<%=td.getId_intervention()%>','<%=td.getId_technicien()%>','<%=td.getPROGRAMMER()%>')">
			     <i class="glyphicon glyphicon-pencil" ></i>
			      </button>
				
				
				<% }
				
				
				
				%>
                <button type="button" id="button_2<%=td.getId_intervention()%>" class="btn-xs btn-social-icon btn-google" data-toggle="modal" data-target="#myModal<%=td.getId_intervention()%>"   >
              <i class="glyphicon glyphicon-eye-open"></i>
            </button>
       
					             <button type="button" id="button_3<%=td.getId_intervention()%>" class="btn-xs btn-social-icon btn-dropbox" onclick="historique_ticket('<%=td.getId_ticket()%>')">
					               <i class="glyphicon glyphicon-th-list"></i>
								</button>
             

 
             
 <div class="modal modal-primary" id="myModal<%=td.getId_intervention()%>" role="dialog">
 
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content" >
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Description détaillées</h4>
        </div>
        <div class="box box-solid">
            <div class="box-header with-border">
              <i class="fa fa-map"></i>

              <h3 class="box-title">Emplacement</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <dl class="dl-horizontal">
                <dt> Region</dt>
                <dd><%=td.getREGION() %></dd>
                <dt>Wilaya</dt>
                <dd><%=td.getNOM_WILAYA() %></dd>
                <dt>Ville</dt>
                <dd><%=td.getNOM_VILLE() %></dd>
            <div class="box-header with-border">
              <i class="fa fa-codepen"></i>

              <h3 class="box-title">Machine</h3>
            </div>
                <dt>Type Machine</dt>
                <dd><%=td.getType_machine() %></dd>
                <dt>Reference Machine</dt>
                <dd><%=td.getRefrence_machine() %></dd>
                <div class="box-header with-border">
              <i class="fa fa-warning"></i>

              <h3 class="box-title">Machine</h3>
            </div>
                <dt>Description du Problem </dt>
                <dd><%=td.getDESCRIPTION_SIGNALISATION() %></dd>
                <dt>Remarque</dt>
                <dd><%=td.getREMARQUE() %></dd>
              </dl>
            </div>
            <!-- /.box-body -->
          </div>
        <div class="modal-footer">
          <button type="button" class="btn-xs btn-default" data-dismiss="modal">Fermer</button>
        </div>
      </div>
      
    </div>
    </div>

    <div class="modal text-center" id="myModalModif" role="dialog">
    <div class="box-body text-center">
     <div class="alert alert-warning alert-dismissible">
			  <button type="button" class="close" data-dismiss="modal" aria-hidden="false">&times;</button>
			  <h4><i class="icon fa fa-warning"></i> Attention!</h4>
			  Vous devez attribuer un technicien et une date d'intervention , pour que vous puissiez la modifier 
	</div>
	</div>
     </div>
   
 
    
               
   
 
      
      
  
             
             
              <% String dis="" ; 
              
              if(td.getEtat_Validation().equalsIgnoreCase("1"))//si ell n pa valider
              {
            	  
            	  %> 
            	   <i class="glyphicon glyphicon-ok"></i>
            	   <% }
              else{ %> 
        <% if(!(td.getIndicateur_status().equalsIgnoreCase("0")&& td.getDATE_INTERVENTION()!=null))// si pa nouvelle affectation
				{
					%>
					<button type="button"  id="button_4<%=td.getId_intervention()%>" class="btn-xs btn-social-icon btn-twitter"  onclick="valider_intervention('<%=td.getId_intervention()%>','<%=td.getNOM_TECHNICIEN()%>','<%=td.getPROGRAMMER()%>')">
					<i class="glyphicon glyphicon-ok"></i>
					</button>
				<%	
				}%>
            
            
            
				  <% }%> 
				 
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
          <!-- /.box -->
          


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


 
 
  <s:if test="#session.ranifimodif!=null">
<script>
$('#collapseExample').collapse({
	  toggle: true
	});

 
 
</script>
 
<%session.removeAttribute("ranifimodif");
 
%>


<%session.removeAttribute("ranifimodif");
 
%>

</s:if>

 <%
 session.setAttribute("id_ticket","");
%>
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
  

  
 
 
  
  function modifier_intervention (Id_intervention,Id_technicien,date_intervention)
  {
	  
	  
	  
		   
  document.getElementById('Id_intervention').value=Id_intervention;
  document.getElementById('Id_technicien').value=Id_technicien;
  document.getElementById('date_intervention').value=date_intervention;
  
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


function modif_dispatch (Id_intervention)

{
	
  
 document.getElementById('Id_intervention').value=Id_intervention;
document.getElementById('f1').action="modif_dispatch?methodtocall=modif_dispatch";
document.getElementById('f1').submit();
	 

}

function valider_intervention (Id_intervention,tec,dat)
{ 
	 if(tec=='null' ||dat=='null')
		 {
		 $('#myModal2').modal({
			  keyboard: false
			}) 
		 
		 }else{
			 
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

</script>    

 
</body>
</html>

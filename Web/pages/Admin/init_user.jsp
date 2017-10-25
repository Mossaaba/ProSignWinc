<%@page import="com.ProSign.Object.Tableau_Sign_Details"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ProSign.Object.*" %>
<%@ page import="com.ProSign.Dispatch.*" %> 
<%
 


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
<body class="hold-transition skin-blue sidebar-mini   ">
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
				
                   <s:form action="/User.action" method="POST" id="f1" target="_parent"> 
     
          
     
    	  <section class="content">
      <div class="row">
		
		  
        <div class="col-md-6">
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Reinitialiser le mot de passe d'un utilisateur</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form">
              <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputEmail1">ID</label>
                  <input type="text" class="form-control" id="id_user_reini" placeholder="ID utilisateur" name="id_user_reini">
                </div>
                
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                 <button type="button" onclick="initPassword_User()" class="btn btn-primary   btn-flat">Ok</button>
              </div>
            </form>
          </div>
          <!-- /.box -->

       
              

        

        </div>
		
		
		 </div>
		
		 </section>
		 </s:form> 
		 
		          <!----------------------------------------------------------------------------->
				  <!--------------fin Modification Interventioin  ------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->
		        

				  <!----------------------------------------------------------------------------->
				  <!-----------------------------------END   FORM ------------------------------->
				  <!----------------------------------------------------------------------------->
				  <!----------------------------------------------------------------------------->
				  
				 

	      
      
      </div>
 <jsp:include page="/pages/tiles/footer.jsp" />

  
  </div>

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
  

 
 
     
function initPassword_User() 
{
 

document.getElementById('f1').action="initPassword_User?methodtocall=initPassword_User";
	

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

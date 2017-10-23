<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
 
<% 
 
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>ProSign | Log in </title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/iCheck/square/blue.css">
  
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page text-center">
 <s:form action="/acces.action" method="POST" id="f1" target="_parent">
 <div class="container  center-block ">
<div class="login-box text-center">
  <div class="login-logo center-block">
  <h1>
    <a href="#" ><i class="glyphicon glyphicon-flash"></i><b>Pro</b>SIGN</a></h1>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body ">
             <img src="dist/img/logo.svg" class="img-responsive center-block" style="width:70%" > <br>   
    <p class="login-box-msg">Connectez-vous pour ouvrire votre session</p>
    <form action="starter.html" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="ID Utilisateur" name="id_user">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="mot de passe" name="pass">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        
        <!-- /.col -->
        <div class="col-md-12">
          <button onclick="acces()" class="btn btn-primary btn-block btn-flat"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;Se connecter</button> <br> 
        </div>
        <!-- /.col -->
      </div>
    </form>

    
    <!-- /.social-auth-links -->
 
  
     
    <s:if test="#session.connectError!=null">
    <s:if test="#session.connectError==1">
    <div class="alert alert-danger alert-dismissible">
     <h4><i class="icon fa fa-ban"></i> Alert!</h4>
     Veuillez renseigner votre identifiant et un mot de passe.
     </div>
    		
    </s:if>
      <s:if test="#session.connectError==2">
      
      <div class="alert alert-danger alert-dismissible">
     <h4><i class="icon fa fa-ban"></i> Alert!</h4>
     Veuillez renseigner votre mot de passe.
     </div>
    		
    </s:if>
    
    <s:if test="#session.connectError==3">
    <div class="alert alert-danger alert-dismissible">
     <h4><i class="icon fa fa-ban"></i> Alert!</h4>
     L'utilisateur n'existe pas.
     </div>
    		
    </s:if>
    
    
     <s:if test="#session.connectError==4">
     <div class="alert alert-danger alert-dismissible">
     <h4><i class="icon fa fa-ban"></i> Alert!</h4>
     L'utilisateur est bloqué
     </div>
    		
    </s:if>
    
      <s:if test="#session.connectError==5">
      <div class="alert alert-danger alert-dismissible">
     <h4><i class="icon fa fa-ban"></i> Alert!</h4>
     Votre mot de passe est incorrecte
     </div>
    		
    </s:if>
    
      <s:if test="#session.connectError==7">
       <div class="alert alert-danger alert-dismissible">
     <h4><i class="icon fa fa-ban"></i> Alert!</h4>
     Erreur connection BD
     </div>
    		
    </s:if>
    
        <%session.removeAttribute("connectError")  ;%>
      </s:if>
      
      
  
  </div>
 
</div>
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
  
  function acces()
{
 
 document.getElementById('f1').submit();

}
</script>

</s:form>

</body>
</html>

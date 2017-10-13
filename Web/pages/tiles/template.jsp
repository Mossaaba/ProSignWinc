<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
  <head>
    <title><tiles:getAsString name="titre"/></title>
  </head>
  <body>
  
  
  <frameset >
  
  	<tiles:insertAttribute name="header" />
  </frameset>
  
  <frameset>
  <frame>
  <tiles:insertAttribute name="body" />
  <frame>
  </frameset>
  
  <frameset>
 <tiles:insertAttribute name="footer" />
  </frameset>
  
  
       
  </body>
</html>
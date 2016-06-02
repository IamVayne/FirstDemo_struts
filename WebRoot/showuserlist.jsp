<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>showuserlist.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1>用户列表：</h1><br/>
  	<table border="1px" width="500px">
  	<tr><td>name</td><td>photo</td></tr>
  	
  	<c:forEach items="${userlists }" var="user">
  		<tr><td>${user.name }</td><td><img src="/FileupAndLoad/picture/${user.goalfilename }" width="50px"/><a href="/FileupAndLoad/download.do?username=${user.name }">点击下载</a></td></tr>
  	</c:forEach>
  	
  	</table>
  </body>
</html:html>

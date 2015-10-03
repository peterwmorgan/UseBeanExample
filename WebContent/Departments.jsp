<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean class="net.netxtra.backingbean.Departments" id="dept"/>
<%
	dept.setSession(request.getSession());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
    <%@include file="/WEB-INF/global.css" %>
</style>
<%--  -->link rel="stylesheet" href="/UseBeanExample/global.css" type="text/css"/--%>

<title>${dept.pageTitle}</title>
</head>
  <body>
  <form action="./Countries.jsp" method="get" name="testform">
   	<div id="headline1">
    <div class="title">${dept.pageTitle}</div>
    <span class="subtitle">${dept.pageSubTitle}</span> </div>
	<div id="navtoplistline">&nbsp;</div>
  <div id="contentwrapper">
    <div id="maincolumn">
      <div class="text">
        <h2>${dept.pageNarrativeHeading}</h2>
        <p><img class="img-left" src="${dept.pageNarrativeImage}" width="150" height="110" alt="" />${dept.pageNarrative}</p>
        <p><a href="http://www.netxtra.net/">Click here for NetXtra</a></p>
        <hr/>
         <input type="submit" value="Countries" />
        <p><strong>${dept.pageBlockQuoteHeading}</strong></p>
        <blockquote>${dept.pageBlockQuoteNarrative}</blockquote>
        <div id="navtoplistline">&nbsp;</div>
        <p><strong>${dept.pageListHeading}</strong></p>
        <ul>
        <c:forEach items="${dept.departmentList}" var="current">
        	<li><c:out value="${current.departmentName}" /><li>
        </c:forEach>
        </ul>
        <p>Quisque vehicula, justo id placerat sodales, metus justo semper magna, vel condimentum dolor nunc eu felis. Praesent semper purus vel sapien. Vivamus condimentum magna quis est. Pellentesque feugiat viverra metus. Sed ac nisl. Donec ut nunc. Suspendisse tellus dolor, malesuada id, fringilla non, pellentesque at, nunc.</p>
      </div>
      <div id="footer">&copy; Copyright 2015 by <a href="http://www.netxtra.net">NetXtra</a></div>
   </div>
  </div>
 </form>
 </body>
</html>

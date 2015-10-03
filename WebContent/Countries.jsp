<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean class="net.netxtra.backingbean.Countries" id="country"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>>${country.pageTitle} here</title>
</head>
<body>

 <table width="40%" cellpadding="5" bordercolor="#000066" bgcolor="#FFFFFF" border="1" cellspacing="0">
      <tr>
      <td>Country</td>
      <td></td>
      <td>Region Id</td>
      </tr>
      <c:forEach items="${country.countryList}" var="current">
        <tr>
          <td><c:out value="${current.countryName}" /><td>
          <td><c:out value="${current.countryId}" /><td>
        </tr>
      </c:forEach>
    </table>
</body>
</html>
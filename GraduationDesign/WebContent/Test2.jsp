<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--    c标签要使用,那么就必须要有它 ${pageContext.request.contextPath}-->
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set scope="page" var="url"
    value="${pageContext.request.contextPath }"> </c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">    
    <title>My JSP 'MyJsp.jsp' starting page</title>    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${url}/Graduation/getPostService" method="post">  
<table>
<tr><td>标题</td><td><input type="text" name="POSTNAME" size=30></td></tr>
<tr><td>内容</td><td><textarea name="CONTENT" cols="30" rows="5"></textarea></tr>	
<tr>
<td colspan="2" align="right"><input type="submit"  value="发布"></td>
</tr>   
</table>  
</form>  
</body>
</html>
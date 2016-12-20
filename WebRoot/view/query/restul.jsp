<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
   <body>
    <form action="<%=basePath%>/ClientTest/QuerySchool" method="post">
    	<table >
    		<tr >
    			<td width="350;">方法名称:<input type="text" value="QRY_SCHOOL" name="action"></td>
    			<td   width="350;">应用key:<input type="text" value="f0540fd7efa44d44a71af93407bfd160" name="appKey"></td>
    			<td  width="350;">第三方系统账号:<input type="text" value="" name="tloginName"></td>
    		</tr>
    		<tr >
    			<td width="350;">  大数据系统账号:<input type="text" value="" name="ssoLoginName"></td>
    			<td  width="350;">时间戳:<input type="text" value="20150602142057" name="timeStamp"></td>
    			<td  width="350;">业务参数体:<input type="text" value="{SchoolName:东区起湾小学 }" name="paraBody"></td>
    		</tr>
    	</table>
    	<input type="submit" value="查询学校提交">
    </form>
  </body>
  </body>
</html>

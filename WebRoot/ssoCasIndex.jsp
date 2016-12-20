<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
	<script language="JavaScript" src="resource/js/jquery-1.8.2.min.js"></script>
	<script language="JavaScript" src="resource/js/interfaceManage/casTicket.js"></script>
	<script type="text/javascript"> 
     $(document).ready(function() { 
    	submitCas();
    	
	});  
	
 //表单提交
	function submitCas(){
		if ($.trim($('#username').val()).length == 0 ){   //获取文本框的用户名
            alert("用户名不能为空。");  
        } else if ($.trim($('#password').val()).length == 0 ){  //获取密码框的用户名
            alert("密码不能为空。");  
        } 
       	var userName=$.trim($('#username').val());
       	var password=$.trim($('#password').val());
       		//调用casTicket.js的getCasTicket方法，返回3个参数casUrl、casTicket、execution
			getCasTicket(function (casUrl,casTicket,execution){//到大数据平台的cas系统获取loginTicket令牌;必须要用ajax获取，因为令牌基于浏览器的cookies
			if (casTicket.length == 0){  
	            alert("服务器正忙，请稍后再试..");  
	            return false;  
        	}
        	//调用大数据接口管理系统的用户登录的验证方法
			 window.location.href = "http://202.96.186.112:8089/QueryInterfaceManage/forwardCas?casUrl="+casUrl+"&loginTicket="+casTicket+"&execution="+execution+"&userName="+userName+"&password="+password;
		});
	}
    
	
	</script>
  </head>
  
  <body>
  <form id="myLoginForm"  action="#" method="post">
			<input type="hidden" name="_eventId" value="submit" />
			<input type="hidden" name="isajax" value="true" />  
			<input type="hidden" name="isframe" value="true" /> 
			<input type="hidden" name="execution" id="execution" value="">
			<input type="hidden" name="lt" id="lt" value="">
			<input type="hidden" name="loginerror" id="loginerror" value="http://202.96.187.34/">
			<table>
				<tr>   
				 	<td>用户名:</td>    
				 	<td>
					 	<input type="text" value="admin" name="username" id="username">
					</td>
					<td>密码:</td>    
				 	<td><input type="text" value="123456@abc" name="password" id="password"></td>
				 	<td align="right" colspan="1"><input type="button" value="登录" onclick="submitCas();"/></td>
				 </tr>
				 <tr>    
					 <td align="right" colspan="2"><input type="button" value="退出" onclick="logout();"/></td>
				 </tr>
			 </table>
		 </form>
  </body></html>

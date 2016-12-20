<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
	<script language="JavaScript" src="resource/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript"> 
	//cas验证成功后要跳转的地址,此地址是大数据平台的配置好的第三方地址auth.zsedu.net   http://192.168.10.77:8080/redirectSys/41?type=3
	//var service = "service=" + encodeURIComponent("http://202.96.186.112:8080/redirectSys/63?type=3");  
	var service = "service=" + encodeURIComponent("http://127.0.0.1:8080/redirectSys/41?type=3");  
	//cas的登录地址+大数据平台的配置好的第三方地址
     //var casUrl = "http://202.96.186.112:8001/cas/login?"+service;
     var casUrl = "http://127.0.0.1:8001/cas/login";
    $(document).ready(function() { 
    	 $.ajax({
			type : "post",
			//url : casUrl+"&n="+ new Date().getTime()+"&get-lt=true",//跳转到cas的ProvideLoginTicketAction获取loginTicket和flowExecutionKey值回来赋给lt和execution文本框
			url : "http://localhost:8089/ClientTest/alipayforward",//跳转到cas的ProvideLoginTicketAction获取loginTicket和flowExecutionKey值回来赋给lt和execution文本框
			dataType : "json",
			success : function(data) {
				alert(data+"----****---"+data._loginTicket);
				$("#lt").val(data._loginTicket);
				$("#execution").val(data._execution);
			}
		}); 
	}); 
 //表单提交
	function submitCas(){
		//表单验证
		if ($.trim($('#username').val()).length == 0 ){  
            alert("用户名不能为空。");  
        } else if ($.trim($('#password').val()).length == 0 ){  
            alert("密码不能为空。");  
        }else if ($('#lt').val().length == 0){  
            alert("服务器正忙，请稍后再试..");  
            return false;  
        }
        //表单提交,表单提交时必须要带上loginTicket、flowExecutionKey、用户名、密码到cas的验证库验证
     	$('form').attr("action",casUrl+service);
     	$('form').submit(); 
	}
    
	/**
	注销或退出系统
	**/
	function logout(){
		window.location.href = "http://202.96.186.112:8001/cas/logout?service=http://192.168.10.77:8089/";
	}
	</script>
  </head>
  
  <body>
  <form id="myLoginForm"  action="#" method="post">
			<!-- <input type="hidden" name="_eventId" value="submit" />
			<input type="hidden" name="isframe" value="true" /> 
			<input type="hidden" name="execution" id="execution" value=""> -->
			<input type="hidden" name="isajax" value="true" />  
			<input type="text" name="lt" id="lt" value="">
			<input type="hidden" name="loginerror" id="loginerror" value="http://202.96.187.34/">
			<table>
				<tr>   
				 	<td>用户名:</td>    
				 	<td>
					 	<input type="text" value="" name="username" id="username">
					</td>
					<td>密码:</td>    
				 	<td><input type="text" value="123456@abc" name="password" id="password"></td>
				 	<td align="right" colspan="1"><input type="button" value="登录" onclick="submitCas();"/></td>
				 </tr>
				<!--  <tr>    
					 <td align="right" colspan="2"><input type="button" value="退出" onclick="logout();"/></td>
				 </tr> -->
			 </table>
		 </form>
  </body>
</html>

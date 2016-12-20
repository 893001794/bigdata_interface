<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
	<script language="JavaScript" src="resource/js/jquery-1.8.2.min.js"></script>
<!-- 	<script language="JavaScript" src="resource/js/global/jquery.min.js"></script> -->
	<script language="JavaScript" src="resource/js/interfaceManage/jqueryManage.js"></script>
	<script type="text/javascript">
		function updateClass(){
			// --------------------------------------------------------------------
			$.ajax({type : "POST",
				dataType : "json",
				url :"http://202.96.186.112:8089/ClientTest/updateClass",
				data:$('#pushMsgForm').serialize(),
				success : function(result) {
					var data=eval(result);
					alert(data+"-----------***"+data.code+"---***"+data.resMsg);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(textStatus);
	//					alert("查询学校信息错误");
				}
			});
			// --------------------------------------------------------------------
		}
		function updateGrade(){
			// --------------------------------------------------------------------
			$.ajax({type : "POST",
				dataType : "json",
				url :"http://202.96.186.112:8089/ClientTest/updateGrade",
				data:$('#pushMsgForm').serialize(),
				success : function(result) {
					var data=eval(result);
					alert(data+"-----------***"+data.code+"---***"+data.resMsg);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(textStatus);
	//					alert("查询学校信息错误");
				}
			});
			// --------------------------------------------------------------------
		}
		
		
		/**
		 *接口绑定查询
		 */
		function queryUserInfo(){
			// --------------------------------------------------------------------
			$.ajax({type : "POST",
				dataType : "json",
				url :"http://localhost:8080/ClientTest/querySSOConfig",
				data:$('#queryUserInfoForm').serialize(),
				success : function(result) {
					//解析json{"code":"1","resMsg":"成功获取东区起湾小学学校信息成功！","data":{"schoolName":"东区起湾小学","orgName":"东区教办","areaName":"东区","schoolLevel":"幼儿园","schoolType":"民办"}}
					alert("****"+result.result);
					var data=eval(result.product_list);
					$('#getresult').text("code:"+"\n"+"resMsg:"+data.resMsg+"\n"+"--第三方应用账号:"+data.data);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("------"+XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);
//						alert("查询学校信息错误");
				}
			});
			// --------------------------------------------------------------------
		}
		
		
		
		function queryAppInfo(){
			// --------------------------------------------------------------------
			$.ajax({type : "POST",
				dataType : "json",
				url :"http://localhost:8080/ClientTest/querySSOConfig",
				data:$('#queryAppInfoForm').serialize(),
				success : function(result) {
					var data=eval(result);
					alert(data);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(textStatus);
	//					alert("查询学校信息错误");
				}
			});
			// --------------------------------------------------------------------
		}
		
		function resStatistics(){
			// --------------------------------------------------------------------
			$.ajax(
				{type : "POST",
				url :"http://192.168.32.128:8080/insideInterfaceApi/resStatistics",
				dataType : 'jsonp',
				//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback) 
				jsonp: "callback",
				data:$('#resStatisticsForm').serialize(),
				//自定义的jsonp回调函数名称"jsonpCallback"，返回的json也必须有这个函数名称
				jsonpCallback:"callback",
				success : function(result) {
					var data=eval(result);
					alert(data);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("--------------"+textStatus);
	//					alert("查询学校信息错误");
				}
			});
			// --------------------------------------------------------------------
		}
		
		/**
		 *接口绑定查询
		 */
		var service = "service=" + encodeURIComponent("http://192.168.17.7:8080/redirectSys/41?type=3");  
		//cas的登录地址+大数据平台的配置好的第三方地址
     	var casUrl = "http://192.168.17.7:8001/cas/login?"+service;
		function queryLoginTicket(){
			// --------------------------------------------------------------------
			$.ajax({type : "POST",
				dataType : "json",
				url :"http://192.168.17.7:8089/big_interface/ClientTest/alipayforward?service="+encodeURIComponent("http://192.168.17.7:8080/redirectSys/41?type=3"),
				success : function(result) {
					var data=eval(result);
					alert(data.data._loginTicket);
					$("#lt").val(data.data._loginTicket);
					$("#execution").val(data.data._execution);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("------"+XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);
//						alert("查询学校信息错误");
				}
			});
			// --------------------------------------------------------------------
		}
		
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
     	$('#myLoginForm').attr("action",casUrl);
     	$('#myLoginForm').submit(); 
	}
	</script>
  </head>
  
  <body>
   <!--/ClientTest/QuerySchool  -->
   <input type="button" onclick="updateGrade()" value="更改年级级">
   <input type="button" onclick="updateClass()" value="更改班级">
   <h4>获取学校信息</h4>
   <div style="border: 1 solid red;">
	   <form id="querySchoolForm"  action="" method="post">
	    	<table >
	    		<tr >
	    			<td width="350;">方法名称:<input type="text" value="QRY_SCHOOL" name="action"></td>
	    			<td   width="350;">应用key:<input type="text" value="c894c5775b324274b1fc966285338360" name="appKey"></td>
	    			<td  width="350;">第三方系统账号:<input type="text" value="hewenwei" name="tloginName"></td>
	    		</tr>
	    		<tr >
	    			<td width="350;">  大数据系统账号:<input type="text" value="admin" name="ssoLoginName"></td>
	    			<td  width="350;">时间戳:<input type="text" value="20150602142057" name="timeStamp"></td>
	    			<td  width="350;">业务参数体:<input type="text" value="{SchoolName:东区起湾小学 }" name="paraBody"></td>
	    		</tr>
	    	</table>
	    	<br>
	    	<input type="button" onclick="querySchool()" value="查询学校">
	    </form>
    </div>
    <hr>
    <h4>获取家长信息</h4>
     <form id="queryFamliyForm"  action="" method="post">
    	<table >
    		<tr >
    			<td width="350;">方法名称:<input type="text" value="QRY_FAMLIY" name="action"></td>
    			<td   width="350;">应用key:<input type="text" value="143f34b68bda4fe4bed5c0b0e04a298f" name="appKey"></td>
    			<td  width="350;">第三方系统账号:<input type="text" value="hewenwei" name="tloginName"></td>
    		</tr>
    		<tr >
    			<td width="350;"> 大数据系统账号:<input type="text" value="admin" name="ssoLoginName"></td>
    			<td  width="350;">时间戳:<input type="text" value="20150602142057" name="timeStamp"></td>
    			<td  width="350;">业务参数体:<input type="text" value="201407846" name="paraBody"></td>
    		</tr>
    	</table>
    	<br>
    	<input type="button" onclick="queryFamliy()" value="查询家长">
    </form>
    <hr>
    <h4>获取学生信息</h4>
     <form id="queryStudentForm"  action="" method="post">
    	<table >
    		<tr >
    			<td width="350;">方法名称:<input type="text" value="QRY_STUDENT" name="action"></td>
    			<td   width="350;">应用key:<input type="text" value="143f34b68bda4fe4bed5c0b0e04a298f" name="appKey"></td>
    			<td  width="350;">第三方系统账号:<input type="text" value="hewenwei" name="tloginName"></td>
    		</tr>
    		<tr >
    			<td width="350;"> 大数据系统账号:<input type="text" value="admin" name="ssoLoginName"></td>
    			<td  width="350;">时间戳:<input type="text" value="20150602142057" name="timeStamp"></td>
    			<td  width="350;">业务参数体:<input type="text" value="512079281" name="paraBody"></td>
    		</tr>
    	</table>
    	<br><br>
    	<input type="button" onclick="queryStudent()" value="查询学生">
    </form>
    <hr>
    <h4>获取老师信息</h4>
     <form id="queryTeacherForm"  action="" method="post">
    	<table >
    		<tr >
    			<td width="350;">方法名称:<input type="text" value="QRY_TEACHER" name="action"></td>
    			<td   width="350;">应用key:<input type="text" value="c894c5775b324274b1fc966285338360" name="appKey"></td>
    			<td  width="350;">第三方系统账号:<input type="text" value="hewenwei" name="tloginName"></td>
    		</tr>
    		<tr >
    			<td width="350;"> 大数据系统账号:<input type="text" value="admin" name="ssoLoginName"></td>
    			<td  width="350;">时间戳:<input type="text" value="20150602142057" name="timeStamp"></td>
    			<td  width="350;">业务参数体:<input type="text" value="196511947" name="paraBody"></td>
    		</tr>
    	</table>
    	<br>
    	<input type="button" onclick="queryTeacher()" value="查询教师">
    </form>
    <hr>
    <h4>查询用户绑定接口</h4>
     <form id="querySSOConfigForm"  action="" method="post">
    	<table >
    		<tr >
    			<td width="350;">方法名称:<input type="text" value="CHECK_USER" name="action"></td>
    			<td   width="350;">应用key:<input type="text" value="1997f30d3b9645298888daf86f9531c0" name="appKey"></td>
    			<td  width="350;">第三方系统账号:<input type="text" value="" name="tloginName"></td>
    		</tr>
    		<tr >
    			<td width="350;"> 大数据系统账号:<input type="text" value="admin" name="ssoLoginName"></td>
    			<td  width="350;">时间戳:<input type="text" value="20150602142057" name="timeStamp"></td>
    			<td  width="350;">业务参数体:<input type="text" value="" name="paraBody"></td>
    		</tr>
    	</table>
    	<br>
    	<input type="button" onclick="querySSOConfig()" value="查询接口绑定">
    </form>
    <hr>
    <h4>查询组织接口</h4>
     <form id="queryOrgForm"  action="" method="post">
    	<table >
    		<tr >
    			<td width="350;">方法名称:<input type="text" value="QRY_ORG" name="action"></td>
    			<td   width="350;">应用key:<input type="text" value="3f6d1ad8a9e24979bffb684100701b34" name="appKey"></td>
    		</tr>
    		
    	</table>
    	<br>
    	<input type="button" onclick="queryOrg()" value="查询组织绑定">
    </form>
    <h4>查询根据组织查询学校接口</h4>
     <form id="querySchoolByOrgForm"  action="" method="post">
    	<table >
    		<tr >
    			<td width="350;">方法名称:<input type="text" value="QRY_SCHOOLBYORG" name="action"></td>
    			<td   width="350;">应用key:<input type="text" value="3f6d1ad8a9e24979bffb684100701b34" name="appKey"></td>
    		</tr>
    		<tr >
    			<td  width="350;">业务参数体:<input type="text" value="{orgId:10}" name="paraBody"></td>
    		</tr>
    	</table>
    	<br>
    	<input type="button" onclick="querySchoolByOrg()" value="查询学校绑定">
    </form>
    
    <h4>推送消息接口</h4>
     <form id="pushMsgForm"  action="" method="post">
    	<table >
    		<tr >
    			<td width="350;">方法名称:<input type="text" value="PUSH_MSG" name="action"></td>
    			<td   width="350;">应用key:<input type="text" value="c894c5775b324274b1fc966285338360" name="appKey"></td>
    			<td  width="350;">第三方系统账号:<input type="text" value="hewenwei" name="tloginName"></td>
    		</tr>
    		<tr >
    			<td width="350;"> 大数据系统账号:<input type="text" value="admin" name="ssoLoginName"></td>
    			<td  width="350;">时间戳:<input type="text" value="20150602142057" name="timeStamp"></td>
    			<td  width="350;">业务参数体:<input type="text" value="{LoginName:admin,Title:暑假学生安全注意事项,MessageContent:各位老师，接下来面临的是暑假安全问题，务必要将安全事项告诉学生和家长...,MessageURL:http://www.baidu.com,OthMsgId:1,ValidDate:2015-09-31}" name="paraBody"></td>
    		</tr>
    	</table>
    	<br>
    	<input type="button" onclick="qushMsg()" value="消息推送接口">
    </form>
    
     <h4>获取用户信息</h4>
     <form id="queryUserInfoForm"  action="" method="post">
    	<table >
    		<tr >
    			<td width="350;">方法名称:<input type="text" value="QRY_USERINFO" name="action"></td>
    			<td   width="350;">应用key:<input type="text" value="2cf983bd706046b4bea0621ea58bbe1a" name="appKey"></td>
    		</tr>
    		<tr >
    			<td width="350;"> 大数据系统账号:<input type="text" value="admin" name="ssoLoginName"></td>
    			<td  width="350;">时间戳:<input type="text" value="20150602142057" name="timeStamp"></td>
    		</tr>
    	</table>
    	<br>
    	<input type="button" onclick="queryUserInfo()" value="获取用户信息接口">
    </form>
    <h4>获取应用信息</h4>
     <form id="queryAppInfoForm"  action="" method="post">
    	<table >
    		<tr >
    			<td width="350;">方法名称:<input type="text" value="QRY_APPINFO" name="action"></td>
    			<td   width="350;">应用key:<input type="text" value="2cf983bd706046b4bea0621ea58bbe1a" name="appKey"></td>
    		</tr>
    		<tr >
    			<td width="350;"> 大数据系统账号:<input type="text" value="admin" name="ssoLoginName"></td>
    			<td  width="350;">时间戳:<input type="text" value="20150602142057" name="timeStamp"></td>
    		</tr>
    	</table>
    	<br>
    	<input type="button" onclick="queryAppInfo()" value="获取应用信息接口">
    </form>
    
     <h4>资源管理平台统计功能</h4>
     <form id="resStatisticsForm"  action="" method="post">
     	<input type="hidden" id="operationType" name="operationType" value="1">
     	<input type="hidden" id="appCode" name="appCode" value="spw">
     	<input type="hidden" id="operationData" name="operationData" value="">
     	<input type="hidden" id="operationPeople" name="operationPeople" value="admin">
     	<input type="hidden" id="operationIp" name="operationIp" value="192.168.32.77">
     	<input type="hidden" id="fileId" name="fileId" value="1132">
    	<table >
    		<tr >
    			<td width="350;">方法名称:<input type="text" value="resStatistics" name="action"></td>
    			<td   width="350;">应用key:<input type="text" value="359a330a076c492392637223cd49781e" name="appKey"></td>
    		</tr>
    	</table>
    	<br>
    	<input type="button" onclick="resStatistics()" value="资源管理统计推送接口">
    </form>
    <h4>cas自定义页面</h4>
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
    	<input type="button" onclick="queryLoginTicket()" value="获取LoginTicket">
    结果集：<div id="getresult" style="border: 1 solid red;height: 150" ></div>
    </br>
    </br>
    <a href="http://www.spm-edu.com/Services/RedirectAppByUser?request_id=1&app_code=1&operators_code=ZSJYQT&hashcode=7F23CE2AD1ACDA10A56F1D21912FFE2D" target="_blank">go南方云教育</a>
    </br>
    <input type="button" value="获取用户信息" onclick="getUserInfo('32001');">
   
  </body>
</html>

	//cas验证成功后要跳转的地址,此地址是大数据平台的配置好的第三方地址auth.zsedu.net   http://192.168.10.77:8080/redirectSys/41?type=3
	//var service = "service=" + encodeURIComponent("http://192.168.17.7:8080/redirectSys/41?type=3");  
	//cas的登录地址+大数据平台的配置好的第三方地址
    //var casUrl = "http://192.168.17.7:8001/cas/login?"+service;
	var service = "service=" + encodeURIComponent("http://202.96.186.112:8080/redirectSys/63?type=3");  
	//cas的登录地址+大数据平台的配置好的第三方地址
     var casUrl = "http://202.96.186.112:8001/cas/login?"+service;
    /**
     * 信息港门户获取大数据管理平台的令牌
     */
	function getCasTicket(callback){//callback是回调函数
		 $.ajax({
			type : "post",
			url : casUrl+"&n="+ new Date().getTime()+"&get-lt=true",//跳转到cas的ProvideLoginTicketAction获取loginTicket和flowExecutionKey值回来赋给lt和execution文本框
			dataType : 'jsonp',
			async: true,
			cache : false, 
			//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback) 
			jsonp: "callback",
			//自定义的jsonp回调函数名称"jsonpCallback"，返回的json也必须有这个函数名称
			jsonpCallback:"callback",
			success : function(data) {
				var casTicket=data._loginTicket;
				var execution=data._execution;
				callback(casUrl,casTicket,execution);////回调函数的方法，并且将参数返3个参数回出去
			}
		}); 
	}
	
	/**
	注销或退出系统
	**/
	function logout(){
		window.location.href = "http://202.96.186.112:8001/cas/logout?service=http://www.zsedu.net/";
	}
	
	
	
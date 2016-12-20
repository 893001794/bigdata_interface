	var url="http://localhost:8080/";
	function getUserInfo(userId){
			// --------------------------------------------------------------------
			$.ajax({type : "GET",
				dataType : "json",
				url :"Services/GetUserInfo?request_id="+userId,
				success : function(result) {
					//解析json{"code":"1","resMsg":"成功获取东区起湾小学学校信息成功！","data":{"schoolName":"东区起湾小学","orgName":"东区教办","areaName":"东区","schoolLevel":"幼儿园","schoolType":"民办"}}
					var data=eval(result.product_list);
					alert(result.data);
					//$('#getresult').text("code:"+"\n"+"resMsg:"+data.resMsg+"\n"+"--第三方应用账号:"+data.data);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);
	//					alert("查询学校信息错误");
				}
			});
			// --------------------------------------------------------------------
		}
	/**
	 *接口绑定查询
	 */
	function querySSOConfig(){
		// --------------------------------------------------------------------
		$.ajax({type : "POST",
			dataType : "json",
			url :url+"/ClientTest/querySSOConfig"+param,
			data:$('#querySSOConfigForm').serialize(),
			success : function(result) {
				//解析json{"code":"1","resMsg":"成功获取东区起湾小学学校信息成功！","data":{"schoolName":"东区起湾小学","orgName":"东区教办","areaName":"东区","schoolLevel":"幼儿园","schoolType":"民办"}}
				alert(result.result);
				var data=eval(result.product_list);
				$('#getresult').text("code:"+"\n"+"resMsg:"+data.resMsg+"\n"+"--第三方应用账号:"+data.data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
//					alert("查询学校信息错误");
			}
		});
		// --------------------------------------------------------------------
	}
	/**
	 * 学校查询
	 */
	function querySchool(){
		// --------------------------------------------------------------------
		$.ajax({type : "POST",
				dataType : "json",
				url :url+"/ClientTest/QuerySchool",
				data:$('#querySchoolForm').serialize(),
				success : function(result) {
					//解析json{"code":"1","resMsg":"成功获取东区起湾小学学校信息成功！","data":{"schoolName":"东区起湾小学","orgName":"东区教办","areaName":"东区","schoolLevel":"幼儿园","schoolType":"民办"}}
					var data=eval(result.result);
					$('#getresult').text("code:"+data.code+"\n"+"resMsg:"+data.resMsg+"\n"+"data:"+eval(data.data).schoolName+"\n"+"---orgName:"+eval(data.data).orgName);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					 alert(XMLHttpRequest.status);
                     alert(XMLHttpRequest.readyState);
                     alert(textStatus);
//					alert("查询学校信息错误");
				}
			});
		// --------------------------------------------------------------------
	}
	/**
	 * 家长查询
	 */
	function queryFamliy(){
		// --------------------------------------------------------------------
		$.ajax({type : "POST",
			dataType : "json",
			url :url+"/ClientTest/QueryFamliy",
			data:$('#queryFamliyForm').serialize(),
			success : function(result) {
				alert(result);
				//解析json{"code":"1","resMsg":"成功获取东区起湾小学学校信息成功！","data":{"schoolName":"东区起湾小学","orgName":"东区教办","areaName":"东区","schoolLevel":"幼儿园","schoolType":"民办"}}
				var data=eval(result.result);
				$('#getresult').text("code:"+data.code+"\n"+"resMsg:"+data.resMsg+"\n"+"data:"+eval(data.data).UserName+"\n"+"---Gender:"+eval(data.data).Gender+"---Email:"+eval(data.data).Email);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
//					alert("查询学校信息错误");
			}
		});
		// --------------------------------------------------------------------
	}
	/**
	 * 学生查询
	 */
	function queryStudent(){
		// --------------------------------------------------------------------
		$.ajax({type : "POST",
			dataType : "json",
			url :url+"/ClientTest/QueryStudent",
			data:$('#queryStudentForm').serialize(),
			success : function(result) {
				alert(result);
				//解析json{"code":"1","resMsg":"成功获取东区起湾小学学校信息成功！","data":{"schoolName":"东区起湾小学","orgName":"东区教办","areaName":"东区","schoolLevel":"幼儿园","schoolType":"民办"}}
				var data=eval(result.result);
				$('#getresult').text("code:"+data.code+"\n"+"resMsg:"+data.resMsg+"\n"+"data:"+eval(data.data).UserName+"\n"+"---Gender:"+eval(data.data).Gender+"---Email:"+eval(data.data).Email);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
//					alert("查询学校信息错误");
			}
		});
		// --------------------------------------------------------------------
	}
	/**
	 * 教师查询
	 */
	function queryTeacher(){
		// --------------------------------------------------------------------
		$.ajax({type : "POST",
			dataType : "json",
			url :url+"/ClientTest/updateClass",
			success : function(result) {
				alert(result);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
//					alert("查询学校信息错误");
			}
		});
		// --------------------------------------------------------------------
	}
	
	/**
	 * 组织查询
	 */
	function queryOrg(){
		// --------------------------------------------------------------------
		$.ajax({type : "POST",
			dataType : "json",
			url :url+"/ClientTest/QueryOrg",
			data:$('#queryOrgForm').serialize(),
			success : function(result) {
				var data=eval(result.result);
				//解析json{"data":[{"id":1,"name":"中山市"},{"id":26,"name":"直属"},{"id":2,"name":"石岐区"},{"id":3,"name":"东区"},{"id":4,"name":"西区"},{"id":5,"name":"南区"},{"id":6,"name":"火炬开发区"},{"id":7,"name":"沙溪镇"},{"id":8,"name":"三乡镇"},{"id":9,"name":"南朗镇"},{"id":10,"name":"三角镇"},{"id":11,"name":"南头镇"},{"id":12,"name":"民众镇"},{"id":13,"name":"东凤镇"},{"id":14,"name":"小榄镇"},{"id":15,"name":"古镇镇"},{"id":16,"name":"阜沙镇"},{"id":17,"name":"坦洲镇"},{"id":18,"name":"大涌镇"},{"id":19,"name":"五桂山镇"},{"id":20,"name":"东升镇"},{"id":21,"name":"板芙镇"},{"id":22,"name":"神湾镇"},{"id":23,"name":"黄圃镇"},{"id":24,"name":"港口镇"},{"id":25,"name":"横栏镇"}],"code":"1","resMsg":"获取组织成功！"}
				var region="";
				$.each(data.data, function (n, key) {
					region+=key.id+"---"+key.name+"\t";
	            });
				$('#getresult').text("code:"+data.code+"\n"+"resMsg:"+data.resMsg+"\n"+"data:"+region);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("查询组织信息错误");
			}
		});
		// --------------------------------------------------------------------
	}
	/**
	 * 根据组织id查询学校
	 */
	function querySchoolByOrg(){
		// --------------------------------------------------------------------
		$.ajax({type : "POST",
			dataType : "json",
			url :url+"/ClientTest/QuerySchoolByOrg",
			data:$('#querySchoolByOrgForm').serialize(),
			success : function(result) {
				//解析json：{"data":[{"id":106,"name":"东区朗晴小学","fullName()":"东区朗晴小学"},{"id":483,"name":"东区长江盈兴托儿所"},{"id":484,"name":"东区起湾幼儿园"},{"id":485,"name":"东区小鳌溪幼儿园"},{"id":486,"name":"东区槎桥幼儿园"},{"id":487,"name":"东区小博士雍逸廷幼儿园"},{"id":488,"name":"东区富湾托儿所"},{"id":489,"name":"东区小牛津幼儿园"},{"id":490,"name":"东区齐东幼儿园"},{"id":491,"name":"东区长江幼儿园"},{"id":492,"name":"东区威宝托儿所"},{"id":493,"name":"东区东梅托儿所"},{"id":494,"name":"东区教育事务指导中心"},{"id":495,"name":"东区雍景园幼儿园"},{"id":496,"name":"东区华凯幼儿园"},{"id":497,"name":"东区大鳌溪幼儿园"},{"id":498,"name":"东区松苑幼儿园"},{"id":499,"name":"东区起湾盈兴托儿所"},{"id":500,"name":"东区小博士幼儿园"},{"id":501,"name":"东区同方实验幼儿园"},{"id":502,"name":"东区库充王世昌幼儿园"},{"id":503,"name":"东区康怡托儿所"},{"id":504,"name":"东区东裕幼儿园"},{"id":505,"name":"东区新村幼儿园"},{"id":506,"name":"东区邦德英文幼儿园"},{"id":507,"name":"东区幸福童年幼儿园"},{"id":508,"name":"东区金锁匙托儿所"},{"id":509,"name":"东区乐天艺术幼儿园"},{"id":510,"name":"东区白沙湾幼儿园"},{"id":511,"name":"东区同德幼儿园"},{"id":512,"name":"东区博文起湾幼儿园"},{"id":513,"name":"东区沙岗幼儿园"},{"id":514,"name":"东区健蕾托儿所"},{"id":515,"name":"东区盈兴托儿所"},{"id":516,"name":"东区顺景幼儿园"},{"id":517,"name":"东区柏苑幼儿园"},{"id":518,"name":"东区夏洋幼儿园"},{"id":519,"name":"东区柏苑托儿所"},{"id":520,"name":"东区康桥托儿所"},{"id":521,"name":"东区爱丽斯托儿所"},{"id":522,"name":"东区育才幼儿园"},{"id":523,"name":"东区三溪幼儿园"},{"id":524,"name":"东区精彩童年幼儿园"},{"id":525,"name":"东区亨尾幼儿园"},{"id":51,"name":"东区中学","fullName()":"东区中学"},{"id":96,"name":"东区白沙湾小学","fullName()":"东区白沙湾小学"},{"id":97,"name":"东区柏苑小学","fullName()":"东区柏苑小学"},{"id":98,"name":"东区教育事务指导中心","fullName()":"东区教育事务指导中心"},{"id":99,"name":"东区起湾小学","fullName()":"东区起湾小学"},{"id":100,"name":"东区团益学校","fullName()":"东区团益学校"},{"id":101,"name":"东区松苑中学","fullName()":"东区松苑中学"},{"id":102,"name":"东区艳阳学校","fullName()":"东区艳阳学校"},{"id":103,"name":"东区竹苑小学","fullName()":"东区竹苑小学"},{"id":104,"name":"东区水云轩小学","fullName()":"东区水云轩小学"},{"id":105,"name":"东区雍景园小学","fullName()":"东区雍景园小学"},{"id":107,"name":"东区初级中学","fullName()":"东区初级中学"}],"code":"1","resMsg":"获取该组织的学校成功！"}
				var data=eval(result.result);
				var schools="";
				$.each(data.data, function (n, key) {
					schools+=key.id+"---"+key.name+"\t";
	            });
				$('#getresult').text("code:"+data.code+"\n"+"resMsg:"+data.resMsg+"\n"+"data:"+schools);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("查询组织信息错误");
			}
		});
		// --------------------------------------------------------------------
	}
	/**
	 * 消息推送
	 */
	function qushMsg(){
		alert(url+"ClientTest/PushClass");
		alert("************");
		// --------------------------------------------------------------------
		$.ajax({type : "POST",
			dataType : "json",
			url :url+"ClientTest/PushClass",
			data:$('#pushMsgForm').serialize(),
			success : function(result) {
				alert(result);
				//解析json{"code":"1","resMsg":"成功获取东区起湾小学学校信息成功！","data":{"schoolName":"东区起湾小学","orgName":"东区教办","areaName":"东区","schoolLevel":"幼儿园","schoolType":"民办"}}
				var data=eval(result.result);
				$('#getresult').text("code:"+data.code+"\n"+"resMsg:"+data.resMsg+"\n");
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(textStatus);
//					alert("查询学校信息错误");
			}
		});
		// --------------------------------------------------------------------
	}
	
package com.qtone.common.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.qtone.common.bigdata.model.InterfaceParameterForm;
import com.qtone.common.service.ISysClassService;
import com.qtone.common.service.ISysGradeService;
import com.qtone.common.util.JsonView;
import com.qtone.common.util.UTF8PostMethod;

import org.apache.commons.httpclient.NameValuePair;
@Controller
@RequestMapping("/ClientTest/")
public class ClientTestControll {
	@Autowired
	private ISysGradeService gradeService;
	@Autowired
	private ISysClassService classService;
	String urlStr="http://202.96.186.112:8089/QueryInterfaceManage/QueryService";
	@RequestMapping(value = "querySSOConfig", method = RequestMethod.POST)
	public JsonView querySSOConfig(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("appKey:"+parameter.getAppKey()+"---tloginName:"+parameter.getTloginName()+"--timeStamp:"+parameter.getTimeStamp()+
				"---ssoLoginName:"+parameter.getSsoLoginName());
		JsonView jsonview = new JsonView();
		StringBuffer url = new StringBuffer();
		
		url.append(urlStr);
		url.append("?action="+parameter.getAction());
		url.append("&appKey="+parameter.getAppKey());
		url.append("&tloginName="+parameter.getTloginName());
		url.append("&ssoLoginName="+parameter.getSsoLoginName());
		url.append("&timeStamp=20150602142057");
//		url.append("&paraBody='{SchoolName:school}'");
		System.out.println("requestUrl:>>>"+url);
		String responseString="";
		HttpClient httpClient=new HttpClient();
		System.out.println("***************"+url.toString());
		PostMethod postMethod=new UTF8PostMethod(url.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("StuNumber", parameter.getParaBody());
		JSONObject myJson = new JSONObject();
		
		myJson.putAll(map);
		NameValuePair[] parametersBody = {new NameValuePair("ParaBody",myJson.toString())};
		postMethod.setRequestBody(parametersBody);
		httpClient.executeMethod(postMethod);
		BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while((str = reader.readLine())!=null){
			stringBuffer.append(str);
		}
		responseString = stringBuffer.toString();
		System.out.println(">>>:"+responseString);
		jsonview.setProperty("result", responseString);
		return jsonview;
	}
	/**
	 * 客户端调服务端查询学校接口
	 */
	@RequestMapping(value = "QuerySchool", method = RequestMethod.POST)
	public JsonView QuerySchool(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("appKey:"+parameter.getAppKey()+"---tloginName:"+parameter.getTloginName()+"--timeStamp:"+parameter.getTimeStamp()+
				"---ssoLoginName:"+parameter.getSsoLoginName());
		JsonView jsonview = new JsonView();
		StringBuffer url = new StringBuffer();
		
		url.append(urlStr);
		url.append("?action=QRY_SCHOOL");
		url.append("&appKey=c894c5775b324274b1fc966285338360");
		url.append("&tloginName=hewenwei");
		url.append("&ssoLoginName=admin");
		url.append("&timeStamp=20150602142057");
		
//		url.append("&paraBody='{SchoolName:school}'");
		System.out.println("requestUrl:>>>"+url);
		String responseString="";
		HttpClient httpClient=new HttpClient();
		System.out.println("***************"+url.toString());
		PostMethod postMethod=new UTF8PostMethod(url.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("SchoolName", "东区起湾小学");
		JSONObject myJson = new JSONObject();
		myJson.putAll(map);
		NameValuePair[] parametersBody = {new NameValuePair("ParaBody",myJson.toString())};
		postMethod.setRequestBody(parametersBody);
		httpClient.executeMethod(postMethod);
		BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while((str = reader.readLine())!=null){
			stringBuffer.append(str);
		}
		responseString = stringBuffer.toString();
		System.out.println(">>>:"+responseString);
		jsonview.setProperty("result", responseString);
		return jsonview;
	}
	/**
	 * 客户端调服务端查询家长接口
	 */
	@RequestMapping(value = "QueryFamliy", method = RequestMethod.POST)
	public JsonView QueryFamliy(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("appKey:"+parameter.getAppKey()+"---tloginName:"+parameter.getTloginName()+"--timeStamp:"+parameter.getTimeStamp()+
				"---ssoLoginName:"+parameter.getSsoLoginName()+"---"+parameter.getParaBody());
		JsonView jsonview = new JsonView();
		StringBuffer url = new StringBuffer();
		
		url.append(urlStr);
		url.append("?action="+parameter.getAction());
		url.append("&appKey="+parameter.getAppKey());
		url.append("&tloginName="+parameter.getTloginName());
		url.append("&ssoLoginName="+parameter.getSsoLoginName());
		url.append("&timeStamp=20151117142057");
//		url.append("&paraBody='{SchoolName:school}'");
		System.out.println("requestUrl:>>>"+url);
		String responseString="";
		HttpClient httpClient=new HttpClient();
		System.out.println("***************"+url.toString());
		PostMethod postMethod=new UTF8PostMethod(url.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("StuNumber", parameter.getParaBody());
		JSONObject myJson = new JSONObject();
		myJson.putAll(map);
		NameValuePair[] parametersBody = {new NameValuePair("ParaBody",myJson.toString())};
		postMethod.setRequestBody(parametersBody);
		httpClient.executeMethod(postMethod);
		BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while((str = reader.readLine())!=null){
			stringBuffer.append(str);
		}
		responseString = stringBuffer.toString();
		System.out.println(">>>:"+responseString);
		jsonview.setProperty("result", responseString);
		return jsonview;
	}
	/**
	 * 客户端调服务端查询学生接口
	 */
	@RequestMapping(value = "QueryStudent", method = RequestMethod.POST)
	public JsonView QueryStudent(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("appKey:"+parameter.getAppKey()+"---tloginName:"+parameter.getTloginName()+"--timeStamp:"+parameter.getTimeStamp()+
				"---ssoLoginName:"+parameter.getSsoLoginName()+"---"+parameter.getParaBody());
		JsonView jsonview = new JsonView();
		StringBuffer url = new StringBuffer();
		
		url.append(urlStr);
		url.append("?action="+parameter.getAction());
		url.append("&appKey="+parameter.getAppKey());
		url.append("&tloginName="+parameter.getTloginName());
		url.append("&ssoLoginName="+parameter.getSsoLoginName());
		url.append("&timeStamp=20150602142057");
//		url.append("&paraBody='{SchoolName:school}'");
		System.out.println("requestUrl:>>>"+url);
		String responseString="";
		HttpClient httpClient=new HttpClient();
		System.out.println("***************"+url.toString());
		PostMethod postMethod=new UTF8PostMethod(url.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("StuNumber", parameter.getParaBody());
		JSONObject myJson = new JSONObject();
		myJson.putAll(map);
		NameValuePair[] parametersBody = {new NameValuePair("ParaBody",myJson.toString())};
		postMethod.setRequestBody(parametersBody);
		httpClient.executeMethod(postMethod);
		BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while((str = reader.readLine())!=null){
			stringBuffer.append(str);
		}
		responseString = stringBuffer.toString();
		System.out.println(">>>:"+responseString);
		jsonview.setProperty("result", responseString);
		return jsonview;
	}
	/**
	 * 客户端调服务端查询学校接口
	 */
	@RequestMapping(value = "QueryTeacher", method = RequestMethod.POST)
	public JsonView QueryTeacher(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("appKey:"+parameter.getAppKey()+"---tloginName:"+parameter.getTloginName()+"--timeStamp:"+parameter.getTimeStamp()+
				"---ssoLoginName:"+parameter.getSsoLoginName()+"---"+parameter.getParaBody());
		JsonView jsonview = new JsonView();
		StringBuffer url = new StringBuffer();
		
		url.append(urlStr);
		url.append("?action="+parameter.getAction());
		url.append("&appKey="+parameter.getAppKey());
		url.append("&tloginName="+parameter.getTloginName());
		url.append("&ssoLoginName="+parameter.getSsoLoginName());
		url.append("&timeStamp=20150602142057");
//		url.append("&paraBody='{SchoolName:school}'");
		System.out.println("requestUrl:>>>"+url);
		String responseString="";
		HttpClient httpClient=new HttpClient();
		System.out.println("***************"+url.toString());
		PostMethod postMethod=new UTF8PostMethod(url.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("EduNumber", parameter.getParaBody());
		
		JSONObject myJson = new JSONObject();
		myJson.putAll(map);
		NameValuePair[] parametersBody = {new NameValuePair("ParaBody",myJson.toString())};
		postMethod.setRequestBody(parametersBody);
		httpClient.executeMethod(postMethod);
		BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while((str = reader.readLine())!=null){
			stringBuffer.append(str);
		}
		responseString = stringBuffer.toString();
		System.out.println(">>>:"+responseString);
		jsonview.setProperty("result", responseString);
		return jsonview;
	}
	/**
	 * 客户端调服务端查询学校接口
	 */
	@RequestMapping(value = "QRY_USERINFO", method = RequestMethod.POST)
	public JsonView QRY_USERINFO(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("appKey:"+parameter.getAppKey()+"---tloginName:"+parameter.getTloginName()+"--timeStamp:"+parameter.getTimeStamp()+
				"---ssoLoginName:"+parameter.getSsoLoginName()+"---"+parameter.getParaBody());
		JsonView jsonview = new JsonView();
		StringBuffer url = new StringBuffer();
		url.append(urlStr);
		url.append("?action="+parameter.getAction());
		url.append("&appKey="+parameter.getAppKey());
		url.append("&tloginName="+parameter.getTloginName());
		url.append("&timeStamp=20150602142057");
		System.out.println("requestUrl:>>>"+url);
		String responseString="";
		HttpClient httpClient=new HttpClient();
		System.out.println("***************"+url.toString());
		PostMethod postMethod=new UTF8PostMethod(url.toString());
		httpClient.executeMethod(postMethod);
		BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while((str = reader.readLine())!=null){
			stringBuffer.append(str);
		}
		responseString = stringBuffer.toString();
		System.out.println(">>>:"+responseString);
		jsonview.setProperty("result", responseString);
		return jsonview;
	}
	
	/**
	 * 查询所有组织
	 */
	@RequestMapping(value = "QueryOrg", method = RequestMethod.POST)
	public JsonView QueryOrg(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("appKey:"+parameter.getAppKey()+"---tloginName:"+parameter.getTloginName()+"--timeStamp:"+parameter.getTimeStamp()+
				"---ssoLoginName:"+parameter.getSsoLoginName()+"---"+parameter.getParaBody());
		JsonView jsonview = new JsonView();
		StringBuffer url = new StringBuffer();
		url.append(urlStr);
		url.append("?action="+parameter.getAction());
		url.append("&appKey="+parameter.getAppKey());
		System.out.println("requestUrl:>>>"+url);
		String responseString="";
		HttpClient httpClient=new HttpClient();
		System.out.println("***************"+url.toString());
		PostMethod postMethod=new UTF8PostMethod(url.toString());
		httpClient.executeMethod(postMethod);
		BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while((str = reader.readLine())!=null){
			stringBuffer.append(str);
		}
		responseString = stringBuffer.toString();
		System.out.println(">>>:"+responseString);
		jsonview.setProperty("result", responseString);
		return jsonview;
	}
	
	/**
	 * 查询该组织下的所有学校
	 */
	@RequestMapping(value = "QuerySchoolByOrg", method = RequestMethod.POST)
	public JsonView QuerySchoolByOrg(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("appKey:"+parameter.getAppKey()+"---tloginName:"+parameter.getTloginName()+"--timeStamp:"+parameter.getTimeStamp()+
				"---ssoLoginName:"+parameter.getSsoLoginName()+"---"+parameter.getParaBody());
		JsonView jsonview = new JsonView();
		StringBuffer url = new StringBuffer();
		url.append(urlStr);
		url.append("?action="+parameter.getAction());
		url.append("&appKey="+parameter.getAppKey());
		System.out.println("requestUrl:>>>"+url);
		String responseString="";
		System.out.println("***************"+url.toString());
		HttpClient httpClient=new HttpClient();
		PostMethod postMethod=new UTF8PostMethod(url.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orgId",5);
		JSONObject myJson = new JSONObject();
		myJson.putAll(map);
		NameValuePair[] parametersBody = {new NameValuePair("ParaBody",myJson.toString())};
		postMethod.setRequestBody(parametersBody);
		httpClient.executeMethod(postMethod);
		BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while((str = reader.readLine())!=null){
			stringBuffer.append(str);
		}
		responseString = stringBuffer.toString();
		System.out.println(">>>:"+responseString);
		jsonview.setProperty("result", responseString);
		return jsonview;
	}
	
	/**
	 * 客户端调服务端查询学校接口
	 */
	@RequestMapping(value = "PushMsg", method = RequestMethod.POST)
	public JsonView PushMsg(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("appKey:"+parameter.getAppKey()+"---tloginName:"+parameter.getTloginName()+"--timeStamp:"+parameter.getTimeStamp()+
				"---ssoLoginName:"+parameter.getSsoLoginName()+"---"+parameter.getParaBody());
		String paraBody=new String(parameter.getParaBody().getBytes("ISO-8859-1"),"UTF-8");
		JsonView jsonview = new JsonView();
		StringBuffer url = new StringBuffer();
		String urlActionStr="http://localhost:8080/bigdata_interface/ActionInterfaceManage/ActionService";
		url.append(urlActionStr);
		url.append("?action="+parameter.getAction());
		url.append("&appKey="+parameter.getAppKey());
		url.append("&tloginName="+parameter.getTloginName());
		url.append("&ssoLoginName="+parameter.getSsoLoginName());
		url.append("&timeStamp=20150602142057");
//		url.append("&paraBody='{SchoolName:school}'");
		System.out.println("requestUrl:>>>"+url);
		String responseString="";
		HttpClient httpClient=new HttpClient();
		System.out.println("***************"+url.toString());
		PostMethod postMethod=new UTF8PostMethod(url.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("LoginName", "admin");
		map.put("Title", "暑假学生安全注意事项");
		map.put("MessageContent", "各位老师，接下来面临的是暑假安全问题，务必要将安全事项告诉学生和家长...");
		map.put("MessageURL", "http://www.baidu.com");
		map.put("OthMsgId", "1");
		map.put("ValidDate", "2015-09-01 12:59:00");
		JSONObject myJson = new JSONObject();
		myJson.putAll(map);
		NameValuePair[] parametersBody = {new NameValuePair("ParaBody",myJson.toString())};
		postMethod.setRequestBody(parametersBody);
		httpClient.executeMethod(postMethod);
		BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while((str = reader.readLine())!=null){
			stringBuffer.append(str);
		}
		responseString = stringBuffer.toString();
		System.out.println(">>>:"+responseString);
		jsonview.setProperty("result", responseString);
		return jsonview;
	}
	/**
	 * 客户端调服务端查询学校接口
	 */
	@RequestMapping(value = "PushClass", method = RequestMethod.POST)
	public JsonView PushClass(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String paraBody=new String(parameter.getParaBody().getBytes("ISO-8859-1"),"UTF-8");
		JsonView jsonview = new JsonView();
		StringBuffer url = new StringBuffer();
		String urlActionStr="http://202.96.186.112:8089/ActionInterfaceManage/ActionService";
		url.append(urlActionStr);
		url.append("?action=PUSH_CLASS");
		url.append("&appKey=2e0ab1da286b41a9b1ff5775bb6b8b1d");
		url.append("&timeStamp=20151207142057");
//		url.append("&paraBody='{SchoolName:school}'");
		System.out.println("requestUrl:>>>"+url);
		String responseString="";
		HttpClient httpClient=new HttpClient();
		System.out.println("***************"+url.toString());
		PostMethod postMethod=new UTF8PostMethod(url.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("schoolName", "火炬开发区中心小学");
		map.put("gradeName", "一年级");
		map.put("className", "一年级(1)班");
		map.put("headmaster", "黄梅");
		map.put("schoolYear", "2015");
		map.put("ValidDate", "2015-12-07 12:59:00");
		JSONObject myJson = new JSONObject();
		myJson.putAll(map);
		NameValuePair[] parametersBody = {new NameValuePair("ParaBody",myJson.toString())};
		postMethod.setRequestBody(parametersBody);
		httpClient.executeMethod(postMethod);
		BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while((str = reader.readLine())!=null){
			stringBuffer.append(str);
		}
		responseString = stringBuffer.toString();
		System.out.println(">>>:"+responseString);
		jsonview.setProperty("result", responseString);
		return jsonview;
	}
	
	/**
	 * 修改班级
	 */
	@RequestMapping(value = "updateClass", method = RequestMethod.POST)
	public JsonView updateClass(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JsonView jsonview =classService.updateClass(null);
		return jsonview;
	}
	
	/**
	 * 修改班级
	 */
	@RequestMapping(value = "updateGrade", method = RequestMethod.POST)
	public JsonView updateGrade(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JsonView jsonview =gradeService.updateGrade(null);
		return jsonview;
	}
	
	//大数据的cas的单点登录
	@RequestMapping("alipayforward")  
    public JsonView alipayforward(HttpServletRequest req, HttpServletResponse resp,String casUrl) throws Exception {
        StringBuffer sbUrl = new StringBuffer();
        sbUrl.append(casUrl);
//        sbUrl.append("");
        sbUrl.append("&n="+new Date().getTime());
        sbUrl.append("&get-lt="+true);
		System.out.println("requestUrl:>>>"+sbUrl);
		String responseString="";
		HttpClient httpClient=new HttpClient();
		System.out.println("***************"+sbUrl.toString());
		PostMethod postMethod=new UTF8PostMethod(sbUrl.toString());
		httpClient.executeMethod(postMethod);
		BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while((str = reader.readLine())!=null){
			stringBuffer.append(str);
		}
		responseString = stringBuffer.toString();
		System.out.println("返回值cas >>>:"+responseString);
		JSONObject jsonObj=JSONObject.fromObject(responseString);
		String loginTicket=jsonObj.get("_loginTicket").toString();
		String execution=jsonObj.get("_execution").toString();
		System.out.println("loginTicket:"+loginTicket);
		System.out.println("execution:"+execution);
//		forwardCas(req,resp,casUrl,loginTicket,execution);
		JsonView jsonview = new JsonView();
		jsonview.setProperty("data", responseString);
		System.out.println(jsonview.getJSONString());
        return  jsonview;  
    }  
	/**
	 * 
	 * @param req
	 * @param resp
	 * @param casUrl    http://192.168.17.7:8001/cas/login?service=http://192.168.17.7:8080/redirectSys/41?type=3 (service前的地址是大数据管理平台的cas地址，service=后面是重定向的地址；41是sys_app表的id对应的子应用)
	 * @param loginTicket  cas返回回来的令牌
	 * @param execution
	 * @param userName    登录账号
	 * @param password    登录密码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("forwardCas")  
	public ModelAndView  forwardCas(HttpServletRequest req, HttpServletResponse resp,String casUrl,String loginTicket,String execution,String userName,String password)throws Exception {
		StringBuffer sbUrl = new StringBuffer();
        sbUrl.append(casUrl);
        sbUrl.append("&_eventId=submit");
        sbUrl.append("&isajax="+true);
        sbUrl.append("&isframe="+true);
        sbUrl.append("&execution="+execution);
        sbUrl.append("&lt="+loginTicket);
        sbUrl.append("&username="+userName);
        sbUrl.append("&password="+password);
        sbUrl.append("&loginerror=http://202.96.187.34/");
        String url = "redirect:"+sbUrl.toString();   
        return new ModelAndView(url);  
	}
	
	@RequestMapping("zseduLogin")  
	public JsonView  zseduLogin(HttpServletRequest req, HttpServletResponse resp)throws Exception {
		JsonView jsonview = new JsonView();
		StringBuffer url = new StringBuffer();
		url.append("http://172.18.20.214:8083/syspurview/login.do");
		url.append("?action=loginByEduNum");
//		url.append("&Keycode=hEFnP4n5dnvQRBitrt20JO3NA2+TMu7s");
//		url.append("&timestamp=2017-01-16");
		System.out.println("requestUrl:>>>"+url);
		String responseString="";
		HttpClient httpClient=new HttpClient();
		System.out.println("***************"+url.toString());
		PostMethod postMethod=new UTF8PostMethod(url.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("Keycode", "hEFnP4n5dnvQRBitrt20JO3NA2+TMu7s");
		map.put("timestamp", "2017-01-16");
		JSONObject myJson = new JSONObject();
		myJson.putAll(map);
		NameValuePair[] parametersBody = {new NameValuePair("ParaBody",myJson.toString())};
		postMethod.setRequestBody(parametersBody);
		httpClient.executeMethod(postMethod);
		BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while((str = reader.readLine())!=null){
			stringBuffer.append(str);
		}
		responseString = stringBuffer.toString();
		JSONObject jsonObj=JSONObject.fromObject(responseString);
		String redirectUrl=jsonObj.get("redirectUrl")+"";
		System.out.println(">>>:"+responseString);
		jsonview.setProperty("result", responseString);
		 return  jsonview;  
	}
	
}

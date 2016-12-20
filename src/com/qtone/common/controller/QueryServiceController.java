package com.qtone.common.controller;


import org.apache.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qtone.common.bigdata.entity.SysInterfaceAccess;
import com.qtone.common.bigdata.entity.SysInterfaceAccessLog;
import com.qtone.common.bigdata.model.InterfaceParameterForm;
import com.qtone.common.service.IOrganizationService;
import com.qtone.common.service.ISysInterfaceAccessLogService;
import com.qtone.common.service.ISysInterfaceAccessService;
import com.qtone.common.service.ISysSSOConfigService;
import com.qtone.common.service.ISysSchoolService;
import com.qtone.common.service.ISysUserParentService;
import com.qtone.common.service.ISysUserService;
import com.qtone.common.service.ISysUserStudentService;
import com.qtone.common.service.ISysUserTeacherService;
import com.qtone.common.util.InterfaceMethod;
import com.qtone.common.util.JsonView;
import com.qtone.common.util.PubUtils;

/**
 *统一平台接口管理
 * @author tzp
 * 
 */
@Controller
@RequestMapping("/QueryInterfaceManage/")
public class QueryServiceController {
	@Autowired
	private ISysInterfaceAccessService sysInterfaceAccessService;
	@Autowired
	private ISysInterfaceAccessLogService iSysInterfaceAccessLogService;
	@Autowired
	private ISysSchoolService sysSchoolService;
	@Autowired
	private ISysUserParentService sysUserParentService;
	@Autowired
	private ISysUserStudentService sysUserStudentService;
	@Autowired
	private ISysUserTeacherService sysUserTeacherService;
	@Autowired
	private ISysSSOConfigService sysSSOConfigService;
	@Autowired
	private IOrganizationService organizationService;
	@Autowired
	private ISysUserService sysUserService;
	//调用日志
	private static Logger logger = Logger.getLogger(QueryServiceController.class);  
	/**
	 * 统一平台接口管理总方法
	 */
	
	@RequestMapping(value = "QueryService", method = RequestMethod.POST)
	public void QueryService(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		JsonView jsView=new JsonView();
		String action=parameter.getAction();
		String appKey=parameter.getAppKey();
		String loginName=parameter.getSsoLoginName();
		String appLoginName=parameter.getTloginName();
		logger.info("客户端传过来的action》》》》》》"+action);
		logger.info("客户端传过来的appKey》》》》》》"+appKey);
		if(appKey !=null&&!"".equals(appKey)){ //当第三方appKey为空
			if(action !=null&&!"".equals(action)){ //当第三方方法为空
				SysInterfaceAccess sysInterfaceAccess=sysInterfaceAccessService.isAccess(appKey, action);//查询第三方是否有访问的权限
				if(sysInterfaceAccess !=null && !"".equals(sysInterfaceAccess)){
					JSONObject paraBodyJson=null;
					//获取传参json如：{SchoolName："东区小学"}
					String paraBody=parameter.getParaBody();
					//参数不能为空
					//actioon方法名转换成大写
					action=action.toUpperCase();
					 if(paraBody !=null&&paraBody.length()>3){
						 paraBody=new String(paraBody.getBytes("ISO-8859-1"),"UTF-8");
						 logger.info("客户端传过来的paraBody》》》》》》"+paraBody);
						//解析Json
						paraBodyJson=JSONObject.fromObject(paraBody);
//							queryService.getClass().getDeclaredMethod(action).invoke(queryService,paraBody,callback);
						if(action.equals(InterfaceMethod.QRYSCHOOLBYORG)){//根据组织查询学校
							jsView=this.qrySchoolByOrg(paraBodyJson);
						}else{//需要绑定后才能访问的接口
							//第三方平台不用传大数据登录账号和第三平台的账号
							boolean flag =sysSSOConfigService.findByDigDateNameAppName(sysInterfaceAccess.getAppId(),loginName, appLoginName);
							if(flag==true){
									//这里可以用反射机制，只有方法一致其他的方法就不用写
//									QueryServiceController qsc = new QueryServiceController();
//									qsc.getClass().getDeclaredMethod(action).invoke(paraBodyJson,loginName,appLoginName);
									if(action.equals(InterfaceMethod.QRYSCHOOL)){//学校接口
										jsView = this.qrySchool(paraBodyJson,loginName,appLoginName);
									}else if(action.equals(InterfaceMethod.QRYSTUDENT)){
										jsView = this.qryStudent(paraBodyJson,loginName,appLoginName);
									}else if(action.equals(InterfaceMethod.QRYTEACHER)){
										jsView = this.qryTeacher(paraBodyJson,loginName,appLoginName);
									}else if(action.equals(InterfaceMethod.QRYFAMLIY)){
										jsView = this.qryFamliy(paraBodyJson,loginName,appLoginName);
									}else if(action.equals(InterfaceMethod.CHECKUSER)){
										jsView = this.querySsoConfig(sysInterfaceAccess.getAppName());
									}
							}else{
								jsView.setProperty("code", "0");
								jsView.setProperty("resMsg", "改账号还没有绑定,请先绑定");
								logger.info("》》》》》》没有访问该接口权限,请联系管理员");
							}
						}
						
					 }else{
						 if(action.equals(InterfaceMethod.QRYORG)){//查询组织
								jsView=this.qryOrg();
						 }else if(action.equals(InterfaceMethod.QRYUSERINFO)){
							 jsView= this.qryUserInfo(loginName);
							//类映射到方法,this.getClass().getDeclaredMethod(action,String.class)获取本类的方法，action方面名称，String.class参数类型，this.getClass().newInstance()本类实例化，new Object[]{loginName}参数
//							 jsView=(JsonView) this.getClass().getDeclaredMethod(action,String.class,ISysUserService.class).invoke(this.getClass().newInstance(),new Object[]{loginName,sysUserService});
//							 jsView=(JsonView) this.getClass().getDeclaredMethod(action,String.class,ISysInterfaceAccessService.class).invoke(this.getClass().newInstance(),new Object[]{loginName,sysInterfaceAccessService});
						 }else if(action.equals(InterfaceMethod.QRYAPPINFO)){
							 jsView= this.qryAppInfo(loginName);
						 }
					 }
					//添加统一平台访问日记
					SysInterfaceAccessLog sysInterfaceAccessLog =new SysInterfaceAccessLog();
					sysInterfaceAccessLog.setAppInterface(1); //接口Id
					sysInterfaceAccessLog.setAppSystem(sysInterfaceAccess.getAppId());//系统Id
					sysInterfaceAccessLog.setAccessUser(parameter.getTloginName()); //第三方账号
					sysInterfaceAccessLog.setAccessAppUser(parameter.getSsoLoginName());//统一平台的账号
					sysInterfaceAccessLog.setAccessPara("action;appKey;tloginName;ssoLoginName;timeStamp;paraBody");//调用时传参
					sysInterfaceAccessLog.setAccessResult("返回结果");//调用后返回结果
					sysInterfaceAccessLog.setAccessTime(PubUtils.getFmtSystime(null)); //当前时间
					sysInterfaceAccessLog.setClientIp(PubUtils.getClientHostIpAddr(request));//客户端IP
					iSysInterfaceAccessLogService.saveInterfaceAccessLog(sysInterfaceAccessLog);
				}else{
					jsView.setProperty("code", "0");
					jsView.setProperty("resMsg", "没有访问该接口权限,请联系管理员");
					logger.info("》》》》》》没有访问该接口权限,请联系管理员");
				}
			}else{
				jsView.setProperty("code", "0");
				jsView.setProperty("resMsg", "action参数不能为空");
				logger.info("》》》》》》action参数不能为空");
			}
		}else{
			jsView.setProperty("code", "0");
			jsView.setProperty("resMsg", "appKey参数不能为空");
			logger.info("》》》》》》appKey参数不能为空");
		}
		logger.info("最终构造的JSON数据格式》》》》》》:" +jsView.getJSONString());
		response.getWriter().print(jsView.getJSONString());
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * 根据登录名称及应用KEY查询第三方系统账号绑定配置
	 * @param request
	 * @return
	 */
	public JsonView querySsoConfig(String appName){
		JsonView jsonView=new JsonView();
		 try {
				jsonView.setProperty("data",appName);
				jsonView.setProperty("code", "1");
				jsonView.setProperty("resMsg","该用户已经绑定！");
		} catch (Exception e) {
			logger.info("该用户还没有绑定");
			e.printStackTrace();
		}
		return jsonView;
		
	}
	
	
	/**
	 * 根据学校名称查询学校信息返回json
	 * @param parameter
	 * @return
	 */
	public JsonView qrySchool(JSONObject paraBodyJson,String loginName,String appLoginName){
		JsonView jsonView=new JsonView();
		//获取学校名称
		String schoolName=paraBodyJson.get("SchoolName")+"";
		try {
				jsonView.setProperty("data",sysSchoolService.findSchoolByName(schoolName));
				jsonView.setProperty("code", "1");
				jsonView.setProperty("resMsg","成功获取"+schoolName+"学校信息成功！");
		} catch (Exception e) {
			jsonView.setProperty("code", "0");
			jsonView.setProperty("resMsg", "没有"+schoolName+"该学校");
			e.printStackTrace();
		}
		
		return jsonView;
		
	}
	
	/**
	 * 根据学籍号查询家长信息返回json
	 * @param parameter
	 * @return
	 */
	public JsonView qryFamliy(JSONObject paraBodyJson,String loginName,String appLoginName){
		JsonView jsonView=new JsonView();
		//获取学籍号
		String stuNumber=paraBodyJson.get("StuNumber")+"";
		try {
				jsonView.setProperty("data",sysUserParentService.findParentByNameStuNo(stuNumber));
				jsonView.setProperty("code", "1");
				jsonView.setProperty("resMsg","成功获取学籍号为"+stuNumber+"的家长成功！");
		} catch (Exception e) {
			jsonView.setProperty("code", "0");
			jsonView.setProperty("resMsg", "没有"+stuNumber+"学籍号");
			e.printStackTrace();
		}
		return jsonView;
		
	}	

	/**
	 * 根据学籍号查询学生信息返回json
	 * @param parameter
	 * @return
	 */
	public JsonView qryStudent(JSONObject paraBodyJson,String loginName,String appLoginName){
		JsonView jsonView=new JsonView();
		//获取学籍号
		String stuNumber=paraBodyJson.get("StuNumber")+"";
		try {
				jsonView.setProperty("data",sysUserStudentService.findStudentByStuNo(stuNumber));
				jsonView.setProperty("code", "1");
				jsonView.setProperty("resMsg","成功获取学籍号为"+stuNumber+"成功！");
		} catch (Exception e) {
			jsonView.setProperty("code", "0");
			jsonView.setProperty("resMsg", "没有"+stuNumber+"学籍号");
			e.printStackTrace();
		}
		return jsonView;
		
	}	

	/**
	 * 根据继教号查询教师信息返回json
	 * @param parameter
	 * @return
	 */
	public JsonView qryTeacher(JSONObject paraBodyJson,String loginName,String appLoginName){
		JsonView jsonView=new JsonView();
		//获取学校名称
		String eduNumber=paraBodyJson.get("EduNumber")+"";
		try {
				jsonView.setProperty("data",sysUserTeacherService.findTeacherByEduNo(eduNumber));
				jsonView.setProperty("code", "1");
				jsonView.setProperty("resMsg","成功获取继教号"+eduNumber+"成功！");
		} catch (Exception e) {
			jsonView.setProperty("code", "0");
			jsonView.setProperty("resMsg", "没有"+eduNumber+"该继教号");
			e.printStackTrace();
		}
		return jsonView;
		
	}	
	
	
	/**
	 * 根据登录账号获取该用户信息返回json
	 * @param parameter
	 * @return
	 */
	public JsonView qryUserInfo(String loginName){
		JsonView jsonView=new JsonView();
		try {
				jsonView.setProperty("data",sysUserService.finUserByLoginName(loginName));
				jsonView.setProperty("code", "1");
				jsonView.setProperty("resMsg","成功获取"+loginName+"信息！");
		} catch (Exception e) {
			e.printStackTrace();
			jsonView.setProperty("code", "0");
			jsonView.setProperty("resMsg", "没有"+loginName+"该账号");
		}
		System.out.println(jsonView.toString());
		return jsonView;
		
	}	
	
	/**
	 * 根据继教号查询教师信息返回json
	 * @param parameter
	 * @return
	 */
	public JsonView qryAppInfo(String loginName){
		JsonView jsonView=new JsonView();
		try {
				jsonView.setProperty("data",sysInterfaceAccessService.findAppsByLoginName(loginName));
				jsonView.setProperty("code", "1");
				jsonView.setProperty("resMsg","成功获取该用户授权的所有应用！");
		} catch (Exception e) {
			jsonView.setProperty("code", "0");
			jsonView.setProperty("resMsg", "该用户没有授权应用");
			e.printStackTrace();
		}
		System.out.println(jsonView.toString());
		return jsonView;
		
	}	
	/**
	 * 查询所有的组织
	 * @param paraBodyJson
	 * @return
	 */
	public JsonView qryOrg(){
		JsonView jsonView=new JsonView();
		System.out.println(sysUserTeacherService+"------"+sysUserService);
		try {
			JSONArray jsonArray=organizationService.findAllOrg();
			jsonView.setProperty("data",jsonArray);
			jsonView.setProperty("code", "1");
			jsonView.setProperty("resMsg","获取组织成功！");
		} catch (Exception e) {
			jsonView.setProperty("code", "0");
			jsonView.setProperty("resMsg", "获取组织失败！");
			e.printStackTrace();
		}
		return jsonView;
	}
		
	/**
	 * 根据组织id查询所有的学校
	 * @param paraBodyJson
	 * @return
	 */
	public JsonView qrySchoolByOrg(JSONObject paraBodyJson){
		JsonView jsonView=new JsonView();
		//获取学校名称
		String orgId=paraBodyJson.get("orgId")+"";
		JSONArray jsonArray=sysSchoolService.findSchoolByOrgId(Long.parseLong(orgId));
		if(orgId !=null ){
		try {
				jsonView.setProperty("data",jsonArray);
				jsonView.setProperty("code", "1");
				jsonView.setProperty("resMsg","获取该组织的学校成功！");
			} catch (Exception e) {
				jsonView.setProperty("code", "0");
				jsonView.setProperty("resMsg", "获取该组织的学校成功！");
				e.printStackTrace();
			}
		}
		return jsonView;
	}
	/**
	 * cas由子应用登录后主平台也跟着登录
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
	
}

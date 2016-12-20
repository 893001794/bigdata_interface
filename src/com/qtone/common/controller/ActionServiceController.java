package com.qtone.common.controller;
import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.qtone.common.bigdata.entity.SysInterfaceAccess;
import com.qtone.common.bigdata.entity.SysInterfaceAccessLog;
import com.qtone.common.bigdata.model.InterfaceParameterForm;
import com.qtone.common.bigdata.model.SysClassForm;
import com.qtone.common.bigdata.model.SysPushMessageForm;
import com.qtone.common.service.ISysClassService;
import com.qtone.common.service.ISysInterfaceAccessLogService;
import com.qtone.common.service.ISysInterfaceAccessService;
import com.qtone.common.service.ISysPushMessageService;
import com.qtone.common.service.ISysSSOConfigService;
import com.qtone.common.service.ISysSchoolService;
import com.qtone.common.util.InterfaceMethod;
import com.qtone.common.util.JsonView;
import com.qtone.common.util.PubUtils;
/**
 * 大数据中心为第三方系统提供数据操作服务
 * @author tzp
 *
 */
@Controller
@RequestMapping("/ActionInterfaceManage/")
public class ActionServiceController {
	@Autowired
	private ISysInterfaceAccessService sysInterfaceAccessService;
	@Autowired
	private ISysInterfaceAccessLogService iSysInterfaceAccessLogService;
	@Autowired
	private ISysSSOConfigService sysSSOConfigService;
	@Autowired
	private ISysPushMessageService sysPushMessageService;
	@Autowired
	private ISysClassService sysClassService;
		//调用日志
		private static Logger logger = Logger.getLogger(ActionServiceController.class);  
		@RequestMapping(value = "ActionService", method = RequestMethod.POST)
		public void ActionService(InterfaceParameterForm parameter,HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			JsonView jsView=new JsonView();
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			
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
							//这里可以用反射机制，只有方法一致其他的方法就不用写
//							QueryServiceController qsc = new QueryServiceController();
//							qsc.getClass().getDeclaredMethod(action).invoke(paraBodyJson,loginName,appLoginName)
							//添加统一平台访问日记
							SysInterfaceAccessLog sysInterfaceAccessLog =new SysInterfaceAccessLog();
							sysInterfaceAccessLog.setAppInterface(1); //接口Id
							sysInterfaceAccessLog.setAppSystem(sysInterfaceAccess.getAppId());//系统Id
							//获取传参json如：{SchoolName："东区小学"}
							String paraBody=parameter.getParaBody();
							//参数不能为空
							 if(paraBody !=null&&!"".equals(paraBody)){
//								 response.getCharacterEncoding();
//								 paraBody=new String(paraBody.getBytes("ISO-8859-1"),"GBK");
								 
								 logger.info("客户端传过来的paraBody》》》》》》"+paraBody);
								//解析Json
								JSONObject paraBodyJson=JSONObject.fromObject(paraBody);
								if(action.equals(InterfaceMethod.PUSHCLASS)){
									//由于学籍那边老是发信息过来所以暂时屏蔽
									jsView =this.pushClass(paraBodyJson);
								}else{//需要记录发送人的
									boolean flag =sysSSOConfigService.findByDigDateNameAppName(sysInterfaceAccess.getAppId(),loginName, appLoginName);
									if(flag==true){
	//										//调用学校接口
											if(action.equals(InterfaceMethod.PUSHMSG)){//推送接口
												jsView =this.pushMsg(paraBodyJson,loginName, appLoginName);
											}
											sysInterfaceAccessLog.setAccessUser(parameter.getTloginName()); //第三方账号
											sysInterfaceAccessLog.setAccessAppUser(parameter.getSsoLoginName());//统一平台的账号
									}else{
										jsView.setProperty("code", "0");
										jsView.setProperty("resMsg", "改账号还没有绑定,请先绑定");
										logger.info("》》》》》》没有访问该接口权限,请联系管理员");
									}
								}
//								sysInterfaceAccessLog.setAccessPara("action;appKey;tloginName;ssoLoginName;timeStamp;paraBody");//调用时传参
//								sysInterfaceAccessLog.setAccessResult("返回结果");//调用后返回结果
//								sysInterfaceAccessLog.setAccessTime(PubUtils.getFmtSystime(null)); //当前时间
//								sysInterfaceAccessLog.setClientIp(PubUtils.getClientHostIpAddr(request));//客户端IP
//								iSysInterfaceAccessLogService.saveInterfaceAccessLog(sysInterfaceAccessLog);
						 }else{
							 logger.info("》》》》》》客户端传过来paraBody不能为空");
						 }
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
		 * 推送信息返回json
		 * @param parameter
		 * @return
		 */
		public JsonView pushMsg(JSONObject paraBodyJson,String loginName,String appLoginName){
			JsonView jsonView=new JsonView();
			SysPushMessageForm sysPushMessage =new SysPushMessageForm();
			try {
				sysPushMessage.setLongName(paraBodyJson.get("LoginName")+"");
				sysPushMessage.setTitle(paraBodyJson.get("Title")+"");
				sysPushMessage.setMessageContent(paraBodyJson.get("MessageContent")+"");
				sysPushMessage.setMessageUrl(paraBodyJson.get("MessageURL")+"");
				sysPushMessage.setOthMsgId(paraBodyJson.get("OthMsgId")+"");
				sysPushMessage.setValidDate(paraBodyJson.get("ValidDate")+"");
				sysPushMessageService.savePushMessage(sysPushMessage);
				jsonView.setProperty("code", "1");
				jsonView.setProperty("resMsg","推送"+sysPushMessage.getTitle()+"成功！");
			} catch (Exception e) {
				jsonView.setProperty("code", "0");
				jsonView.setProperty("resMsg", "推送"+sysPushMessage.getTitle()+"失败！");
				e.printStackTrace();
			}
			return jsonView;
			
		}
		/**
		 * 推送信息返回json
		 * @param parameter
		 * @return
		 */
		public JsonView pushClass(JSONObject paraBodyJson){
			SysClassForm sysClass=new SysClassForm();
//				schoolName:班级所属（学校名称）,gradeName:班级所属（年级名称）,className:班级名称,identityName:识别班级的唯一名称,headmaster:班主任,schoolYear:学年
			sysClass.setSchoolName(paraBodyJson.get("schoolName")+"");
			sysClass.setGradeName(paraBodyJson.get("gradeName")+"");
			sysClass.setClassName(paraBodyJson.get("className")+"");
			sysClass.setIdentityName(paraBodyJson.get("identityName")+"");
			sysClass.setHeadmasterName(paraBodyJson.get("headMaster")+"");
			sysClass.setSchoolYear(paraBodyJson.get("schoolYear")+"");
			JsonView jsonView=sysClassService.saveClass(sysClass);
			return jsonView;
			
		}
}

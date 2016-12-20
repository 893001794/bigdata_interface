package com.qtone.common.bigdata.model;

import java.io.Serializable;

/**
 * 接口参数Form
 * @author tzp
 *
 */
public class InterfaceParameterForm implements Serializable{
	private static final long serialVersionUID = -1268125305615512404L;
	private String action; //调总接口子方法名，入学校：QRY_STUDENT
	private String appKey; //注册应用系统后由大数据平台生成
	private String  tloginName; //第三方系统登录账号
	private String ssoLoginName; //大数据登录平台参考“第三方应用系统获取大数据平台统一登录账号”
	private String timeStamp; //时间戳
	private String paraBody ; //
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getTloginName() {
		return tloginName;
	}
	public void setTloginName(String tloginName) {
		this.tloginName = tloginName;
	}
	public String getSsoLoginName() {
		return ssoLoginName;
	}
	public void setSsoLoginName(String ssoLoginName) {
		this.ssoLoginName = ssoLoginName;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getParaBody() {
		return paraBody;
	}
	public void setParaBody(String paraBody) {
		this.paraBody = paraBody;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
}
 
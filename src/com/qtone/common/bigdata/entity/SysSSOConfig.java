package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *单点登陆用户映射表
 * @author tzp
 *
 */
@XmlRootElement(name = "SysSSOConfigs")
@XmlType(name = "SysSSOConfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysSSOConfig implements Serializable{
	private static final long serialVersionUID = 7661682349156994503L;
	@XmlElement(name = "sso_id")
	private Integer ssoId; //单点登录ID
	@XmlElement(name = "app_id")
	private Integer appId; //应用系统ID 
	@XmlElement(name = "user_id")
	private Integer userId; //登录用户ID
	@XmlElement(name = "login_name")
	private String loginName; //登录用户名
	@XmlElement(name = "app_login_name")
	private String appLoginName; //第三方系统登录账号
	@XmlElement(name = "is_verify")
	private Integer isVerify; //是否已验证
	@XmlElement(name = "is_anony")
	private Integer isAnony; //是否匿名登录
	public Integer getSsoId() {
		return ssoId;
	}
	public void setSsoId(Integer ssoId) {
		this.ssoId = ssoId;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getAppLoginName() {
		return appLoginName;
	}
	public void setAppLoginName(String appLoginName) {
		this.appLoginName = appLoginName;
	}
	public Integer getIsVerify() {
		return isVerify;
	}
	public void setIsVerify(Integer isVerify) {
		this.isVerify = isVerify;
	}
	public Integer getIsAnony() {
		return isAnony;
	}
	public void setIsAnony(Integer isAnony) {
		this.isAnony = isAnony;
	}
	

}

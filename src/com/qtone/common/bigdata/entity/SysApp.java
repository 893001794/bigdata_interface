package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 *系统系统(第三方的应用系统)
 * 
 * @author tzp
 * 
 */
@XmlRootElement(name = "SysApps")
@XmlType(name = "SysApp")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysApp  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6080490401418832582L;
	@XmlElement(name = "id")
	private Long id;// 应用系统ID
	@XmlElement(name = "appName")
	private String appName;// 应用系统名称
	@XmlElement(name = "appCode")
	private String appCode;// 应用系统代码
	@XmlElement(name = "appType")
	private Integer appType;// 应用系统类型
	@XmlElement(name = "appKey")
	private String appKey;// 应用系统关键字
	@XmlElement(name = "homePage")
	private String homePage;// 主页
	@XmlElement(name = "isrequiteLogin")
	private Integer isrequiteLogin;// 是否需要登录访问
	@XmlElement(name = "accountType")
	private Integer accountType;// 账号体系类型
	@XmlElement(name = "forUsertype")
	private Integer forUsertype;// 开放的用户类型
	@XmlElement(name = "devCompany")
	private String devCompany;// 开发商
	@XmlElement(name = "devPerson")
	private String devPerson;// 技术联系人
	@XmlElement(name = "devPersonPhone")
	private String devPersonPhone;// 技术联系人电话
	@XmlElement(name = "busiDept")
	private String busiDept;// 业务单位
	@XmlElement(name = "busiDeptPerson")
	private String busiDeptPerson;// 业务联系人
	@XmlElement(name = "sortNum")
	private Integer sortNum;//排序号
	private String appSsoUrl; //单点登录对接的地址
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	public Integer getAppType() {
		return appType;
	}
	public void setAppType(Integer appType) {
		this.appType = appType;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public Integer getIsrequiteLogin() {
		return isrequiteLogin;
	}
	public void setIsrequiteLogin(Integer isrequiteLogin) {
		this.isrequiteLogin = isrequiteLogin;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public Integer getForUsertype() {
		return forUsertype;
	}
	public void setForUsertype(Integer forUsertype) {
		this.forUsertype = forUsertype;
	}
	public String getDevCompany() {
		return devCompany;
	}
	public void setDevCompany(String devCompany) {
		this.devCompany = devCompany;
	}
	public String getDevPerson() {
		return devPerson;
	}
	public void setDevPerson(String devPerson) {
		this.devPerson = devPerson;
	}
	public String getDevPersonPhone() {
		return devPersonPhone;
	}
	public void setDevPersonPhone(String devPersonPhone) {
		this.devPersonPhone = devPersonPhone;
	}
	public String getBusiDept() {
		return busiDept;
	}
	public void setBusiDept(String busiDept) {
		this.busiDept = busiDept;
	}
	public String getBusiDeptPerson() {
		return busiDeptPerson;
	}
	public void setBusiDeptPerson(String busiDeptPerson) {
		this.busiDeptPerson = busiDeptPerson;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	public String getAppSsoUrl() {
		return appSsoUrl;
	}
	public void setAppSsoUrl(String appSsoUrl) {
		this.appSsoUrl = appSsoUrl;
	}
	
	
	
	

}

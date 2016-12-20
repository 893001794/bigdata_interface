package com.qtone.common.bigdata.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 *统一平台借口日志信息(第三方在调用本平台借口的日记)
 * 
 * @author tzp
 * 
 */
@XmlRootElement(name = "InterfaceAccessLogs")
@XmlType(name = "InterfaceAccessLog")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysInterfaceAccessLog  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2484581237747051916L;
	@XmlElement(name = "id")
	private Long id;//接口访问日志ID
	@XmlElement(name = "appInterface")
	private Integer appInterface;//接口
	@XmlElement(name = "appSystem")
	private Integer appSystem;//应用系统
	@XmlElement(name = "accessTime")
	private String accessTime;//访问时间
	@XmlElement(name = "accessAppUser")
	private String accessAppUser;//访问用户名
	@XmlElement(name = "accessUser")
	private String accessUser;//对应统一平台用户
	@XmlElement(name = "accessPara")
	private String accessPara;//调用参数
	@XmlElement(name = "accessResult")
	private String accessResult;//调用结果
	@XmlElement(name = "clientIp")
	private String clientIp;//客户机IP
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAppInterface() {
		return appInterface;
	}
	public void setAppInterface(Integer appInterface) {
		this.appInterface = appInterface;
	}
	public Integer getAppSystem() {
		return appSystem;
	}
	public void setAppSystem(Integer appSystem) {
		this.appSystem = appSystem;
	}
	
	public String getAccessAppUser() {
		return accessAppUser;
	}
	public void setAccessAppUser(String accessAppUser) {
		this.accessAppUser = accessAppUser;
	}
	public String getAccessUser() {
		return accessUser;
	}
	public void setAccessUser(String accessUser) {
		this.accessUser = accessUser;
	}
	public String getAccessPara() {
		return accessPara;
	}
	public void setAccessPara(String accessPara) {
		this.accessPara = accessPara;
	}
	public String getAccessResult() {
		return accessResult;
	}
	public void setAccessResult(String accessResult) {
		this.accessResult = accessResult;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}

	

}

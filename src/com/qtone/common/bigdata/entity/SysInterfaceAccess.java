package com.qtone.common.bigdata.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 *统一平台借口访问权限(判断第三方是否有权限访问该平台)
 * 
 * @author tzp
 * 
 */
@XmlRootElement(name = "SysInterfaceAccessLog.javas")
@XmlType(name = "SysInterfaceAccessLog.java")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysInterfaceAccess  implements Serializable{
	private static final long serialVersionUID = 7195314345711352650L;
	@XmlElement(name = "id")
	private Long id;//统一平台接口访问权限ID
	@XmlElement(name = "appId")
	private Integer appId;//应用系统id
	@XmlElement(name = "interfaceId")
	private Integer interfaceId;//接口id
	private String appName;  //应用接口名称
	
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public Integer getInterfaceId() {
		return interfaceId;
	}
	public void setInterfaceId(Integer interfaceId) {
		this.interfaceId = interfaceId;
	}
	
}

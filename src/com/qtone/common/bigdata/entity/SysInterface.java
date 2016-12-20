package com.qtone.common.bigdata.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 *统一平台借口(提供给第三方的借口)
 * 
 * @author tzp
 * 
 */
@XmlRootElement(name = "SysInterfaces")
@XmlType(name = "SysInterface")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysInterface  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4384552816148205909L;
	@XmlElement(name = "id")
	private Long id;//接口ID
	@XmlElement(name = "interfaceUrl")
	private String interfaceUrl;  //接口地址
	@XmlElement(name = "interfaceName")
	private String interfaceName;//接口名称
	@XmlElement(name = "interfaceAppCode")
	private String interfaceAppCode; //接口所属系统代码
	@XmlElement(name = "interfaceType")
	private String interfaceType;  //接口类型
	@XmlElement(name = "interfaceCode")
	private String interfaceCode;//接口代码
	@XmlElement(name = "interfacePara")
	private String interfacePara;//接口参数
	@XmlElement(name = "interfaceUsage")
	private String interfaceUsage;//接口说明
	@XmlElement(name = "interfaceParent")
	private Integer interfaceParent; //上级接口
	@XmlElement(name = "interfaceReturn")
	private String interfaceReturn; //返回值说明
	@XmlElement(name = "interfaceAppName")
	private String interfaceAppName;//接口所属系统名称
	@XmlElement(name = "createDate")
	private String createDate;//创建时间
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getInterfaceCode() {
		return interfaceCode;
	}
	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}
	public String getInterfacePara() {
		return interfacePara;
	}
	public void setInterfacePara(String interfacePara) {
		this.interfacePara = interfacePara;
	}
	public String getInterfaceUsage() {
		return interfaceUsage;
	}
	public void setInterfaceUsage(String interfaceUsage) {
		this.interfaceUsage = interfaceUsage;
	}
	public String getInterfaceUrl() {
		return interfaceUrl;
	}
	public void setInterfaceUrl(String interfaceUrl) {
		this.interfaceUrl = interfaceUrl;
	}
	public String getInterfaceAppCode() {
		return interfaceAppCode;
	}
	public void setInterfaceAppCode(String interfaceAppCode) {
		this.interfaceAppCode = interfaceAppCode;
	}
	public String getInterfaceType() {
		return interfaceType;
	}
	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}
	public Integer getInterfaceParent() {
		return interfaceParent;
	}
	public void setInterfaceParent(Integer interfaceParent) {
		this.interfaceParent = interfaceParent;
	}
	public String getInterfaceReturn() {
		return interfaceReturn;
	}
	public void setInterfaceReturn(String interfaceReturn) {
		this.interfaceReturn = interfaceReturn;
	}
	public String getInterfaceAppName() {
		return interfaceAppName;
	}
	public void setInterfaceAppName(String interfaceAppName) {
		this.interfaceAppName = interfaceAppName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	

}

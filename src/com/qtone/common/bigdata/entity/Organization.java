package com.qtone.common.bigdata.entity;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 机构信息
 * 
 * @author tzp
 * 
 */
@XmlRootElement(name = "Organizations")
@XmlType(name = "Organization")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
	private static final long serialVersionUID = 4594268340794145039L;
	@XmlElement(name = "orgId")
	private Long orgId;// 组织机构ID
	@XmlElement(name = "orgName")
	private String orgName;// 组织机构名称
	@XmlElement(name = "orgFullName")
	private String orgFullName;// 组织机构全称
	@XmlElement(name = "parentOrg")
	private Organization parentOrg;// 父组织机构
	@XmlElement(name = "region")
	private Region region;// 所属区域
	@XmlElement(name = "likeCode")
	private String likeCode;// 参考代码
	@XmlElement(name = "orgKindCode")
	private String orgKindCode;// 组织类别
	@XmlElement(name = "orgOrder")
	private String orgOrder;// 组织机构排序
	@XmlElement(name = "orgLevel")
	private int orgLevel;// 组织机构级别
	@XmlElement(name = "linkMan")
	private String linkMan;// 联系人
	@XmlElement(name = "linkTel")
	private String linkTel;// 联系电话
	@XmlElement(name = "address")
	private String address;// 地址
	@XmlElement(name = "homePage")
	private String homePage;// 主页
	@XmlElement(name = "email")
	private String email;// 邮箱
	@XmlElement(name = "remark")
	private String remark;// 备注
	
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgFullName() {
		return orgFullName;
	}
	public void setOrgFullName(String orgFullName) {
		this.orgFullName = orgFullName;
	}
	public Organization getParentOrg() {
		return parentOrg;
	}
	public void setParentOrg(Organization parentOrg) {
		this.parentOrg = parentOrg;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public String getLikeCode() {
		return likeCode;
	}
	public void setLikeCode(String likeCode) {
		this.likeCode = likeCode;
	}
	public String getOrgKindCode() {
		return orgKindCode;
	}
	public void setOrgKindCode(String orgKindCode) {
		this.orgKindCode = orgKindCode;
	}
	public String getOrgOrder() {
		return orgOrder;
	}
	public void setOrgOrder(String orgOrder) {
		this.orgOrder = orgOrder;
	}
	public int getOrgLevel() {
		return orgLevel;
	}
	public void setOrgLevel(int orgLevel) {
		this.orgLevel = orgLevel;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	

}

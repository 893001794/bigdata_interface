package com.qtone.common.bigdata.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 *学校信息
 * @author tzp
 *
 */
@XmlRootElement(name = "SysSchools")
@XmlType(name = "SysSchool")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysSchool implements Serializable {
	private static final long serialVersionUID = 884498500093802465L;
	@XmlElement(name = "schoolId")
	private Long schoolId;// 学校ID
	@XmlElement(name = "schoolLevel")
	private Integer schoolLevel; //学校层次
	@XmlElement(name = "schoolType")
	private Integer schoolType; //学校类别
	@XmlElement(name = "schoolName")
	private String schoolName;// 学校名称
	@XmlElement(name = "schoolFullName")
	private String schoolFullName;// 学校全称
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
	
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolFullName() {
		return schoolFullName;
	}
	public void setSchoolFullName(String schoolFullName) {
		this.schoolFullName = schoolFullName;
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
	public Integer getSchoolLevel() {
		return schoolLevel;
	}
	public void setSchoolLevel(Integer schoolLevel) {
		this.schoolLevel = schoolLevel;
	}
	public Integer getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(Integer schoolType) {
		this.schoolType = schoolType;
	}

}

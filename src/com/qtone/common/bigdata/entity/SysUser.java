package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * 用户信息
 * @author Administrator
 *
 */
@XmlRootElement(name = "SysUsers")
@XmlType(name = "SysUser")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysUser implements Serializable{
	private static final long serialVersionUID = 6332604593530045598L;
	@XmlElement(name = "user_id")
	private Integer userId; //用户Id
	@XmlElement(name = "login_name")
	private String loginName; //登录账号
	@XmlElement(name = "user_name")
	private String userName;  //姓名
	@XmlElement(name = "gender")
	private Integer gender; //性别：0-男，1-女
	@XmlElement(name = "email")
	private String email; //邮件
	@XmlElement(name = "mobile")
	private String mobile; //手机
	@XmlElement(name = "card_type")
	private Integer cardType; //1-身份证,2-回乡证,3-侨胞证,4-军官证,5-其他
	@XmlElement(name = "card_num")
	private String cardNum; //证件号
	@XmlElement(name = "is_teacher")
	private Integer isTeacher; //是否教师
	@XmlElement(name = "is_student")
	private Integer isStudent; //是否教师
	private String regionName; //居住区域y页面显示
	
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Integer getIsTeacher() {
		return isTeacher;
	}
	public void setIsTeacher(Integer isTeacher) {
		this.isTeacher = isTeacher;
	}
	public Integer getIsStudent() {
		return isStudent;
	}
	public void setIsStudent(Integer isStudent) {
		this.isStudent = isStudent;
	}
	
	
	
	
}

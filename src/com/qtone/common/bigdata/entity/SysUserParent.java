package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * 家长信息
 * @author tzp
 *
 */
@XmlRootElement(name = "sysUserParents")
@XmlType(name = "sysUserParent")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysUserParent implements Serializable{
	private static final long serialVersionUID = 7367338054828547729L;
	@XmlElement(name = "parent_id")
	private Integer id; //教师id
	@XmlElement(name = "user_id")
	private Integer userId; //用户id
	@XmlElement(name = "card_type")
	private String cardType;  //学校id
	@XmlElement(name = "card_num")
	private String cardNum; //继教号
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
}

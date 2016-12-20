package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *推送信息
 * @author tzp
 *
 */
@XmlRootElement(name = "SysPushMessages")
@XmlType(name = "SysPushMessage")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysPushMessage implements Serializable{
	private static final long serialVersionUID = -8855632553016724116L;
	@XmlElement(name = "pushId")
	private Integer pushId;  //消息推送Id
	@XmlElement(name = "userId")
	private Integer userId;  //消息接收者Id
	@XmlElement(name = "title")
	private String title;  //消息标题
	@XmlElement(name = "messageContent")
	private String messageContent; //消息内容
	@XmlElement(name = "messageUrl")
	private String messageUrl;  //消息对应连接地址
	@XmlElement(name = "othMsgId")
	private String othMsgId;  //第三方消息ID(第三方提供的唯一ID)
	@XmlElement(name = "validDate")
	private String validDate; //有效日期
	@XmlElement(name = "pushData")
	private String pushData;  //推送日期
	@XmlElement(name = "statu")
	private Integer status;  //状态(1-未读，2-已读)
	
	public Integer getPushId() {
		return pushId;
	}
	public void setPushId(Integer pushId) {
		this.pushId = pushId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getMessageUrl() {
		return messageUrl;
	}
	public void setMessageUrl(String messageUrl) {
		this.messageUrl = messageUrl;
	}
	public String getOthMsgId() {
		return othMsgId;
	}
	public void setOthMsgId(String othMsgId) {
		this.othMsgId = othMsgId;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public String getPushData() {
		return pushData;
	}
	public void setPushData(String pushData) {
		this.pushData = pushData;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

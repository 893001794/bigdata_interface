package com.qtone.common.bigdata.model;

import java.io.Serializable;

import com.qtone.common.bigdata.entity.SysPushMessage;
/**
 *推送接口form
 * @author tzp
 *
 */
public class SysPushMessageForm extends SysPushMessage implements Serializable {
	private static final long serialVersionUID = -7543331381606783203L;
	private String validDateStart;//推送开始时间
	private String validDateEnd; //推送的结束时间
	private String longName ; //登录账号
	private String pushDataStart;//推送开始时间
	private String pushDataEnd ;//推送结束时间
	public String getValidDateStart() {
		return validDateStart;
	}
	public void setValidDateStart(String validDateStart) {
		this.validDateStart = validDateStart;
	}
	public String getValidDateEnd() {
		return validDateEnd;
	}
	public void setValidDateEnd(String validDateEnd) {
		this.validDateEnd = validDateEnd;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getPushDataStart() {
		return pushDataStart;
	}
	public void setPushDataStart(String pushDataStart) {
		this.pushDataStart = pushDataStart;
	}
	public String getPushDataEnd() {
		return pushDataEnd;
	}
	public void setPushDataEnd(String pushDataEnd) {
		this.pushDataEnd = pushDataEnd;
	}
}

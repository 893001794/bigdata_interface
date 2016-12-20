package com.qtone.common.bigdata.model;

import com.qtone.common.bigdata.entity.SysClass;

/**
 * 班级的form
 * @author Administrator
 *
 */
public class SysClassForm extends SysClass{
	private static final long serialVersionUID = 6104474072035170450L;
	private String schoolName;//学校名称
	private String gradeName; //年级名称
	private String className; //班名称
	private String headmasterName; //班主任
	private String schoolYear; //学年
	private String identityName; //标示班级的唯一预算
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	public String getIdentityName() {
		return identityName;
	}
	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}
	public String getHeadmasterName() {
		return headmasterName;
	}
	public void setHeadmasterName(String headmasterName) {
		this.headmasterName = headmasterName;
	}
	
	
}

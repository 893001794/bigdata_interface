package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 *教师信息
 * @author tzp
 *
 */
@XmlRootElement(name = "SysUserTeachers")
@XmlType(name = "SysUserTeacher")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysUserTeacher implements Serializable{
	private static final long serialVersionUID = -561777171252955111L;
	@XmlElement(name = "id")
	private Integer id; //教师id
	@XmlElement(name = "user_id")
	private Integer userId; //用户id
	@XmlElement(name = "school_id")
	private Integer schoolId;  //学校id
	@XmlElement(name = "teacher_edu_num")
	private String TeacherEduNum; //继教号
	
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
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getTeacherEduNum() {
		return TeacherEduNum;
	}
	public void setTeacherEduNum(String teacherEduNum) {
		TeacherEduNum = teacherEduNum;
	}
	
}

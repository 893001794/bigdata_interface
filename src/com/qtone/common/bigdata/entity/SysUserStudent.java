package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 *学生信息
 * @author tzp
 *
 */
@XmlRootElement(name = "sysUserStudents")
@XmlType(name = "sysUserStudent")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysUserStudent implements Serializable{
	private static final long serialVersionUID = -1951560383466915405L;
	@XmlElement(name = "student_id")
	private Integer studentId ;//学生Id
	@XmlElement(name = "user_id")
	private Integer userId ;  // 用户Id;
	@XmlElement(name = "school_id")
	private Integer schoolId ;  //学校Id
	@XmlElement(name = "class_id")
	private Integer classId; //班级Id
	@XmlElement(name = "student_number")
	private String studentNumber; //学号
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	
}

package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 教师班级关联表
 * @author tzp
 *
 */
@XmlRootElement(name = "SysTeacherGrades")
@XmlType(name = "SysTeacherGrade")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysTeacherClass implements Serializable{
	private static final long serialVersionUID = -3444420416772378953L;
	@XmlElement(name = "teacher_grade_id")
	private Integer id; //教师班级关联id
	@XmlElement(name = "teacher_id")
	private Integer teacherId; //教师id
	@XmlElement(name = "class_id")
	private Integer classId; //年级id
	@XmlElement(name = "subject_id")
	private Integer subjectId; //学科id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	
	
	
}

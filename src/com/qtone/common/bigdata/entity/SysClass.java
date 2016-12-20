package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * 年级表
 * @author tzp
 *
 */
@XmlRootElement(name = "SysClasss")
@XmlType(name = "SysClass")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysClass implements Serializable {
	private static final long serialVersionUID = 2613742199546070789L;
	@XmlElement(name = "class_id")
	private Integer classId; //班级id
	@XmlElement(name = "school_id")
	private Long schoolId; //学校id
	@XmlElement(name = "class_name")
	private String className; //班级名称
	@XmlElement(name = "identity_name")
	private String identityName; //班级名称
	@XmlElement(name = "grade_id")
	private Integer gradeId; //年级Id
	@XmlElement(name = "headmaster")
	private Integer headmaster; //班主任
	@XmlElement(name = "school_year_id")
	private Integer schoolYearId; //班主任
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getIdentityName() {
		return identityName;
	}
	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public Integer getHeadmaster() {
		return headmaster;
	}
	public void setHeadmaster(Integer headmaster) {
		this.headmaster = headmaster;
	}
	public Integer getSchoolYearId() {
		return schoolYearId;
	}
	public void setSchoolYearId(Integer schoolYearId) {
		this.schoolYearId = schoolYearId;
	}
	

}

package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * 学期表
 * @author tzp
 *
 */
@XmlRootElement(name = "SysSemesters")
@XmlType(name = "SysSemester")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysSemester implements Serializable {
	private static final long serialVersionUID = -5612724552413287561L;
	@XmlElement(name = "semester_id")
	private Integer semesterId; //学年id
	@XmlElement(name = "start_date")
	private String startDate; //起始日期
	@XmlElement(name = "end_date")
	private String endDate; //结束日期
	@XmlElement(name = "semester_name")
	private String semesterName; //学期名称:01:是上学期，02:是下学期
	@XmlElement(name = "school_year_id")
	private Integer schoolYearId; //学年ID
	public Integer getSemesterId() {
		return semesterId;
	}
	public void setSemesterId(Integer semesterId) {
		this.semesterId = semesterId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getSemesterName() {
		return semesterName;
	}
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	public Integer getSchoolYearId() {
		return schoolYearId;
	}
	public void setSchoolYearId(Integer schoolYearId) {
		this.schoolYearId = schoolYearId;
	}
	
	

}

package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * 学年表
 * @author tzp
 *
 */
@XmlRootElement(name = "SysSchoolYears")
@XmlType(name = "SysSchoolYear")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysSchoolYear implements Serializable {
	private static final long serialVersionUID = 2966130749006966659L;
	@XmlElement(name = "school_year_id")
	private Integer schoolYearId; //学年id
	@XmlElement(name = "school_year_name")
	private String schoolYearName; //学年名称
	@XmlElement(name = "school_year")
	private Integer schoolYear; //学年年份
	public Integer getSchoolYearId() {
		return schoolYearId;
	}
	public void setSchoolYearId(Integer schoolYearId) {
		this.schoolYearId = schoolYearId;
	}
	
	public Integer getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(Integer schoolYear) {
		this.schoolYear = schoolYear;
	}
	public String getSchoolYearName() {
		return schoolYearName;
	}
	public void setSchoolYearName(String schoolYearName) {
		this.schoolYearName = schoolYearName;
	}
	
	
	
}

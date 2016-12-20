package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * 学科表
 * @author tzp
 *
 */
@XmlRootElement(name = "SysSubjects")
@XmlType(name = "SysSubject")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysSubject implements Serializable {
	private static final long serialVersionUID = 2057534337714908004L;
	@XmlElement(name = "subject_id")
	private Integer subjectId; //学科id
	@XmlElement(name = "subject_code")
	private String subjectCode; //学科编号
	@XmlElement(name = "subject_name")
	private String subjectName; //学科名称
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
}

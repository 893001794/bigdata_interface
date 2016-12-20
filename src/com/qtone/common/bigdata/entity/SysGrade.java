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
@XmlRootElement(name = "SysGrades")
@XmlType(name = "SysGrade")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysGrade implements Serializable {
	private static final long serialVersionUID = -2880709064775531894L;
		@XmlElement(name = "GRADE_ID")
		private Integer gradeId; //年级id
		@XmlElement(name = "grade_code")
		private String gradeCode; //年级编号
		@XmlElement(name = "grade_name")
		private String gradeName; //年级名称
		@XmlElement(name = "grade_level")
		private Integer gradeLevel; //类型：1-幼儿园2-小学;3-初中;4-高中;5-中专、中职;6-其他
		public Integer getGradeId() {
			return gradeId;
		}
		public void setGradeId(Integer gradeId) {
			this.gradeId = gradeId;
		}
		public String getGradeCode() {
			return gradeCode;
		}
		public void setGradeCode(String gradeCode) {
			this.gradeCode = gradeCode;
		}
		public String getGradeName() {
			return gradeName;
		}
		public void setGradeName(String gradeName) {
			this.gradeName = gradeName;
		}
		public Integer getGradeLevel() {
			return gradeLevel;
		}
		public void setGradeLevel(Integer gradeLevel) {
			this.gradeLevel = gradeLevel;
		}
		
		
}

package com.qtone.common.bigdata.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * 年级科目表
 * @author tzp
 *
 */
@XmlRootElement(name = "SysGradeSubjects")
@XmlType(name = "SysGradeSubject")
@XmlAccessorType(XmlAccessType.FIELD)
public class sysGradeSubject implements Serializable {
	private static final long serialVersionUID = 3357725461325398056L;
		@XmlElement(name = "grade_subject_id")
		private Integer gradeSubjectId; //年级科目表id
		@XmlElement(name = "subject_id")
		private Integer subjectId; //科目id
		@XmlElement(name = "grade_id")
		private Integer gradeId; //年级id
		public Integer getGradeSubjectId() {
			return gradeSubjectId;
		}
		public void setGradeSubjectId(Integer gradeSubjectId) {
			this.gradeSubjectId = gradeSubjectId;
		}
		public Integer getSubjectId() {
			return subjectId;
		}
		public void setSubjectId(Integer subjectId) {
			this.subjectId = subjectId;
		}
		public Integer getGradeId() {
			return gradeId;
		}
		public void setGradeId(Integer gradeId) {
			this.gradeId = gradeId;
		}
		
}

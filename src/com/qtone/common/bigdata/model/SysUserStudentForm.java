package com.qtone.common.bigdata.model;

import com.qtone.common.bigdata.entity.SysUserStudent;
/**
 * 接口参数Form
 * @author tzp
 *
 */
public class SysUserStudentForm extends SysUserStudent {
	private static final long serialVersionUID = 706775142399703949L;
	private Integer schoolCode; //学校名称
	private String schoolName; //学校名称
	private String subjectCode; //学科编号
	private String subjectName; //学科名称
	private String gradeCode; //年级编号
	private String gradeName;//年级名称
	private Integer classId; //班级id
	private String className; //班级名称
	private String semesterName;//学期
	private String schoolYearName; //教课学年
	private String term; //学期1:上学期，2：下学期
	public Integer getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(Integer schoolCode) {
		this.schoolCode = schoolCode;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
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
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSemesterName() {
		return semesterName;
	}
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	public String getSchoolYearName() {
		return schoolYearName;
	}
	public void setSchoolYearName(String schoolYearName) {
		this.schoolYearName = schoolYearName;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	

}

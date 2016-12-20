package com.qtone.common.bigdata.model;

public class UserInfo {
	private String ret_code	;//调用结果编码(此输出参数命名必须一致，并且成功必须返回10000)
	private String ret_msg;//调用结果描述(此输出参数命名必须一致)
	private String user_id;//用户id(此参数可任意命名)
	private String user_name;//用户名(此参数可任意命名)
	private String real_name;//真实姓名
	private String user_type;//用户类型，1:学生;２:家长;３:教师(此参数可任意命名)
	private String is_try;//是否试用，1:是；0:否
	private String school_code;//学校code(此参数可任意命名)
	private String school_name;//学校名称(此参数可任意命名)
	private String grade_code;//年级code(此参数可任意命名)
	private String grade_name;//年级名称(此参数可任意命名)
	private String class_code;//班级code(此参数可任意命名)
	private String class_name;//班级名称 (此参数可任意命名)
	private String product_list;//	购买产品清单
	public String getRet_code() {
		return ret_code;
	}
	public void setRet_code(String ret_code) {
		this.ret_code = ret_code;
	}
	public String getRet_msg() {
		return ret_msg;
	}
	public void setRet_msg(String ret_msg) {
		this.ret_msg = ret_msg;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getIs_try() {
		return is_try;
	}
	public void setIs_try(String is_try) {
		this.is_try = is_try;
	}
	public String getSchool_code() {
		return school_code;
	}
	public void setSchool_code(String school_code) {
		this.school_code = school_code;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getGrade_code() {
		return grade_code;
	}
	public void setGrade_code(String grade_code) {
		this.grade_code = grade_code;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public String getClass_code() {
		return class_code;
	}
	public void setClass_code(String class_code) {
		this.class_code = class_code;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getProduct_list() {
		return product_list;
	}
	public void setProduct_list(String product_list) {
		this.product_list = product_list;
	}
	

}

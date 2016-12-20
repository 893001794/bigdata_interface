package com.qtone.common.service;

import com.qtone.common.util.JsonView;

import net.sf.json.JSONObject;



/**
 * @title 持久层接口
 * 
 *       学生接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysUserStudentService {
	/**
	 * 根据学生名称和学号查询学生信息
	 * @param StuNumber 学号
	 * @return JSONObject
	 */
	public JSONObject findStudentByStuNo(String stuNumber);
	/**
	 * 跟人教e学对接是查看改学生所能看到的本学期科目权限
	 * @param userId
	 * @param year
	 * @return
	 */
	public JsonView  findStudentSubject(Integer userId,Integer year);

}

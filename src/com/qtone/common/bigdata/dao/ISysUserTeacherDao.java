package com.qtone.common.bigdata.dao;
import java.util.Collection;

import com.qtone.common.bigdata.entity.SysUserTeacher;
import com.qtone.common.bigdata.model.SysUserTeacherForm;



/**
 * @title 持久层接口
 * 
 *       教师接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysUserTeacherDao {
	/**
	 * 根据继教号查询教师信息
	 * @param eduNumber: 继教号
	 * @return 教师对象
	 */
	public SysUserTeacher findTeacherByEduNo(String eduNumber);
	/**
	 * 根据用户Id查询该教师的详细信息，包括(所在学校、所教学科、所教年级)
	 * @param userId
	 * @return 
	 */
	public Collection<SysUserTeacherForm> findTeacherInfor(Integer userId,Integer year);

}

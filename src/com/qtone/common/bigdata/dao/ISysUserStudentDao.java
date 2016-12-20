package com.qtone.common.bigdata.dao;

import java.util.Collection;

import com.qtone.common.bigdata.entity.SysUserStudent;
import com.qtone.common.bigdata.model.SysUserStudentForm;



/**
 * @title 持久层接口
 * 
 *       学生接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysUserStudentDao {
	/**
	 * 根据学生名称和学号查询学生信息
	 * @param StuNumber 学号
	 * @return 学生对象
	 */
	public SysUserStudent findStudentByStuNo(String stuNumber);
	/**
	 * 跟人教e学对接是查看改学生所能看到的本学期科目权限
	 * @param userId
	 * @param year
	 * @return
	 */
	public Collection<SysUserStudentForm> findStudentSubject(Integer userId,Integer year);

}

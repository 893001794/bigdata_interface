package com.qtone.common.bigdata.dao;

import java.util.Collection;

import com.qtone.common.bigdata.entity.SysSchool;
import com.qtone.common.bigdata.model.SysSchoolForm;

/**
 * @title 持久层接口
 * 
 *        学校接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysSchoolDao {
	/**
	 * 根据名称查询学校信息
	 * @param schoolName学校名称
	 * @return 学校对象
	 */
	public SysSchoolForm findSchoolByName(String schoolName);
	/**
	 * 根据id查询学校信息
	 * @param schoolName学校名称
	 * @return 学校对象
	 */
	public SysSchoolForm findSchoolById(Integer schoolId);
	/**
	 * 根据组织查询学校
	 * @param orgId
	 * @return
	 */
	Collection<SysSchool> findSchoolByOrgId(Long orgId);

}

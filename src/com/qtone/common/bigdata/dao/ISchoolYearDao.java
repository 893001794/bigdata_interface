package com.qtone.common.bigdata.dao;

import com.qtone.common.bigdata.entity.SysGrade;
import com.qtone.common.bigdata.entity.SysSchoolYear;

/**
 * @title 持久层接口
 * 
 *        学年接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISchoolYearDao {
	/**
	 * 添加学期
	 * @param sysClass
	 */
	public void saveSchoolYear(SysSchoolYear schoolYear);
	
}

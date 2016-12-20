package com.qtone.common.bigdata.dao;

import com.qtone.common.bigdata.entity.SysUserParent;

/**
 * @title 持久层接口
 * 
 *        家长接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysUserParentDao {
	/**
	 * 根据家长名称和孩子的学号查询家长信息
	 * @param StuNumber 孩子的学号
	 * @return 家长对象
	 */
	public SysUserParent findParentByStuNo(String StuNumber);

}

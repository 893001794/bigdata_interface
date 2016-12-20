package com.qtone.common.bigdata.dao;

import com.qtone.common.bigdata.entity.SysGrade;

/**
 * @title 持久层接口
 * 
 *        年级接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface IGadeDao {
	/**
	 * 添加年级
	 * @param grade
	 */
	public void saveGade(SysGrade grade);
	/**
	 * 更改年级
	 * @param grade
	 */
	public void updateGade(SysGrade grade);
}

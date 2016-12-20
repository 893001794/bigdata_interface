package com.qtone.common.service;

import net.sf.json.JSONObject;
/**
 *家长信息
 * @author Administrator
 *
 */
public interface ISysUserParentService {
	/**
	 * 根据家长名称和孩子的学号查询家长信息
	 * @param StuNumber 孩子的学号
	 * @return JSONObject
	 */
	public JSONObject findParentByNameStuNo(String stuNumber);
}

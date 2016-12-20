package com.qtone.common.service;

import net.sf.json.JSONArray;

/**
 * @title 持久层接口
 * 
 *        组织接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface IOrganizationService {
	/**
	 * 查询所组织信息
	 * @param sysInterface
	 * @return
	 */
	public JSONArray findAllOrg();
}

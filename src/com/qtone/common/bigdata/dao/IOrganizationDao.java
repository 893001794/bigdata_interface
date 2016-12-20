package com.qtone.common.bigdata.dao;

import java.util.Collection;

import com.qtone.common.bigdata.entity.Organization;
import com.qtone.common.bigdata.entity.Region;

/**
 * @title 持久层接口
 * 
 *        组织接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface IOrganizationDao {
	/**
	 * 查询所组织信息
	 * @param sysInterface
	 * @return
	 */
	public Collection<Organization> findAllOrg();
}

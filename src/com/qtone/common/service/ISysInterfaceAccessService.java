package com.qtone.common.service;

import net.sf.json.JSONArray;

import com.qtone.common.bigdata.entity.SysInterfaceAccess;

/**
 * @title 持久层接口
 * 
 *        统一平台借口访问权限(判断第三方是否有权限访问该平台)接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysInterfaceAccessService {
	/**
	 * 查询该第三方是否拥有可以访问的权限
	 * @param appkey  第三方访问的appKey
	 * @param action  借口名称
	 * @return  返回统一平台接口访问权限
	 */
	public SysInterfaceAccess isAccess(String appkey,String action);
	/**
	 * 根据登录账号查询授权的应用
	 * @param loginName
	 * @return
	 */
	public JSONArray findAppsByLoginName(String loginName);
}


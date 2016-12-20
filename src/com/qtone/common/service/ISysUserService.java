package com.qtone.common.service;

import net.sf.json.JSONObject;

import com.qtone.common.bigdata.entity.SysUser;
/**
 * @title 持久层接口
 * 
 *        用户接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysUserService {
	/**
	 * 根据id查询用户信息信息
	 * @userId 用户Id
	 * @return 用户对象
	 */
	public SysUser findUserById(Integer userId);
	/**
	 * 根据大数据登录账号查询用户对象
	 * @param loginName
	 * @return
	 */
	public SysUser finSysUserByLoginName(String loginName);
	/**
	 * 根据大数据登录账号查询用户对象,返回JsonObject
	 * @param loginName
	 * @return
	 */
	public JSONObject finUserByLoginName(String loginName);

}

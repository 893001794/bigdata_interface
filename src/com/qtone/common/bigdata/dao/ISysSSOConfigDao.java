package com.qtone.common.bigdata.dao;
/**
 * @title 持久层接口
 * 
 *        单点登陆用户映射表接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysSSOConfigDao {
	/**
	 * 根据大数据登录账户和第三方账号查询是否绑定
	 * @param appId 
	 * @param loginName 大数据登录账号
	 * @param appLoginName 第三方登录账号
	 * @return
	 */
	public boolean findByDigDateNameAppName(Integer appId,String loginName, String appLoginName);

}

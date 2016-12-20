package com.qtone.common.service;
/**
 * 学校信息服务接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysSSOConfigService {
	/**
	 * 根据大数据登录账户和第三方账号查询是否绑定
	 * @param appid 
	 * @param loginName 大数据登录账号
	 * @param appLoginName 第三方登录账号
	 * @return
	 */
	public boolean findByDigDateNameAppName(Integer appId,String loginName, String appLoginName);

}

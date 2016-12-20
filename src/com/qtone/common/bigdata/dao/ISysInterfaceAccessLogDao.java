package com.qtone.common.bigdata.dao;

import com.qtone.common.bigdata.entity.SysInterfaceAccessLog;
/**
 * 统一平台接口日志接口
 * @author tzp
 *
 */
public interface ISysInterfaceAccessLogDao {
	/**
	 * 添加统一平台接口日志
	 * @return
	 */
	public void saveInterfaceAccessLog(SysInterfaceAccessLog interfaceAccessLog);
}

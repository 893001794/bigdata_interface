package com.qtone.common.service;

import com.qtone.common.bigdata.entity.SysInterfaceAccessLog;

/**
 * 统一平台接口日志接口
 * @author tzp
 *
 */
public interface ISysInterfaceAccessLogService {
	/**
	 * 添加统一平台接口日志
	 * @return
	 */
	public void saveInterfaceAccessLog(SysInterfaceAccessLog interfaceAccessLog);
}

package com.qtone.common.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtone.common.bigdata.dao.ISysInterfaceAccessLogDao;
import com.qtone.common.bigdata.entity.SysInterfaceAccessLog;
@Service
public class ISysInterfaceAccessLogServiceImpl implements
		ISysInterfaceAccessLogService {
	@Autowired
	private ISysInterfaceAccessLogDao sysInterfaceAccessLogDao;
	@Override
	public void saveInterfaceAccessLog(SysInterfaceAccessLog interfaceAccessLog) {
		sysInterfaceAccessLogDao.saveInterfaceAccessLog(interfaceAccessLog);
	}

}

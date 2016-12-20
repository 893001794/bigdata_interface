package com.qtone.common.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtone.common.bigdata.dao.ISysSSOConfigDao;


/**
 *  单点登陆用户映射表接口现类
 * @version 1.0
 * @author tzp
 * 
 */
@Service
public  class ISysSSOConfigServiceImpl implements ISysSSOConfigService {
	@Autowired
	private ISysSSOConfigDao sysSSOConfigDao;
	@Override
	public boolean findByDigDateNameAppName(Integer appId,String loginName,String appLoginName) {
		return sysSSOConfigDao.findByDigDateNameAppName(appId,loginName, appLoginName);
	}
	
}

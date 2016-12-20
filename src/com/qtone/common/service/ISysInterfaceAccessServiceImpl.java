package com.qtone.common.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtone.common.bigdata.dao.ISysInterfaceAccessDao;
import com.qtone.common.bigdata.entity.SysApp;
import com.qtone.common.bigdata.entity.SysInterfaceAccess;

/**
 * @title 持久层接口
 * 
 *        统一平台借口访问权限(判断第三方是否有权限访问该平台)接口
 * @version 1.0
 * @author tzp
 * 
 */
@Service
public class ISysInterfaceAccessServiceImpl implements ISysInterfaceAccessService{
	@Autowired
	private ISysInterfaceAccessDao sysInterfaceAccessDao;
	@Override
	public SysInterfaceAccess isAccess(String appkey, String action) {
		return sysInterfaceAccessDao.isAccess(appkey, action);
	}
	@Override
	public JSONArray findAppsByLoginName(String loginName) {
		//根据登录账号获取权限信息
		List<SysApp> apps=sysInterfaceAccessDao.findAppsByLoginName(loginName);
		JSONArray jsonArr=JSONArray.fromObject(apps);
		return jsonArr;
	}
	
	
}

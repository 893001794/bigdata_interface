package com.qtone.common.service;

import net.sf.json.JSONObject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qtone.common.bigdata.dao.ISysUserDao;
import com.qtone.common.bigdata.entity.SysUser;
/**
 * 用户信息服务接口实现类
 * @version 1.0
 * @author tzp
 * 
 */
@Service
public class ISysUserServiceImpl implements ISysUserService {
	@Autowired
	private ISysUserDao sysUserDao;
	
	@Override
	public SysUser findUserById(Integer userId) {
		return sysUserDao.findUserById(userId);
	}

	@Override
	public SysUser finSysUserByLoginName(String loginName) {
		return sysUserDao.finSysUserByLoginName(loginName);
	}
	
	@Override
	public JSONObject finUserByLoginName(String loginName) {
		//获取用户信息
		SysUser sysUser=sysUserDao.finSysUserByLoginName(loginName);
		JSONObject json=new JSONObject();
		json.put("LoginName",sysUser.getLoginName());
		json.put("UserName",sysUser.getUserName());
		json.put("Gender",sysUser.getGender());
		json.put("Email",sysUser.getEmail());
		json.put("Mobile",sysUser.getMobile());
		json.put("RegionName",sysUser.getRegionName());
		json.put("IdCardType",sysUser.getCardType());
		json.put("IdCardNum",sysUser.getCardNum());
		return json;
	}
}

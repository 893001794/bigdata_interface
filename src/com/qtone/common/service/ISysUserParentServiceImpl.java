package com.qtone.common.service;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtone.common.bigdata.dao.ISysUserDao;
import com.qtone.common.bigdata.dao.ISysUserParentDao;
import com.qtone.common.bigdata.entity.SysUser;
import com.qtone.common.bigdata.entity.SysUserParent;
/**
 * 家长服务接口实现类
 * @version 1.0
 * @author tzp
 * 
 */
@Service
public class ISysUserParentServiceImpl implements ISysUserParentService{
	@Autowired
	private ISysUserParentDao sysUserParentDao;
	@Autowired
	private ISysUserDao sysUserDao;
	@Override
	public JSONObject findParentByNameStuNo(String stuNumber) {
		//根据学籍号获取家长信息
		SysUserParent sysUserParent =sysUserParentDao.findParentByStuNo(stuNumber);
		//根据id获取用户信息
		SysUser sysUser=sysUserDao.findUserById(sysUserParent.getUserId());
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

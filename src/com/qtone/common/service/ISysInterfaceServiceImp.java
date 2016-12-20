package com.qtone.common.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.qtone.common.base.page.Page;
import com.qtone.common.bigdata.dao.ISysInterfaceDao;
import com.qtone.common.bigdata.entity.SysInterface;
import com.qtone.common.util.Message;
/**
 * @title 持久层接口
 * 
 *        接口交换接口
 * @version 1.0
 * @author tzp
 * 
 */
@Service
public class ISysInterfaceServiceImp implements ISysInterfaceService {
	@Autowired
	private ISysInterfaceDao sysInterfaceDao;
	@Override
	public Message saveSysInterface(SysInterface sysInterface) {
		Message msg=new Message();
		try {
			sysInterfaceDao.saveSysInterface(sysInterface);
			msg.setProperty("result", "success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Message updateByInterfaceId(SysInterface sysInterface) {
		Message msg=new Message();
		try {
			sysInterfaceDao.updateByInterfaceId(sysInterface);
			msg.setProperty("result", "success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Message deleteByInterfaceId(Integer interfaceId) {
		Message msg=new Message();
		try {
			sysInterfaceDao.deleteByInterfaceId(interfaceId);
			msg.setProperty("result", "success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Message findSysInterfaceById(Integer interfaceId) {
		Message msg=new Message();
		try {
			SysInterface sysInterface=sysInterfaceDao.findSysInterfaceById(interfaceId);
			msg.setProperty("sysInterface", sysInterface);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Message findAllSysInterface(SysInterface sysInterface) {
		Message msg=new Message();
		try {
			Collection<SysInterface> sysInterfaces=sysInterfaceDao.findAllSysInterface(sysInterface);
			msg.setProperty("sysInterfaces", sysInterfaces);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Message findSysInterfaceByPage(SysInterface sysInterface,
			Page<SysInterface> page) {
		Message msg=new Message();
		try {
			Page<SysInterface> sysInterfacePage=sysInterfaceDao.findSysInterfaceByPage(sysInterface, page);
			msg.setProperty("sysInterfacePage", sysInterfacePage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

}

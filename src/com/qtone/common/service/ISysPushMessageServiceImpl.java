package com.qtone.common.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtone.common.bigdata.dao.ISysPushMessageDao;
import com.qtone.common.bigdata.dao.ISysUserDao;
import com.qtone.common.bigdata.model.SysPushMessageForm;

/**
 * 推送接口接口实现类
 * @version 1.0
 * @author tzp
 * 
 */
@Service
public   class ISysPushMessageServiceImpl implements ISysPushMessageService{
	@Autowired
	private ISysPushMessageDao sysPushMessageDao;
	@Autowired
	private ISysUserDao sysUserDao;
	@Override
	public void savePushMessage(SysPushMessageForm sysPushMessage) {
		sysPushMessage.setUserId(sysUserDao.finSysUserByLoginName(sysPushMessage.getLongName()).getUserId());
		sysPushMessageDao.savePushMessage(sysPushMessage);
	}

	@Override
	public void updateByOthMsgId(String othMsgId) {
		sysPushMessageDao.updateByOthMsgId(othMsgId);
	}

	@Override
	public void deletePushMessageById(Integer pushId) {
		sysPushMessageDao.deletePushMessageById(pushId);
	}

}

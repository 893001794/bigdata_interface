package com.qtone.common.bigdata.dao;

import java.util.Collection;


import com.qtone.common.base.page.Page;
import com.qtone.common.bigdata.model.SysPushMessageForm;

/**
 * @title 持久层接口
 * 
 *        推送消息接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysPushMessageDao {
	/**
	 * 添加推送消息
	 * @param sysPushMessage
	 */
	public void savePushMessage(SysPushMessageForm  sysPushMessage);
	/**
	 * 推送消息将未读改已读
	 * @param othMsgId 
	 */
	public void updateByOthMsgId(String othMsgId);
	/**
	 * 根据id删除推送消息
	 * @param pushId 推送id
	 */
	public void deletePushMessageById(Integer pushId);
	/**
	 * 根据推送id查询
	 * @param pushId
	 * @return
	 */
	public SysPushMessageForm findPushMessageById(Integer pushId);
	/**
	 * 查询所有信息
	 * @param sysPushMessage
	 * @return
	 */
	public Collection<SysPushMessageForm> findAllPushMessage(SysPushMessageForm sysPushMessage);
	/**
	 * 分页查询推送消息
	 * @param sysPushMessage
	 * @param page
	 * @return
	 */
	public Page<SysPushMessageForm> findPushMessageByPage(SysPushMessageForm sysPushMessage,Page<SysPushMessageForm> page);

}

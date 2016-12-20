package com.qtone.common.service;
import com.qtone.common.bigdata.model.SysPushMessageForm;

/**
 * 推送服务接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysPushMessageService {
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

}

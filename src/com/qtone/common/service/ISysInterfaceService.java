package com.qtone.common.service;
import com.qtone.common.base.page.Page;
import com.qtone.common.bigdata.entity.SysInterface;
import com.qtone.common.util.Message;

/**
 * @title 持久层接口
 * 
 *        数据交换接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysInterfaceService {
	/**
	 * 添加接口管理
	 * @param sysInterface
	 */
	public Message saveSysInterface(SysInterface  sysInterface);
	/**
	 * 更改接口管理
	 * @param interfaceId 
	 */
	public Message updateByInterfaceId(SysInterface sysInterface);
	/**
	 * 根据id删除接口
	 * @param interfaceId 接口id
	 */
	public Message deleteByInterfaceId(Integer interfaceId);
	/**
	 * 根据接口id查询
	 * @param interfaceId
	 * @return
	 */
	public Message findSysInterfaceById(Integer interfaceId);
	/**
	 * 查询所有接口信息
	 * @param sysInterface
	 * @return
	 */
	public Message findAllSysInterface(SysInterface sysInterface);
	/**
	 * 分页查询接口管理消息
	 * @param sysInterface
	 * @param page
	 * @return
	 */
	public Message findSysInterfaceByPage(SysInterface sysInterface,Page<SysInterface> page);

}

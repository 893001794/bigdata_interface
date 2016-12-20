package com.qtone.common.bigdata.dao;

import java.util.Collection;
import com.qtone.common.base.page.Page;
import com.qtone.common.bigdata.entity.SysInterface;

/**
 * @title 持久层接口
 * 
 *        交换平台接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysInterfaceDao {
	/**
	 * 添加接口管理
	 * @param sysInterface
	 */
	public void saveSysInterface(SysInterface  sysInterface);
	/**
	 * 更改接口管理
	 * @param interfaceId 
	 */
	public void updateByInterfaceId(SysInterface sysInterface);
	/**
	 * 根据id删除接口
	 * @param interfaceId 接口id
	 */
	public void deleteByInterfaceId(Integer interfaceId);
	/**
	 * 根据接口id查询
	 * @param interfaceId
	 * @return
	 */
	public SysInterface findSysInterfaceById(Integer interfaceId);
	/**
	 * 查询所有接口信息
	 * @param sysInterface
	 * @return
	 */
	public Collection<SysInterface> findAllSysInterface(SysInterface sysInterface);
	/**
	 * 分页查询接口管理消息
	 * @param sysInterface
	 * @param page
	 * @return
	 */
	public Page<SysInterface> findSysInterfaceByPage(SysInterface sysInterface,Page<SysInterface> page);

}

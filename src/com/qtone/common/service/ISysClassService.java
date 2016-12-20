package com.qtone.common.service;
import com.qtone.common.bigdata.entity.SysClass;
import com.qtone.common.bigdata.model.SysClassForm;
import com.qtone.common.util.JsonView;
/**
 * 学校信息服务接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysClassService {
	/**
	 * 保存班信息
	 * @param schoolName  学校名称
	 * @return
	 */
	public JsonView saveClass(SysClassForm sysClass);
	/**
	 * 更改班信息
	 * @param SysClass  班级
	 * @return
	 */
	public JsonView updateClass(SysClass sysClass);
}

package com.qtone.common.service;
import java.util.Collection;

import com.qtone.common.bigdata.model.SysSchoolForm;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 学校信息服务接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysSchoolService {
	/**
	 * 获取学校信息
	 * @param schoolName  学校名称
	 * @return
	 */
	public JSONObject findSchoolByName(String schoolName);
	/**
	 * 根据组织查询学校
	 * @param orgId
	 * @return
	 */
	public JSONArray findSchoolByOrgId(Long orgId);
}

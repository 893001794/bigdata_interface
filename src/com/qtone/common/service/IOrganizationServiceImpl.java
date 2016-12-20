package com.qtone.common.service;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.qtone.common.bigdata.dao.IOrganizationDao;
import com.qtone.common.bigdata.entity.Organization;
import com.qtone.common.bigdata.entity.Region;
import com.qtone.common.bigdata.entity.SysGrade;

import com.qtone.common.util.JsonView;

/**
 * @title 持久层接口
 * 
 *        组织接口
 * @version 1.0
 * @author tzp
 * 
 */
@Service
public class IOrganizationServiceImpl implements IOrganizationService{
	@Autowired
	private IOrganizationDao orgDao;

	@Override
	public JSONArray findAllOrg() {
		JSONArray jsonArr=new JSONArray();
		Collection<Organization> organization=orgDao.findAllOrg();
		for(Organization temp:organization){
			JSONObject obj=new JSONObject();
			obj.put("id", temp.getOrgId());
			obj.put("name", temp.getOrgName());
			obj.put("fullName", temp.getOrgFullName());
			jsonArr.add(obj);
		}
		return jsonArr;
	}
}

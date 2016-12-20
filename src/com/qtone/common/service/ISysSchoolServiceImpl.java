package com.qtone.common.service;
import java.util.Collection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qtone.common.bigdata.dao.ISysSchoolDao;
import com.qtone.common.bigdata.entity.Organization;
import com.qtone.common.bigdata.entity.SysSchool;
import com.qtone.common.bigdata.model.SysSchoolForm;


/**
 * 学校信息服务接口实现类
 * @version 1.0
 * @author tzp
 * 
 */
@Service
public class ISysSchoolServiceImpl implements ISysSchoolService {
	@Autowired
	private ISysSchoolDao  schoolDao;
	@Override
	public JSONObject findSchoolByName(String schoolName) {
		String schoolLevel=""; //学校层次
		String schoolType=""; //学校类别
		SysSchoolForm schoolForm=schoolDao.findSchoolByName(schoolName);
		Integer level=schoolForm.getSchoolLevel();
		Integer type=schoolForm.getSchoolType();
		if(level !=null&&!"".equals(level)){
			if(level==1){
				schoolLevel="幼儿园";
			}else if(level==2){
				schoolLevel="小学";
			}else if(level==3){
				schoolLevel="初中";
			}else if(level==4){
				schoolLevel="高中";
			}else{
				schoolLevel="中专、中职工";
			}
		}
		if(type !=null&&!"".equals(type)){
			if(type==1){
				schoolType="公办";
			}else{
				schoolType="民办";
			}
		}
		JSONObject json=new JSONObject();
		json.put("schoolName",schoolForm.getSchoolName());
		json.put("orgName",schoolForm.getOrganName());
		json.put("areaName",schoolForm.getAreaName());
		json.put("schoolLevel",schoolLevel);
		json.put("schoolType",schoolType);
		return json;
	}
	@Override
	public JSONArray findSchoolByOrgId(Long orgId) {
		Collection<SysSchool> schoolList=schoolDao.findSchoolByOrgId(orgId);
		JSONArray jsonArray=new JSONArray();
		for(SysSchool temp:schoolList){
			JSONObject obj=new JSONObject();
			obj.put("id", temp.getSchoolId());
			obj.put("name", temp.getSchoolName());
			obj.put("fullName()",temp.getSchoolFullName());
			jsonArray.add(obj);
		}
		return jsonArray;
	}
}

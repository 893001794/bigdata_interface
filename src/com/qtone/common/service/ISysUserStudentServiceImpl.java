package com.qtone.common.service;

import java.util.Collection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtone.common.bigdata.dao.ISysSchoolDao;
import com.qtone.common.bigdata.dao.ISysUserDao;
import com.qtone.common.bigdata.dao.ISysUserStudentDao;
import com.qtone.common.bigdata.entity.SysSchool;
import com.qtone.common.bigdata.entity.SysUser;
import com.qtone.common.bigdata.entity.SysUserStudent;
import com.qtone.common.bigdata.model.SysUserStudentForm;
import com.qtone.common.bigdata.model.SysUserTeacherForm;
import com.qtone.common.util.JsonView;
/**
 * 学生信息服务接口实现类
 * @version 1.0
 * @author tzp
 * 
 */
@Service
public class ISysUserStudentServiceImpl implements ISysUserStudentService {
	@Autowired
	private ISysUserStudentDao sysUserStudentDao;
	@Autowired
	private ISysUserDao sysUserDao;
	@Autowired
	private ISysSchoolDao sysSchoolDao;
	@Override
	public JSONObject findStudentByStuNo(String stuNumber) {
		//根据学籍号获取学生信息
		SysUserStudent  sysUserStudent=sysUserStudentDao.findStudentByStuNo(stuNumber);
		//获取用户信息
		SysUser sysUser=sysUserDao.findUserById(sysUserStudent.getUserId());
		//获取学校信息
		SysSchool sysSchool=sysSchoolDao.findSchoolById(sysUserStudent.getSchoolId());
		JSONObject json=new JSONObject();
		json.put("LoginName",sysUser.getLoginName());
		json.put("UserName",sysUser.getUserName());
		json.put("Gender",sysUser.getGender());
		json.put("Email",sysUser.getEmail());
		json.put("Mobile",sysUser.getMobile());
		json.put("RegionName",sysUser.getRegionName());
		json.put("SchoolName",sysSchool.getSchoolName());
		json.put("StudentNum",sysUserStudent.getStudentNumber());
		json.put("IdCardType",sysUser.getCardType());
		json.put("IdCardNum",sysUser.getCardNum());
		return json;
	}
	
	@Override
	public JsonView findStudentSubject(Integer userId, Integer year) {
		JsonView jsonview = new JsonView();
		JSONArray jsonArr = new JSONArray();//json集合
		Collection<SysUserStudentForm> sysUserStudent=sysUserStudentDao.findStudentSubject(userId, year);//获取该学生的资料
		Integer schoolCode=null;
		String schoolName="";
		String gradeCode="";
		String gradeName="";
		Integer classCode=0;
		String className="";
		if(sysUserStudent !=null && sysUserStudent.size()>0){
			for(SysUserStudentForm userStudentTemp:sysUserStudent){
				schoolName=userStudentTemp.getSchoolName();
				schoolCode=userStudentTemp.getSchoolCode();
				//拼凑产品编号
				String productCode="RJ01"+"#"+userStudentTemp.getSubjectCode()+"#"+userStudentTemp.getGradeCode()+"#"+userStudentTemp.getSemesterName();
				String termStr="";
				if(userStudentTemp.getSemesterName() !=null){
					if(userStudentTemp.getSemesterName().equals("01")){
							termStr+="(上册)";	
					}else{
						termStr+="(下册)";	
					}
				}
				gradeCode=userStudentTemp.getGradeCode();
				gradeName=userStudentTemp.getGradeName();
				classCode=userStudentTemp.getClassId();
				className=userStudentTemp.getClassName();
				JSONObject jsonObjArr = new JSONObject(); 
				jsonObjArr.put("product_code", productCode);
				jsonObjArr.put("product_name",userStudentTemp.getGradeName()+userStudentTemp.getSubjectName()+termStr);
				jsonObjArr.put("grade", userStudentTemp.getGradeCode());
				jsonObjArr.put("subject", userStudentTemp.getSubjectCode());
				jsonObjArr.put("grade_code",userStudentTemp.getGradeCode());
				jsonObjArr.put("grade_name",userStudentTemp.getGradeName());
				jsonObjArr.put("class_code",userStudentTemp.getClassId());
				jsonObjArr.put("class_name", userStudentTemp.getClassName());
				jsonObjArr.put("endtime", "2017-12-30 12:59:00");
				jsonArr.add(jsonObjArr);
			}
		}
		jsonview.setProperty("school_code",schoolCode);
		jsonview.setProperty("school_name",schoolName);
		jsonview.setProperty("product_list", jsonArr);
		jsonview.setProperty("grade_code", gradeCode);
		jsonview.setProperty("grade_name", gradeName);
		jsonview.setProperty("class_code", classCode);
		jsonview.setProperty("class_name", className);
		return jsonview;
	}

}

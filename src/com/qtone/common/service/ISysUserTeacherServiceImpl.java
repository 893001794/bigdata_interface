package com.qtone.common.service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.security.auth.Subject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtone.common.bigdata.dao.ISysSchoolDao;
import com.qtone.common.bigdata.dao.ISysUserDao;
import com.qtone.common.bigdata.dao.ISysUserTeacherDao;
import com.qtone.common.bigdata.entity.SysGrade;
import com.qtone.common.bigdata.entity.SysSchool;
import com.qtone.common.bigdata.entity.SysSemester;
import com.qtone.common.bigdata.entity.SysSubject;
import com.qtone.common.bigdata.entity.SysTeacherClass;
import com.qtone.common.bigdata.entity.SysUser;
import com.qtone.common.bigdata.entity.SysUserTeacher;
import com.qtone.common.bigdata.model.SysUserTeacherForm;
import com.qtone.common.util.JsonView;
/**
 * 教师信息服务接口实现类
 * @version 1.0
 * @author tzp
 * 
 */
@Service
public class ISysUserTeacherServiceImpl implements ISysUserTeacherService {
	@Autowired
	private ISysUserTeacherDao sysUserTeacherDao;
	@Autowired
	private ISysUserDao sysUserDao;
	@Autowired
	private ISysSchoolDao sysSchoolDao;
	@Override
	public JSONObject findTeacherByEduNo(String eduNumber) {
		//根据继教号获取教师信息
		SysUserTeacher sysUserTeacher=sysUserTeacherDao.findTeacherByEduNo(eduNumber);
		//获取学校信息
		SysSchool sysSchool=sysSchoolDao.findSchoolById(sysUserTeacher.getSchoolId());
		//获取用户信息
		SysUser sysUser=sysUserDao.findUserById(sysUserTeacher.getUserId());
		JSONObject json=new JSONObject();
		json.put("LoginName",sysUser.getLoginName());
		json.put("UserName",sysUser.getUserName());
		json.put("Gender",sysUser.getGender());
		json.put("Email",sysUser.getEmail());
		json.put("Mobile",sysUser.getMobile());
		json.put("RegionName",sysUser.getRegionName());
		json.put("SchoolName",sysSchool.getSchoolName());
		json.put("TeacherEduNum",sysUserTeacher.getTeacherEduNum());
		json.put("IdCardType",sysUser.getCardType());
		json.put("IdCardNum",sysUser.getCardNum());
		return json;
	}
	@Override
	public JsonView findTeacherInfor(Integer userId,Integer year) {
		JsonView jsonview = new JsonView();
		JSONArray jsonArr = new JSONArray();//json集合
		Integer schoolCode=null;
		String schoolName="";
		String gradeCode="";
		String gradeName="";
		Integer classCode=0;
		String className="";
		Collection<SysUserTeacherForm> sysUserTeacher=sysUserTeacherDao.findTeacherInfor(userId,year);//获取用户id获取用户教师关联表格
		System.out.println(sysUserTeacher.size()+"**********教师授课数量----------");
		if(sysUserTeacher !=null && sysUserTeacher.size()>0){
			for(SysUserTeacherForm userTeacherTemp:sysUserTeacher){
				schoolName=userTeacherTemp.getSchoolName();
				schoolCode=userTeacherTemp.getSchoolCode();
				//拼凑产品编号
				String productCode="RJ01"+"#"+userTeacherTemp.getSubjectCode()+"#"+userTeacherTemp.getGradeCode()+"#"+userTeacherTemp.getSemesterCode();
				System.out.println("-------------productCode:"+productCode);
				String termStr="";
				if(userTeacherTemp.getSemesterName() !=null){
					if(userTeacherTemp.getSemesterName().equals("01")){
							termStr+="(上册)";	
					}else{
						termStr+="(下册)";	
					}
				}
				gradeCode=userTeacherTemp.getGradeCode();
				gradeName=userTeacherTemp.getGradeName();
				classCode=userTeacherTemp.getClassId();
				className=userTeacherTemp.getClassName();
				JSONObject jsonObjArr = new JSONObject(); 
				jsonObjArr.put("product_code", productCode);
				jsonObjArr.put("product_name",userTeacherTemp.getGradeName()+userTeacherTemp.getSubjectName()+termStr);
				jsonObjArr.put("grade", userTeacherTemp.getGradeCode());
				jsonObjArr.put("subject", userTeacherTemp.getSubjectCode());
				jsonObjArr.put("grade_code",userTeacherTemp.getGradeCode());
				jsonObjArr.put("grade_name",userTeacherTemp.getGradeName());
				jsonObjArr.put("class_code",userTeacherTemp.getClassId());
				jsonObjArr.put("class_name", userTeacherTemp.getClassName());
				jsonObjArr.put("endtime", "2017-12-30 12:59:00");
				jsonArr.add(jsonObjArr);
			}
		}
		System.out.println("-----学号："+schoolCode+"------"+schoolName);
		System.out.println("年级编号："+gradeCode+"------"+jsonArr);
		jsonview.setProperty("school_code",schoolCode);
		jsonview.setProperty("school_name",schoolName);
		jsonview.setProperty("product_list", jsonArr);
		jsonview.setProperty("grade_code", gradeCode);
		jsonview.setProperty("grade_name", gradeName);
		jsonview.setProperty("class_code", classCode);
		jsonview.setProperty("class_name", className);
		System.out.println("传给人教e学json:"+jsonview.toString());
		return jsonview;
	}

}

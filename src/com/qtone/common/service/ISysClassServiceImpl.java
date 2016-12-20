package com.qtone.common.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qtone.common.bigdata.dao.IGadeDao;
import com.qtone.common.bigdata.dao.ISchoolYearDao;
import com.qtone.common.bigdata.dao.ISysClassDao;
import com.qtone.common.bigdata.dao.ISysSchoolDao;
import com.qtone.common.bigdata.entity.SysClass;
import com.qtone.common.bigdata.entity.SysGrade;
import com.qtone.common.bigdata.entity.SysSchoolYear;
import com.qtone.common.bigdata.entity.SysUser;
import com.qtone.common.bigdata.model.SysClassForm;
import com.qtone.common.bigdata.model.SysSchoolForm;
import com.qtone.common.util.JsonView;
@Service
public class ISysClassServiceImpl implements ISysClassService {
	@Autowired
	private ISysSchoolDao schoolDao;
	@Autowired
	private ISysClassDao classDao;
	@Autowired
	private IGadeDao gadeDao;
	@Autowired
	private ISchoolYearDao schoolYearDao;
	@Override
	public JsonView saveClass(SysClassForm sysClass) {
		JsonView jsonView=new JsonView();
		SysSchoolForm school=null;
		SysGrade grade=null;
		SysSchoolYear schoolYear=null;
		SysUser user=null;
		if(sysClass.getSchoolName() !=null && !"".equals(sysClass.getSchoolName())){
			//根据学校名称查询学校对象
			school=schoolDao.findSchoolByName(sysClass.getSchoolName());
		}
		if(school ==null){
			jsonView.setProperty("code", "0");
			jsonView.setProperty("resMsg","没有"+sysClass.getSchoolName()+"学校名称！");
			return 	jsonView;
		}
		if(sysClass.getGradeName() !=null && !"".equals(sysClass.getGradeName())){
			//根据年级查询年级对象
			grade=classDao.findGradeByName(sysClass.getGradeName());
		}
		if(grade ==null){
			grade=new SysGrade();
			grade.setGradeName(sysClass.getGradeName());
			gadeDao.saveGade(grade);
		}
		if(sysClass.getSchoolYear() !=null && !"".equals(sysClass.getSchoolYear())){
			//根据年份查询学年信息
			schoolYear=classDao.findSchoolYearByName(sysClass.getSchoolYear());
		}
		if(schoolYear ==null){
			schoolYear=new SysSchoolYear();
			schoolYear.setSchoolYear(Integer.parseInt(sysClass.getSchoolYear()));
			schoolYear.setSchoolYearName(sysClass.getSchoolYear()+"学年");
			schoolYearDao.saveSchoolYear(schoolYear);
		}
		if(school !=null &&  sysClass.getHeadmasterName() !=null && !"".equals(sysClass.getHeadmasterName())){
			//根据学校id和用户名称查询用户
			user=classDao.findBySchoolIdUserName(school.getSchoolId(), sysClass.getHeadmasterName());
		}
//		if(user ==null){
//			jsonView.setProperty("code", "0");
//			jsonView.setProperty("resMsg","没有"+sysClass.getHeadmaster()+"班主任");
//			return 	jsonView;
//		}
		
		System.out.println(sysClass.getSchoolName() + " " + sysClass.getClassName());
		
		try {
			if(school !=null && grade !=null){
				//根据学校和年级查询是否存在班级
				SysClass classTemp=classDao.findBySchoolIdGradeId(school.getSchoolId(), grade.getGradeId(),schoolYear.getSchoolYearId(),sysClass.getClassName());
				if(classTemp !=null){
					classTemp.setClassName(sysClass.getClassName());
					classTemp.setGradeId(grade.getGradeId());
					classTemp.setHeadmaster(user==null?0:user.getUserId());
					classTemp.setIdentityName(sysClass.getIdentityName());
					classTemp.setSchoolYearId(schoolYear.getSchoolYearId());
					classTemp.setSchoolId(school.getSchoolId());
					classDao.updClass(classTemp);
				}else{
					sysClass.setClassName(sysClass.getClassName());
					sysClass.setGradeId(grade.getGradeId());
					sysClass.setHeadmaster(user==null?0:user.getUserId());
					sysClass.setIdentityName(sysClass.getIdentityName());
					sysClass.setSchoolYearId(schoolYear.getSchoolYearId());
					sysClass.setSchoolId(school.getSchoolId());
					classDao.saveClass(sysClass);
				}
			}
			jsonView.setProperty("code", "1");
			jsonView.setProperty("resMsg","推送"+sysClass.getClassName()+"成功！");
		} catch (Exception e) {
			jsonView.setProperty("code", "0");
			jsonView.setProperty("resMsg","推送失败！");
			e.printStackTrace();
		}
		return jsonView;
	}
	@Override
	public JsonView updateClass(SysClass sysClass) {
		JsonView jsonView=new JsonView();
		try {
			for(int i=1;i<21;i++){
				sysClass=new SysClass();
				sysClass.setClassId(i);
				if(i<11){
					sysClass.setClassName("初一("+i+")班");
				}else{
					sysClass.setClassName("初二("+i+")班");
				}
				
				classDao.updClass(sysClass);
			}
			jsonView.setProperty("code", "1");
			jsonView.setProperty("resMsg","班级修改成功！");
			return 	jsonView;
		} catch (Exception e) {
			jsonView.setProperty("code", "0");
			jsonView.setProperty("resMsg","班级修改失败！");
			return 	jsonView;
		}
	}

}

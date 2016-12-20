package com.qtone.common.bigdata.daoImpl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.bigdata.dao.ISysClassDao;
import com.qtone.common.bigdata.entity.SysClass;
import com.qtone.common.bigdata.entity.SysGrade;
import com.qtone.common.bigdata.entity.SysSchoolYear;
import com.qtone.common.bigdata.entity.SysUser;
@Repository
@Transactional
public class ISysClassDaoImpl extends BaseDAO implements ISysClassDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysGrade findGradeByName(String gradeName) {
		String strSQL = "select *  from SYS_GRADE where GRADE_NAME ='"+gradeName+"'";
		try {
			return this.getJdbcTemplate().queryForObject(strSQL,new BeanPropertyRowMapper(SysGrade.class));
		} catch (Exception e) {
			return null;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysSchoolYear findSchoolYearByName(String schoolYear) {
		String strSQL = "select *  from SYS_SCHOOL_YEAR where SCHOOL_YEAR ="+schoolYear+"";
		try {
			return this.getJdbcTemplate().queryForObject(strSQL,new BeanPropertyRowMapper(SysSchoolYear.class));
		} catch (Exception e) {
			return null;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysClass findBySchoolIdGradeId(Long schoolId, Integer gradeId,Integer schoolYearId,String className) {
		String strSQL = "select *  from SYS_CLASS where  school_id ="+schoolId+" and grade_id="+gradeId +" and school_year_id="+schoolYearId+" and class_name='"+className+"'";
		try {
			return this.getJdbcTemplate().queryForObject(strSQL,new BeanPropertyRowMapper(SysClass.class));
		} catch (Exception e) {
			return null;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysUser findBySchoolIdUserName(Long schoolId, String userName) {
		String strSQL = "select ut.* from SYS_USER_TEACHER ut left join SYS_USER  u on ut.USER_ID=u.USER_ID  where ut.SCHOOL_ID="+schoolId+" and  u.USER_NAME='"+userName+"'";
		try {
			return this.getJdbcTemplate().queryForObject(strSQL,new BeanPropertyRowMapper(SysUser.class));
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public void updClass(SysClass sysClass) {
		String sql = "update sys_class set class_name='"+sysClass.getClassName()+"' where class_id="+ sysClass.getClassId() ;
		System.out.println("------修改班级信息："+sql);
		this.getJdbcTemplate().update(sql);
		
	}
//	public void updClass(SysClass sysClass) {
//		String sql = "update sys_class set school_id=" + sysClass.getSchoolId()
//				+ ",class_name='" + sysClass.getClassName() + "',identity_name='"
//				+ sysClass.getIdentityName() + "',grade_id=" + sysClass.getGradeId()
//				+ ",headmaster=" + sysClass.getHeadmaster() + ",school_year_id="+sysClass.getSchoolYearId()+" where class_id="
//				+ sysClass.getClassId() ;
//		this.getJdbcTemplate().update(sql);
//		
//	}
	@Override
	public void saveClass(SysClass sysClass) {
		sysClass.setClassId(this.nextClassId());
		String sql = "insert into sys_class(class_id,school_id,class_name,identity_name,grade_id,headmaster,school_year_id) values("
				+ sysClass.getClassId() + "," +  sysClass.getSchoolId() + ",'"
				+ sysClass.getClassName() + "','" + sysClass.getIdentityName() + "',"
				+ sysClass.getGradeId() + "," + sysClass.getHeadmaster() + ","+sysClass.getSchoolYearId()+")";
		System.out.println("**********保存班级信息："+sql);
		this.getJdbcTemplate().update(sql);
	}
	
	@SuppressWarnings("deprecation")
	private int nextClassId() {
		try {
			String sql = "select max(class_id)+1 from sys_class";
			return this.getJdbcTemplate().queryForInt(sql);
		} catch (Exception ex) {
			return 1;
		}
	}

}

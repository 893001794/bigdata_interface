package com.qtone.common.bigdata.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.bigdata.dao.ISysUserTeacherDao;
import com.qtone.common.bigdata.entity.SysClass;
import com.qtone.common.bigdata.entity.SysGrade;
import com.qtone.common.bigdata.entity.SysSchool;
import com.qtone.common.bigdata.entity.SysSchoolYear;
import com.qtone.common.bigdata.entity.SysSemester;
import com.qtone.common.bigdata.entity.SysSubject;
import com.qtone.common.bigdata.entity.SysTeacherClass;
import com.qtone.common.bigdata.entity.SysUserTeacher;
import com.qtone.common.bigdata.model.SysUserTeacherForm;
@Repository
@Transactional
public class ISysUserTeacherDaoImpl extends BaseDAO implements ISysUserTeacherDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysUserTeacher findTeacherByEduNo(String eduNumber) {
		String strSQL="select * from sys_user_teacher  where teacher_edu_num ='"+eduNumber+"'";
		return this.getJdbcTemplate().queryForObject(strSQL,
				new BeanPropertyRowMapper(SysUserTeacher.class));
	}

	@Override
	public Collection<SysUserTeacherForm> findTeacherInfor(Integer userId,Integer year) {
		String strSQL="select sc.school_id,sc.school_name,c.class_id,c.class_name,g.GRADE_CODE,g.GRADE_NAME,s.subject_code,s.subject_name,se.semester_name,se.semester_code,y.SCHOOL_YEAR_NAME,y.SCHOOL_YEAR from sys_user_teacher ut "; 
		strSQL+="left join SYS_TEACHER_CLASS tc on ut.id=tc.TEACHER_ID ";
		strSQL+="left join SYS_SCHOOL sc on ut.SCHOOL_ID=sc.SCHOOL_ID ";
		strSQL+="left join SYS_CLASS c on tc.CLASS_ID=c.CLASS_ID ";
		strSQL+="left join SYS_GRADE g on c.grade_id=g.grade_id ";
		strSQL+="left join SYS_SUBJECT s on tc.SUBJECT_ID=s.SUBJECT_ID ";
		strSQL+="left join SYS_SEMESTER se on se.SEMESTER_ID=tc.SEMESTER_ID ";
		strSQL+="left join SYS_SCHOOL_YEAR y on y.SCHOOL_YEAR_ID=c.SCHOOL_YEAR_ID ";
		strSQL+="where ut.USER_ID="+userId +" and y.school_year="+year+" and to_char(sysdate,'yyyy-mm') between START_DATE and END_DATE";
		System.out.println("给老师配置权限："+strSQL);
		Collection<SysUserTeacherForm> sysUserTeachers=this.getJdbcTemplate().query(strSQL, new ParameterizedRowMapper<SysUserTeacherForm>() {
			@Override
			public SysUserTeacherForm mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				SysUserTeacherForm ut = new SysUserTeacherForm();
				ut.setSchoolCode(rs.getInt("school_id"));
				ut.setSchoolName(rs.getString("school_name"));
				ut.setClassId(rs.getInt("class_id"));
				ut.setClassName(rs.getString("class_name"));
				ut.setGradeCode(rs.getString("GRADE_CODE"));
				ut.setGradeName(rs.getString("GRADE_NAME"));
				ut.setSubjectCode(rs.getString("subject_code"));
				ut.setSubjectName(rs.getString("subject_name"));
				ut.setSemesterName(rs.getString("semester_name"));
				ut.setSemesterCode(rs.getString("semester_code"));
				ut.setSchoolYearName(rs.getString("SCHOOL_YEAR_NAME"));
				return ut;
			}
		});
		return sysUserTeachers;
	}

}

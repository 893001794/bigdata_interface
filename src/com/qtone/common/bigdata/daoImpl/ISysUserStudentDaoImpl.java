package com.qtone.common.bigdata.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.bigdata.dao.ISysUserStudentDao;
import com.qtone.common.bigdata.entity.SysUserStudent;
import com.qtone.common.bigdata.model.SysUserStudentForm;
import com.qtone.common.bigdata.model.SysUserTeacherForm;
@Repository
@Transactional
public class ISysUserStudentDaoImpl extends BaseDAO implements ISysUserStudentDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysUserStudent findStudentByStuNo(String stuNumber) {
		String strSQL="select * from sys_user_student s where student_number ='"+stuNumber+"'";
		return this.getJdbcTemplate().queryForObject(strSQL,
				new BeanPropertyRowMapper(SysUserStudent.class));
	}
	
	@Override
	public Collection<SysUserStudentForm> findStudentSubject(Integer userId,Integer year) {
		String strSQL="select sc.school_id,sc.school_name,c.class_id,c.class_name,g.grade_id,g.grade_code,g.grade_name,s.subject_code,s.subject_name,ss.semester_code,ss.semester_name,sy.school_year_name from sys_user_student us "; 
		strSQL+=" left join sys_user u  on us.user_id=u.user_id  ";
		strSQL+=" left join sys_class c on c.class_id=us.class_id ";
		strSQL+=" left join sys_grade g on c.grade_id=g.grade_id ";
		strSQL+=" left join sys_grade_subject gs on g.grade_id=gs.grade_id ";
		strSQL+=" left join sys_subject s on gs.subject_id=s.subject_id ";
		strSQL+=" left join sys_school sc on us.school_id=sc.school_id ";
		strSQL+=" left join sys_school_year sy on c.school_year_id=sy.school_year_id ";
		strSQL+=" left join sys_semester ss on ss.school_year_id=sy.school_year_id ";
		strSQL+="where u.USER_ID="+userId+" and sy.SCHOOL_YEAR="+year +" and to_char(sysdate,'yyyy-mm') between START_DATE and END_DATE";
		System.out.println("----给学生配置权限strSQL："+strSQL);
		Collection<SysUserStudentForm> studentSubjectList=this.getJdbcTemplate().query(strSQL, new ParameterizedRowMapper<SysUserStudentForm>() {
			@Override
			public SysUserStudentForm mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				SysUserStudentForm ut = new SysUserStudentForm();
				ut.setSchoolCode(rs.getInt("school_id"));
				ut.setSchoolName(rs.getString("school_name"));
				ut.setClassId(rs.getInt("class_id"));
				ut.setClassName(rs.getString("class_name"));
				ut.setGradeCode(rs.getString("grade_code"));
				ut.setGradeName(rs.getString("grade_name"));
				ut.setSubjectCode(rs.getString("subject_code"));
				ut.setSubjectName(rs.getString("subject_name"));
				ut.setSemesterName(rs.getString("semester_name"));
				ut.setSchoolYearName(rs.getString("school_year_name"));
				return ut;
			}
		});
		return studentSubjectList;
	}

}

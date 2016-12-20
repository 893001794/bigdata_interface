package com.qtone.common.bigdata.daoImpl;

import java.util.Collection;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.bigdata.dao.ISysSchoolDao;
import com.qtone.common.bigdata.entity.SysSchool;
import com.qtone.common.bigdata.model.SysSchoolForm;


@Repository
@Transactional
public class ISysSchoolDaoImp extends BaseDAO implements ISysSchoolDao{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysSchoolForm findSchoolByName(String schoolName) {
		String strSQL = "select s.*,o.org_name as organName,r.region_name as areaName  from SYS_SCHOOL s " +
				"left join  SYS_ORG o on s.ORG_ID=o.ORG_ID " +
				"left join Sys_Region r on o.region_id=r.region_id  where s.school_full_name='"+schoolName+"'";
		try {
			return this.getJdbcTemplate().queryForObject(strSQL,new BeanPropertyRowMapper(SysSchoolForm.class));
		} catch (Exception e) {
			return null;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysSchoolForm findSchoolById(Integer schoolId) {
		String strSQL = "select *  from SYS_SCHOOL  where school_id="+schoolId;
		return this.getJdbcTemplate().queryForObject(strSQL,new BeanPropertyRowMapper(SysSchoolForm.class));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<SysSchool> findSchoolByOrgId(Long orgId) {
		String strSQL = "select * from sys_school where org_id="+orgId ;
		return this.getJdbcTemplate().query(strSQL,new BeanPropertyRowMapper(SysSchool.class));
	}

}

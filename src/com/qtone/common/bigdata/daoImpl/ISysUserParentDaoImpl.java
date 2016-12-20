package com.qtone.common.bigdata.daoImpl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.bigdata.dao.ISysUserParentDao;
import com.qtone.common.bigdata.entity.SysUserParent;
@Repository
@Transactional
public class ISysUserParentDaoImpl extends BaseDAO implements ISysUserParentDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysUserParent findParentByStuNo(String StuNumber) {
		String strSQL="select * from sys_user_parent p left join sys_parent_student ps on p.parent_id=ps.parent_id left join sys_user_student s on s.student_id=ps.student_id where s.student_number ='"+StuNumber+"'";
		return this.getJdbcTemplate().queryForObject(strSQL,
				new BeanPropertyRowMapper(SysUserParent.class));
	}

}

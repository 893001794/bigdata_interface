package com.qtone.common.bigdata.daoImpl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.bigdata.dao.ISysUserDao;
import com.qtone.common.bigdata.entity.SysUser;
@Repository
@Transactional
public class ISysUserDaoImpl extends BaseDAO implements ISysUserDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysUser findUserById(Integer userId) {
		try {
			String strSQL="select * from sys_user where user_id="+userId;
			return this.getJdbcTemplate().queryForObject(strSQL,new BeanPropertyRowMapper(SysUser.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysUser finSysUserByLoginName(String loginName){
		String strSQL="select * from sys_user where login_name='"+loginName+"'";
		System.out.println("strSQL:"+strSQL);
		return this.getJdbcTemplate().queryForObject(strSQL,new BeanPropertyRowMapper(SysUser.class));
	}
	
}

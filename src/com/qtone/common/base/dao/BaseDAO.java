package com.qtone.common.base.dao;

import org.apache.commons.logging.Log;


import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * @title 数据库底层接口
 * 
 *        底层接口
 * @version 1.0
 * @author tzp
 * 
 */
@Repository
public class BaseDAO {
	protected static final Log log = LogFactory.getLog(BaseDAO.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 获取Spring JdbcTemplate
	 * 
	 * @return
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * 设置 Spring JdbcTemplate
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}

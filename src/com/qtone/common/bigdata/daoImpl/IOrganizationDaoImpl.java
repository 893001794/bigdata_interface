package com.qtone.common.bigdata.daoImpl;

import java.util.Collection;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.bigdata.dao.IOrganizationDao;
import com.qtone.common.bigdata.entity.Organization;

@Repository
@Transactional
public class IOrganizationDaoImpl  extends BaseDAO  implements  IOrganizationDao{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Organization> findAllOrg() {
		try {
			String strSQL = "select * from sys_org " ;
			return this.getJdbcTemplate().query(strSQL,new BeanPropertyRowMapper(Organization.class));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

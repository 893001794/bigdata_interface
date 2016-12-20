package com.qtone.common.bigdata.daoImpl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.bigdata.dao.ISysSSOConfigDao;
import com.qtone.common.bigdata.entity.SysSSOConfig;
@Repository
@Transactional
public class ISysSSOConfigDaoImpl extends BaseDAO implements ISysSSOConfigDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean findByDigDateNameAppName(Integer appId,String loginName,String appLoginName) {
		String strSQL = "select * from sys_sso_config where 1=1 ";
		if(appId !=null && !"".equals(appId)){
			strSQL+=" and app_id="+appId;
		}
		if(loginName !=null && !"".equals(loginName)){
			strSQL+=" and login_name='"+loginName+"'";
		}
		if(appLoginName !=null && !"".equals(appLoginName)){
			strSQL+=" and app_login_name='"+appLoginName+"'";
		}
		SysSSOConfig sysSSOConfig=this.getJdbcTemplate().queryForObject(strSQL,new BeanPropertyRowMapper(SysSSOConfig.class));
		if(sysSSOConfig !=null){
			return true;
		}else{
			return false;
		}
	}

}

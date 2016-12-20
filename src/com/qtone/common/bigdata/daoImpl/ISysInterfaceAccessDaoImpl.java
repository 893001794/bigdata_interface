package com.qtone.common.bigdata.daoImpl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.bigdata.dao.ISysInterfaceAccessDao;
import com.qtone.common.bigdata.entity.Organization;
import com.qtone.common.bigdata.entity.SysApp;
import com.qtone.common.bigdata.entity.SysInterfaceAccess;

@Repository
@Transactional
public class ISysInterfaceAccessDaoImpl extends BaseDAO  implements ISysInterfaceAccessDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysInterfaceAccess isAccess(String appkey,String action) {
			try {
				String strSql="select sia.*,sa.app_name appName  from sys_interface_access sia " +
						"left join sys_app sa on sia.app_id=sa.app_id" +
						" left join sys_interface si on si.interface_id=sia.interface_id " +
						"where sa.app_key='"+appkey+"' ";
				if(action !=null && !"".equals(action)){
					
				strSql+=" and si.interface_code='"+action+"'";
				}
				return this.getJdbcTemplate().queryForObject(strSql,
						new BeanPropertyRowMapper(SysInterfaceAccess.class));
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public List<SysApp> findAppsByLoginName(String loginName) {
		try {
			String strSql="SELECT DISTINCT a.app_id as appId,a.APP_CODE as appCode,a.app_name as appName,a.home_page as homePage,'http://202.96.186.112:8080/redirectSys/'||a.app_id||'?type=3' as appSsoUrl FROM sys_app a " +
					"LEFT JOIN SYS_APP_INTERFACE b  on a.app_id=b.APP_ID" +
					" LEFT JOIN sys_sso_config s ON a.app_id=s.app_id  " +
					" where  s.login_name='"+loginName+"' ";
			return this.getJdbcTemplate().query(strSql,new BeanPropertyRowMapper(SysApp.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}

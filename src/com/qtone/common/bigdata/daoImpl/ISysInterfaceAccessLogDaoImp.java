package com.qtone.common.bigdata.daoImpl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.bigdata.dao.ISysInterfaceAccessLogDao;
import com.qtone.common.bigdata.entity.SysInterfaceAccessLog;
@Repository
@Transactional
public class ISysInterfaceAccessLogDaoImp  extends BaseDAO implements ISysInterfaceAccessLogDao {
	@Override
	public void saveInterfaceAccessLog(SysInterfaceAccessLog interfaceAccessLog) {
		try {
			String strSQL = " insert into "
				+ "sys_interface_access_log  (id,app_id,interface_id,access_time,access_app_user,access_user,access_para,access_result,client_ip,accesslog_id) "
				+ "values(SYS_INTERFACE_ACCESS_LOG_SEQ.NEXTVAL," +interfaceAccessLog.getAppSystem() + "," + interfaceAccessLog.getAppInterface()
				+ ",to_timestamp('" +interfaceAccessLog.getAccessTime() + "','yyyy-mm-dd hh24:mi:ss'),'"
				+ interfaceAccessLog.getAccessAppUser() + "','"+ interfaceAccessLog.getAccessUser() + "','"
				+ interfaceAccessLog.getAccessPara() + "','"+ interfaceAccessLog.getAccessResult() + "','"+interfaceAccessLog.getClientIp()+"',1)";
			this.getJdbcTemplate().update(strSQL);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

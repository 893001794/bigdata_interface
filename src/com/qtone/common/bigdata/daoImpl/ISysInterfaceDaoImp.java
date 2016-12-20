package com.qtone.common.bigdata.daoImpl;

import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.base.page.Page;
import com.qtone.common.bigdata.dao.ISysInterfaceDao;
import com.qtone.common.bigdata.entity.SysInterface;
@Repository
@Transactional
public class ISysInterfaceDaoImp extends BaseDAO implements ISysInterfaceDao {
	private final String TABLE="SYS_INTERFACE";
	private final String ALL_FIELD="interface_id,interface_url,interface_name,interface_appCode,interface_type,interface_code,interface_para,interface_usage,interface_parent,interface_return,interface_appName";
	
	@Override
	public void saveSysInterface(SysInterface sysInterface) {
		Integer interfaceId=this.findInterfaceId();
		String strSQL = " insert into "+TABLE
				+ " ("+ALL_FIELD+") "
				+ "values(" + interfaceId + ",'" +sysInterface.getInterfaceUrl()
				+ "','" + sysInterface.getInterfaceName() + "','"
				+ sysInterface.getInterfaceAppCode() + "','"
				+ sysInterface.getInterfaceType()+ "','"
				+ sysInterface.getInterfaceCode() + "','"
				+ sysInterface.getInterfacePara()+"','"
				+ sysInterface.getInterfaceUsage() +"',"
				+ sysInterface.getInterfaceParent() +",'"
				+ sysInterface.getInterfaceReturn() +"','"
				+ sysInterface.getInterfaceAppName() +"'";
		this.getJdbcTemplate().update(strSQL);

	}

	@Override
	public void updateByInterfaceId(SysInterface sysInterface) {
		String strSQL = "update  " + TABLE
				+ " set interface_url='"+sysInterface.getInterfaceUrl()+"',interface_name='"+sysInterface.getInterfaceName()+"'" +
						",interface_appCode='"+sysInterface.getInterfaceAppCode()+"',interface_type='"+sysInterface.getInterfaceType()+"'" +
						",interface_code='"+sysInterface.getInterfaceCode()+"'" +",interface_para='"+sysInterface.getInterfacePara()+"'," +
						"interface_usage='"+ sysInterface.getInterfaceUsage()+"',interface_parent="+sysInterface.getInterfaceParent()+"" +
						",interface_return='"+sysInterface.getInterfaceReturn()+"',interface_appName='"+sysInterface.getInterfaceAppName()+"' " +
						"where interface_id="+ sysInterface.getId();
		this.getJdbcTemplate().update(strSQL);
	}

	@Override
	public void deleteByInterfaceId(Integer interfaceId) {
		String strSQL = "delete from " + TABLE+ " where interface_id=" + interfaceId;
		this.getJdbcTemplate().update(strSQL);

	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysInterface findSysInterfaceById(Integer interfaceId) {
		String strSQL ="select "+ALL_FIELD +" from " + TABLE + " where interface_id="+ interfaceId;
		return this.getJdbcTemplate().queryForObject(strSQL,new BeanPropertyRowMapper(SysInterface.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<SysInterface> findAllSysInterface(
			SysInterface sysInterface) {
		String strSQL = "select "+ALL_FIELD +" from " +TABLE ;
		strSQL+=" order by  create_date  desc";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(SysInterface.class));
	}

	@Override
	public Page<SysInterface> findSysInterfaceByPage(SysInterface sysInterface,
			Page<SysInterface> page) {
		String condition =this.createCondition(sysInterface);
		String strSQL = "select "+ALL_FIELD +" from "+ TABLE+ " where 1=1 "+condition+"  order by  createDate asc ";
		String strCountSQL = "select  count(*) from "+ TABLE +" where 1=1 "+condition;
			page.paginationProcess(this.getJdbcTemplate().queryForLong(strCountSQL.toString()));
			String paginationSQL = page.getPaginationSQL(strSQL.toString());
			List<SysInterface> sysInterfaces = this.getJdbcTemplate().query(paginationSQL,
					ParameterizedBeanPropertyRowMapper.newInstance(SysInterface.class));
			page.setPageResult(sysInterfaces);
			return page;
	}
	
	
	/**
	 * 创建模糊动态参数条件
	 * 
	 * @param code
	 * @return
	 */

	private String createCondition(SysInterface sysInterface) {
		StringBuffer condition = new StringBuffer("");
		if (sysInterface != null) {
			String appCode=sysInterface.getInterfaceAppCode();
			String aceAppName=sysInterface.getInterfaceAppName();
			String type=sysInterface.getInterfaceType();
			if(appCode != null  && !"".equals(appCode.trim())){
				condition.append(" and interface_appcode ='").append(appCode).append("'");
			}
			if (aceAppName != null && !"".equals(aceAppName.trim())) {
				condition.append(" and interface_name like '").append(aceAppName).append("'");
			}
			if(type !=null && !"".equals(type.trim())){
				condition.append(" and interface_type ='").append(type).append("'");
			}
		}
		return condition.toString();
	}
	
	@SuppressWarnings("deprecation")
	private int findInterfaceId() {
			String strSQL = "select max(interface_id)+1 from " + TABLE;
			Integer interfaceId=this.getJdbcTemplate().queryForInt(strSQL);
			if(interfaceId !=null){
				return interfaceId+1;
			}
			return 1;
		}

}

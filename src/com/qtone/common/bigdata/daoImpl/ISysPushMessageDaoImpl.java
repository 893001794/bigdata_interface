package com.qtone.common.bigdata.daoImpl;
import java.util.Collection;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.base.page.Page;
import com.qtone.common.bigdata.dao.ISysPushMessageDao;
import com.qtone.common.bigdata.entity.SysPushMessage;
import com.qtone.common.bigdata.model.SysPushMessageForm;


@Repository
@Transactional
public class ISysPushMessageDaoImpl extends BaseDAO implements ISysPushMessageDao {
	private final String TABLE="SYS_PUSH_MESSAGE";
	private final String ALL_FIELD="push_id,user_id, title, message_content, message_url, oth_msg_id, valid_date, push_data, status";
	
	@Override
	public void savePushMessage(SysPushMessageForm sysPushMessage) {
		Integer pushId=this.findPushId();
		String strSQL = " insert into "+TABLE
				+ " (push_id,user_id, title, message_content, message_url, oth_msg_id) "
				+ "values(" + pushId + "," + sysPushMessage.getUserId()
				+ ",'" + sysPushMessage.getTitle() + "','"
				+ sysPushMessage.getMessageContent() + "','"
				+ sysPushMessage.getMessageUrl()+ "','"
				+ sysPushMessage.getOthMsgId() + "',to_date('"+sysPushMessage.getValidDate()+"','yyyy-mm-dd hh24:mi:ss'))";
		this.getJdbcTemplate().update(strSQL);
	}

	@Override
	public void updateByOthMsgId(String othMsgId) {
		String strSQL = "update  " + TABLE
				+ " set statu=2 where oth_msg_id='"+ othMsgId+ "'";
		this.getJdbcTemplate().update(strSQL);
	}

	@Override
	public void deletePushMessageById(Integer pushId) {
		String strSQL = "delete from " + TABLE+ " where push_id=" + pushId;
		this.getJdbcTemplate().update(strSQL);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysPushMessageForm findPushMessageById(Integer pushId) {
		String strSQL ="select "+ALL_FIELD +" from " + TABLE + " where push_id="+ pushId;
		return this.getJdbcTemplate().queryForObject(strSQL,new BeanPropertyRowMapper(SysPushMessageForm.class));
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<SysPushMessageForm> findAllPushMessage(SysPushMessageForm sysPushMessage) {
		String strSQL = "select "+ALL_FIELD +" from " +TABLE ;
		strSQL+=" order by  push_data D,accountid asc";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(SysPushMessage.class));
	}
	@Override
	public Page<SysPushMessageForm> findPushMessageByPage(
			SysPushMessageForm sysPushMessage, Page<SysPushMessageForm> page) {
		String condition =this.createCondition(sysPushMessage);
		String strSQL = "select "+ALL_FIELD +" from "+ TABLE+ " where 1=1 "+condition+"  order by  valid_date asc ";
		String strCountSQL = "select  count(*) from "+ TABLE +" where 1=1 "+condition;
			page.paginationProcess(this.getJdbcTemplate().queryForLong(strCountSQL.toString()));
			String paginationSQL = page.getPaginationSQL(strSQL.toString());
			List<SysPushMessageForm> sysPushMessages = this.getJdbcTemplate().query(paginationSQL,
					ParameterizedBeanPropertyRowMapper.newInstance(SysPushMessageForm.class));
			page.setPageResult(sysPushMessages);
		return page;
	}
	/**
	 * 创建模糊动态参数条件
	 * 
	 * @param code
	 * @return
	 */

	private String createCondition(SysPushMessageForm sysPushMessage) {
		StringBuffer condition = new StringBuffer("");
		if (sysPushMessage != null) {

			Integer userId=sysPushMessage.getUserId();
			String title=sysPushMessage.getTitle();
			Integer status=sysPushMessage.getStatus();
			String validDate=sysPushMessage.getValidDate();
			if(userId != null){
				condition.append(" and user_id =").append(userId);
			}
			if (title != null && !"".equals(title.trim())) {
				condition.append(" and title like '").append(title).append("'");
			}
			if(status !=null && !"".equals(status)){
				condition.append(" and status =").append(status);
			}
			if(validDate !=null && !"".equals(validDate)){
				condition.append(" and valid_date >='").append(sysPushMessage.getValidDateStart()).append("' and valid_date<='").append(sysPushMessage.getValidDateEnd())
				.append("'");
			}
		}
		return condition.toString();
	}
	@SuppressWarnings("deprecation")
	private int findPushId() {
			String strSQL = "select max(push_id)+1 from " + TABLE;
			Integer serialCode=this.getJdbcTemplate().queryForInt(strSQL);
			if(serialCode !=null){
				return serialCode+1;
			}
			return 1;
		}
}

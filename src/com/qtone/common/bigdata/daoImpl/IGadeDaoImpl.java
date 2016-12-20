package com.qtone.common.bigdata.daoImpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.bigdata.dao.IGadeDao;
import com.qtone.common.bigdata.entity.SysGrade;
@Repository
@Transactional
public class IGadeDaoImpl extends BaseDAO implements IGadeDao {
	@Override
	public void saveGade(SysGrade grade) {
		grade.setGradeId(this.nextGradeId());
		String sql = "insert into sys_grade(grade_id,grade_code,grade_name) values("
				+ grade.getGradeId() + "," + this.getGradeCode(grade.getGradeName()) + ",'"
				+ grade.getGradeName() + "'"+")";
		this.getJdbcTemplate().update(sql);
	}

	private String getGradeCode(String gradeName){
		String code="01";
		if(gradeName.indexOf("二年")>-1){
			code="02";
		}else if(gradeName.indexOf("三年")>-1){
			code="03";
		}else if(gradeName.indexOf("四年")>-1){
			code="04";
		}else if(gradeName.indexOf("五年")>-1){
			code="05";
		}else if(gradeName.indexOf("六年")>-1){
			code="06";
		}else if(gradeName.indexOf("初一")>-1){
			code="07";
		}else if(gradeName.indexOf("初二")>-1){
			code="08";
		}else if(gradeName.indexOf("初三")>-1){
			code="09";
		}else if(gradeName.indexOf("高一")>-1){
			code="10";
		}else if(gradeName.indexOf("高二")>-1){
			code="11";
		}else if(gradeName.indexOf("高三")>-1){
			code="12";
		}
		return code;
	}
	@SuppressWarnings("deprecation")
	private int nextGradeId() {
		try {
			String sql = "select max(grade_id)+1 from sys_grade";
			return this.getJdbcTemplate().queryForInt(sql);
		} catch (Exception ex) {
			return 1;
		}
	}

	@Override
	public void updateGade(SysGrade grade) {
		String sql = "update sys_grade set grade_name='"+grade.getGradeName()+"' where grade_id="+grade.getGradeId();
		this.getJdbcTemplate().update(sql);
	}
}

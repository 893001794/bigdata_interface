package com.qtone.common.bigdata.daoImpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qtone.common.base.dao.BaseDAO;
import com.qtone.common.bigdata.dao.ISchoolYearDao;
import com.qtone.common.bigdata.entity.SysSchoolYear;
@Repository
@Transactional
public class ISchoolYearDaoImpl extends BaseDAO implements ISchoolYearDao {
	@Override
	public void saveSchoolYear(SysSchoolYear schoolYear) {
		schoolYear.setSchoolYearId(this.nextSchoolYearId());
		String sql = "insert into sys_school_year(school_year_id,school_year_name,school_year) values("
				+schoolYear.getSchoolYearId() + ",'"+ schoolYear.getSchoolYearName()  + "'," + schoolYear.getSchoolYear()+")";
		this.getJdbcTemplate().update(sql);
	}

	@SuppressWarnings("deprecation")
	private int nextSchoolYearId() {
		try {
			String sql = "select max(school_year_id)+1 from sys_school_year";
			return this.getJdbcTemplate().queryForInt(sql);
		} catch (Exception ex) {
			return 1;
		}
	}
}

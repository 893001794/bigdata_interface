package com.qtone.common.bigdata.dao;

import com.qtone.common.bigdata.entity.SysClass;
import com.qtone.common.bigdata.entity.SysGrade;
import com.qtone.common.bigdata.entity.SysSchoolYear;
import com.qtone.common.bigdata.entity.SysUser;
/**
 * @title 持久层接口
 * 
 *        班级接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysClassDao {
	/**
	 * 根据班级名称查询班级信息
	 * @param gradeName学校名称
	 * @return 学校对象
	 */
	public SysGrade findGradeByName(String gradeName);
	/**
	 * 根据名称查询学年
	 * @param schoolYear
	 * @return
	 */
	public SysSchoolYear findSchoolYearByName(String schoolYear);
	/**
	 * 根据学校id和班级id查询是否存在班级
	 * @param schoolYear
	 * @return
	 */
	public SysClass findBySchoolIdGradeId(Long schoolId,Integer gradeId,Integer schoolYearId,String className);
	/**
	 * 根据学校和教师名称查询用户信息
	 * @param schoolId
	 * @param userName
	 * @return
	 */
	public SysUser findBySchoolIdUserName(Long schoolId,String userName);
	/**
	 * 更新班级
	 * @param sysClass
	 */
	public void updClass(SysClass sysClass);
	/**
	 * 添加班级
	 * @param sysClass
	 */
	public void saveClass(SysClass sysClass);
	
}

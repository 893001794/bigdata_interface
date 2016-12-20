package com.qtone.common.service;
import com.qtone.common.bigdata.entity.SysGrade;
import com.qtone.common.util.JsonView;

/**
 * 学校信息服务接口
 * @version 1.0
 * @author tzp
 * 
 */
public interface ISysGradeService {
	/**
	 * 更改年级信息
	 * @param SysGrade  年级
	 * @return
	 */
	public JsonView updateGrade(SysGrade SysGrade);
}

package com.qtone.common.bigdata.model;
import java.io.Serializable;
import com.qtone.common.bigdata.entity.SysSchool;
/**
 *学校信息form
 * @author tzp
 *
 */
public class SysSchoolForm extends SysSchool implements Serializable {
	private static final long serialVersionUID = -8634040281781470149L;
	private String organName;// 所属机构
	private String areaName ;// 区域
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
}

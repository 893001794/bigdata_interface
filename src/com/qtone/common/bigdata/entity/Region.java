package com.qtone.common.bigdata.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 区域信息
 * 
 * @author tzp
 * 
 */
@XmlRootElement(name = "Regions")
@XmlType(name = "Region")
@XmlAccessorType(XmlAccessType.FIELD)
public class Region implements Serializable{
	private static final long serialVersionUID = 6696045925067331029L;
	@XmlElement(name = "regionId")
	private Long regionId;// 区域ID
	@XmlElement(name = "regionName")
	private String regionName;// 区域名称
	@XmlElement(name = "likeCode")
	private String likeCode;// 参考代码
	@XmlElement(name = "parentRegion")
	private Region parentRegion;// 父区域
	@XmlElement(name = "regionOrder")
	private String regionOrder;// 区域排序
	@XmlElement(name = "regionLevel")
	private Integer regionLevel;// 区域级别
	@XmlElement(name = "remark")
	private String remark;// 备注
	
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getLikeCode() {
		return likeCode;
	}
	public void setLikeCode(String likeCode) {
		this.likeCode = likeCode;
	}
	public Region getParentRegion() {
		return parentRegion;
	}
	public void setParentRegion(Region parentRegion) {
		this.parentRegion = parentRegion;
	}
	public String getRegionOrder() {
		return regionOrder;
	}
	public void setRegionOrder(String regionOrder) {
		this.regionOrder = regionOrder;
	}
	public Integer getRegionLevel() {
		return regionLevel;
	}
	public void setRegionLevel(Integer regionLevel) {
		this.regionLevel = regionLevel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


}

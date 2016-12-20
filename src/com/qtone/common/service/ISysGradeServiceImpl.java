package com.qtone.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtone.common.bigdata.dao.IGadeDao;
import com.qtone.common.bigdata.entity.SysGrade;
import com.qtone.common.util.JsonView;

@Service
public class ISysGradeServiceImpl implements ISysGradeService{
	@Autowired
	private IGadeDao gadeDao;
	@Override
	public JsonView updateGrade(SysGrade sysGrade) {
		JsonView jsonView=new JsonView();
		try {
			for(int i=1;i<10;i++){
				sysGrade=new SysGrade();
				sysGrade.setGradeId(i);
				if(i==1){
					sysGrade.setGradeName("一年级");
				}else if(i==2){
					sysGrade.setGradeName("二年级");
				}else if(i==3){
					sysGrade.setGradeName("三年级");
				}else if(i==4){
					sysGrade.setGradeName("四年级");
				}else if(i==5){
					sysGrade.setGradeName("五年级");
				}else if(i==6){
					sysGrade.setGradeName("六年级");
				}else if(i==7){
					sysGrade.setGradeName("初一");
				}else if(i==8){
					sysGrade.setGradeName("初二");
				}else if(i==9){
					sysGrade.setGradeName("初三");
				}
				gadeDao.updateGade(sysGrade);
			}
			jsonView.setProperty("code", "1");
			jsonView.setProperty("resMsg","年级修改成功！");
			return 	jsonView;
		} catch (Exception e) {
			jsonView.setProperty("code", "0");
			jsonView.setProperty("resMsg","年级修改失败！");
			return 	jsonView;
		}
	}

}

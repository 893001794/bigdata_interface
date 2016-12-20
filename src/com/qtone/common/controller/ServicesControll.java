package com.qtone.common.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qtone.common.bigdata.entity.SysUser;
import com.qtone.common.service.ISysUserService;
import com.qtone.common.service.ISysUserStudentService;
import com.qtone.common.service.ISysUserTeacherService;
import com.qtone.common.util.JsonView;
@Controller
@RequestMapping("/Services/")
/**
 * 南方云教育接口对接测试
 * @author Administrator
 *
 */
public class ServicesControll {
	@Autowired
	private ISysUserTeacherService sysUserTeacherService;
	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private ISysUserStudentService sysUserStudentService;
	/**
	 * 南方云教育回调获取用户信息的方法
	 */
	@RequestMapping(value = "GetUserInfo", method = RequestMethod.GET)
	public JsonView GetUserInfo(Integer request_id,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JsonView jsonview =new JsonView();
		if(request_id !=null && !"".equals(request_id)){
			StringBuffer url = new StringBuffer();
			SysUser user=sysUserService.findUserById(request_id);//根据id获取用户信息
			if(user !=null){
				try {
					//获取系统年份
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
					Integer currYear=Integer.parseInt(sdf.format(new Date()));//获取年份
					//该用户是学生
					if(user.getIsStudent()!=null && user.getIsStudent()==1){
						jsonview =sysUserStudentService.findStudentSubject(request_id,currYear);
						jsonview.setProperty("user_type", "1");
					}else if(user.getIsTeacher()!=null &&user.getIsTeacher()==1){
						jsonview =sysUserTeacherService.findTeacherInfor(request_id,currYear);
						//改用户是教师
						jsonview.setProperty("user_type", "3");
					}
					jsonview.setProperty("ret_code", "10000");
					jsonview.setProperty("ret_msg", "操作成功");
					jsonview.setProperty("user_id", request_id);
					jsonview.setProperty("user_name", user.getLoginName());
					jsonview.setProperty("real_name", user.getUserName());
					jsonview.setProperty("is_try", "1");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				jsonview.setProperty("ret_code", "12003");
				jsonview.setProperty("ret_msg", "用户Id="+request_id+",不存在!");
			}
			
		}else{
			jsonview.setProperty("ret_code", "11000");
			jsonview.setProperty("ret_msg", "人教e学没有传过来request_id参数");
		}
		System.out.println("传给人教E学的数据："+jsonview.toString());
		return jsonview;
	}
	
}

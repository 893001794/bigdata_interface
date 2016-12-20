package com.qtone.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qtone.common.bigdata.entity.SysInterface;

@Controller
public class SysInterfaceController {
	@RequestMapping(params = "action=saveSysInterfaceIndex")
	public ModelAndView saveSysInterfaceIndex(
			HttpServletRequest request, ModelMap map,SysInterface sysInterface){
		
		return new ModelAndView("");
	}
}

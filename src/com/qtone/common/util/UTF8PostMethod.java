package com.qtone.common.util;

import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 后台http请求时解决请求参数中文乱码问题
 * @author Administrator
 *
 */
public class UTF8PostMethod extends PostMethod{

	public UTF8PostMethod(String url){
		super(url);
	}
	
	public String getRequestCharSet() { 
		return "UTF-8";
	}
	
}

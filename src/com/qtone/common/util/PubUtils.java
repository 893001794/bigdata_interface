package com.qtone.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class PubUtils {
	/**
	 * 根据时间格式匹配返回当前时间 如yyyyMMdd 表示20060810
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getFmtSystime(String pattern) {
		if (pattern == null) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		String sTmp = dateFormat.format(new java.util.Date());
		return sTmp;
	}

	/**
	 * 根据时间格式匹配返回当前时间 如yyyyMMdd 表示20060810
	 * 
	 * @param pattern
	 * @return
	 */
	public static Date getParseSystime(String pattern) {
		if (pattern == null) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat dateParse = new SimpleDateFormat(pattern);
		Date sTmp = null;
		try {
			sTmp = dateParse.parse(dateParse.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sTmp;
	}
	/**
	 * 获取客户端网络地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getClientHostIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}

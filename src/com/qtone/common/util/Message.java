package com.qtone.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring MVC
 * 
 * 提供返回对象
 * 
 * @author tzp
 * 
 */
public class Message {
	/**
	 * 是否操作成功
	 */
	private boolean success = false;

	/**
	 * 提示信息
	 */
	private String message;

	/**
	 * 用于存储其他各属性和值
	 */
	private Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 设置其他各属性和值
	 */
	public void setProperty(String key, Object value) {
		map.put(key, value);
	}

	/**
	 * 取得其他各属性和值
	 */
	public Object getProperty(String key) {
		return map.get(key);
	}

	public boolean isSuccess() {
		return success;
	}

	public Message setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Message setMessage(String message) {
		this.message = message;
		return this;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}

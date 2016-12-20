package com.qtone.common.util;

import java.io.PrintWriter;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.View;

/**
 * Spring MVC 视图
 * 
 * 提供Ajax方式返回Json对象
 * 
 * @author tzp
 * 
 */
public class JsonView implements View {
	private Map<String, Object> map = new LinkedHashMap<String, Object>();

	public String getContentType() {
		return "text/plain;charset=UTF-8";
	}

	public void setProperty(String key, Object value) {		
		map.put(key, value);
	}

	public void render(Map<String, ?> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType(getContentType());
		PrintWriter out = response.getWriter();
		try {
			out.write(this.getJSONString());
		} finally {
			out.close();
			out = null;
		}
	}

	/**
	 * 获取json对象:
	 * 
	 * {"success":"true","message":"info"}
	 */
	public String getJSONString() {
		JSONObject jsonObject = getJsonFromMap(map);
		return jsonObject.toString();
	}

	/**
	 * Map对象转化Json对象
	 * 
	 * @param map
	 * @return
	 */
	private JSONObject getJsonFromMap(Map<String, Object> map) {
		if (!map.isEmpty()) {
			JSONObject jsonObject = new JSONObject();
			Iterator<String> it = map.keySet().iterator();
			while (it.hasNext()) {
				Object key = it.next();
				jsonObject.put(key, map.get(key));
			}
			return jsonObject;
		} else {
			return null;
		}
	}

	/**
	 *将str转jsonObject
	 * @param map
	 * @return
	 */
	public JSONObject StrToJson(String str){
		 return JSONObject.fromObject(str);
	}
	public static void main(String[] args) {
		
		JsonView view = new JsonView();
		JSONObject temp=new JSONObject();
//		view.setProperty("证件编号", "证件编号");
//		view.setProperty("证件名称", "证件名称");
//		view.setProperty("证件编号证件编号证件编号证件名称", "证件编号证件编号证件编号证件名称");
//		System.out.println(view.getJSONString());
		view.setProperty("code", "1");
		temp.put("schoolName", "东区起湾小学");
		temp.put("orgName", "东区教办");
		temp.put("areaName", "东区");
		temp.put("schoolLevel", "幼儿园");
		temp.put("schoolType", "民办");
		view.setProperty("resMsg",temp);
		System.out.println(view.getJSONString());

	}
}

package com.light.web.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 
 * 抽象的Controller <br/>
 * 抽象一些常用的Controller操作 <br/>
 * 
 * @author yudengqiu
 *
 */
public abstract class AbstractController {

	private static final String contentType = "application/json;charset=utf-8";
	private static final String contentTypeForIE = "text/html;charset=utf-8";
	private static boolean forIE = false;
	
	@Autowired(required=false)
	private HttpServletResponse response;
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	/**
	 * 返回json
	 * @param val 要转化成json的对象 <br/>
	 * @author liufeng
	 * @date 2015年11月24日 上午9:08:35
	 */
	public void renderJson(Object val) {
		PrintWriter writer = null;
		try {
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType(forIE ? contentTypeForIE : contentType);
			writer = response.getWriter();
	        writer.write(JSON.toJSONString(val));
	        writer.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

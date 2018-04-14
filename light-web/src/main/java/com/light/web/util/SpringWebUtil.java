package com.light.web.util;

import com.light.web.interceptor.ModelAndViewInterceptor;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @ClassName: SpringWebUtil
 * @Description: 从spring容器里获取HttpServlet等容器对象
 */
public class SpringWebUtil {

	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public static HttpSession getSession() {
		return getRequest().getSession();
	}
	
	public static HttpServletResponse getResponse() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	public static Configuration getConfiguration() {
		FreeMarkerConfigurer freemarkerConfigurer = (FreeMarkerConfigurer) SpringUtil.getBean("freemarkerConfigurer");
		Configuration configuration = freemarkerConfigurer.getConfiguration();
		return configuration;
	}
	
	public static String getTemplateContent(String tplName) {
		String content = "";
		Template template = getTemplate(tplName);
		if(template != null) {
			StringWriter out = new StringWriter();
			try {
				template.dump(out);
			} catch (IOException e) {
			}
			content = out.toString();
		}
		return content;
	}
	
	public static Template getTemplate(String tplName) {
		Template template = null;
		try {
			Configuration configuration = getConfiguration();
			if(configuration != null) {
				template = configuration.getTemplate(tplName);
			}
		} catch(Exception e) {
		}
		return template;
	}
	
	public static ModelAndView getModelAndView() {
		ModelAndView modelAndView = ModelAndViewInterceptor.getModelAndView();
		return modelAndView;
	}
	
	public static String getRealPath() {
		String base = getSession().getServletContext().getRealPath("/");
		return base;
	}
}

package com.light.web.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModelAndViewInterceptor extends HandlerInterceptorAdapter {

	private static final ThreadLocal<ModelAndView> modelAndViewLocal = new ThreadLocal<ModelAndView>();
	
	public static ModelAndView getModelAndView() {
		return modelAndViewLocal.get();
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		modelAndViewLocal.set(modelAndView);
	}

}

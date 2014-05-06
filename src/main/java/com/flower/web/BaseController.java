package com.flower.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import com.flower.cons.CommonConstant;
import com.flower.domain.User;

public class BaseController {
	protected static final String ERROR_MSG_KEY = "errorMsg";
	
	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(
				CommonConstant.USER_CONTEXT);
	}
	
	protected void setSessionUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
	}
	
	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url can't empty");
		Assert.isTrue(url.startsWith("/"), "/ as start");
		return request.getContextPath() + url;
	}
}

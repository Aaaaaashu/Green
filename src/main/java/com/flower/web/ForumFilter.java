package com.flower.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import static com.flower.cons.CommonConstant.*;
import com.flower.domain.User;

public class ForumFilter implements Filter {
	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
	
	private static final String[] INHERENT_ESCAPE_URIS = {"/index.jsp",
		"/index.html", "/login.jsp", "/login/doLogin.html",
		"/register.jsp", "/register.html", "/board/listBoardTopics-",
		"/board/listTopicPosts-" 
	};
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			User userContext = getSessionUser(httpRequest);
			
			if (userContext == null
					&& !isURILogin(httpRequest.getRequestURI(), httpRequest)) {
				String toUrl = httpRequest.getRequestURL().toString();
				if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
					toUrl += "?" + httpRequest.getQueryString();
				}
				
				httpRequest.getSession().setAttribute(LOGIN_TO_URL, toUrl);
				
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
			chain.doFilter(request, response);
		}
	}
	
	private boolean isURILogin(String requestURI, HttpServletRequest request) {
		if (request.getContextPath().equalsIgnoreCase(requestURI)
				|| (request.getContextPath() + "/").equalsIgnoreCase(requestURI))
			return true;
		for (String uri : INHERENT_ESCAPE_URIS) {
			if (requestURI != null && requestURI.indexOf(uri) >= 0) {
				return true;
			}
		}
		return false;
	}

	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(USER_CONTEXT);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}

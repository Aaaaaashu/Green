package com.flower.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flower.cons.CommonConstant;
import com.flower.domain.User;
import com.flower.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	
	public ModelAndView login(HttpServletRequest request, User user) {
		User dbUser = userService.getUserByUserName(user.getUserName());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/login.jsp");
		if (dbUser == null) {
			mav.addObject("errorMsg", "UserName isn't exist");
		} else if (!dbUser.getPassword().equals(user.getPassword())) {
			mav.addObject("errorMsg", "Password isn't right");
		} else if (dbUser.getLocked() == User.USER_LOCK) {
			mav.addObject("errorMsg", "User already lock, which can't login");
		} else {
			dbUser.setLastIp(request.getRemoteAddr());
			dbUser.setLastVisit(new Date());
			userService.loginSuccess(dbUser);
			setSessionUser(request,dbUser);
			String toUrl = (String)request.getSession().getAttribute(CommonConstant.LOGIN_TO_URL);
			request.getSession().removeAttribute(CommonConstant.LOGIN_TO_URL);
			
			if(StringUtils.isEmpty(toUrl)){
				toUrl = "/index.html";
			}
			mav.setViewName("redirect:"+toUrl);
		}
		return mav;
	}
	
	@RequestMapping("/doLogout")
	public String logout(HttpSession session) {
		session.removeAttribute(CommonConstant.USER_CONTEXT);
		return "forward:/index.jsp";
	}
}



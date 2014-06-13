
package com.green.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.cons.CommonConstant;
import com.green.domain.User;
import com.green.exception.UserExistException;
import com.green.service.UserService;

@Controller                   
public class RegisterController extends BaseController {

	@Autowired
	private UserService userService;

	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,User user){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/index.jsp");
		try {
			userService.register(user);
		} catch (UserExistException e) {
			mav.addObject("errorMsg", "用户名已经存在，请选择其它的名字。");
			mav.setViewName("forward:/register.jsp");
		}
		setSessionUser(request,user);
		return mav;
	}
}

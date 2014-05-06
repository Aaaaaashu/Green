package com.flower.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.flower.domain.User;
import com.flower.exception.UserExistException;
import com.flower.service.UserService;

@Controller
public class RegisterController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, User user) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/success");
		try {
			userService.register(user);
		} catch (UserExistException e) {
			view.addObject("errorMsg", "Username already exist, please choose other name.");
			view.setViewName("forward:/register.jsp");
		}
		setSessionUser(request, user);
		return view;
	}
}

package com.flower.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flower.domain.Board;
import com.flower.domain.User;
import com.flower.service.ForumService;
import com.flower.service.UserService;

@Controller
public class ForumManageController extends BaseController {
	
	@Autowired
	private ForumService forumService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView listAllBoards() {
		ModelAndView mav = new ModelAndView();
		List<Board> boards = forumService.getAllBoards();
		mav.addObject("boards", boards);
		mav.setViewName("/listAllBoards");
		return mav;
	}
	
	@RequestMapping(value = "/forum/addBoardPage", method = RequestMethod.GET)
	public String addBoardPage() {
		return "/addBoard";
	}
	
	@RequestMapping(value = "/forum/addBoard", method = RequestMethod.POST)
	public String addBoard(Board board) {
		forumService.addBoard(board);
		return "/addBoardSuccess";
	}
	
	@RequestMapping(value = "/forum/setBoardManagerPage", method = RequestMethod.GET)
	public ModelAndView setBoardManagerPage() {
		ModelAndView mav =new ModelAndView();
		List<Board> boards = forumService.getAllBoards();
		List<User> users = userService.getAllUsers();
		mav.addObject("boards", boards);
		mav.addObject("users", users);
		mav.setViewName("/setBoardManager");
		return mav;
	}
	
	@RequestMapping(value = "/forum/setBoardManager", method = RequestMethod.POST)
	public ModelAndView setBoardManager(@RequestParam("userName") String userName,
			@RequestParam("boardId") String boardId) {
		ModelAndView mav = new ModelAndView();
		User user = userService.getUserByUserName(userName);
		if (user == null) {
			mav.addObject("errorMsg", "UserName(" + userName + ")isn't exist");
			mav.setViewName("/fail");
		} else {
			Board board = forumService.getBoardById(Integer.parseInt(boardId));
			user.getManBoards().add(board);
			userService.update(user);
			mav.setViewName("/success");
		}
		return mav;
	}
	
	@RequestMapping(value = "/forum/userLockManagePage", method = RequestMethod.GET)
	public ModelAndView userLockManagePage() {
		ModelAndView mav =new ModelAndView();
		List<User> users = userService.getAllUsers();
		mav.setViewName("/userLockManage");
		mav.addObject("users", users);
		return mav;
	}
	
	@RequestMapping(value = "/forum/userLockManage", method = RequestMethod.POST)
	public ModelAndView userLockManage(@RequestParam("userName") String userName
			,@RequestParam("locked") String locked) {
		ModelAndView mav =new ModelAndView();
        User user = userService.getUserByUserName(userName);
		if (user == null) {
			mav.addObject("errorMsg", "UserName(" + userName
					+ ") isn't exist");
			mav.setViewName("/fail");
		} else {
			user.setLocked(Integer.parseInt(locked));
			userService.update(user);
			mav.setViewName("/success");
		}
		return mav;
	}

}

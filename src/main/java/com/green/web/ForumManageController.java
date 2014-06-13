
package com.green.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.domain.Board;
import com.green.domain.User;
import com.green.service.ForumService;
import com.green.service.UserService;

@Controller
public class ForumManageController extends BaseController {
	@Autowired
	private ForumService forumService;
	@Autowired
	private UserService userService;

	/**
	 * 跳转至添加版块页面
	 * 列出所有的论坛模块
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/forum/addBoardPage", method = RequestMethod.GET)
	public ModelAndView listAllBoards() {
		ModelAndView mav =new ModelAndView();
		List<Board> boards = forumService.getAllBoards();
		mav.addObject("boards", boards);
		mav.setViewName("/backManagement/addBoard");
		return mav;
	}

//	/**
//	 *  跳转至添加版块页面
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/forum/addBoardPage", method = RequestMethod.GET)
//	public String addBoardPage() {
//		return "/addBoard";
//	}

	/**
	 * 添加一个版块
	 * @param request
	 * @param response
	 * @param board
	 * @return
	 */
	@RequestMapping(value = "/forum/addBoard", method = RequestMethod.POST)
	public String addBoard(Board board) {
		forumService.addBoard(board);
		return "/index";
	}

	/**
	 * 跳转至指定论坛管理员的页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/forum/setBoardManagerPage", method = RequestMethod.GET)
	public ModelAndView setBoardManagerPage() {
		ModelAndView mav =new ModelAndView();
		List<Board> boards = forumService.getAllBoards();
		List<User> users = userService.getAllUsers();
		mav.addObject("boards", boards);
		mav.addObject("users", users);
		mav.setViewName("/backManagement/setManager");
		return mav;
	}
	
    /**
     * 设置版块管理员
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value = "/forum/setBoardManager", method = RequestMethod.POST)
	public ModelAndView setBoardManager(@RequestParam("userName") String userName
			,@RequestParam("boardId") String boardId) {
		ModelAndView mav =new ModelAndView();
		User user = userService.getUserByUserName(userName);
		if (user == null) {
			mav.addObject("errorMsg", "用户名(" + userName
					+ ")不存在");
			mav.setViewName("/fail");
		} else {
			Board board = forumService.getBoardById(Integer.parseInt(boardId));
			user.getManBoards().add(board);
			user.setUserType(2);
			userService.update(user);
			mav.setViewName("/index");
		}
		return mav;
	}

	/**
	 * 跳轉至用户锁定及解锁管理页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/forum/userLockManagePage", method = RequestMethod.GET)
	public ModelAndView userLockManagePage() {
		ModelAndView mav =new ModelAndView();
		List<User> users = userService.getAllUsers();
		mav.addObject("users", users);
		mav.setViewName("/backManagement/userLock");
		return mav;
	}

	/**
	 * 用户锁定及解锁设定
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/forum/userLockManage", method = RequestMethod.POST)
	public ModelAndView userLockManage(@RequestParam("userName") String userName
			,@RequestParam("locked") String locked) {
		ModelAndView mav =new ModelAndView();
        User user = userService.getUserByUserName(userName);
		if (user == null) {
			mav.addObject("errorMsg", "用户名(" + userName
					+ ")不存在");
			mav.setViewName("/fail");
		} else {
			user.setLocked(Integer.parseInt(locked));
			userService.update(user);
			mav.setViewName("/index");
		}
		return mav;
	}
}

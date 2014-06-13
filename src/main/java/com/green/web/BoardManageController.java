
package com.green.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.cons.CommonConstant;
import com.green.dao.Page;
import com.green.domain.Board;
import com.green.domain.MainPost;
import com.green.domain.Post;
import com.green.domain.Topic;
import com.green.domain.User;
import com.green.service.ForumService;

@Controller
public class BoardManageController extends BaseController {
	@Autowired
	private ForumService forumService;

	/**
	 * 列出论坛模块下的主题帖子
	 * 
	 * @param boardId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/board/listBoardTopics-{boardId}", method = RequestMethod.GET)
	public ModelAndView listBoardTopics(@PathVariable Integer boardId,@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		ModelAndView mav =new ModelAndView();
		Board board = forumService.getBoardById(boardId);
		pageNo = pageNo == null ? 1 : pageNo;
		Page pagedTopic = forumService.getPagedTopics(boardId, pageNo,
				CommonConstant.PAGE_SIZE);
		mav.addObject("board", board);
		mav.addObject("pagedTopic", pagedTopic);
		mav.setViewName("forward:/listBoardTopics.jsp");
		return mav;
	}

	/**
	 * 跳转至主题帖页面
	 * 
	 * @param boardId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/board/addTopicPage-{boardId}", method = RequestMethod.GET)
	public ModelAndView addTopicPage(@PathVariable Integer boardId) {
		ModelAndView mav =new ModelAndView();
		mav.addObject("boardId", boardId);
		mav.setViewName("forward:/addTopic.jsp");
		return mav;
	}

	/**
	 * 添加一个主题帖
	 * 
	 * @param request
	 * @param response
	 * @param topic
	 * @return
	 */
	@RequestMapping(value = "/board/addTopic", method = RequestMethod.POST)
	public String addTopic(HttpServletRequest request,Topic topic) {
		User user = getSessionUser(request);
		topic.setUser(user);
		Date now = new Date();
		topic.setCreateTime(now);
		topic.setLastPost(now);
		forumService.addTopic(topic);
		String targetUrl = "/board/listBoardTopics-" + topic.getBoardId()
				+ ".html";
		return "redirect:"+targetUrl;
	}

	/**
	 * 列出主题的所有帖子
	 * 
	 * @param topicId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/board/listTopicPosts-{topicId}", method = RequestMethod.GET)
	public ModelAndView listTopicPosts(@PathVariable Integer topicId,@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		ModelAndView mav =new ModelAndView();
		Topic topic = forumService.getTopicByTopicId(topicId);
		pageNo = pageNo==null?1:pageNo;
		Page pagedPost = forumService.getPagedPosts(topicId, pageNo,
				CommonConstant.PAGE_SIZE);
		// 为回复帖子表单准备数据
		mav.addObject("topic", topic);
		mav.addObject("pagedPost", pagedPost);
		mav.setViewName("forward:/listTopicPosts.jsp");
		return mav;
	}

	/**
	 * 回复主题
	 * 
	 * @param request
	 * @param response
	 * @param post
	 * @return
	 */
	@RequestMapping(value = "/board/addPost")
	public String addPost(HttpServletRequest request, Post post) {
		post.setCreateTime(new Date());
		post.setUser(getSessionUser(request));
		forumService.addPost(post);
		String targetUrl = "/board/listTopicPosts-"
				+ post.getTopic().getTopicId() + ".html";
		return "redirect:"+targetUrl;
	}

	/**
	 * 删除版块
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/board/removeBoard-{boardId}", method = RequestMethod.GET)
	public ModelAndView removeBoard(@PathVariable Integer boardId) {
		forumService.removeBoard(boardId);
		ModelAndView mav =new ModelAndView();
		mav.setViewName("forward:/index.jsp");
		return mav;
	}

	/**
	 * 删除主题
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/board/removeTopic", method = RequestMethod.GET)
	public String removeTopic(@RequestParam("topicIds") String topicIds,@RequestParam("boardId") String boardId) {
		String[] arrIds = topicIds.split(",");
		for (int i = 0; i < arrIds.length; i++) {
			forumService.removeTopic(new Integer(arrIds[i]));
		}
		String targetUrl = "/board/listBoardTopics-" + boardId + ".html";
		return "redirect:"+targetUrl;
	}

	/**
	 * 设置精华帖
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/board/makeDigestTopic", method = RequestMethod.GET)
	public String makeDigestTopic(@RequestParam("topicIds") String topicIds,@RequestParam("boardId") String boardId) {
		String[] arrIds = topicIds.split(",");
		for (int i = 0; i < arrIds.length; i++) {
			forumService.makeDigestTopic(new Integer(arrIds[i]));
		}
		String targetUrl = "/board/listBoardTopics-" + boardId + ".html";
		return "redirect:"+targetUrl;
	}
}

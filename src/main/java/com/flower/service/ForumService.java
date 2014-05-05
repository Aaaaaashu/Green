package com.flower.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flower.dao.BoardDao;
import com.flower.dao.Page;
import com.flower.dao.PostDao;
import com.flower.dao.TopicDao;
import com.flower.dao.UserDao;
import com.flower.domain.Board;
import com.flower.domain.MainPost;
import com.flower.domain.Post;
import com.flower.domain.Topic;
import com.flower.domain.User;

@Service
public class ForumService {
	
	@Autowired
	private TopicDao topicDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private PostDao postDao;
	
	public void addTopic(Topic topic) {
		Board board = (Board) boardDao.load(topic.getBoardId());
		board.setTopicNum(board.getTopicNum() + 1);
		topicDao.save(topic);
		
		topic.getMainPost().setTopic(topic);
		MainPost post = topic.getMainPost();
		post.setCreateTime(new Date());
		post.setUser(topic.getUser());
		post.setPostTitle(topic.getTopicTitle());
		post.setBoardId(topic.getBoardId());
		postDao.save(topic.getMainPost());
		
		User user = topic.getUser();
		user.setCredit(user.getCredit() + 10);
		userDao.update(user);
	}
	
	public void removeTopic(int topicId) {
		Topic topic = topicDao.load(topicId);
		
		Board board = boardDao.load(topic.getBoardId());
		board.setTopicNum(board.getTopicNum() - 1);
		
		User user = topic.getUser();
		user.setCredit(user.getCredit() - 50);
		
		topicDao.remove(topic);
		postDao.deleteTopicPosts(topicId);
	}
	
	public void addPost(Post post) {
		postDao.save(post);
		
		User user = post.getUser();
		user.setCredit(user.getCredit() + 5);
		userDao.update(user);
		
		Topic topic = topicDao.load(post.getTopic().getTopicid());
		topic.setReplies(topic.getReplies() + 1);
		topic.setLastPost(new Date());
	}
	
	public void removePost(int postId) {
		Post post = postDao.load(postId);
		postDao.remove(post);
		
		Topic topic = topicDao.load(post.getTopic().getTopicid());
		topic.setReplies(topic.getReplies() - 1);
		
		User user = post.getUser();
		user.setCredit(user.getCredit() - 20);
	}
	
	public void addBoard(Board board) {
		boardDao.save(board);
	}
	
	public void removeBoard(int boardId) {
		Board board = boardDao.load(boardId);
		boardDao.remove(board);
	}
	
	public void makeDigestTopic(int topicId) {
		Topic topic = topicDao.load(topicId);
		topic.setDigest(Topic.DIGEST_TOPIC);
		User user = topic.getUser();
		user.setCredit(user.getCredit() + 100);
	}
	
	public List<Board> getAllBoards() {
		return boardDao.loadAll();
	}
	
	public Page getPagedTopics(int boardId, int pageNo, int pageSize) {
		return topicDao.getPagedTopics(boardId, pageNo, pageSize);
	}
	
	public Page getPagedPosts(int topicId, int pageNo, int pageSize) {
		return postDao.getPagedPosts(topicId, pageNo, pageSize);
	}
	
	public Page queryTopicByTitle(String title, int pageNo, int pageSize) {
		return topicDao.queryTopicByTitle(title, pageNo, pageSize);
	}
	
	public Board getBoardById(int boardId) {
		return boardDao.load(boardId);
	}
	
	public Topic getTopicByTopicId(int topicId) {
		return topicDao.load(topicId);
	}
	
	public Post getPostByPostId(int postId) {
		return postDao.load(postId);
	}
	
	public void addBoardManager(int boardId, String userName) {
		User user = userDao.getUserByUserName(userName);
		if (user == null) {
			throw new RuntimeException("Account's" + userName + "isn't exist.");
		} else {
			Board board = boardDao.load(boardId);
			user.getManBoards().add(board);
			userDao.update(user);
		}
	}
	
	public void updateTopic(Topic topic) {
		topicDao.update(topic);
	}
	
	public void updatePost(Post post) {
		postDao.update(post);
	}
}

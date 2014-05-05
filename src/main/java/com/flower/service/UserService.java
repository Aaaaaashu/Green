package com.flower.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flower.dao.LoginLogDao;
import com.flower.dao.UserDao;
import com.flower.domain.LoginLog;
import com.flower.domain.User;
import com.flower.exception.UserExistException;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	public void register(User user) throws UserExistException {
		User u = this.getUserByUserName(user.getUserName());
		if (u != null) {
			throw new UserExistException("UserName already exist");
		} else {
			user.setCredit(100);
			user.setUserType(1);
			userDao.save(user);
		}
	}
	
	public void update(User user) {
		userDao.update(user);
	}
	
	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}
	
	public User getUserById(int userId) {
		return userDao.load(userId);
	}
	
	public void lockUser(String userName) {
		User user = userDao.getUserByUserName(userName);
		user.setLocked(User.USER_LOCK);
		userDao.update(user);
	}
	
	public void unlockUser(String userName) {
		User user = userDao.getUserByUserName(userName);
		user.setLocked(User.USER_UNLOCK);
		userDao.update(user);
	}
	
	public List<User> queryUserByUserName(String userName) {
		return userDao.queryUserByUserName(userName);
	}
	
	public List<User> getAllUsers() {
		return userDao.loadAll();
	}
	
	public void loginSuccess(User user) {
		user.setCredit( 5 + user.getCredit());
		LoginLog loginLog = new LoginLog();
		loginLog.setUser(user);
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(new Date());
		userDao.update(user);
		loginLogDao.save(loginLog);
	}
	
}

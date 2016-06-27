package com.pts.ats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pts.ats.DAO.User;
import com.pts.ats.DAO.UserDao;

@Service("userService")
public class serviceDao {

	private UserDao userDao;
	/**
	 * @param userDao the userDao to set
	 */
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public List<User> getUsers(){
		return userDao.getUsers();
	}
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userDao.createUser(user);
	}

}

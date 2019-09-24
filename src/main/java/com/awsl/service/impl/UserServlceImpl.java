package com.awsl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.awsl.dao.UserDao;
import com.awsl.entity.User;
import com.awsl.service.UserServlce;

@Service("userService")
public class UserServlceImpl extends BaseServiceImpl<User> implements UserServlce {

	@Resource
	private UserDao userDao;
	@Override
	public User login(String username, String password) {
		return userDao.login(username, password);
	}

}

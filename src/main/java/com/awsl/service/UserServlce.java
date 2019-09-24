package com.awsl.service;

import com.awsl.entity.User;

public interface UserServlce extends BaseService<User>{
	public User login(String username,String password);

}

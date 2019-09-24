package com.awsl.dao;

import com.awsl.entity.User;

public interface UserDao extends BaseDao<User>{
	public User login(String username,String password);

}

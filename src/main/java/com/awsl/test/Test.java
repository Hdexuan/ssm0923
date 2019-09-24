package com.awsl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.awsl.entity.User;
import com.awsl.service.UserServlce;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServlce servlce= (UserServlce) context.getBean("userService");
		User user= servlce.queryById(User.class, 1);
		System.out.println(user);
		
		
	}

}

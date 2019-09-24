package com.awsl.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsl.entity.User;
import com.awsl.service.UserServlce;

@Controller
public class UserController {
	
	@Resource
	private UserServlce userServlce;
	
	// ${pageContext.request.contextPath}是JSP取得绝对路径的方法   :/ssm-0920  
	
	@RequestMapping("/addForm")//放在WEB-INF 的原因：不能直接就访问到页面,更有安全性
	public String add() {
		return "add";//以请求的方式跳转到新增页面
	}
	
	@RequestMapping("/add")
	public String add(User user) {
		userServlce.add(user); //完成了注册的功能
		return "redirect:loginForm";//重定向
	}
	
	//首先访问这个页面
	@RequestMapping("/loginForm")
	public String login() {
		return "login";
	}
	
	
	//登陆判断
	@RequestMapping("/login")
	public String login(User user,HttpSession session) {
		user =userServlce.login(user.getUsername(), user.getPassword());
		if(user!=null) {
			//保存登陆信息到会话中
			session.setAttribute("u", user);
			
			return "redirect:list/1";
		}else {
			return "redirect:loginForm";//跳到另一个请求
		}
	}
	
	//分页查询列表
	@RequestMapping("/list/{currentPage}")
	public String list(@PathVariable String currentPage,Map<String, Object> map) {
		int sp=1;
		int pageSize=20;
		//获取总记录数
		int totals = userServlce.getTotals(User.class);
		
		int pageCounts=totals/pageSize; 
		if(totals%pageSize!=0) {
			pageCounts++;
		}
		try {
			sp=Integer.parseInt(currentPage);
			
		} catch (Exception e) {
			// TODO: handle exception
			sp=1;
		}
		if(sp>pageCounts) {
			sp=pageCounts;
		}
		if(sp<1) {
			sp=1;
		}
		List<User> list=userServlce.queryByPage(User.class, sp, pageSize);
		map.put("sp", sp);
		map.put("totals", totals);
		map.put("pageCounts", pageCounts);
		map.put("list", list);
		return "list";
	}
	
	
	/**
	 * 把需要修改的信息 传到修改页面
	 * @param currentPage
	 * @param id
	 * @param map
	 * @return
	 */
	//{currentPage} 当前页码数
	
	@RequestMapping("/queryById/{currentPage}/{id}") //@PathVariable  注意这个注解的使用
	public String queryById(@PathVariable String currentPage, @PathVariable int id, Map<String, Object> map) {
		User user =userServlce.queryById(User.class, id);
		map.put("user", user);//把对象放到 map中
		System.out.println(currentPage);
		return "update";
	}
	/**
	 * 更新信息
	 * @param user
	 * @param currentPage
	 * @return
	 */
	
	@RequestMapping("/update")
	public String update(User user,String currentPage ) {
		//把从页面获取到的账号，密码 传进方法中
		userServlce.update(user);
		//修改成功之后，请求到 /list + 当前 页面中
		return "redirect:/list/"+currentPage;
		
	}
	
	/**
	 * 删除
	 * @param currentPage
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById/{currentPage}/{id}")
	public String deleteById(@PathVariable String currentPage, @PathVariable int id) {
		userServlce.deleteById(User.class, id);
		//删除成功之后，回到当前页
		return "redirect:/list/"+currentPage;//
	}
	
	
	
	
	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/loginFomr";
		
	}
	
	
}

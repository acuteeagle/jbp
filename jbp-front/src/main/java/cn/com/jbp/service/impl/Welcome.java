package cn.com.jbp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Welcome {
	
	@RequestMapping(value ="/welcome/user")
	public ModelAndView welcome(HttpServletRequest request,HttpServletResponse response,
			ModelMap modelMap) {
		return new ModelAndView("welcome",modelMap);
		//普通转向
	}
	
	@RequestMapping(value ="/welcome/ordinary")
	public ModelAndView ordinary(HttpServletRequest request,HttpServletResponse response,
			ModelMap modelMap) {
		//velocity测试
		List<String> strlist = new ArrayList<String>();
		for(int i=0;i<10;i++) {
			strlist.add("list字符"+i);
		}
		modelMap.put("strlist", strlist);
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<10;i++) {
			map.put("zifu"+i, "map字符"+i);
		}
		map.put(null, "哦");
		modelMap.put("map", map);
		List<User> objlist = new Stack<User>();
		for(int i=0;i<10;i++) {
			objlist.add(new User("name"+i,"nick"+i));
		}
		modelMap.put("uselist", objlist);
		return new ModelAndView("ordinary",modelMap);
	}
	
	 	
	public class User {
		private String username;
		private String nickname;
		public User(String username, String nickname) {
			this.username = username;
			this.nickname = nickname;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
	}
}
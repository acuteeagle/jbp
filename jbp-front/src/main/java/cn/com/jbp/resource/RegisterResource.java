package cn.com.jbp.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.jbp.service.IUserService;

@Controller
public class RegisterResource{
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService userServiceImpl;
	
	@RequestMapping(value ="/reg",method = RequestMethod.POST)
	public ModelAndView reg(HttpServletRequest request,HttpServletResponse response,
			ModelMap modelMap) {
		boolean flag=true;
		String userId=request.getParameter("userId");
		String passwd=request.getParameter("password");
		String passwd2=request.getParameter("password2");
		if(StringUtils.isEmpty(userId)){
			modelMap.addAttribute("errorMsg", "用户名不可少");
			flag=false;
		}
		if(StringUtils.isEmpty(passwd)||StringUtils.isEmpty(passwd2)){
			modelMap.addAttribute("errorMsg", "登陆密码不可少");
			flag=false;
		}
		if(passwd.trim().equals(passwd2.trim())){
			modelMap.addAttribute("errorMsg", "两次密码输入不一致");
			flag=false;
		}
		try {
			userServiceImpl.createUser(userId.trim(), passwd.trim());
		} catch (Exception e) {
			logger.error("注册用户失败",e);
			modelMap.addAttribute("errorMsg", "注册服务异常");
			flag=false;
		}
		if(!flag){
			return new ModelAndView("register",modelMap);
		}
		return new ModelAndView("index",modelMap);
	}

}

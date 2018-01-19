package com.tangzhihe.controller;

import com.tangzhihe.domain.User;
import com.tangzhihe.service.UserService;
import com.tangzhihe.tools.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 登录
 * Created by tengj on 2017/4/10.
 */
@Controller
public class LoginController extends  AbstractController{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        model.addAttribute("ctx", getContextPath()+"/");
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("ctx",request.getContextPath());
        Map<String,Object> map =new HashMap<String,Object>();
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        if(StringUtil.isNull(userName)){
        	map.put("result", "用户名不能为空!");
        	return map;
        } else if(StringUtil.isNull(password)) {
        	map.put("result", "密码不能为空!");
        	return map;
        } else{
            User user =new User();
            user.setUsername(userName);
            user.setPassword(password);
            request.getSession().setAttribute("user",user);
            logger.info("userName: " + userName + " , " + "password: " + password);
	        List<User> userList = userService.queryUserList(user);
	        if(userList.size()!=0) {
	        	map.put("result", "1");
	        }else {
	        	map.put("result", "0");
	        }
        }
        return map;
    }
}

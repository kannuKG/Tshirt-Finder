package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.service.LoginService;

@Controller
public class UserController {
	@Autowired
	LoginService loginService;
	@RequestMapping("/user")
	public ModelAndView login(HttpServletRequest req,HttpServletRequest resp) {
		String u=req.getParameter("username");
		String p=req.getParameter("password");
		ModelAndView mv=new ModelAndView();
		loginService.save();
		if(loginService.validation(u,p)) {
			mv.setViewName("MainPage.jsp");
			mv.addObject("username", u);
		}
		else {
			System.out.println("INVALID User!!!");
			mv.setViewName("index.jsp");
		}
		return mv;
}
	@RequestMapping("/SignOut")
	public ModelAndView logout() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}

}

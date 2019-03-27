package com.abc.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.maven.surefire.shade.common.org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@PostMapping(value = "/employee/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Map<String, Object> map, HttpSession session) {
		if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
			session.setAttribute("loginUser", username);
			return "redirect:/main.html";
		} else {
			map.put("msg", "Wrong username or password");
			return "login";
		}

	}
}

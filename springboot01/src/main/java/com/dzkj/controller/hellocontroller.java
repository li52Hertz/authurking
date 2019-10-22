package com.dzkj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dzkj.pojo.User;

@Controller
public class hellocontroller {
		@RequestMapping("/hello")
			public String hello(Model model) {
			User user1 = new User("张三", "123");
			User user2 = new User("李四", "456");
			User user3 = new User("王五", "567");
			List<User> date = new ArrayList<User>();
			date.add(user1);
			date.add(user2);
			date.add(user3);
			model.addAttribute("date", date);
			return "list";
		}
		
		@RequestMapping("/a")
		public String Login() {
			return "login";
		}
		@RequestMapping("/login")
		public String Loginint(@RequestParam("u_name") String uname,@RequestParam("u_password") String upassword) {
			if(uname.equals("zs")&& upassword.equals("123456")) {
				return  "forward:show";
				
			}else{
				return  "forward:a";
			}
		
		}
		
		
		@RequestMapping("/index")
		public String Show2() {
			return "index";
			
		}
}

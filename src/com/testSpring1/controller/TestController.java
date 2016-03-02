package com.testSpring1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.models.Credentials;

/**
 * 
 */

/**
 * @author Maurice
 * Ref:https://spring.io/guides/gs/handling-form-submission/
 * http://www.tutorialspoint.com/spring/spring_mvc_form_handling_example.htm
 */
@Controller
public class TestController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld(){
		return new ModelAndView("hello", "message", "Hello World");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model) {			
	  return new ModelAndView("login", "command", new Credentials());
   }
	  
	@RequestMapping(value = "/addlogin", method = RequestMethod.POST)	
	public String submitLogin(@ModelAttribute Credentials cred, Model model){
		String name = cred.getName();
		String pwd = cred.getPassword();
		if (name.equals("Maurice") && pwd.equals("myPassword")){
			//login passed
			model.addAttribute("name", cred.getName());
			model.addAttribute("password", cred.getPassword());
			return "result";
		}else{
			return "error";
		}

	}	
}

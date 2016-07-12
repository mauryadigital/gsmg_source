package com.pts.ats.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pts.ats.DAO.User;
import com.pts.ats.service.serviceDao;

@Controller
public class HomeController {
	
	private serviceDao service;
	/**
	 * @param service the service to set
	 */
	@Autowired
	public void setService(serviceDao service) {
		this.service = service;
	}
	@RequestMapping("/users")
	public String showHome(Model model) {	
		List<User> users = service.getUsers();
		model.addAttribute("User", users);
		return "users";
	}
	@RequestMapping("/createUser")
	public String createUser(Model model) {	
		model.addAttribute("user", new User());
		return "createUser";
	}
	@RequestMapping(value="/doCreateUser", method=RequestMethod.POST)
	public String docreateUser(Model model, @Valid User user, BindingResult result) {
		
		if(result.hasErrors()){
			System.out.println("Form doesn't validate");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors){
				System.out.println(error.getDefaultMessage());
			}
			return "createUser";
		}else{
			System.out.println("User Form validated");
			service.createUser(user);
		}
		return "doCreateUser";
	}
}

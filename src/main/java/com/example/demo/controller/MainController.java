package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.entity.StudentInfo;
import com.example.demo.entity.User;

@Controller
public class MainController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
		model.addAttribute("login", new User());
        return "index";
    }
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.POST)
    public String indexPOST(Model model) {
		model.addAttribute("login", new User());
        return "index";
    }
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
    public String showPageRegister(Model model) {
		model.addAttribute("user", new User());
        return "register";
    }
	
	@RequestMapping(value = { "/listStudent" }, method = RequestMethod.GET)
    public String showPageAdminGET(Model model) {

        return "listStudent";
	}
	
	@RequestMapping(value = { "/listStudent" }, method = RequestMethod.POST)
    public String showPageAdminPOST(Model model, @ModelAttribute("login") User user) {
		User t = userDAO.findUserLogin(user.getUsername(), user.getPassword());
		if (t != null) {
			List<StudentInfo> list = studentDAO.getListStudent();
			model.addAttribute("listStudent", list);
			model.addAttribute("username", t.getUsername());
			return "listStudent";
		}
		return "index";
	}
	
	@RequestMapping(value = { "/updateStudent" }, method = RequestMethod.GET)
    public String showPageUpdateStudent(Model model) {
        return "updateStudent";
    }
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String registerUser(Model model, @ModelAttribute("user") User user) {
		model.addAttribute("user", new User());
		User t = userDAO.findUserByName(user.getUsername());
		if (t != null) {
			return "register";
		}
		userDAO.addUser(user.getUsername(), user.getPassword());
		return "redirect:index";
	}
}

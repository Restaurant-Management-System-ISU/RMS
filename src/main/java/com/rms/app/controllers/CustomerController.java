package com.rms.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rms.app.model.Cart;
import com.rms.app.model.Menu;
import com.rms.app.model.Tables;
import com.rms.app.model.User;
import com.rms.app.service.AdminService;
import com.rms.app.service.UserService;


@Controller
public class CustomerController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;

	@GetMapping("/customer")
	public String getCustomerWelcomePage(@ModelAttribute("user") User user, Model model, HttpSession session)
	{
		@SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");

		if(messages == null) {
			model.addAttribute("errormsg", "Session Expired. Please Login Again");
			return "home/error";
		}
        model.addAttribute("sessionMessages", messages);
        
	List<Menu> menuList = userService.getAllMenu();
		
        
        model.addAttribute("menus", menuList);

		return "customer/welcomecustomer";
	}
	
	@GetMapping("/profile")
	public String getCustomerProfile(@ModelAttribute("user") User user, Model model, HttpSession session)
	{
		@SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");

		if(messages == null) {
			model.addAttribute("errormsg", "Session Expired. Please Login Again");
			return "home/error";
		}
        model.addAttribute("sessionMessages", messages);
        
		User userModel = userService.getUserByEmail(messages.get(0));
			
	        
	        model.addAttribute("user", userModel);

		return "customer/profile";
	}
	
	@PostMapping("/updateProfile")
	public String updateProfile(@ModelAttribute("user") User user, Model model)
	{
		System.out.println("save===user");
		int output =userService.saveUser(user);
		if(output>0) {
			return "redirect:/profile";
		}
		
		else {
			model.addAttribute("errormsg", "Operation failed. Please try again");
			return "home/error";
		}
		
	}
	
	@PostMapping("/deleteProfile/{id}")
	public String deleteProfile(@PathVariable(name="id") Long id,HttpServletRequest request, Model model)
	{
		userService.deleteUser(id);
		 request.getSession().invalidate();
		 model.addAttribute("errormsg", "Your Account Deleted Successfully");
			return "home/error";
	}



	@GetMapping("/reservetable")
	public String getCustomerProfile(@ModelAttribute("table") Tables table, Model model, HttpSession session)
	{
		@SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");

		if(messages == null) {
			model.addAttribute("errormsg", "Session Expired. Please Login Again");
			return "home/error";
		}
        model.addAttribute("sessionMessages", messages);
        
		User userModel = userService.getUserByEmail(messages.get(0));
		 
		Tables tableModel = new Tables();
			
	        
	    model.addAttribute("table", tableModel);

		return "customer/reservetable";
	}
	
	@PostMapping("/bookTable")
	public String bookTable(@ModelAttribute("table") Tables table, Model model)
	{
		System.out.println("save===table");
		int output =userService.saveTable(table);
		if(output>0) {
			return "redirect:/customer";
		}
		
		else {
			model.addAttribute("errormsg", "Operation failed. Please try again");
			return "home/error";
		}
		
	}
}

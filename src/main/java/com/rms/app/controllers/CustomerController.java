package com.rms.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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
import com.rms.app.model.Order;
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

		@PostMapping("/addToCart/{id}")
	public String addToCart(Model model, HttpSession session, @PathVariable(name="id") Long id, @RequestParam("quantity") String quantity) {
		
		
		@SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
		if(messages == null) {
			model.addAttribute("errormsg", "Session Expired. Please Login Again");
			return "home/error";
		}
		Menu menu = adminService.getMenuById(id);
		Cart cart = new Cart();
		
		cart.setCategory(menu.getCategory());
		cart.setCuisine(menu.getCuisine());
		cart.setCustomerEmail(messages.get(0));
		cart.setDescription(menu.getDescription());
		cart.setName(menu.getName());
		cart.setType(menu.getType());
		cart.setVegOrNonVeg(menu.getVegOrNonVeg());
		cart.setQuantity(quantity);
		cart.setPrice(menu.getPrice());
		int totalPrice = Integer.parseInt(menu.getPrice())* Integer.parseInt(quantity);
		cart.setTotalPrice(String.valueOf(totalPrice));
		
		userService.addToCart(cart);
		
        model.addAttribute("sessionMessages", messages);
		
		return "redirect:/cart";
	}
	
	@GetMapping("/cart")
	public String cart(Model model, HttpSession session) {
		
		
		@SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
		if(messages == null) {
			model.addAttribute("errormsg", "Session Expired. Please Login Again");
			return "home/error";
		}
		User userdata = userService.findUser(messages.get(0));
		List<Cart> carts = userService.getUserCart(userdata.getEmail());
		model.addAttribute("carts", carts);
		
		int finalPrice = 0;
		for(int i=0;i<carts.size();i++) {
			finalPrice = finalPrice + Integer.parseInt(carts.get(i).getTotalPrice());
		}
		
		if(finalPrice > 0) {
			model.addAttribute("finalprice", finalPrice);
		}
		else {
			model.addAttribute("finalprice", "0");
		}
		
		
		int cartSize = carts.size();
		if(cartSize > 0) {
			model.addAttribute("flag", 1);
		}
		else {
			model.addAttribute("flag", 0);
		}
		
		
		model.addAttribute("cartsize", cartSize);
		System.out.println(carts.size()+"------");
		model.addAttribute("role", userdata.getUsertype());
		
		return "customer/cart";
		
	}
	

	@PostMapping("/removeFromCart/{id}")
	public String removeFromCart(@PathVariable(name="id") Long id)
	{
		userService.deleteFromCart(id);
		
		return "redirect:/cart";
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
		@PostMapping("makePayment")
	public String makePayment(@ModelAttribute("order") Order order,HttpSession session, Model model )
	{
		
		@SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
		if(messages == null) {
			model.addAttribute("errormsg", "Session Expired. Please Login Again");
			return "home/error";
		}
		User userdata = userService.findUser(messages.get(0));
		
		List<Cart> cart =userService.getUserCart(userdata.getEmail());
		
		StringJoiner name = new StringJoiner(",");
		StringJoiner price = new StringJoiner(",");
		StringJoiner quantity = new StringJoiner(",");
		StringJoiner totalCost = new StringJoiner(",");
		
		 
		int finalCost = 0;
		
		for(int i=0;i<cart.size(); i++) {
			
			name.add(cart.get(i).getName());
			
			price.add(cart.get(i).getPrice());
			
			quantity.add(cart.get(i).getQuantity());
			
			
			
			totalCost.add(cart.get(i).getTotalPrice());
			
			finalCost = finalCost + Integer.parseInt(cart.get(i).getTotalPrice());
		}
		
		order.setName(name.toString());
		order.setPrice(price.toString());
		order.setQuantity(quantity.toString());
		order.setTotalCost(totalCost.toString());
		order.setEmail(userdata.getEmail());
		order.setFinalBill(String.valueOf(finalCost));
		order.setStatus("ordered");
		
		
		
		
		
		userService.saveOrder(order);
		
		
		
		
		return "redirect:/customer";
	}
	
	@PostMapping("/cancelOrder/{id}")
	public String cancelOrder(@PathVariable(name="id") Long id)
	{
		userService.cancelOrder(id);
		
		return "redirect:/orders";
	}
	
	
}


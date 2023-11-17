package com.rms.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.app.dao.CartRepo;
import com.rms.app.dao.MenuRepo;
import com.rms.app.dao.OrderRepo;
import com.rms.app.dao.StaffRepo;
import com.rms.app.dao.TablesRepo;
import com.rms.app.dao.UserRepo;
import com.rms.app.model.Cart;
import com.rms.app.model.Menu;
import com.rms.app.model.Order;
import com.rms.app.model.Staff;
import com.rms.app.model.Tables;
import com.rms.app.model.User;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private MenuRepo menuRepo;
	
	@Autowired
	private StaffRepo staffRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private TablesRepo tableRepo;
	
	@Autowired
	private OrderRepo orderRepo;
	
	

	
	public int saveUser(User user) {
		user.setUsertype("customer");
		userRepo.save(user);
		
		if(userRepo.save(user)!=null) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public User findUser(String email) {
		List<User> user = userRepo.findAll();
		System.out.println("----"+user.size());
		if(user.size() == 0) {
			return null;
		}
		List<User> veifiedUser = user.stream().filter(n -> n.getEmail().equals(email) || n.getUsername().equals(email)).collect(Collectors.toList());
		if(veifiedUser.size() > 0) {
			return veifiedUser.get(0);
		}
		else {
			return null;
		}
		
	}
	
	public User authenticateUser(User user) {
		
		if(user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("admin")) {
			
			user.setUsertype("admin");
			
			return user;
		}
		
		List<User> users = userRepo.findAll();
		List<User> veifiedUser = users.stream().filter(n -> (n.getEmail().equals(user.getEmail()) || n.getUsername().equals(user.getEmail())) && n.getPassword().equals(user.getPassword())).collect(Collectors.toList());
		
		if(veifiedUser.size() ==1) {
			
			
			return veifiedUser.get(0);
		}
		else {
			List<Staff> staffs = staffRepo.findAll();
			List<Staff> verifiedStaff = staffs.stream().filter(s -> (s.getEmail().equals(user.getEmail()) || s.getUsername().equals(user.getEmail())) && s.getPassword().equals(user.getPassword())).collect(Collectors.toList());
			
			if(verifiedStaff.size() ==1) {
				
				user.setUsertype("staff");
				return user;
			}
			else {
				return null;
			}
		}
			
	}
	
	public User findUserByUsername(String username) {
		
		List<User> users = userRepo.findAll();
		List<User> veifiedUser = users.stream().filter(n -> n.getUsername().equals(username)).collect(Collectors.toList());
		if(veifiedUser.size() > 0) {
			return veifiedUser.get(0);
		}
		else {
			return null;
		}
		
	}
	
	public int validatePassword(User usermodel, String securityQuestion, String securityAnswer, String role) {
		
		if(role.equals("customer")) {
		
		List<User> users = userRepo.findAll();
		List<User> verifiedUser = users.stream().filter(n -> n.getEmail().equals(usermodel.getEmail())).collect(Collectors.toList());
		if(verifiedUser.size() ==1) {
			List<User> userSecurities = userRepo.findAll();
			
			List<User> securedUser = userSecurities.stream().filter(security -> security.getSecurityQuestion().equals(securityQuestion) && security.getSecurityAnswer().equals(securityAnswer)
					
					).collect(Collectors.toList());
			if(securedUser.size() == 1) {
				return 1;
			}
			else {
				return 2;
			}
		}
		else {
			return 0;
		}
		
		}
		else {
			
			List<Staff> staffs = staffRepo.findAll();
			List<Staff> verifiedStaff = staffs.stream().filter(s -> s.getEmail().equals(usermodel.getEmail())).collect(Collectors.toList());
			if(verifiedStaff.size() ==1) {
				List<Staff> staffSecurities = staffRepo.findAll();
				
				List<Staff> securedStaff = staffSecurities.stream().filter(security -> security.getSecurityQuestion().equals(securityQuestion) && security.getSecurityAnswer().equals(securityAnswer)
						
						).collect(Collectors.toList());
				if(securedStaff.size() == 1) {
					return 1;
				}
				else {
					return 2;
				}
			}
			else {
				return 0;
			}
			
		}
	}
	
	public void saveNewPassword(User usermodel, String role) {
		
		if(role.equals("customer")) {
		
			User user = userRepo.findbyEmail(usermodel.getEmail());
			System.out.println("user#########"+user.toString());
			user.setPassword(usermodel.getPassword());
			userRepo.save(user);
			
		}
		else {
			Staff staff = staffRepo.findbyEmail(usermodel.getEmail());
			System.out.println("user#########"+staff.toString());
			staff.setPassword(usermodel.getPassword());
			staffRepo.save(staff);
		}
	}
	
	public void deleteUser(Long id) {
			
			userRepo.deleteById(id);
			
	}

	

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return menuRepo.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findbyEmail(email);
	}

	@Override
	public void addToCart(Cart cart) {
		cartRepo.save(cart);
		
	}

	@Override
	public List<Cart> getUserCart(String email) {
		// TODO Auto-generated method stub
		return cartRepo.findAll().stream().filter(c -> c.getCustomerEmail().equals(email)).collect(Collectors.toList());
	}

	@Override
	public void deleteFromCart(Long id) {
		cartRepo.deleteById(id);
		
	}

	@Override
	public int saveTable(Tables table) {
		
		tableRepo.save(table);
		
		if(tableRepo.save(table)!=null) {
			return 1;
		}
		else {
			return 0;
		}
	}
	@Override
	public void cancelOrder(Long id) {
		// TODO Auto-generated method stub
		orderRepo.deleteById(id);
		
	}


	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		orderRepo.save(order);
		cartRepo.deleteCart(order.getEmail());
		
	}

	@Override
	public List<Order> getCustomerOrders(String email) {
		// TODO Auto-generated method stub
		return orderRepo.findAll().stream().filter(o -> o.getEmail().equals(email)).collect(Collectors.toList());
	}
	
	

}

package com.rms.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import com.rms.app.dao.MenuRepo;
import com.rms.app.dao.StaffRepo;
import com.rms.app.dao.UserRepo;
import com.rms.app.model.Menu;
import com.rms.app.model.User;

import java.util.ArrayList;
import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepo userRepo;

    @Mock
    private MenuRepo menuRepo;

    
    @Test
    public void getAllMenu() {

        Menu menu = new Menu();
        
        menu.setCategory("Starters");
        menu.setCuisine("indian");
        menu.setDescription("nicely chopped cabbage with deeply fried manchurian");
        menu.setName("Veg Manchurian");
        menu.setPrice("200");
        menu.setType("type");
        menu.setVegOrNonVeg("Veg");
        
        
        List<Menu> menus = new ArrayList<>();
        menus.add(menu);
        
        when(menuRepo.findAll()).thenReturn(menus);

        assertEquals(menus, userService.getAllMenu());

    }
    
    @Test
    public void getAllUsers() {

    	 User user = new User();
    	 
    	 user.setEmail("user@gmail.com");
    	 user.setLastname("lastname");
    	 user.setFirstname("firstname");
    	 user.setMobileNumber("1234567890");
    	 user.setCity("city");
    	 user.setDoorNo("12");
    	 user.setUsername("username");
         
         
         List<User> users = new ArrayList<>();
         users.add(user);
         
         when(userRepo.findAll()).thenReturn(users);

         assertEquals(users, userService.getAllUsers());

    }
    
    
    
   
    
    

}
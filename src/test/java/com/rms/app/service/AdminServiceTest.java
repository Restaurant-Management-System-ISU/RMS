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
import com.rms.app.model.Menu;

import java.util.ArrayList;
import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @InjectMocks
    private AdminServiceImpl adminService;

    @Mock
    private MenuRepo menuRepo;

    @Mock
    private StaffRepo staffRepo;

    
    @Test
    public void getAllMenus() {

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

        assertEquals(menus, adminService.getAllMenu());

    }
    
    @Test
    public void checkEmptyMenuList() {

    	 Menu menu = new Menu();
         
         menu.setCategory("Starters");
         menu.setCuisine("indian");
         menu.setDescription("nicely chopped cabbage with deeply fried manchurian");
         menu.setName("Veg Manchurian");
         menu.setPrice("200");
         menu.setType("type");
         menu.setVegOrNonVeg("Veg");
         
         
         List<Menu> menus = new ArrayList<>();
         
         when(menuRepo.findAll()).thenReturn(menus);

         assertEquals(0, adminService.getAllMenu().size());

    }
    
    
    
   
    
    

}
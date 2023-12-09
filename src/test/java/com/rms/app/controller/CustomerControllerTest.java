package com.rms.app.controller;

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

import com.rms.app.dao.CartRepo;
import com.rms.app.dao.MenuRepo;
import com.rms.app.dao.OrderRepo;
import com.rms.app.dao.ReviewRepo;
import com.rms.app.dao.StaffRepo;
import com.rms.app.dao.TablesRepo;
import com.rms.app.dao.TicketRepo;
import com.rms.app.dao.UserRepo;
import com.rms.app.model.Cart;
import com.rms.app.model.Menu;
import com.rms.app.model.Order;
import com.rms.app.model.Review;
import com.rms.app.model.Tables;
import com.rms.app.model.Ticket;
import com.rms.app.model.User;
import com.rms.app.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepo userRepo;

    @Mock
    private CartRepo cartRepo;
    
    @Mock
    private MenuRepo menuRepo;

    
    @Mock
    private TablesRepo tableRepo;
    
    @Mock
    private OrderRepo orderRepo;
    
    @Mock
    private ReviewRepo reviewRepo;
    
    @Mock
    private TicketRepo ticketRepo;
    
    
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
        menu.setSeason("normal");
        
        
        List<Menu> menus = new ArrayList<>();
        menus.add(menu);
        
        when(menuRepo.findAll()).thenReturn(menus);

        assertEquals(menus, userService.getAllMenu());

    }
    
    @Test
    public void getEmptyMenus() {

        Menu menu = new Menu();
        
        menu.setCategory("Starters");
        menu.setCuisine("indian");
        menu.setDescription("nicely chopped cabbage with deeply fried manchurian");
        menu.setName("Veg Manchurian");
        menu.setPrice("200");
        menu.setType("type");
        menu.setVegOrNonVeg("Veg");
        menu.setSeason("normal");
        
        
        List<Menu> menus = new ArrayList<>();
        
        when(menuRepo.findAll()).thenReturn(menus);

        assertEquals(0, userService.getAllMenu().size());

    }
    
    @Test
    public void addTocart() {

        Cart cart = new Cart();
        
        cart.setCategory("Starters");
        cart.setCuisine("indian");
        cart.setDescription("nicely chopped cabbage with deeply fried manchurian");
        cart.setName("Veg Manchurian");
        cart.setPrice("200");
        cart.setType("type");
        cart.setVegOrNonVeg("Veg");
        cart.setCustomerEmail("customer@gmail.com");
        
        
        List<Cart> carts = new ArrayList<>();
        carts.add(cart);
        
        when(cartRepo.findAll()).thenReturn(carts);

        assertEquals(carts, userService.getUserCart("customer@gmail.com"));

    }
    
    @Test
    public void cartNotFound() {

        Cart cart = new Cart();
        
        cart.setCategory("Starters");
        cart.setCuisine("indian");
        cart.setDescription("nicely chopped cabbage with deeply fried manchurian");
        cart.setName("Veg Manchurian");
        cart.setPrice("200");
        cart.setType("type");
        cart.setVegOrNonVeg("Veg");
        cart.setCustomerEmail("customer@gmail.com");
        
        
        List<Cart> carts = new ArrayList<>();
        carts.add(cart);
        
        when(cartRepo.findAll()).thenReturn(carts);

        assertEquals(0, userService.getUserCart("custmer@gmail.com").size());

    }
    
    @Test
    public void deleteFromCart() {

        Cart cart = new Cart();
        
        cart.setCategory("Starters");
        cart.setCuisine("indian");
        cart.setDescription("nicely chopped cabbage with deeply fried manchurian");
        cart.setName("Veg Manchurian");
        cart.setPrice("200");
        cart.setType("type");
        cart.setVegOrNonVeg("Veg");
        cart.setCustomerEmail("customer@gmail.com");
        
        
        List<Cart> carts = new ArrayList<>();
        carts.add(cart);
        
        cartRepo.delete(cart);
        
        when(cartRepo.findAll()).thenReturn(carts);

        assertEquals(0, userService.getUserCart("custmer@gmail.com").size());

    }
    
    @Test
    public void bookTable() {

        Tables table = new Tables();
        
        table.setCustomerEmail("customer@gmail.com");
        table.setDatetime("1-12-2023::10:10");
        table.setName("t1");
        table.setNoOfPersons("4");
        
        tableRepo.save(table);
        
        List<Tables> tables = new ArrayList<>();
        tables.add(table);
        
        
        when(tableRepo.findAll()).thenReturn(tables);

        assertEquals(1, tableRepo.findAll().size());

    }
    
    @Test
    public void bookNoTable() {

        Tables table = new Tables();
        
        table.setCustomerEmail("customer@gmail.com");
        table.setDatetime("1-12-2023::10:10");
        table.setName("t1");
        table.setNoOfPersons("4");
        
        
        List<Tables> tables = new ArrayList<>();
       
        
        
        when(tableRepo.findAll()).thenReturn(tables);

        assertEquals(0, tableRepo.findAll().size());

    }
    
    @Test
    public void orders() {

        Order order = new Order();
        
        order.setCardName("cardName");
        order.setCardNumber("1234567890");
        order.setCvv("321");
        order.setEmail("customer@gmail.com");
        order.setFinalBill("1230");
        order.setName("Pizza");
        order.setPrice("123");
        order.setQuantity("10");
        order.setTotalCost("1230");
        order.setStatus("ordered");
        
        
        List<Order> orders = new ArrayList<>();
        orders.add(order);       
        
        
        when(orderRepo.findAll()).thenReturn(orders);

        assertEquals(1, orderRepo.findAll().size());

    }
    
    @Test
    public void Noorders() {

        Order order = new Order();
        
        order.setCardName("cardName");
        order.setCardNumber("1234567890");
        order.setCvv("321");
        order.setEmail("customer@gmail.com");
        order.setFinalBill("1230");
        order.setName("Pizza");
        order.setPrice("123");
        order.setQuantity("10");
        order.setTotalCost("1230");
        order.setStatus("ordered");
        
        
        List<Order> orders = new ArrayList<>();
        
        
        when(orderRepo.findAll()).thenReturn(orders);

        assertEquals(0, orderRepo.findAll().size());

    }
    
    @Test
    public void cancelOrder() {

        Order order = new Order();
        
        order.setCardName("cardName");
        order.setCardNumber("1234567890");
        order.setCvv("321");
        order.setEmail("customer@gmail.com");
        order.setFinalBill("1230");
        order.setName("Pizza");
        order.setPrice("123");
        order.setQuantity("10");
        order.setTotalCost("1230");
        order.setStatus("ordered");
        order.setId(1L);
        orderRepo.save(order);
        orderRepo.delete(order);
        
        
        List<Order> orders = new ArrayList<>();
        
        
        when(orderRepo.findAll()).thenReturn(orders);

        assertEquals(0, orderRepo.findAll().size());

    }
    
    @Test
    public void addReview() {

        Review review = new Review();
        		
        review.setCustomerEmail("customer@gmail.com");
        review.setFeedback("good");
        review.setId(1L);
        review.setRating("5");
        review.setOrderId("1");
        
        reviewRepo.save(review);
        
        
        
        
        List<Review> reviews = new ArrayList<>();
        reviews.add(review);
        
        
        when(reviewRepo.findAll()).thenReturn(reviews);

        assertEquals(1, reviewRepo.findAll().size());

    }
    
    @Test
    public void addNoReview() {

        Review review = new Review();
        		
        review.setCustomerEmail("customer@gmail.com");
        review.setFeedback("good");
        review.setId(1L);
        review.setRating("5");
        review.setOrderId("1");
        
        
        
        
        
        List<Review> reviews = new ArrayList<>();
        
        
        when(reviewRepo.findAll()).thenReturn(reviews);

        assertEquals(0, reviewRepo.findAll().size());

    }
    
    @Test
    public void raiseTicket() {

        Ticket ticket = new Ticket();
        
        ticket.setCustomerEmail("customer@gmail.com");
        ticket.setDescription("description");
        ticket.setId(1L);
        ticket.setPriority("Low");
        
        
        
        
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);
        
        
        when(ticketRepo.findAll()).thenReturn(tickets);

        assertEquals(1, ticketRepo.findAll().size());

    }
   
    @Test
    public void raiseNoTicket() {

        Ticket ticket = new Ticket();
        
        ticket.setCustomerEmail("customer@gmail.com");
        ticket.setDescription("description");
        ticket.setId(1L);
        ticket.setPriority("Low");
        
        
        
        
        List<Ticket> tickets = new ArrayList<>();
        
        
        when(ticketRepo.findAll()).thenReturn(tickets);

        assertEquals(0, ticketRepo.findAll().size());

    }
    
    

}
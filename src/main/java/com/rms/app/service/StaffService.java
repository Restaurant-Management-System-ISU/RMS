package com.rms.app.service;

import java.util.List;

import com.rms.app.model.Menu;
import com.rms.app.model.Order;
import com.rms.app.model.Staff;
import com.rms.app.model.Tables;
import com.rms.app.model.User;



public interface StaffService {

	int saveStaff(Staff staff);

	Staff getStaffByEmail(String string);

	void deleteStaff(Long id);

	List<Tables> getCustomerReservations();

	void deleteReservation(Long id);

	List<Order> getAllOrders();

	void confirmOrder(Long id);




}

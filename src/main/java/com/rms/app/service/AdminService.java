package com.rms.app.service;

import java.util.List;

import com.rms.app.model.Menu;
import com.rms.app.model.Staff;
import com.rms.app.model.User;



public interface AdminService {

	List<Menu> getAllMenu();

	void saveMenu(Menu menu);

	void deleteMenu(Long id);

	Menu getMenuById(Long id);

	void updateMenu(Menu menu);

	List<Staff> getAllStaff();

	void saveStaff(Staff staff);

	void deleteStaff(Long id);


	



}

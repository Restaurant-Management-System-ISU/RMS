package com.rms.app.service;

import java.util.List;

import com.rms.app.model.Menu;
import com.rms.app.model.Staff;
import com.rms.app.model.User;



public interface StaffService {

	int saveStaff(Staff staff);

	Staff getStaffByEmail(String string);

	void deleteStaff(Long id);




}

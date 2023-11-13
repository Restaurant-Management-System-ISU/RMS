package com.rms.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.app.dao.MenuRepo;
import com.rms.app.dao.StaffRepo;
import com.rms.app.dao.TablesRepo;
import com.rms.app.dao.UserRepo;
import com.rms.app.model.Menu;
import com.rms.app.model.Staff;
import com.rms.app.model.Tables;
import com.rms.app.model.User;


@Service
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	private StaffRepo staffRepo;
	
	@Autowired
	private MenuRepo menuRepo;
	
	@Autowired
	private TablesRepo tableRepo;

	@Override
	public int saveStaff(Staff staff) {
		// TODO Auto-generated method stub
		staffRepo.save(staff);
		return 1;
	}

	@Override
	public Staff getStaffByEmail(String email) {
		// TODO Auto-generated method stub
		return staffRepo.findbyEmail(email);
	}

	@Override
	public void deleteStaff(Long id) {
		// TODO Auto-generated method stub
		staffRepo.deleteById(id);
	}
	
	@Override
	public List<Tables> getCustomerReservations() {
		// TODO Auto-generated method stub
		return tableRepo.findAll();
	}

	@Override
	public void deleteReservation(Long id) {
		// TODO Auto-generated method stub
		tableRepo.deleteById(id);
		
	}


	
	

	
	

}

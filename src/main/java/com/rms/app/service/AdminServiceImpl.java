package com.rms.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.app.dao.MenuRepo;
import com.rms.app.dao.UserRepo;
import com.rms.app.model.Menu;
import com.rms.app.model.User;


@Service
public class AdminServiceImpl implements AdminService{

	
	@Autowired
	private MenuRepo menuRepo;

	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return menuRepo.findAll();
	}

	@Override
	public void saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuRepo.save(menu);
	}

	@Override
	public void deleteMenu(Long id) {
		// TODO Auto-generated method stub
		menuRepo.deleteById(id);
		
	}
	
	

	
	
	
	

}

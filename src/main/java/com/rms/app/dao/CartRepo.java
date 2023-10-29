package com.rms.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rms.app.model.Cart;
import com.rms.app.model.Menu;



@Repository
public interface CartRepo extends JpaRepository<Cart, Long>{



}
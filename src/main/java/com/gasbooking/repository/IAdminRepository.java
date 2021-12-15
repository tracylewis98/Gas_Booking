package com.gasbooking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gasbooking.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin,Integer>{

	//Admin findById(int adminId);

	//Admin deleteById(int adminId);
	
}